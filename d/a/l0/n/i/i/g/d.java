package d.a.l0.n.i.i.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f51724b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.n.i.i.e.b f51725a = new d.a.l0.n.i.i.e.b();

    public static d b() {
        d dVar = f51724b;
        if (dVar != null) {
            return dVar;
        }
        synchronized (d.class) {
            if (f51724b == null) {
                f51724b = new d();
            }
        }
        return f51724b;
    }

    public d.a.l0.n.i.i.b a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new k(fVar, false);
    }

    public synchronized boolean c(String str) {
        return this.f51725a.e(str);
    }

    public synchronized boolean d(String str) {
        return this.f51725a.f(str);
    }

    public synchronized void e(b bVar) {
        this.f51725a.c(bVar);
    }

    public synchronized <T> void f(f<T> fVar) {
        fVar.r(false);
        this.f51725a.h(fVar);
    }

    public synchronized void g(b bVar) {
        this.f51725a.i(bVar);
    }
}
