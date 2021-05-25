package d.a.l0.a.i2;

import android.util.Log;
import d.a.l0.a.i2.d.c;
import d.a.l0.a.k;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43017e = k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43018f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.i2.d.b f43019a = new d.a.l0.a.i2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f43020b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f43021c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i2.c.a f43022d = new d.a.l0.a.i2.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.i2.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f43023b;

        public b(a aVar) {
        }

        public void b() {
            this.f43023b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f43023b);
            } catch (JSONException e2) {
                if (d.a.l0.a.i2.d.a.f43026a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f43018f == null) {
            synchronized (a.class) {
                if (f43018f == null) {
                    f43018f = new a();
                }
            }
        }
        return f43018f;
    }

    public void a() {
        this.f43019a.c();
        this.f43020b.b();
        this.f43021c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f43022d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f43021c.c();
        if (f43017e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f43019a.d();
        if (f43017e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.a.l0.a.i2.c.a f() {
        return this.f43022d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f43020b.c();
        if (f43017e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f43020b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f43019a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f43019a.b(jSONObject);
    }

    public void l() {
        if (this.f43021c.f43023b == null || this.f43021c.f43023b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f43022d.d(jSONArray);
    }
}
