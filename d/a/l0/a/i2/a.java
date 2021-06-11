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
    public static final boolean f46693e = k.f46875a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f46694f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.i2.d.b f46695a = new d.a.l0.a.i2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f46696b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f46697c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.i2.c.a f46698d = new d.a.l0.a.i2.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.i2.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f46699b;

        public b(a aVar) {
        }

        public void b() {
            this.f46699b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f46699b);
            } catch (JSONException e2) {
                if (d.a.l0.a.i2.d.a.f46702a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f46694f == null) {
            synchronized (a.class) {
                if (f46694f == null) {
                    f46694f = new a();
                }
            }
        }
        return f46694f;
    }

    public void a() {
        this.f46695a.c();
        this.f46696b.b();
        this.f46697c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f46698d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f46697c.c();
        if (f46693e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f46695a.d();
        if (f46693e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.a.l0.a.i2.c.a f() {
        return this.f46698d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f46696b.c();
        if (f46693e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f46696b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f46695a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f46695a.b(jSONObject);
    }

    public void l() {
        if (this.f46697c.f46699b == null || this.f46697c.f46699b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f46698d.d(jSONArray);
    }
}
