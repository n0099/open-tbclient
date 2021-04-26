package d.a.h0.a.l1.c.c;

import android.util.Log;
import d.a.h0.a.k0.b.g;
import d.a.h0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f43252a;

    /* renamed from: b  reason: collision with root package name */
    public String f43253b;

    /* renamed from: c  reason: collision with root package name */
    public Object f43254c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43255d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f43256e;

    public a(String str) {
        this.f43253b = str;
    }

    public static String a(d.a.h0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f43248f);
            jSONObject.put("pluginProvider", bVar.f43244b);
            jSONObject.put("args", bVar.f43249g);
            jSONObject.put("slaveId", bVar.f43247e);
        } catch (JSONException e2) {
            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f43253b);
            jSONObject.put("isSuccess", this.f43255d);
            jSONObject.put("data", this.f43256e);
            if (this.f43254c != null) {
                jSONObject.put("error", this.f43254c.toString());
            }
        } catch (JSONException e2) {
            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f43119b = jSONObject;
        f.V().o(this.f43252a, gVar);
        d.a.h0.a.l1.d.a.a("finish event, isSuccess = " + this.f43255d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f43253b + "', error=" + this.f43254c + ", isSuccess=" + this.f43255d + ", resultData='" + this.f43256e + "'}";
    }
}
