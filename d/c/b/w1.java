package d.c.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public final i f65938d;

    /* renamed from: e  reason: collision with root package name */
    public final j f65939e;

    public w1(Context context, j jVar, i iVar) {
        super(context);
        this.f65939e = jVar;
        this.f65938d = iVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65938d.D() + 21600000;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return b2.f65801g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject c2 = this.f65939e.c();
        if (this.f65939e.v() == 0 || c2 == null || this.f65938d.D() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c2);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject j = x.j(x.e(y.a(this.f65933a, this.f65939e.c(), x.b().d(), true, a.k()), x.f65944e), jSONObject);
        a.f().d(!s0.f(j, this.f65938d.C()), j);
        if (j != null) {
            this.f65938d.u(j);
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "c";
    }
}
