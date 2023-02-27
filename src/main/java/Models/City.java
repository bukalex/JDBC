package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityID;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private List<Employee> employees;

    public City(){

    }

    public City(String cityName){
        this.cityName = cityName;
    }
}
