package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f13007a;

    /* renamed from: b  reason: collision with root package name */
    public int f13008b = -1;
    public String c;
    public String d;
    public String e;

    public String a() {
        return b().toString();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("anti_plan_type", this.f13007a);
                jSONObject.put("error_code", String.valueOf(this.f13008b));
                jSONObject.put("error_msg", this.c);
                jSONObject.put("real_device_plan", this.d);
                jSONObject.put("device_plans", this.e);
            } catch (Throwable th) {
            }
        }
    }

    public static a aba(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.e = jSONObject.optString("device_plans", null);
                aVar.d = jSONObject.optString("real_device_plan", null);
                aVar.c = jSONObject.optString("error_msg", null);
                aVar.f13007a = jSONObject.optString("anti_plan_type", null);
                String optString = jSONObject.optString("error_code");
                if (TextUtils.isEmpty(optString)) {
                    aVar.f13008b = -1;
                } else {
                    aVar.f13008b = Integer.parseInt(optString);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return aVar;
    }

    public String toString() {
        return "AntiHijackAttempt{anti_plan_type='" + this.f13007a + "', error_code=" + this.f13008b + ", error_msg='" + this.c + "', real_device_plan='" + this.d + "', device_plans='" + this.e + "'}";
    }
}
