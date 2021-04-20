package d.b.g0.a.l1.c.c;

import android.util.Log;
import d.b.g0.a.k0.b.g;
import d.b.g0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45587a;

    /* renamed from: b  reason: collision with root package name */
    public String f45588b;

    /* renamed from: c  reason: collision with root package name */
    public Object f45589c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45590d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f45591e;

    public a(String str) {
        this.f45588b = str;
    }

    public static String a(d.b.g0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f45584f);
            jSONObject.put("pluginProvider", bVar.f45580b);
            jSONObject.put("args", bVar.f45585g);
            jSONObject.put("slaveId", bVar.f45583e);
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f45588b);
            jSONObject.put("isSuccess", this.f45590d);
            jSONObject.put("data", this.f45591e);
            if (this.f45589c != null) {
                jSONObject.put("error", this.f45589c.toString());
            }
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f45461b = jSONObject;
        f.V().z(this.f45587a, gVar);
        d.b.g0.a.l1.d.a.a("finish event, isSuccess = " + this.f45590d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f45588b + "', error=" + this.f45589c + ", isSuccess=" + this.f45590d + ", resultData='" + this.f45591e + "'}";
    }
}
