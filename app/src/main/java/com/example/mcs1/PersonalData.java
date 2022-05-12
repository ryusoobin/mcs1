package com.example.mcs1;

public class PersonalData {
    private String seat_num;
    private String username;
    private String time;

    public String getSeat_seatnum(){
        return seat_num;
    }
    public String getMember_time(){
        return time;
    }
    public String getMember_username(){
        return username;
    }
    public void setSeat_seatnum(String seat_seatnum){
        this.seat_num = seat_seatnum;
    }
    public void setMember_time(String member_time){
        this.time = member_time;
    }
    public void setMember_username(String member_username){
        this.username = member_username;
    }
}
