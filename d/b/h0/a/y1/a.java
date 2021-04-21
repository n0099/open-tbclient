package d.b.h0.a.y1;

import android.util.Log;
import d.b.h0.a.k;
import d.b.h0.a.y1.d.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47846e = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public static a f47847f;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.y1.d.b f47848a = new d.b.h0.a.y1.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f47849b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f47850c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.y1.c.a f47851d = new d.b.h0.a.y1.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.y1.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f47852b;

        public b(a aVar) {
        }

        public void b() {
            this.f47852b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f47852b);
            } catch (JSONException e2) {
                if (d.b.h0.a.y1.d.a.f47855a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f47847f == null) {
            synchronized (a.class) {
                if (f47847f == null) {
                    f47847f = new a();
                }
            }
        }
        return f47847f;
    }

    public void a() {
        this.f47848a.c();
        this.f47849b.b();
        this.f47850c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f47851d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f47850c.c();
        if (f47846e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f47848a.d();
        if (f47846e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.b.h0.a.y1.c.a f() {
        return this.f47851d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f47849b.c();
        if (f47846e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f47849b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f47848a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f47848a.b(jSONObject);
    }

    public void l() {
        if (this.f47850c.f47852b == null || this.f47850c.f47852b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f47851d.d(jSONArray);
    }
}
