package d.a.m0.a.y0.k.f.c;

import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.m0.a.y0.k.f.a f49678a = new d.a.m0.a.y0.k.f.a();

    public a(String str) {
    }

    @Override // d.a.m0.a.y0.k.f.c.f, d.a.m0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        if (this.f49678a.f()) {
            this.f49678a.k();
            d.a.m0.a.y0.k.f.b.f();
            return;
        }
        this.f49678a.g("fmpArrived", z ? "1" : "0");
    }

    public void d() {
        this.f49678a.c();
        if (this.f49678a.e("fmpArrived")) {
            this.f49678a.k();
            d.a.m0.a.y0.k.f.b.f();
        }
    }
}
