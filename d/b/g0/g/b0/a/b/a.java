package d.b.g0.g.b0.a.b;

import d.b.g0.i.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f47913a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47914b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f47913a = nVar;
        c(this.f47914b);
    }

    public final void c(boolean z) {
        this.f47914b = z;
        n nVar = this.f47913a;
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
