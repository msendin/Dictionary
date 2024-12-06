package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import cat.udl.demosEP.testInterfaces.EmptyDictionaryInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmptyDictionaryTest implements EmptyDictionaryInterfaceTest {

    private DictionaryImpl dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new DictionaryImpl();
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
                () -> dictionary.getDefinitions("Middleware"));
    }
}
