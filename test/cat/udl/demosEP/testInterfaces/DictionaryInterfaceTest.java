package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface DictionaryInterfaceTest {

    @BeforeEach
    void setUp() throws AlreadyDefinedException;

    @Test
    void getExistentWordExceptionTest();
    // Checks if the AlreadyDefinedException throws adequately

    @Test
    void defineExistentWordTest() throws AlreadyDefinedException, NotDefinedException;
    // Adds another definition to a word already existent in the DIctionary
}
