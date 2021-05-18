package d.b.b;

import android.app.Application;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public long f65062d;

    /* renamed from: e  reason: collision with root package name */
    public final i f65063e;

    /* renamed from: f  reason: collision with root package name */
    public final j f65064f;

    public t1(Application application, j jVar, i iVar) {
        super(application);
        this.f65064f = jVar;
        this.f65063e = iVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long O = this.f65063e.O();
        if (O < 600000) {
            O = 600000;
        }
        return this.f65062d + O;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f64937g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        JSONObject c2 = this.f65064f.c();
        if (this.f65064f.v() == 0 || c2 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f65064f.c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject k = x.k(x.e(y.a(this.f65074a, this.f65064f.c(), x.b().e(), true, a.k()), x.f65085e), jSONObject);
        if (k != null) {
            a.f().a(!s0.f(a.b(), k), k);
            if (r0.f65049b) {
                r0.a("getAbConfig " + k, null);
            }
            this.f65064f.e(k);
            this.f65062d = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "ab";
    }
}
