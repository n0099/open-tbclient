package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f58262b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f58263c;

    /* renamed from: d  reason: collision with root package name */
    public String f58264d;

    /* renamed from: e  reason: collision with root package name */
    public String f58265e;

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
            jSONObject.put("error_code", String.valueOf(this.f58262b));
            jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f58263c);
            jSONObject.put("real_device_plan", this.f58264d);
            jSONObject.put("device_plans", this.f58265e);
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
            aVar.f58265e = jSONObject.optString("device_plans", null);
            aVar.f58264d = jSONObject.optString("real_device_plan", null);
            aVar.f58263c = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f58262b = -1;
            } else {
                aVar.f58262b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}
