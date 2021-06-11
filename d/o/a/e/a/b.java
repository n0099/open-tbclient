package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f70801a;

    /* renamed from: b  reason: collision with root package name */
    public int f70802b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f70803c;

    /* renamed from: d  reason: collision with root package name */
    public String f70804d;

    /* renamed from: e  reason: collision with root package name */
    public String f70805e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f70805e = jSONObject.optString("device_plans", null);
            bVar.f70804d = jSONObject.optString("real_device_plan", null);
            bVar.f70803c = jSONObject.optString("error_msg", null);
            bVar.f70801a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f70802b = -1;
            } else {
                bVar.f70802b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bVar;
    }

    public String b() {
        return d().toString();
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f70801a);
            jSONObject.put("error_code", String.valueOf(this.f70802b));
            jSONObject.put("error_msg", this.f70803c);
            jSONObject.put("real_device_plan", this.f70804d);
            jSONObject.put("device_plans", this.f70805e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
