package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import cat.udl.demosEP.testInterfaces.DictionaryInterfaceTest;
import cat.udl.demosEP.testInterfaces.EmptyDictionaryInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OneWordDictionaryTest implements EmptyDictionaryInterfaceTest, DictionaryInterfaceTest {

    private DictionaryImpl dictionary;

    @BeforeEach
    public void setUp() throws AlreadyDefinedException {
        dictionary = new DictionaryImpl();
        dictionary.defineWord("Hardware", "Definición 1 de Hardware");
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
    public void getInexistentWordExceptionTest() {
        assertThrows(NotDefinedException.class,
                () -> dictionary.getDefinitions("Framework"));
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

    @Override
    @Test
    public void getExistentWordExceptionTest() {
        assertThrows(AlreadyDefinedException.class,
                () -> dictionary.defineWord("Hardware", "Definición 1 de Hardware"));
    }

}
