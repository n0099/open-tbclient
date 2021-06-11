package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a extends e {
    public a() {
    }

    public a(String str) {
        super(str);
    }

    public final Object a(String str) {
        return this.f39142a.opt(str);
    }

    public final Object a(String str, String str2) {
        JSONObject optJSONObject = this.f39142a.optJSONObject("ps");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    public final void a(String str, Object obj) {
        try {
            this.f39142a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }

    public final void a(String str, Object obj, String str2) {
        try {
            JSONObject optJSONObject = this.f39142a.optJSONObject("ps");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f39142a.putOpt("ps", optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }
}
