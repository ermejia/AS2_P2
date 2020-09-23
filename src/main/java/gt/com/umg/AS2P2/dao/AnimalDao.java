package gt.com.umg.AS2P2.dao;

import gt.com.umg.AS2P2.controller.ConectionService;
import gt.com.umg.AS2P2.interfaces.ICrud;
import gt.com.umg.AS2P2.entity.AnimalEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AnimalDao implements ICrud {

    @Override
    public  List<AnimalEntity> select(String id) {
        List<AnimalEntity> listAnimals =new LinkedList<>();
        AnimalEntity animal = new AnimalEntity();
        try{
            ConectionService con= ConectionService.getInstance();
            Connection conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Animal Where IdArea ="+id);
            ResultSet consulta=statement.executeQuery();

            while (consulta.next()) {
                animal.setIdAnimal(consulta.getInt("IdAnimal"));
                animal.setIdArea(consulta.getInt("IdArea"));
                animal.setName(consulta.getString("Name"));
                animal.setAge(consulta.getInt("Age"));
                animal.setHeigth(consulta.getFloat("Heigth"));
                animal.setWeight(consulta.getFloat("Weight"));
                animal.setColor(consulta.getString("Color"));
                animal.setGender(consulta.getString("Gender"));
                animal.setCountry(consulta.getString("Country"));
                animal.setExtinctionRisk(consulta.getString("Extinction_Risk"));
                animal.setSciName(consulta.getString("Scientific_Name"));

                listAnimals.add(animal);
            }
            conexion.close();
            consulta.close();
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {

        }
        return listAnimals;
    }

    @Override
    public List<AnimalEntity> readAllAnimals(String id) {
        List<AnimalEntity> listAnimals =new LinkedList<>();
        AnimalEntity animal = new AnimalEntity();
        try{
            ConectionService con= ConectionService.getInstance();
            Connection conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Animal WHERE IdArea = "+id);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                animal.setIdAnimal(consulta.getInt("IdAnimal"));
                animal.setIdArea(consulta.getInt("IdArea"));
                animal.setName(consulta.getString("Name"));
                animal.setAge(consulta.getInt("Age"));
                animal.setHeigth(consulta.getFloat("Heigth"));
                animal.setWeight(consulta.getFloat("Weight"));
                animal.setColor(consulta.getString("Color"));
                animal.setGender(consulta.getString("Gender"));
                animal.setCountry(consulta.getString("Country"));
                animal.setExtinctionRisk(consulta.getString("Extinction_Risk"));
                animal.setSciName(consulta.getString("Scientific_Name"));


                listAnimals.add(animal);
            }
            conexion.close();
            consulta.close();
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {

        }
        return listAnimals;
    }


    @Override
    public void delete(String id) {

    }

    @Override
    public void update(AnimalEntity animal) {

    }

    @Override
    public void create(AnimalEntity animal) {

    }
}
