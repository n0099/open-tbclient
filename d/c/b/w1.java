package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public final i f65093d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65094e;

    public w1(Context context, j jVar, i iVar) {
        super(context);
        this.f65094e = jVar;
        this.f65093d = iVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65093d.D() + 21600000;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f64956g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject c2 = this.f65094e.c();
        if (this.f65094e.v() == 0 || c2 == null || this.f65093d.D() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c2);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject j = x.j(x.e(y.a(this.f65088a, this.f65094e.c(), x.b().d(), true, a.k()), x.f65099e), jSONObject);
        a.f().d(!s0.f(j, this.f65093d.C()), j);
        if (j != null) {
            this.f65093d.u(j);
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "c";
    }
}
