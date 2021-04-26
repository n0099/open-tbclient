package d.a.h0.l.l.h.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f47181b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.l.l.h.e.b f47182a = new d.a.h0.l.l.h.e.b();

    public static d b() {
        d dVar = f47181b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f47181b == null) {
                f47181b = new d();
            }
        }
        return f47181b;
    }

    public d.a.h0.l.l.h.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f47182a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f47182a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f47182a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f47182a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f47182a.i(bVar);
    }
}
