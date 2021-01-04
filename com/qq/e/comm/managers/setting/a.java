package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class a extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str) {
        return this.f11855a.opt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str, String str2) {
        JSONObject optJSONObject = this.f11855a.optJSONObject("ps");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, Object obj) {
        try {
            this.f11855a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, Object obj, String str2) {
        JSONObject jSONObject;
        try {
            JSONObject optJSONObject = this.f11855a.optJSONObject("ps");
            if (optJSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                this.f11855a.putOpt("ps", jSONObject2);
                jSONObject = jSONObject2;
            } else {
                jSONObject = optJSONObject;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(str2);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                jSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }
}
