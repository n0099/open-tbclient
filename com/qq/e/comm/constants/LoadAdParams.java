package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f38652a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f38653b;

    /* renamed from: c  reason: collision with root package name */
    public String f38654c;

    /* renamed from: d  reason: collision with root package name */
    public String f38655d;

    /* renamed from: e  reason: collision with root package name */
    public String f38656e;

    /* renamed from: f  reason: collision with root package name */
    public int f38657f;

    /* renamed from: g  reason: collision with root package name */
    public String f38658g;

    /* renamed from: h  reason: collision with root package name */
    public Map f38659h;
    public boolean i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f38657f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f38652a;
    }

    public String getLoginAppId() {
        return this.f38654c;
    }

    public String getLoginOpenid() {
        return this.f38655d;
    }

    public LoginType getLoginType() {
        return this.f38653b;
    }

    public Map getPassThroughInfo() {
        return this.f38659h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f38659h == null || this.f38659h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38659h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f38656e;
    }

    public String getWXAppId() {
        return this.f38658g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i) {
        this.f38657f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f38652a = i;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.f38654c = str;
    }

    public void setLoginOpenid(String str) {
        this.f38655d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38653b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f38659h = map;
    }

    public void setUin(String str) {
        this.f38656e = str;
    }

    public void setWXAppId(String str) {
        this.f38658g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f38652a + ", loginType=" + this.f38653b + ", loginAppId=" + this.f38654c + ", loginOpenid=" + this.f38655d + ", uin=" + this.f38656e + ", blockEffect=" + this.f38657f + ", passThroughInfo=" + this.f38659h + ", extraInfo=" + this.j + '}';
    }
}
