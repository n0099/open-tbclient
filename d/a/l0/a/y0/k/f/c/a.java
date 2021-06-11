package d.a.l0.a.y0.k.f.c;

import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.a.y0.k.f.a f49570a = new d.a.l0.a.y0.k.f.a();

    public a(String str) {
    }

    @Override // d.a.l0.a.y0.k.f.c.f, d.a.l0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        if (this.f49570a.f()) {
            this.f49570a.k();
            d.a.l0.a.y0.k.f.b.f();
            return;
        }
        this.f49570a.g("fmpArrived", z ? "1" : "0");
    }

    public void d() {
        this.f49570a.c();
        if (this.f49570a.e("fmpArrived")) {
            this.f49570a.k();
            d.a.l0.a.y0.k.f.b.f();
        }
    }
}
