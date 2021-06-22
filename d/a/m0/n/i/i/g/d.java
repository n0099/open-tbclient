package d.a.m0.n.i.i.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f51832b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.n.i.i.e.b f51833a = new d.a.m0.n.i.i.e.b();

    public static d b() {
        d dVar = f51832b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f51832b == null) {
                f51832b = new d();
            }
        }
        return f51832b;
    }

    public d.a.m0.n.i.i.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f51833a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f51833a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f51833a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f51833a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f51833a.i(bVar);
    }
}
