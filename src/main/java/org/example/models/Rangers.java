package org.example.models;

public class Rangers {
    private Integer id;
    private String ranger ;
    private String username;
    private String gender;
    private String contacts;
    private String email;
    private Boolean deleted;

    public void setId(Integer id) { this.id = id; }
    public void setRanger(String ranger) { this.ranger = ranger; }
    public void setUsername(String username) { this.username = username; }
    public void setGender(String gender) { this.gender = gender; }
    public void setContacts(String contacts) { this.contacts = contacts; }
    public void setEmail(String email) { this.email = email; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

    public Integer getId() { return id;}
    public String getRanger() { return ranger; }
    public String getUsername() { return username; }
    public String getGender() { return gender; }
    public String getContacts() { return contacts; }
    public String getEmail() { return email; }
    public Boolean getDeleted() { return deleted; }

    public Rangers(Integer id, String ranger, String username, String gender, String contacts, String email, Boolean deleted) {
        this.id = id;
        this.ranger = ranger;
        this.username = username;
        this.gender = gender;
        this.contacts = contacts;
        this.email = email;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Rangers{" +
                "id=" + id +
                ", ranger='" + ranger + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", contacts='" + contacts + '\'' +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
