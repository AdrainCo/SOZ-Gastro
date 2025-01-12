package pl.pjatk.SOZ_Gastro.ObjectClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "tabletops")
public class Tabletop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isAvailable;

    public Tabletop(Long id, String name, boolean isAvailable) {
        validateNameOrThrowError(name);
        this.id = id;
        this.name = name;
        this.isAvailable=isAvailable;
    }

    public Tabletop() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateNameOrThrowError(name);
        this.name = name;
    }

    public void validateNameOrThrowError(String name){
        if (InputStringMysqlValidator.containsForbiddenCharacters(name)) {
            throw new IllegalArgumentException("name contains forbidden characters " + name);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
