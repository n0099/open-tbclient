package com.qq.e.comm.plugin.y;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f12698a;

    public d() {
        this(new JSONObject());
    }

    public d(JSONObject jSONObject) {
        this.f12698a = jSONObject;
    }

    public d a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f12698a.putOpt(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public JSONObject a() {
        if (this.f12698a == null || this.f12698a.length() <= 0) {
            return null;
        }
        return this.f12698a;
    }

    public String toString() {
        return this.f12698a.toString();
    }
}
