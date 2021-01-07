package com.qq.e.comm.plugin.y;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f12997a = new JSONObject();

    public c a(String str) {
        try {
            this.f12997a.putOpt("pid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JSONObject a() {
        if (this.f12997a.length() > 0) {
            return this.f12997a;
        }
        return null;
    }

    public c b(String str) {
        try {
            this.f12997a.putOpt("aid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c c(String str) {
        try {
            this.f12997a.putOpt("traceid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String toString() {
        return this.f12997a.toString();
    }
}
