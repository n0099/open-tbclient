package d.a.l0.n.i.i.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f48050b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.n.i.i.e.b f48051a = new d.a.l0.n.i.i.e.b();

    public static d b() {
        d dVar = f48050b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f48050b == null) {
                f48050b = new d();
            }
        }
        return f48050b;
    }

    public d.a.l0.n.i.i.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f48051a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f48051a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f48051a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f48051a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f48051a.i(bVar);
    }
}
