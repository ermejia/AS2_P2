

package gt.com.umg.AS2P2.entity;

/**
 *
 * @author Max
 */
public class AnimalEntity {
           
    //Attributos
    private int idAnimal;
    private String name;
    private int age;
    private float height;
    private float weight;
    private String color;
    private String gender;
    private String country;
    private String extincionRisk;
    private String sciName;
    private int idArea;
    
    //constructor
    
    public AnimalEntity () { }
    
    public AnimalEntity (int idAnimal,String name,  int age, float height, float weight, String color, String gender, 
                                        String country, String extincionRisk,String sciName, int idArea){
        
         this.age=age;
         this.color=color;
         this.country=country;
         this.extincionRisk=extincionRisk;
         this.gender=gender;
         this.height=height;
         this.idAnimal=idAnimal;
         this.idArea=idArea;
         this.name=name;
         this.sciName=sciName;
         this.weight=weight;
                
    }
    
    //set y get
    
    
}
