package d.b.b;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w1 extends v1 {

    /* renamed from: d  reason: collision with root package name */
    public final i f64393d;

    /* renamed from: e  reason: collision with root package name */
    public final j f64394e;

    public w1(Context context, j jVar, i iVar) {
        super(context);
        this.f64394e = jVar;
        this.f64393d = iVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f64393d.D() + 21600000;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return b2.f64251g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        JSONObject c2 = this.f64394e.c();
        if (this.f64394e.v() == 0 || c2 == null || this.f64393d.D() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c2);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject j = x.j(x.e(y.a(this.f64388a, this.f64394e.c(), x.b().d(), true, a.k()), x.f64399e), jSONObject);
        a.f().d(!s0.f(j, this.f64393d.C()), j);
        if (j != null) {
            this.f64393d.u(j);
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "c";
    }
}
