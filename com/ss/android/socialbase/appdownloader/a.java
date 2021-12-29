package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f62043b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f62044c;

    /* renamed from: d  reason: collision with root package name */
    public String f62045d;

    /* renamed from: e  reason: collision with root package name */
    public String f62046e;

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
            jSONObject.put("error_code", String.valueOf(this.f62043b));
            jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f62044c);
            jSONObject.put("real_device_plan", this.f62045d);
            jSONObject.put("device_plans", this.f62046e);
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
            aVar.f62046e = jSONObject.optString("device_plans", null);
            aVar.f62045d = jSONObject.optString("real_device_plan", null);
            aVar.f62044c = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f62043b = -1;
            } else {
                aVar.f62043b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}
