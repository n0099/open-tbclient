package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67015a;

    /* renamed from: b  reason: collision with root package name */
    public int f67016b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f67017c;

    /* renamed from: d  reason: collision with root package name */
    public String f67018d;

    /* renamed from: e  reason: collision with root package name */
    public String f67019e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f67019e = jSONObject.optString("device_plans", null);
            bVar.f67018d = jSONObject.optString("real_device_plan", null);
            bVar.f67017c = jSONObject.optString("error_msg", null);
            bVar.f67015a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f67016b = -1;
            } else {
                bVar.f67016b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f67015a);
            jSONObject.put("error_code", String.valueOf(this.f67016b));
            jSONObject.put("error_msg", this.f67017c);
            jSONObject.put("real_device_plan", this.f67018d);
            jSONObject.put("device_plans", this.f67019e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
