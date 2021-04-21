package d.b.h0.g.b0.a.b;

import d.b.h0.i.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f48634a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48635b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f48634a = nVar;
        c(this.f48635b);
    }

    public final void c(boolean z) {
        this.f48635b = z;
        n nVar = this.f48634a;
        if (nVar == null) {
            return;
        }
        if (z) {
            nVar.d(4, 1);
        } else {
            nVar.k(4);
        }
    }

    public void d() {
        c(true);
    }
}
