package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.*;
import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cat.udl.demosEP.exceptions.AlreadyDefinedException;
import cat.udl.demosEP.exceptions.NotDefinedException;

import java.util.Dictionary;

public interface DictionaryInterfaceTest {


    @Test
    void getExistentWordTest();
    // Checks if the AlreadyDefinedException throws adequately

    @Test
    void defineWordExistentTest() throws AlreadyDefinedException, NotDefinedException;
    // Adds another definition to a word already existent in the DIctionary
}
