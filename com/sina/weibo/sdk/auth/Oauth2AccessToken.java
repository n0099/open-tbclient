package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Oauth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    Bundle bundle;
    private String mAccessToken;
    private long mExpiresTime;
    private String mPhoneNum;
    private String mRefreshToken;
    private String mUid;

    public Oauth2AccessToken() {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
    }

    @Deprecated
    public Oauth2AccessToken(String str) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setUid(jSONObject.optString("uid"));
                setToken(jSONObject.optString("access_token"));
                setExpiresIn(jSONObject.optString("expires_in"));
                setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
                setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        this.mAccessToken = str;
        this.mExpiresTime = System.currentTimeMillis();
        if (str2 != null) {
            this.mExpiresTime += Long.parseLong(str2) * 1000;
        }
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
                oauth2AccessToken.setUid(jSONObject.optString("uid"));
                oauth2AccessToken.setToken(jSONObject.optString("access_token"));
                oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
                oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
                oauth2AccessToken.setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
                return oauth2AccessToken;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle != null) {
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(getString(bundle, "uid", ""));
            oauth2AccessToken.setToken(getString(bundle, "access_token", ""));
            oauth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
            oauth2AccessToken.setRefreshToken(getString(bundle, KEY_REFRESH_TOKEN, ""));
            oauth2AccessToken.setPhoneNum(getString(bundle, KEY_PHONE_NUM, ""));
            oauth2AccessToken.setBundle(bundle);
            return oauth2AccessToken;
        }
        return null;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public String toString() {
        return "uid: " + this.mUid + ", access_token: " + this.mAccessToken + ", " + KEY_REFRESH_TOKEN + ": " + this.mRefreshToken + ", " + KEY_PHONE_NUM + ": " + this.mPhoneNum + ", expires_in: " + Long.toString(this.mExpiresTime);
    }

    public String getUid() {
        return this.mUid;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setExpiresIn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    private static String getString(Bundle bundle, String str, String str2) {
        String string;
        return (bundle == null || (string = bundle.getString(str)) == null) ? str2 : string;
    }

    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    private void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
