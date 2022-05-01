package com.example.mcs1;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper
{
    private final String INTRO = "intro";
    private final String NAME = "name";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String EMAIL = "email";
    private final String GENDER = "gender";
    private final String AGE = "age";
    private final String SEAT = "seat";
    private final String QR = "qr";
    private final String TIME = "time";
    private final String CHECKIN = "checkin";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context)
    {
        app_prefs = context.getSharedPreferences("shared", 0);
        this.context = context;
    }

    public void putIsLogin(boolean loginOrOut)
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginOrOut);
        edit.apply();
    }

    public void putName(String loginOrOut) // 사용자 이름
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginOrOut);
        edit.apply();
    }

    public String getName()
    {
        return app_prefs.getString(NAME, "");
    }

    public void putUsername(String loginOrOut) // 사용자 별명
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(USERNAME, loginOrOut);
        edit.apply();
    }

    public String getUsername()
    {
        return app_prefs.getString(USERNAME, "");
    }

    public void putPassword(String loginOrOut) // 사용자 비밀번호
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(PASSWORD, loginOrOut);
        edit.apply();
    }

    /*
    public void getPassword(String loginOrOut) // 사용자 비밀번호
    {
        return app_prefs.getString(PASSWORD, "");
    }*/

    public String getPassword() { return app_prefs.getString(PASSWORD, ""); }

    public void putEmail(String loginOrOut) // 사용자 이메일
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(EMAIL, loginOrOut);
        edit.apply();
    }

    public String getEmail() { return app_prefs.getString(EMAIL, ""); }

    public void putGender(String loginOrOut) // 사용자 성별
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(GENDER, loginOrOut);
        edit.apply();
    }

    public String getGender() { return app_prefs.getString(GENDER, ""); }

    public void putAge(String loginOrOut) // 사용자 나이
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(AGE, loginOrOut);
        edit.apply();
    }

    public String getAge() { return app_prefs.getString(AGE, ""); }

    public void putSeat(String loginOrOut) // 사용자 좌석번호
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(SEAT, loginOrOut);
        edit.apply();
    }

    public String getSeat() { return app_prefs.getString(SEAT, ""); }

    public void putQr(String loginOrOut) // 사용자 qr
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(QR, loginOrOut);
        edit.apply();
    }

    public String getQr() { return app_prefs.getString(QR, ""); }

    public void putTime(String loginOrOut) // 사용자 남은 시간
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(TIME, loginOrOut);
        edit.apply();
    }

    public String getTime() { return app_prefs.getString(TIME, ""); }

    public void putCheckin(String loginOrOut) // 사용자 이메일
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(CHECKIN, loginOrOut);
        edit.apply();
    }

    public String getCheckin() { return app_prefs.getString(CHECKIN, ""); }

}