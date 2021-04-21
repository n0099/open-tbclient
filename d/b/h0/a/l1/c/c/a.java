package d.b.h0.a.l1.c.c;

import android.util.Log;
import d.b.h0.a.k0.b.g;
import d.b.h0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45916a;

    /* renamed from: b  reason: collision with root package name */
    public String f45917b;

    /* renamed from: c  reason: collision with root package name */
    public Object f45918c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45919d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f45920e;

    public a(String str) {
        this.f45917b = str;
    }

    public static String a(d.b.h0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f45913f);
            jSONObject.put("pluginProvider", bVar.f45909b);
            jSONObject.put("args", bVar.f45914g);
            jSONObject.put("slaveId", bVar.f45912e);
        } catch (JSONException e2) {
            d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f45917b);
            jSONObject.put("isSuccess", this.f45919d);
            jSONObject.put("data", this.f45920e);
            if (this.f45918c != null) {
                jSONObject.put("error", this.f45918c.toString());
            }
        } catch (JSONException e2) {
            d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f45790b = jSONObject;
        f.V().z(this.f45916a, gVar);
        d.b.h0.a.l1.d.a.a("finish event, isSuccess = " + this.f45919d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f45917b + "', error=" + this.f45918c + ", isSuccess=" + this.f45919d + ", resultData='" + this.f45920e + "'}";
    }
}
