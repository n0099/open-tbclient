package d.a.m0.a.t1.c.c;

import android.util.Log;
import d.a.m0.a.g1.f;
import d.a.m0.a.o0.d.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48543a;

    /* renamed from: b  reason: collision with root package name */
    public String f48544b;

    /* renamed from: c  reason: collision with root package name */
    public Object f48545c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48546d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f48547e;

    public a(String str) {
        this.f48544b = str;
    }

    public static String a(d.a.m0.a.t1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f48539f);
            jSONObject.put("pluginProvider", bVar.f48535b);
            jSONObject.put("args", bVar.f48540g);
            jSONObject.put("slaveId", bVar.f48538e);
        } catch (JSONException e2) {
            d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.f48544b);
            jSONObject.put("isSuccess", this.f48546d);
            jSONObject.put("data", this.f48547e);
            if (this.f48545c != null) {
                jSONObject.put("error", this.f48545c.toString());
            }
        } catch (JSONException e2) {
            d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f47708c = jSONObject;
        f.V().m(this.f48543a, gVar);
        d.a.m0.a.t1.d.a.a("finish event, isSuccess = " + this.f48546d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f48544b + "', error=" + this.f48545c + ", isSuccess=" + this.f48546d + ", resultData='" + this.f48547e + "'}";
    }
}
