package d.a.i0.n.i.i.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f47874b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.n.i.i.e.b f47875a = new d.a.i0.n.i.i.e.b();

    public static d b() {
        d dVar = f47874b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f47874b == null) {
                f47874b = new d();
            }
        }
        return f47874b;
    }

    public d.a.i0.n.i.i.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f47875a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f47875a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f47875a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f47875a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f47875a.i(bVar);
    }
}
