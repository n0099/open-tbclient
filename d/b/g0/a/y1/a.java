package d.b.g0.a.y1;

import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.y1.d.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47125e = k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public static a f47126f;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.y1.d.b f47127a = new d.b.g0.a.y1.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f47128b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f47129c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.y1.c.a f47130d = new d.b.g0.a.y1.c.a();

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.y1.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f47131b;

        public b(a aVar) {
        }

        public void b() {
            this.f47131b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f47131b);
            } catch (JSONException e2) {
                if (d.b.g0.a.y1.d.a.f47134a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f47126f == null) {
            synchronized (a.class) {
                if (f47126f == null) {
                    f47126f = new a();
                }
            }
        }
        return f47126f;
    }

    public void a() {
        this.f47127a.c();
        this.f47128b.b();
        this.f47129c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f47130d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f47129c.c();
        if (f47125e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f47127a.d();
        if (f47125e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.b.g0.a.y1.c.a f() {
        return this.f47130d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f47128b.c();
        if (f47125e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f47128b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f47127a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f47127a.b(jSONObject);
    }

    public void l() {
        if (this.f47129c.f47131b == null || this.f47129c.f47131b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f47130d.d(jSONArray);
    }
}
