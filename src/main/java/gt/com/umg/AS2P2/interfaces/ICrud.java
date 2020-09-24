package gt.com.umg.AS2P2.interfaces;

import gt.com.umg.AS2P2.entity.AnimalEntity;

import java.io.StringReader;
import java.util.List;

public interface ICrud {
    public List<AnimalEntity> readAllAnimals (String id);
    public int delete(String id);
    public int update(AnimalEntity animal);
    public int create(AnimalEntity animal);

}
