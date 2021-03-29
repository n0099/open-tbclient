package d.b.g0.l.l.h.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f48950b;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.l.l.h.e.b f48951a = new d.b.g0.l.l.h.e.b();

    public static d b() {
        d dVar = f48950b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f48950b == null) {
                f48950b = new d();
            }
        }
        return f48950b;
    }

    public d.b.g0.l.l.h.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f48951a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f48951a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f48951a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f48951a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f48951a.i(bVar);
    }
}
