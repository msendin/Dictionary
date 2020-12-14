package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DictionaryImpl implements Dictionary {

    private HashMap<String,List<String>> entriesList;

    DictionaryImpl() {
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
                entriesList.put(word, defL);
            }
        } else {
            defL = new ArrayList<>();
            defL.add(definition);
            entriesList.put(word, defL);
        }
    }

    @Override
    public List<String> getDefinitions(String word) throws NotDefinedException {
        int index;

        if (entriesList.containsKey(word)) {
            return entriesList.get(word);
        }
        else {
            throw new NotDefinedException("Palabra no incluida en el diccionario");
        }
    }
}