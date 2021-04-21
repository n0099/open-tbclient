package d.c.b;

import android.app.Application;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public long f66016d;

    /* renamed from: e  reason: collision with root package name */
    public final i f66017e;

    /* renamed from: f  reason: collision with root package name */
    public final j f66018f;

    public t1(Application application, j jVar, i iVar) {
        super(application);
        this.f66018f = jVar;
        this.f66017e = iVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        long O = this.f66017e.O();
        if (O < 600000) {
            O = 600000;
        }
        return this.f66016d + O;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f65896g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject c2 = this.f66018f.c();
        if (this.f66018f.v() == 0 || c2 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f66018f.c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject k = x.k(x.e(y.a(this.f66028a, this.f66018f.c(), x.b().e(), true, a.k()), x.f66039e), jSONObject);
        if (k != null) {
            a.f().b(!s0.f(a.b(), k), k);
            if (r0.f66004b) {
                r0.a("getAbConfig " + k, null);
            }
            this.f66018f.e(k);
            this.f66016d = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "ab";
    }
}
