package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f66972a;

    /* renamed from: b  reason: collision with root package name */
    public int f66973b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f66974c;

    /* renamed from: d  reason: collision with root package name */
    public String f66975d;

    /* renamed from: e  reason: collision with root package name */
    public String f66976e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f66976e = jSONObject.optString("device_plans", null);
            bVar.f66975d = jSONObject.optString("real_device_plan", null);
            bVar.f66974c = jSONObject.optString("error_msg", null);
            bVar.f66972a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f66973b = -1;
            } else {
                bVar.f66973b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f66972a);
            jSONObject.put("error_code", String.valueOf(this.f66973b));
            jSONObject.put("error_msg", this.f66974c);
            jSONObject.put("real_device_plan", this.f66975d);
            jSONObject.put("device_plans", this.f66976e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
