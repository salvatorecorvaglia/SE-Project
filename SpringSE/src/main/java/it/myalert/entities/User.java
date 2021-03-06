package it.myalert.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="user", indexes={@Index(name="user_Email_IX", columnList="Email", unique=true)})
public class User implements Serializable {

    /** Primary key. */
    protected static final String PK = "idUser";

    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private Integer idUser;
    @Column(name="Name", nullable=false, length=20)
    private String name;
    @Column(name="Surname", nullable=false, length=20)
    private String surname;
    @Column(name="Email", unique=true, nullable=false, length=30)
    private String email;
    @Column(name="BirthDate", nullable=false)
    private Timestamp birthDate;
    @Column(name="Sex", nullable=false, length=1)
    private String sex;
    @Column(name="Address", nullable=false, length=50)
    private String address;
    @Column(name="City", nullable=false, length=20)
    private String city;
    @Column(name="State", nullable=false, length=20)
    private String state;
    @Column(name="Token", length=18000000)
    private String token;
    @OneToMany(mappedBy="user")
    private Set<Agent> agent;
    @OneToMany(mappedBy="user")
    private Set<Citizen> citizen;
    @OneToMany(mappedBy="user")
    private Set<Image> image;
    @OneToMany(mappedBy="user")
    private Set<Manager> manager;

    /** Default constructor. */
    public User() {
        super();
    }

    /**
     * Access method for idUser.
     *
     * @return the current value of idUser
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * Setter method for idUser.
     *
     * @param aIdUser the new value for idUser
     */
    public void setIdUser(Integer aIdUser) {
        idUser = aIdUser;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for surname.
     *
     * @return the current value of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter method for surname.
     *
     * @param aSurname the new value for surname
     */
    public void setSurname(String aSurname) {
        surname = aSurname;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for birthDate.
     *
     * @return the current value of birthDate
     */
    public Timestamp getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birthDate.
     *
     * @param aBirthDate the new value for birthDate
     */
    public void setBirthDate(Timestamp aBirthDate) {
        birthDate = aBirthDate;
    }

    /**
     * Access method for sex.
     *
     * @return the current value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for sex.
     *
     * @param aSex the new value for sex
     */
    public void setSex(String aSex) {
        sex = aSex;
    }

    /**
     * Access method for address.
     *
     * @return the current value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param aAddress the new value for address
     */
    public void setAddress(String aAddress) {
        address = aAddress;
    }

    /**
     * Access method for city.
     *
     * @return the current value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method for city.
     *
     * @param aCity the new value for city
     */
    public void setCity(String aCity) {
        city = aCity;
    }

    /**
     * Access method for state.
     *
     * @return the current value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Setter method for state.
     *
     * @param aState the new value for state
     */
    public void setState(String aState) {
        state = aState;
    }
    
    /**
     * Access method for token.
     *
     * @return the current value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for token.
     *
     * @param aToken the new value for token
     */
    public void setToken(String aToken) {
        token = aToken;
    }

    /**
     * Access method for agent.
     *
     * @return the current value of agent
     */
    public Set<Agent> getAgent() {
        return agent;
    }

    /**
     * Setter method for agent.
     *
     * @param aAgent the new value for agent
     */
    public void setAgent(Set<Agent> aAgent) {
        agent = aAgent;
    }

    /**
     * Access method for citizen.
     *
     * @return the current value of citizen
     */
    public Set<Citizen> getCitizen() {
        return citizen;
    }

    /**
     * Setter method for citizen.
     *
     * @param aCitizen the new value for citizen
     */
    public void setCitizen(Set<Citizen> aCitizen) {
        citizen = aCitizen;
    }

    /**
     * Access method for image.
     *
     * @return the current value of image
     */
    public Set<Image> getImage() {
        return image;
    }

    /**
     * Setter method for image.
     *
     * @param aImage the new value for image
     */
    public void setImage(Set<Image> aImage) {
        image = aImage;
    }

    /**
     * Access method for manager.
     *
     * @return the current value of manager
     */
    public Set<Manager> getManager() {
        return manager;
    }

    /**
     * Setter method for manager.
     *
     * @param aManager the new value for manager
     */
    public void setManager(Set<Manager> aManager) {
        manager = aManager;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        if (this.getIdUser() != that.getIdUser()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdUser();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" idUser=").append(getIdUser());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idUser", Integer.valueOf(getIdUser()));
        return ret;
    }

}
