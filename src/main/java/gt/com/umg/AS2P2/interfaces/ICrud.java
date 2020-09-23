package gt.com.umg.AS2P2.interfaces;

import gt.com.umg.AS2P2.entity.AnimalEntity;

import java.util.List;

public interface ICrud {
    public List<AnimalEntity> select (String id);
    public List<AnimalEntity> readAllAnimals (String id);
    public void delete(String id);
    public void update(AnimalEntity animal);
    public void create(AnimalEntity animal);

}
