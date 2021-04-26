package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f36226a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f36227b;

    /* renamed from: c  reason: collision with root package name */
    public String f36228c;

    /* renamed from: d  reason: collision with root package name */
    public String f36229d;

    /* renamed from: e  reason: collision with root package name */
    public String f36230e;

    /* renamed from: f  reason: collision with root package name */
    public int f36231f;

    /* renamed from: g  reason: collision with root package name */
    public String f36232g;

    /* renamed from: h  reason: collision with root package name */
    public Map f36233h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36234i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f36231f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f36226a;
    }

    public String getLoginAppId() {
        return this.f36228c;
    }

    public String getLoginOpenid() {
        return this.f36229d;
    }

    public LoginType getLoginType() {
        return this.f36227b;
    }

    public Map getPassThroughInfo() {
        return this.f36233h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f36233h == null || this.f36233h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f36233h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f36230e;
    }

    public String getWXAppId() {
        return this.f36232g;
    }

    public boolean isHotStart() {
        return this.f36234i;
    }

    public void setBlockEffectValue(int i2) {
        this.f36231f = i2;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i2) {
        this.f36226a = i2;
    }

    public void setHotStart(boolean z) {
        this.f36234i = z;
    }

    public void setLoginAppId(String str) {
        this.f36228c = str;
    }

    public void setLoginOpenid(String str) {
        this.f36229d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f36227b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f36233h = map;
    }

    public void setUin(String str) {
        this.f36230e = str;
    }

    public void setWXAppId(String str) {
        this.f36232g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f36226a + ", loginType=" + this.f36227b + ", loginAppId=" + this.f36228c + ", loginOpenid=" + this.f36229d + ", uin=" + this.f36230e + ", blockEffect=" + this.f36231f + ", passThroughInfo=" + this.f36233h + ", extraInfo=" + this.j + '}';
    }
}
