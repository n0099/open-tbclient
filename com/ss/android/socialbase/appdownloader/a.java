package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f59745b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f59746c;

    /* renamed from: d  reason: collision with root package name */
    public String f59747d;

    /* renamed from: e  reason: collision with root package name */
    public String f59748e;

    public String a() {
        return b().toString();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.a);
            jSONObject.put("error_code", String.valueOf(this.f59745b));
            jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f59746c);
            jSONObject.put("real_device_plan", this.f59747d);
            jSONObject.put("device_plans", this.f59748e);
        } catch (Throwable unused) {
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f59748e = jSONObject.optString("device_plans", null);
            aVar.f59747d = jSONObject.optString("real_device_plan", null);
            aVar.f59746c = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f59745b = -1;
            } else {
                aVar.f59745b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}
