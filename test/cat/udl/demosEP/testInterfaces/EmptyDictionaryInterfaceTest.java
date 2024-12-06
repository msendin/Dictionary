package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

public interface EmptyDictionaryInterfaceTest {

    @Test
    void getInexistentWordExceptionTest();
    // Checks if the NotDefinedException throws adequately

    @Test
    void defineWordTest() throws AlreadyDefinedException, NotDefinedException;
    // Adds a new word to the Dictionary

    @Test
    void defineWordMultiDTest() throws AlreadyDefinedException, NotDefinedException;
    // Adds a new word in the Dictionary, which has two definitions

}
