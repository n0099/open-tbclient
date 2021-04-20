package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LoadAdParams {

    /* renamed from: a  reason: collision with root package name */
    public int f38557a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f38558b;

    /* renamed from: c  reason: collision with root package name */
    public String f38559c;

    /* renamed from: d  reason: collision with root package name */
    public String f38560d;

    /* renamed from: e  reason: collision with root package name */
    public String f38561e;

    /* renamed from: f  reason: collision with root package name */
    public int f38562f;

    /* renamed from: g  reason: collision with root package name */
    public String f38563g;

    /* renamed from: h  reason: collision with root package name */
    public Map f38564h;
    public boolean i;
    public JSONObject j;

    public int getBlockEffectValue() {
        return this.f38562f;
    }

    public JSONObject getExtraInfo() {
        return this.j;
    }

    public int getFlowSourceId() {
        return this.f38557a;
    }

    public String getLoginAppId() {
        return this.f38559c;
    }

    public String getLoginOpenid() {
        return this.f38560d;
    }

    public LoginType getLoginType() {
        return this.f38558b;
    }

    public Map getPassThroughInfo() {
        return this.f38564h;
    }

    public String getPassThroughInfoJsonString() {
        try {
            if (this.f38564h == null || this.f38564h.size() <= 0) {
                return null;
            }
            return new JSONObject(this.f38564h).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f38561e;
    }

    public String getWXAppId() {
        return this.f38563g;
    }

    public boolean isHotStart() {
        return this.i;
    }

    public void setBlockEffectValue(int i) {
        this.f38562f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f38557a = i;
    }

    public void setHotStart(boolean z) {
        this.i = z;
    }

    public void setLoginAppId(String str) {
        this.f38559c = str;
    }

    public void setLoginOpenid(String str) {
        this.f38560d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f38558b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f38564h = map;
    }

    public void setUin(String str) {
        this.f38561e = str;
    }

    public void setWXAppId(String str) {
        this.f38563g = str;
    }

    public String toString() {
        return "LoadAdParams{flowSourceId=" + this.f38557a + ", loginType=" + this.f38558b + ", loginAppId=" + this.f38559c + ", loginOpenid=" + this.f38560d + ", uin=" + this.f38561e + ", blockEffect=" + this.f38562f + ", passThroughInfo=" + this.f38564h + ", extraInfo=" + this.j + '}';
    }
}
