package d.a.m0.n.i.i.g;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51844f = d.a.m0.n.c.f51766a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.n.f.d f51846b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.m0.n.h.e> f51847c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.m0.n.h.e> f51848d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.m0.n.h.e> f51849e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.m0.n.i.i.b> f51845a = new ArrayList();

    public i(d.a.m0.n.f.d dVar) {
        this.f51846b = dVar;
        d.b().e(this);
    }

    @Override // d.a.m0.n.i.i.g.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.a.m0.n.i.i.g.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.a.m0.n.i.i.b> it = this.f51845a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.m0.n.i.i.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f51845a.remove(next);
                if (h2 == 2) {
                    this.f51849e.add(next.a().f51836e.f51835b);
                } else if (h2 == 3) {
                    this.f51848d.add(next.a().f51836e.f51835b);
                } else if (h2 != 10) {
                    if (d.a.m0.n.c.f51766a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f51847c.add(next.a().f51836e.f51835b);
                }
            }
        }
        d();
    }

    public void c(d.a.m0.n.i.i.b bVar) {
        if (bVar != null) {
            this.f51845a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f51845a.isEmpty()) {
            this.f51846b.b();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f51844f) {
            Log.i("PMSTaskGroup", d.a.m0.n.c.b().v() + " startDownload: total=" + this.f51845a.size());
        }
        for (d.a.m0.n.i.i.b bVar : this.f51845a) {
            if (f51844f) {
                Log.i("PMSTaskGroup", d.a.m0.n.c.b().v() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
