import com.yok.university.entity.Address;
import com.yok.university.entity.Faculty;
import com.yok.university.entity.University;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        University university = University.getInstance();

        Faculty engineering = new Faculty(1, "Engineering", "Mr. Ahmet");
        Faculty medicine = new Faculty(2, "Medicine", "Mr. Ayşe Engin");
        Faculty medicine2 = new Faculty(3, "Medicine2", "Mr. Ayşe");

        Address address = new Address("İstanbul", 34728);
        university.setAddress(address);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(engineering);

        //dışarıdan bir List verince, dışarıdan bu List'e eklemeler yapabiliriz.
        //çözüm: setter'da gelen List'ten yeni bir arraylist oluşturduk => defensive copy
        university.setFaculties(facultyList);
        facultyList.add(medicine);

        List<Faculty> faculties = university.getFaculties();
        //faculties.add(medicine2);
        university.addFaculty(engineering); //eklemeyecek, çünkü kontrol ekledik.

        university.removeFaculty(engineering);


        //getbyid örneği
        university.addFaculty(engineering);
        university.addFaculty(medicine);
        university.addFaculty(medicine2);

        System.out.println("getbyid örneği__________");
        System.out.println(university.getFacultyById(2));
        //---

        //searchbyname örneği
        System.out.println("\nsearchbyname örneği__________");
        System.out.println(university.searchFacultiesByName("medicine").toString());


        //searchby örneği
        System.out.println("\nsearchby örneği__________");
        System.out.println(university.searchFaculties("enGin").toString());

        System.out.println("\nprint university______");
        System.out.println(university);

    }
}