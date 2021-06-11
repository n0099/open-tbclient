package d.b.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public final i f68853d;

    /* renamed from: e  reason: collision with root package name */
    public final j f68854e;

    public w1(Context context, j jVar, i iVar) {
        super(context);
        this.f68854e = jVar;
        this.f68853d = iVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f68853d.D() + 21600000;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f68711g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        JSONObject c2 = this.f68854e.c();
        if (this.f68854e.v() == 0 || c2 == null || this.f68853d.D() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c2);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject j = x.j(x.e(y.a(this.f68848a, this.f68854e.c(), x.b().d(), true, a.k()), x.f68859e), jSONObject);
        a.f().d(!s0.f(j, this.f68853d.C()), j);
        if (j != null) {
            this.f68853d.u(j);
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "c";
    }
}
