package d.b.g0.l.l.h.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f48949b;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.l.l.h.e.b f48950a = new d.b.g0.l.l.h.e.b();

    public static d b() {
        d dVar = f48949b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f48949b == null) {
                f48949b = new d();
            }
        }
        return f48949b;
    }

    public d.b.g0.l.l.h.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f48950a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f48950a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f48950a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f48950a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f48950a.i(bVar);
    }
}
