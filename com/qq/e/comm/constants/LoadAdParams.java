package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f35400a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f35401b;

    /* renamed from: c  reason: collision with root package name */
    public String f35402c;

    /* renamed from: d  reason: collision with root package name */
    public String f35403d;

    /* renamed from: e  reason: collision with root package name */
    public String f35404e;

    /* renamed from: f  reason: collision with root package name */
    public int f35405f;

    /* renamed from: g  reason: collision with root package name */
    public String f35406g;

    /* renamed from: h  reason: collision with root package name */
    public Map f35407h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35408i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f35405f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f35400a;
    }

    public String getLoginAppId() {
        return this.f35402c;
    }

    public String getLoginOpenid() {
        return this.f35403d;
    }

    public LoginType getLoginType() {
        return this.f35401b;
    }

    public Map getPassThroughInfo() {
        return this.f35407h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f35407h == null || this.f35407h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f35407h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f35404e;
    }

    public String getWXAppId() {
        return this.f35406g;
    }

    public boolean isHotStart() {
        return this.f35408i;
    }

    public void setBlockEffectValue(int i2) {
        this.f35405f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.f35400a = i2;
    }

    public void setHotStart(boolean z) {
        this.f35408i = z;
    }

    public void setLoginAppId(String str) {
        this.f35402c = str;
    }

    public void setLoginOpenid(String str) {
        this.f35403d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f35401b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f35407h = map;
    }

    public void setUin(String str) {
        this.f35404e = str;
    }

    public void setWXAppId(String str) {
        this.f35406g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f35400a + ", loginType=" + this.f35401b + ", loginAppId=" + this.f35402c + ", loginOpenid=" + this.f35403d + ", uin=" + this.f35404e + ", blockEffect=" + this.f35405f + ", passThroughInfo=" + this.f35407h + ", extraInfo=" + this.j + '}';
    }
}
