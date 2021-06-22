package d.a.m0.a.i2;

import android.util.Log;
import d.a.m0.a.i2.d.c;
import d.a.m0.a.k;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46801e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f46802f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.i2.d.b f46803a = new d.a.m0.a.i2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f46804b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f46805c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.i2.c.a f46806d = new d.a.m0.a.i2.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.i2.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f46807b;

        public b(a aVar) {
        }

        public void b() {
            this.f46807b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f46807b);
            } catch (JSONException e2) {
                if (d.a.m0.a.i2.d.a.f46810a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f46802f == null) {
            synchronized (a.class) {
                if (f46802f == null) {
                    f46802f = new a();
                }
            }
        }
        return f46802f;
    }

    public void a() {
        this.f46803a.c();
        this.f46804b.b();
        this.f46805c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f46806d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f46805c.c();
        if (f46801e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f46803a.d();
        if (f46801e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.a.m0.a.i2.c.a f() {
        return this.f46806d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f46804b.c();
        if (f46801e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f46804b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f46803a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f46803a.b(jSONObject);
    }

    public void l() {
        if (this.f46805c.f46807b == null || this.f46805c.f46807b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f46806d.d(jSONArray);
    }
}
