package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f66790a;

    /* renamed from: b  reason: collision with root package name */
    public int f66791b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f66792c;

    /* renamed from: d  reason: collision with root package name */
    public String f66793d;

    /* renamed from: e  reason: collision with root package name */
    public String f66794e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f66794e = jSONObject.optString("device_plans", null);
            bVar.f66793d = jSONObject.optString("real_device_plan", null);
            bVar.f66792c = jSONObject.optString("error_msg", null);
            bVar.f66790a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f66791b = -1;
            } else {
                bVar.f66791b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f66790a);
            jSONObject.put("error_code", String.valueOf(this.f66791b));
            jSONObject.put("error_msg", this.f66792c);
            jSONObject.put("real_device_plan", this.f66793d);
            jSONObject.put("device_plans", this.f66794e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
