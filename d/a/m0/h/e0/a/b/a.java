package d.a.m0.h.e0.a.b;

import d.a.m0.k.n;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public n f51095a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51096b = true;

    public void a() {
        c(false);
    }

    public void b(n nVar) {
        this.f51095a = nVar;
        c(this.f51096b);
    }

    public final void c(boolean z) {
        this.f51096b = z;
        n nVar = this.f51095a;
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
