package d.a.f0.b.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static d f43533a;

    public static JSONObject a(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.b());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.a());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void b(Exception exc) {
        d dVar = f43533a;
        if (dVar != null) {
            dVar.a(a(exc).toString());
        }
    }

    public static void c(String str) {
        d dVar = f43533a;
        if (dVar != null) {
            dVar.a(str);
        }
    }
}
