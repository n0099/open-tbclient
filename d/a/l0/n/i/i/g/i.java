package d.a.l0.n.i.i.g;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48062f = d.a.l0.n.c.f47984a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.n.f.d f48064b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f48065c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f48066d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f48067e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.l0.n.i.i.b> f48063a = new ArrayList();

    public i(d.a.l0.n.f.d dVar) {
        this.f48064b = dVar;
        d.b().e(this);
    }

    @Override // d.a.l0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.a.l0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.a.l0.n.i.i.b> it = this.f48063a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.l0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f48063a.remove(next);
                if (h2 == 2) {
                    this.f48067e.add(next.a().f48054e.f48053b);
                } else if (h2 == 3) {
                    this.f48066d.add(next.a().f48054e.f48053b);
                } else if (h2 != 10) {
                    if (d.a.l0.n.c.f47984a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f48065c.add(next.a().f48054e.f48053b);
                }
            }
        }
        d();
    }

    public void c(d.a.l0.n.i.i.b bVar) {
        if (bVar != null) {
            this.f48063a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f48063a.isEmpty()) {
            this.f48064b.b();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f48062f) {
            Log.i("PMSTaskGroup", d.a.l0.n.c.b().v() + " startDownload: total=" + this.f48063a.size());
        }
        for (d.a.l0.n.i.i.b bVar : this.f48063a) {
            if (f48062f) {
                Log.i("PMSTaskGroup", d.a.l0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
