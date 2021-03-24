package d.b.g0.a.y1;

import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.y1.d.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47124e = k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public static a f47125f;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.y1.d.b f47126a = new d.b.g0.a.y1.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f47127b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f47128c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.y1.c.a f47129d = new d.b.g0.a.y1.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.y1.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f47130b;

        public b(a aVar) {
        }

        public void b() {
            this.f47130b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f47130b);
            } catch (JSONException e2) {
                if (d.b.g0.a.y1.d.a.f47133a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f47125f == null) {
            synchronized (a.class) {
                if (f47125f == null) {
                    f47125f = new a();
                }
            }
        }
        return f47125f;
    }

    public void a() {
        this.f47126a.c();
        this.f47127b.b();
        this.f47128c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f47129d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f47128c.c();
        if (f47124e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f47126a.d();
        if (f47124e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.b.g0.a.y1.c.a f() {
        return this.f47129d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f47127b.c();
        if (f47124e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f47127b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f47126a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f47126a.b(jSONObject);
    }

    public void l() {
        if (this.f47128c.f47130b == null || this.f47128c.f47130b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f47129d.d(jSONArray);
    }
}
