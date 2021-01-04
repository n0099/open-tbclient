package com.qq.e.comm.plugin.y;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f12997a;

    public d() {
        this(new JSONObject());
    }

    public d(JSONObject jSONObject) {
        this.f12997a = jSONObject;
    }

    public d a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f12997a.putOpt(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public JSONObject a() {
        if (this.f12997a == null || this.f12997a.length() <= 0) {
            return null;
        }
        return this.f12997a;
    }

    public String toString() {
        return this.f12997a.toString();
    }
}
