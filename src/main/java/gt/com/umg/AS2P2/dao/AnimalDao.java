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
        AnimalEntity animal;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Animal Where IdArea ="+id);
            ResultSet consulta=statement.executeQuery();

            while (consulta.next()) {
                animal = new AnimalEntity();
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
            consulta.close();
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return listAnimals;
    }

    @Override
    public List<AnimalEntity> readAllAnimals(String id) {
        List<AnimalEntity> listAnimals =new LinkedList<>();
        AnimalEntity animal;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Animal WHERE IdArea = "+id);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                animal = new AnimalEntity();
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
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return listAnimals;
    }


    @Override
    public void delete(String id) {
        AnimalEntity animal = new AnimalEntity();
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            String query = "DELETE FROM Animal WHERE IdAnimal="+id;
            parametro = conexion.prepareStatement(query);
            parametro.executeUpdate();
            conexion.close();

        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public void update(AnimalEntity animal) {
    
        AnimalEntity animal1 = new AnimalEntity();
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            String query = "UPDATE Animal set IdArea=?,Name=?,Age=?,Heigth=?,Weight=?,Color=?,Gender=?,Country=?,Extinction_Risk=?,Scientific_Name=? WHERE IdAnimal=?;";
            parametro = conexion.prepareStatement(query);
            parametro.setInt(1,animal.getIdArea());
            parametro.setString(2,animal.getName());
            parametro.setInt(3,animal.getAge());
            parametro.setFloat(4,animal.getHeigth());
            parametro.setFloat(5,animal.getWeight());
            parametro.setString(6,animal.getColor());
            parametro.setString(7,animal.getGender());
            parametro.setString(8,animal.getCountry());
            parametro.setString(9,animal.getExtinctionRisk());
            parametro.setString(10,animal.getSciName());
            parametro.setInt(11,animal.getIdAnimal());
            parametro.executeUpdate();
            conexion.close();

        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    @Override
    public void create(AnimalEntity animal) {
        AnimalEntity animal1 = new AnimalEntity();
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            String query = "INSERT INTO Animal(IdArea,Name,Age,Heigth,Weight,Color,Gender,Country,Extinction_Risk,Scientific_Name) VALUES(?,?,?,?,?,?,?,?,?,?);";
            parametro = conexion.prepareStatement(query);
            parametro.setInt(1,animal.getIdArea());
            parametro.setString(2,animal.getName());
            parametro.setInt(3,animal.getAge());
            parametro.setFloat(4,animal.getHeigth());
            parametro.setFloat(5,animal.getWeight());
            parametro.setString(6,animal.getColor());
            parametro.setString(7,animal.getGender());
            parametro.setString(8,animal.getCountry());
            parametro.setString(9,animal.getExtinctionRisk());
            parametro.setString(10,animal.getSciName());
            parametro.executeUpdate();
            conexion.close();

        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
