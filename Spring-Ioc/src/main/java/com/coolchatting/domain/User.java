package com.coolchatting.domain;

public class User {

    private Integer userId;
    private String userName;
    private String address;

    public User() {
        System.out.println(Thread.currentThread().getName() + "调用user无参构造");
    }

    public User(Integer userId, String userName, String address) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private void initUser() {
        System.out.println("进入initUser方法");
    }
}
