package d.b.g0.g.b0.a.b;

import d.b.g0.i.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f47912a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47913b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f47912a = nVar;
        c(this.f47913b);
    }

    public final void c(boolean z) {
        this.f47913b = z;
        n nVar = this.f47912a;
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
