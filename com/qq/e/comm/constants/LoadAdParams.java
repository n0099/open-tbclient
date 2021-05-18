package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f35471a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f35472b;

    /* renamed from: c  reason: collision with root package name */
    public String f35473c;

    /* renamed from: d  reason: collision with root package name */
    public String f35474d;

    /* renamed from: e  reason: collision with root package name */
    public String f35475e;

    /* renamed from: f  reason: collision with root package name */
    public int f35476f;

    /* renamed from: g  reason: collision with root package name */
    public String f35477g;

    /* renamed from: h  reason: collision with root package name */
    public Map f35478h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35479i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f35476f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f35471a;
    }

    public String getLoginAppId() {
        return this.f35473c;
    }

    public String getLoginOpenid() {
        return this.f35474d;
    }

    public LoginType getLoginType() {
        return this.f35472b;
    }

    public Map getPassThroughInfo() {
        return this.f35478h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f35478h == null || this.f35478h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f35478h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f35475e;
    }

    public String getWXAppId() {
        return this.f35477g;
    }

    public boolean isHotStart() {
        return this.f35479i;
    }

    public void setBlockEffectValue(int i2) {
        this.f35476f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.f35471a = i2;
    }

    public void setHotStart(boolean z) {
        this.f35479i = z;
    }

    public void setLoginAppId(String str) {
        this.f35473c = str;
    }

    public void setLoginOpenid(String str) {
        this.f35474d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f35472b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f35478h = map;
    }

    public void setUin(String str) {
        this.f35475e = str;
    }

    public void setWXAppId(String str) {
        this.f35477g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f35471a + ", loginType=" + this.f35472b + ", loginAppId=" + this.f35473c + ", loginOpenid=" + this.f35474d + ", uin=" + this.f35475e + ", blockEffect=" + this.f35476f + ", passThroughInfo=" + this.f35478h + ", extraInfo=" + this.j + '}';
    }
}
