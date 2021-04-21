package d.b.h0.l.l.h.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f49671b;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.l.l.h.e.b f49672a = new d.b.h0.l.l.h.e.b();

    public static d b() {
        d dVar = f49671b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f49671b == null) {
                f49671b = new d();
            }
        }
        return f49671b;
    }

    public d.b.h0.l.l.h.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f49672a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f49672a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f49672a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f49672a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f49672a.i(bVar);
    }
}
