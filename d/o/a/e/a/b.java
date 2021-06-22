package d.o.a.e.a;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f70905a;

    /* renamed from: b  reason: collision with root package name */
    public int f70906b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f70907c;

    /* renamed from: d  reason: collision with root package name */
    public String f70908d;

    /* renamed from: e  reason: collision with root package name */
    public String f70909e;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f70909e = jSONObject.optString("device_plans", null);
            bVar.f70908d = jSONObject.optString("real_device_plan", null);
            bVar.f70907c = jSONObject.optString("error_msg", null);
            bVar.f70905a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                bVar.f70906b = -1;
            } else {
                bVar.f70906b = Integer.parseInt(optString);
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
            jSONObject.put("ah_plan_type", this.f70905a);
            jSONObject.put("error_code", String.valueOf(this.f70906b));
            jSONObject.put("error_msg", this.f70907c);
            jSONObject.put("real_device_plan", this.f70908d);
            jSONObject.put("device_plans", this.f70909e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }
}
