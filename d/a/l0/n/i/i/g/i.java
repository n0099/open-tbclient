package d.a.l0.n.i.i.g;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51736f = d.a.l0.n.c.f51658a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.n.f.d f51738b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f51739c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f51740d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.l0.n.h.e> f51741e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.l0.n.i.i.b> f51737a = new ArrayList();

    public i(d.a.l0.n.f.d dVar) {
        this.f51738b = dVar;
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
        Iterator<d.a.l0.n.i.i.b> it = this.f51737a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.l0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f51737a.remove(next);
                if (h2 == 2) {
                    this.f51741e.add(next.a().f51728e.f51727b);
                } else if (h2 == 3) {
                    this.f51740d.add(next.a().f51728e.f51727b);
                } else if (h2 != 10) {
                    if (d.a.l0.n.c.f51658a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f51739c.add(next.a().f51728e.f51727b);
                }
            }
        }
        d();
    }

    public void c(d.a.l0.n.i.i.b bVar) {
        if (bVar != null) {
            this.f51737a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f51737a.isEmpty()) {
            this.f51738b.b();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f51736f) {
            Log.i("PMSTaskGroup", d.a.l0.n.c.b().v() + " startDownload: total=" + this.f51737a.size());
        }
        for (d.a.l0.n.i.i.b bVar : this.f51737a) {
            if (f51736f) {
                Log.i("PMSTaskGroup", d.a.l0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
