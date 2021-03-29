package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f38268a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f38269b;

    /* renamed from: c  reason: collision with root package name */
    public String f38270c;

    /* renamed from: d  reason: collision with root package name */
    public String f38271d;

    /* renamed from: e  reason: collision with root package name */
    public String f38272e;

    /* renamed from: f  reason: collision with root package name */
    public int f38273f;

    /* renamed from: g  reason: collision with root package name */
    public String f38274g;

    /* renamed from: h  reason: collision with root package name */
    public Map f38275h;
    public boolean i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f38273f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f38268a;
    }

    public String getLoginAppId() {
        return this.f38270c;
    }

    public String getLoginOpenid() {
        return this.f38271d;
    }

    public LoginType getLoginType() {
        return this.f38269b;
    }

    public Map getPassThroughInfo() {
        return this.f38275h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f38275h == null || this.f38275h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38275h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f38272e;
    }

    public String getWXAppId() {
        return this.f38274g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i) {
        this.f38273f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f38268a = i;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.f38270c = str;
    }

    public void setLoginOpenid(String str) {
        this.f38271d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38269b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f38275h = map;
    }

    public void setUin(String str) {
        this.f38272e = str;
    }

    public void setWXAppId(String str) {
        this.f38274g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f38268a + ", loginType=" + this.f38269b + ", loginAppId=" + this.f38270c + ", loginOpenid=" + this.f38271d + ", uin=" + this.f38272e + ", blockEffect=" + this.f38273f + ", passThroughInfo=" + this.f38275h + ", extraInfo=" + this.j + '}';
    }
}
