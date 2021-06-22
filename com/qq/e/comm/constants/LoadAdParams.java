package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f39177a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f39178b;

    /* renamed from: c  reason: collision with root package name */
    public String f39179c;

    /* renamed from: d  reason: collision with root package name */
    public String f39180d;

    /* renamed from: e  reason: collision with root package name */
    public String f39181e;

    /* renamed from: f  reason: collision with root package name */
    public int f39182f;

    /* renamed from: g  reason: collision with root package name */
    public String f39183g;

    /* renamed from: h  reason: collision with root package name */
    public Map f39184h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39185i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f39182f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f39177a;
    }

    public String getLoginAppId() {
        return this.f39179c;
    }

    public String getLoginOpenid() {
        return this.f39180d;
    }

    public LoginType getLoginType() {
        return this.f39178b;
    }

    public Map getPassThroughInfo() {
        return this.f39184h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f39184h == null || this.f39184h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f39184h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f39181e;
    }

    public String getWXAppId() {
        return this.f39183g;
    }

    public boolean isHotStart() {
        return this.f39185i;
    }

    public void setBlockEffectValue(int i2) {
        this.f39182f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.f39177a = i2;
    }

    public void setHotStart(boolean z) {
        this.f39185i = z;
    }

    public void setLoginAppId(String str) {
        this.f39179c = str;
    }

    public void setLoginOpenid(String str) {
        this.f39180d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f39178b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f39184h = map;
    }

    public void setUin(String str) {
        this.f39181e = str;
    }

    public void setWXAppId(String str) {
        this.f39183g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f39177a + ", loginType=" + this.f39178b + ", loginAppId=" + this.f39179c + ", loginOpenid=" + this.f39180d + ", uin=" + this.f39181e + ", blockEffect=" + this.f39182f + ", passThroughInfo=" + this.f39184h + ", extraInfo=" + this.j + '}';
    }
}
