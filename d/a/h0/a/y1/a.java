package d.a.h0.a.y1;

import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.a.y1.d.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45281e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static a f45282f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.y1.d.b f45283a = new d.a.h0.a.y1.d.b();

    /* renamed from: b  reason: collision with root package name */
    public c f45284b = new c();

    /* renamed from: c  reason: collision with root package name */
    public b f45285c = new b();

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.y1.c.a f45286d = new d.a.h0.a.y1.c.a();

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.y1.d.a<JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f45287b;

        public b(a aVar) {
        }

        public void b() {
            this.f45287b = null;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.f45287b);
            } catch (JSONException e2) {
                if (d.a.h0.a.y1.d.a.f45290a) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e2));
                }
            }
            return jSONObject;
        }
    }

    public static a d() {
        if (f45282f == null) {
            synchronized (a.class) {
                if (f45282f == null) {
                    f45282f = new a();
                }
            }
        }
        return f45282f;
    }

    public void a() {
        this.f45283a.c();
        this.f45284b.b();
        this.f45285c.b();
    }

    public File b() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        return this.f45286d.d(jSONArray);
    }

    public JSONObject c() {
        JSONObject c2 = this.f45285c.c();
        if (f45281e) {
            Log.d("SwanStabilityTracer", "extraTraces: " + c2);
        }
        return c2;
    }

    public JSONObject e() {
        JSONObject d2 = this.f45283a.d();
        if (f45281e) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + d2);
        }
        return d2;
    }

    public d.a.h0.a.y1.c.a f() {
        return this.f45286d;
    }

    public JSONObject g() {
        JSONObject c2 = this.f45284b.c();
        if (f45281e) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + c2);
        }
        return c2;
    }

    public void h(JSONObject jSONObject) {
        this.f45284b.a(jSONObject);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, String str2) {
        this.f45283a.a(str, str2);
    }

    public void k(JSONObject jSONObject) {
        this.f45283a.b(jSONObject);
    }

    public void l() {
        if (this.f45285c.f45287b == null || this.f45285c.f45287b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f45286d.d(jSONArray);
    }
}
