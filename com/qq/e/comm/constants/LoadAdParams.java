package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f38267a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f38268b;

    /* renamed from: c  reason: collision with root package name */
    public String f38269c;

    /* renamed from: d  reason: collision with root package name */
    public String f38270d;

    /* renamed from: e  reason: collision with root package name */
    public String f38271e;

    /* renamed from: f  reason: collision with root package name */
    public int f38272f;

    /* renamed from: g  reason: collision with root package name */
    public String f38273g;

    /* renamed from: h  reason: collision with root package name */
    public Map f38274h;
    public boolean i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f38272f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f38267a;
    }

    public String getLoginAppId() {
        return this.f38269c;
    }

    public String getLoginOpenid() {
        return this.f38270d;
    }

    public LoginType getLoginType() {
        return this.f38268b;
    }

    public Map getPassThroughInfo() {
        return this.f38274h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f38274h == null || this.f38274h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38274h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f38271e;
    }

    public String getWXAppId() {
        return this.f38273g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i) {
        this.f38272f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f38267a = i;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.f38269c = str;
    }

    public void setLoginOpenid(String str) {
        this.f38270d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38268b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f38274h = map;
    }

    public void setUin(String str) {
        this.f38271e = str;
    }

    public void setWXAppId(String str) {
        this.f38273g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f38267a + ", loginType=" + this.f38268b + ", loginAppId=" + this.f38269c + ", loginOpenid=" + this.f38270d + ", uin=" + this.f38271e + ", blockEffect=" + this.f38272f + ", passThroughInfo=" + this.f38274h + ", extraInfo=" + this.j + '}';
    }
}
