package d.c.b;

import android.app.Application;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public long f65076d;

    /* renamed from: e  reason: collision with root package name */
    public final i f65077e;

    /* renamed from: f  reason: collision with root package name */
    public final j f65078f;

    public t1(Application application, j jVar, i iVar) {
        super(application);
        this.f65078f = jVar;
        this.f65077e = iVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        long O = this.f65077e.O();
        if (O < 600000) {
            O = 600000;
        }
        return this.f65076d + O;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f64956g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject c2 = this.f65078f.c();
        if (this.f65078f.v() == 0 || c2 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f65078f.c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject k = x.k(x.e(y.a(this.f65088a, this.f65078f.c(), x.b().e(), true, a.k()), x.f65099e), jSONObject);
        if (k != null) {
            a.f().b(!s0.f(a.b(), k), k);
            if (r0.f65064b) {
                r0.a("getAbConfig " + k, null);
            }
            this.f65078f.e(k);
            this.f65076d = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ab";
    }
}
