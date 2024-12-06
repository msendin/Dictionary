package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import cat.udl.demosEP.testInterfaces.DictionaryInterfaceTest;
import cat.udl.demosEP.testInterfaces.EmptyDictionaryInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlentyDictionaryTest implements EmptyDictionaryInterfaceTest, DictionaryInterfaceTest {

    private DictionaryImpl dictionary;

    @BeforeEach
    public void setUp() throws AlreadyDefinedException {
        dictionary = new DictionaryImpl();
        dictionary.defineWord("Licencia", "Definición 1 de Licencia");
        dictionary.defineWord("Licencia", "Definición 2 de Licencia");
        dictionary.defineWord("Hardware", "Definición 1 de Hardware");
    }


    @Override
    @Test
    public void getInexistentWordExceptionTest() {
        assertThrows(NotDefinedException.class,
                () -> dictionary.getDefinitions("Middleware"));
    }

    @Override
    @Test
    public void defineWordTest() throws AlreadyDefinedException, NotDefinedException {
        List<String> defs = new ArrayList<>();
        dictionary.defineWord("Sistema Operativo", "Definición de Sistema Operativo");
        defs.add("Definición de Sistema Operativo");
        assertEquals(defs, dictionary.getDefinitions("Sistema Operativo"));
    }

    @Override
    @Test
    public void defineWordMultiDTest() throws AlreadyDefinedException, NotDefinedException {
        List<String> defs = new ArrayList<>();
        dictionary.defineWord("Sistema Operativo", "Definición 1 de Sistema Operativo");
        dictionary.defineWord("Sistema Operativo", "Definición 2 de Sistema Operativo");
        defs.add("Definición 1 de Sistema Operativo");
        defs.add("Definición 2 de Sistema Operativo");
        assertEquals(defs, dictionary.getDefinitions("Sistema Operativo"));
    }

    @Override
    @Test
    public void getExistentWordExceptionTest() {
        assertThrows(AlreadyDefinedException.class,
                () -> dictionary.defineWord("Hardware", "Definición 1 de Hardware"));
    }

    @Override
    @Test
    public void defineExistentWordTest() throws AlreadyDefinedException, NotDefinedException {
        List<String> definitions = new ArrayList<>();
        definitions.add("Definición 1 de Hardware");
        definitions.add("Definición 2 de Hardware");
        dictionary.defineWord("Hardware", "Definición 2 de Hardware");
        assertEquals(definitions, dictionary.getDefinitions("Hardware"));
    }


    @Test
    @DisplayName("demo assertAll")
    void groupedAssertions() {
        assertAll("definiciones de Licencia y más",
                () -> assertEquals("Definición 1 de Licencia", dictionary.getDefinitions("Licencia").get(0)),
                () -> assertEquals("Definición 2 de Licencia", dictionary.getDefinitions("Licencia").get(1)),
                () -> assertThat("comparació valor 8 amb assertThat", 4+4, equalTo(8))
        );
    }


}
