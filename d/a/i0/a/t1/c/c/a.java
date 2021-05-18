package d.a.i0.a.t1.c.c;

import android.util.Log;
import d.a.i0.a.g1.f;
import d.a.i0.a.o0.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44585a;

    /* renamed from: b  reason: collision with root package name */
    public String f44586b;

    /* renamed from: c  reason: collision with root package name */
    public Object f44587c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44588d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f44589e;

    public a(String str) {
        this.f44586b = str;
    }

    public static String a(d.a.i0.a.t1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f44581f);
            jSONObject.put("pluginProvider", bVar.f44577b);
            jSONObject.put("args", bVar.f44582g);
            jSONObject.put("slaveId", bVar.f44580e);
        } catch (JSONException e2) {
            d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f44586b);
            jSONObject.put("isSuccess", this.f44588d);
            jSONObject.put("data", this.f44589e);
            if (this.f44587c != null) {
                jSONObject.put("error", this.f44587c.toString());
            }
        } catch (JSONException e2) {
            d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f43750c = jSONObject;
        f.V().m(this.f44585a, gVar);
        d.a.i0.a.t1.d.a.a("finish event, isSuccess = " + this.f44588d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f44586b + "', error=" + this.f44587c + ", isSuccess=" + this.f44588d + ", resultData='" + this.f44589e + "'}";
    }
}
