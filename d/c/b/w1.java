package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public final i f65092d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65093e;

    public w1(Context context, j jVar, i iVar) {
        super(context);
        this.f65093e = jVar;
        this.f65092d = iVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65092d.D() + 21600000;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f64955g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject c2 = this.f65093e.c();
        if (this.f65093e.v() == 0 || c2 == null || this.f65092d.D() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c2);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject j = x.j(x.e(y.a(this.f65087a, this.f65093e.c(), x.b().d(), true, a.k()), x.f65098e), jSONObject);
        a.f().d(!s0.f(j, this.f65092d.C()), j);
        if (j != null) {
            this.f65092d.u(j);
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "c";
    }
}
