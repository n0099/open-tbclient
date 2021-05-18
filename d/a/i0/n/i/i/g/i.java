package d.a.i0.n.i.i.g;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47886f = d.a.i0.n.c.f47808a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.n.f.d f47888b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.i0.n.h.e> f47889c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.i0.n.h.e> f47890d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.i0.n.h.e> f47891e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.i0.n.i.i.b> f47887a = new ArrayList();

    public i(d.a.i0.n.f.d dVar) {
        this.f47888b = dVar;
        d.b().e(this);
    }

    @Override // d.a.i0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.a.i0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.a.i0.n.i.i.b> it = this.f47887a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.i0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f47887a.remove(next);
                if (h2 == 2) {
                    this.f47891e.add(next.a().f47878e.f47877b);
                } else if (h2 == 3) {
                    this.f47890d.add(next.a().f47878e.f47877b);
                } else if (h2 != 10) {
                    if (d.a.i0.n.c.f47808a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f47889c.add(next.a().f47878e.f47877b);
                }
            }
        }
        d();
    }

    public void c(d.a.i0.n.i.i.b bVar) {
        if (bVar != null) {
            this.f47887a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f47887a.isEmpty()) {
            this.f47888b.b();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f47886f) {
            Log.i("PMSTaskGroup", d.a.i0.n.c.b().v() + " startDownload: total=" + this.f47887a.size());
        }
        for (d.a.i0.n.i.i.b bVar : this.f47887a) {
            if (f47886f) {
                Log.i("PMSTaskGroup", d.a.i0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
