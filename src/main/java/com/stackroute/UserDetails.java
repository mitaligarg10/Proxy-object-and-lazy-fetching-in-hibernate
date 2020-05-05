package com.stackroute;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetails {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "USER_NAME")
    private String userName;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    private Collection<Address> lisOfAddresses = new ArrayList<Address>();

    public Collection<Address> getLisOfAddresses() {
        return lisOfAddresses;
    }

    public void setLisOfAddresses(Collection<Address> lisOfAddresses) {
        this.lisOfAddresses = lisOfAddresses;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
