package d.a.h0.g.b0.a.b;

import d.a.h0.i.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f46098a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46099b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f46098a = nVar;
        c(this.f46099b);
    }

    public final void c(boolean z) {
        this.f46099b = z;
        n nVar = this.f46098a;
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
