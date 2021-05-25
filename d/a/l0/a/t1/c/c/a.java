package d.a.l0.a.t1.c.c;

import android.util.Log;
import d.a.l0.a.g1.f;
import d.a.l0.a.o0.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44761a;

    /* renamed from: b  reason: collision with root package name */
    public String f44762b;

    /* renamed from: c  reason: collision with root package name */
    public Object f44763c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44764d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f44765e;

    public a(String str) {
        this.f44762b = str;
    }

    public static String a(d.a.l0.a.t1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f44757f);
            jSONObject.put("pluginProvider", bVar.f44753b);
            jSONObject.put("args", bVar.f44758g);
            jSONObject.put("slaveId", bVar.f44756e);
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
            jSONObject.put("componentId", this.f44762b);
            jSONObject.put("isSuccess", this.f44764d);
            jSONObject.put("data", this.f44765e);
            if (this.f44763c != null) {
                jSONObject.put("error", this.f44763c.toString());
            }
        } catch (JSONException e2) {
            d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f43924c = jSONObject;
        f.V().m(this.f44761a, gVar);
        d.a.l0.a.t1.d.a.a("finish event, isSuccess = " + this.f44764d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f44762b + "', error=" + this.f44763c + ", isSuccess=" + this.f44764d + ", resultData='" + this.f44765e + "'}";
    }
}
