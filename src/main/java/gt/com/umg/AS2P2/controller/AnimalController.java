package gt.com.umg.AS2P2.controller;

import com.google.gson.Gson;
import gt.com.umg.AS2P2.dao.AnimalDao;
import gt.com.umg.AS2P2.entity.AnimalEntity;

import java.util.LinkedList;
import java.util.List;

public class AnimalController {

    public List <String> convertAllAnimal(String id){
        List <String> json = new LinkedList<>();
        Gson gson = new Gson();
        AnimalDao animal = new AnimalDao();
        List<AnimalEntity> listAnimal = animal.readAllAnimals(id);
        for(int i =0; i <listAnimal.size();i++) {
            json.add(gson.toJson(listAnimal.get(i)));
        }
        return json;
    }

}
