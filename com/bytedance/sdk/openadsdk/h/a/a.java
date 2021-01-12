package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d<a> {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f7172a = new JSONObject();

    public a a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                this.f7172a.put(str, obj);
            } catch (Throwable th) {
            }
        }
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.d, com.bytedance.sdk.openadsdk.h.a.b
    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject a2 = super.a();
        try {
            String optString = a2.optString("event_extra", null);
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(optString);
            }
            jSONObject.put("dns_info", this.f7172a);
            a2.put("event_extra", jSONObject.toString());
        } catch (Exception e) {
        }
        return a2;
    }
}
