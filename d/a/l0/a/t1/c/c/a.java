package d.a.l0.a.t1.c.c;

import android.util.Log;
import d.a.l0.a.g1.f;
import d.a.l0.a.o0.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48435a;

    /* renamed from: b  reason: collision with root package name */
    public String f48436b;

    /* renamed from: c  reason: collision with root package name */
    public Object f48437c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48438d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f48439e;

    public a(String str) {
        this.f48436b = str;
    }

    public static String a(d.a.l0.a.t1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f48431f);
            jSONObject.put("pluginProvider", bVar.f48427b);
            jSONObject.put("args", bVar.f48432g);
            jSONObject.put("slaveId", bVar.f48430e);
        } catch (JSONException e2) {
            d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f48436b);
            jSONObject.put("isSuccess", this.f48438d);
            jSONObject.put("data", this.f48439e);
            if (this.f48437c != null) {
                jSONObject.put("error", this.f48437c.toString());
            }
        } catch (JSONException e2) {
            d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f47600c = jSONObject;
        f.V().m(this.f48435a, gVar);
        d.a.l0.a.t1.d.a.a("finish event, isSuccess = " + this.f48438d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f48436b + "', error=" + this.f48437c + ", isSuccess=" + this.f48438d + ", resultData='" + this.f48439e + "'}";
    }
}
