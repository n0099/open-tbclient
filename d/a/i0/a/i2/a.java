package d.a.i0.a.i2;

import android.util.Log;
import d.a.i0.a.i2.d.c;
import d.a.i0.a.k;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42843e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f42844f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.i2.d.b f42845a = new d.a.i0.a.i2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f42846b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f42847c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.i2.c.a f42848d = new d.a.i0.a.i2.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.i2.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f42849b;

        public b(a aVar) {
        }

        public void b() {
            this.f42849b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f42849b);
            } catch (JSONException e2) {
                if (d.a.i0.a.i2.d.a.f42852a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f42844f == null) {
            synchronized (a.class) {
                if (f42844f == null) {
                    f42844f = new a();
                }
            }
        }
        return f42844f;
    }

    public void a() {
        this.f42845a.c();
        this.f42846b.b();
        this.f42847c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f42848d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f42847c.c();
        if (f42843e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f42845a.d();
        if (f42843e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.a.i0.a.i2.c.a f() {
        return this.f42848d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f42846b.c();
        if (f42843e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f42846b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f42845a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f42845a.b(jSONObject);
    }

    public void l() {
        if (this.f42847c.f42849b == null || this.f42847c.f42849b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f42848d.d(jSONArray);
    }
}
