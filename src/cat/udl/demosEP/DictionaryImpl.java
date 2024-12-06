package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DictionaryImpl implements Dictionary {

    private final HashMap<String,List<String>> entriesList;

    public DictionaryImpl() {
        entriesList = new HashMap<>();
    }

    @Override
    public void defineWord(String word, String definition) throws AlreadyDefinedException {
        List<String> defL;

        if (entriesList.containsKey(word)) {
            defL = entriesList.get(word);
            if (defL.contains(definition))
                throw new AlreadyDefinedException("Definición ya existente");
            else {
                defL.add(definition);
            }
        } else {
            defL = new ArrayList<>();
            defL.add(definition);
            entriesList.put(word, defL);
        }
    }

    @Override
    public List<String> getDefinitions(String word) throws NotDefinedException {

        if (entriesList.containsKey(word)) {
            return entriesList.get(word);
        }
        else {
            throw new NotDefinedException("Palabra no incluida en el diccionario");
        }
    }
}