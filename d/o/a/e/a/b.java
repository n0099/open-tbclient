package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f66286a;

    /* renamed from: b  reason: collision with root package name */
    public int f66287b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f66288c;

    /* renamed from: d  reason: collision with root package name */
    public String f66289d;

    /* renamed from: e  reason: collision with root package name */
    public String f66290e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f66290e = jSONObject.optString("device_plans", null);
            bVar.f66289d = jSONObject.optString("real_device_plan", null);
            bVar.f66288c = jSONObject.optString("error_msg", null);
            bVar.f66286a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f66287b = -1;
            } else {
                bVar.f66287b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f66286a);
            jSONObject.put("error_code", String.valueOf(this.f66287b));
            jSONObject.put("error_msg", this.f66288c);
            jSONObject.put("real_device_plan", this.f66289d);
            jSONObject.put("device_plans", this.f66290e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
