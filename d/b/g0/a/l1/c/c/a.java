package d.b.g0.a.l1.c.c;

import android.util.Log;
import d.b.g0.a.k0.b.g;
import d.b.g0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45195a;

    /* renamed from: b  reason: collision with root package name */
    public String f45196b;

    /* renamed from: c  reason: collision with root package name */
    public Object f45197c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45198d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f45199e;

    public a(String str) {
        this.f45196b = str;
    }

    public static String a(d.b.g0.a.l1.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.f45192f);
            jSONObject.put("pluginProvider", bVar.f45188b);
            jSONObject.put("args", bVar.f45193g);
            jSONObject.put("slaveId", bVar.f45191e);
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
            jSONObject.put("componentId", this.f45196b);
            jSONObject.put("isSuccess", this.f45198d);
            jSONObject.put("data", this.f45199e);
            if (this.f45197c != null) {
                jSONObject.put("error", this.f45197c.toString());
            }
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f45069b = jSONObject;
        f.V().z(this.f45195a, gVar);
        d.b.g0.a.l1.d.a.a("finish event, isSuccess = " + this.f45198d);
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.f45196b + "', error=" + this.f45197c + ", isSuccess=" + this.f45198d + ", resultData='" + this.f45199e + "'}";
    }
}
