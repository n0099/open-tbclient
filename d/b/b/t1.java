package d.b.b;

import android.app.Application;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public long f64376d;

    /* renamed from: e  reason: collision with root package name */
    public final i f64377e;

    /* renamed from: f  reason: collision with root package name */
    public final j f64378f;

    public t1(Application application, j jVar, i iVar) {
        super(application);
        this.f64378f = jVar;
        this.f64377e = iVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long O = this.f64377e.O();
        if (O < 600000) {
            O = 600000;
        }
        return this.f64376d + O;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f64251g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        JSONObject c2 = this.f64378f.c();
        if (this.f64378f.v() == 0 || c2 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f64378f.c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject k = x.k(x.e(y.a(this.f64388a, this.f64378f.c(), x.b().e(), true, a.k()), x.f64399e), jSONObject);
        if (k != null) {
            a.f().a(!s0.f(a.b(), k), k);
            if (r0.f64363b) {
                r0.a("getAbConfig " + k, null);
            }
            this.f64378f.e(k);
            this.f64376d = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ab";
    }
}
