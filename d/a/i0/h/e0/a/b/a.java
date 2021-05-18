package d.a.i0.h.e0.a.b;

import d.a.i0.k.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f47137a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47138b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f47137a = nVar;
        c(this.f47138b);
    }

    public final void c(boolean z) {
        this.f47138b = z;
        n nVar = this.f47137a;
        if (nVar == null) {
            return;
        }
        if (z) {
            nVar.c(4, 1);
        } else {
            nVar.j(4);
        }
    }

    public void d() {
        c(true);
    }
}
