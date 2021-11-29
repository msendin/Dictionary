package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

public interface DictionaryInterfaceTest {

    @Test
    void getExistentWordTest();

    @Test
    void defineWordExistentTest() throws AlreadyDefinedException, NotDefinedException;
}
