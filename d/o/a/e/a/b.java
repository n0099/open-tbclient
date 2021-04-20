package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67788a;

    /* renamed from: b  reason: collision with root package name */
    public int f67789b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f67790c;

    /* renamed from: d  reason: collision with root package name */
    public String f67791d;

    /* renamed from: e  reason: collision with root package name */
    public String f67792e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f67792e = jSONObject.optString("device_plans", null);
            bVar.f67791d = jSONObject.optString("real_device_plan", null);
            bVar.f67790c = jSONObject.optString("error_msg", null);
            bVar.f67788a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f67789b = -1;
            } else {
                bVar.f67789b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f67788a);
            jSONObject.put("error_code", String.valueOf(this.f67789b));
            jSONObject.put("error_msg", this.f67790c);
            jSONObject.put("real_device_plan", this.f67791d);
            jSONObject.put("device_plans", this.f67792e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
