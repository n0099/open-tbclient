package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    private int f7559a;
    private LoginType b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private Map h;
    private boolean i;
    private JSONObject j;

    public int getBlockEffectValue() {
        return this.f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f7559a;
    }

    public String getLoginAppId() {
        return this.c;
    }

    public String getLoginOpenid() {
        return this.d;
    }

    public LoginType getLoginType() {
        return this.b;
    }

    public Map getPassThroughInfo() {
        return this.h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.h == null || this.h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.h).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.e;
    }

    public String getWXAppId() {
        return this.g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i) {
        this.f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f7559a = i;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.c = str;
    }

    public void setLoginOpenid(String str) {
        this.d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.h = map;
    }

    public void setUin(String str) {
        this.e = str;
    }

    public void setWXAppId(String str) {
        this.g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f7559a + ", loginType=" + this.b + ", loginAppId=" + this.c + ", loginOpenid=" + this.d + ", uin=" + this.e + ", blockEffect=" + this.f + ", passThroughInfo=" + this.h + ", extraInfo=" + this.j + '}';
    }
}
