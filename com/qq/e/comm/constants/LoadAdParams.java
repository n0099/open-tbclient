package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f39079a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f39080b;

    /* renamed from: c  reason: collision with root package name */
    public String f39081c;

    /* renamed from: d  reason: collision with root package name */
    public String f39082d;

    /* renamed from: e  reason: collision with root package name */
    public String f39083e;

    /* renamed from: f  reason: collision with root package name */
    public int f39084f;

    /* renamed from: g  reason: collision with root package name */
    public String f39085g;

    /* renamed from: h  reason: collision with root package name */
    public Map f39086h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39087i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f39084f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f39079a;
    }

    public String getLoginAppId() {
        return this.f39081c;
    }

    public String getLoginOpenid() {
        return this.f39082d;
    }

    public LoginType getLoginType() {
        return this.f39080b;
    }

    public Map getPassThroughInfo() {
        return this.f39086h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f39086h == null || this.f39086h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f39086h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f39083e;
    }

    public String getWXAppId() {
        return this.f39085g;
    }

    public boolean isHotStart() {
        return this.f39087i;
    }

    public void setBlockEffectValue(int i2) {
        this.f39084f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.f39079a = i2;
    }

    public void setHotStart(boolean z) {
        this.f39087i = z;
    }

    public void setLoginAppId(String str) {
        this.f39081c = str;
    }

    public void setLoginOpenid(String str) {
        this.f39082d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f39080b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f39086h = map;
    }

    public void setUin(String str) {
        this.f39083e = str;
    }

    public void setWXAppId(String str) {
        this.f39085g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f39079a + ", loginType=" + this.f39080b + ", loginAppId=" + this.f39081c + ", loginOpenid=" + this.f39082d + ", uin=" + this.f39083e + ", blockEffect=" + this.f39084f + ", passThroughInfo=" + this.f39086h + ", extraInfo=" + this.j + '}';
    }
}
