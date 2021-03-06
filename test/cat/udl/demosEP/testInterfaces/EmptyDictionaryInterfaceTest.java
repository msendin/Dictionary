package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

public interface EmptyDictionaryInterfaceTest {

    @Test
    void getInexistentWordTest();

    @Test
    void defineWordTest() throws AlreadyDefinedException, NotDefinedException;
}
