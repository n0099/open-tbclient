package d.b.b;

import android.app.Application;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class t1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public long f68940d;

    /* renamed from: e  reason: collision with root package name */
    public final i f68941e;

    /* renamed from: f  reason: collision with root package name */
    public final j f68942f;

    public t1(Application application, j jVar, i iVar) {
        super(application);
        this.f68942f = jVar;
        this.f68941e = iVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long O = this.f68941e.O();
        if (O < 600000) {
            O = 600000;
        }
        return this.f68940d + O;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f68815g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        JSONObject c2 = this.f68942f.c();
        if (this.f68942f.v() == 0 || c2 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f68942f.c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject k = x.k(x.e(y.a(this.f68952a, this.f68942f.c(), x.b().e(), true, a.k()), x.f68963e), jSONObject);
        if (k != null) {
            a.f().a(!s0.f(a.b(), k), k);
            if (r0.f68927b) {
                r0.a("getAbConfig " + k, null);
            }
            this.f68942f.e(k);
            this.f68940d = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ab";
    }
}
