package d.b.g0.l.l.h.f;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49353f = d.b.g0.l.f.f49281a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.l.h.d f49355b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f49356c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f49357d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f49358e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.g0.l.l.h.b> f49354a = new ArrayList();

    public i(d.b.g0.l.h.d dVar) {
        this.f49355b = dVar;
        d.b().e(this);
    }

    @Override // d.b.g0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.b.g0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.b.g0.l.l.h.b> it = this.f49354a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.g0.l.l.h.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f49354a.remove(next);
                if (h2 == 2) {
                    this.f49358e.add(next.a().f49346e.f49345b);
                } else if (h2 == 3) {
                    this.f49357d.add(next.a().f49346e.f49345b);
                } else if (h2 != 10) {
                    if (d.b.g0.l.f.f49281a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f49356c.add(next.a().f49346e.f49345b);
                }
            }
        }
        d();
    }

    public void c(d.b.g0.l.l.h.b bVar) {
        if (bVar != null) {
            this.f49354a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f49354a.isEmpty()) {
            this.f49355b.h();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f49353f) {
            Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: total=" + this.f49354a.size());
        }
        for (d.b.g0.l.l.h.b bVar : this.f49354a) {
            if (f49353f) {
                Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
