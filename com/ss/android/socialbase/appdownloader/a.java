package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f43002b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f43003c;

    /* renamed from: d  reason: collision with root package name */
    public String f43004d;

    /* renamed from: e  reason: collision with root package name */
    public String f43005e;

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
            jSONObject.put("error_code", String.valueOf(this.f43002b));
            jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f43003c);
            jSONObject.put("real_device_plan", this.f43004d);
            jSONObject.put("device_plans", this.f43005e);
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
            aVar.f43005e = jSONObject.optString("device_plans", null);
            aVar.f43004d = jSONObject.optString("real_device_plan", null);
            aVar.f43003c = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f43002b = -1;
            } else {
                aVar.f43002b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}
