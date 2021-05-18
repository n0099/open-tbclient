package d.a.i0.a.y0.k.f.c;

import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.i0.a.y0.k.f.a f45720a = new d.a.i0.a.y0.k.f.a();

    public a(String str) {
    }

    @Override // d.a.i0.a.y0.k.f.c.f, d.a.i0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        if (this.f45720a.f()) {
            this.f45720a.k();
            d.a.i0.a.y0.k.f.b.f();
            return;
        }
        this.f45720a.g("fmpArrived", z ? "1" : "0");
    }

    public void d() {
        this.f45720a.c();
        if (this.f45720a.e("fmpArrived")) {
            this.f45720a.k();
            d.a.i0.a.y0.k.f.b.f();
        }
    }
}
