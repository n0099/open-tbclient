package d.a.h0.l.l.h.f;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47193f = d.a.h0.l.f.f47117a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.l.h.d f47195b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.h0.l.k.e> f47196c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.h0.l.k.e> f47197d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.h0.l.k.e> f47198e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.h0.l.l.h.b> f47194a = new ArrayList();

    public i(d.a.h0.l.h.d dVar) {
        this.f47195b = dVar;
        d.b().e(this);
    }

    @Override // d.a.h0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.a.h0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.a.h0.l.l.h.b> it = this.f47194a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.h0.l.l.h.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f47194a.remove(next);
                if (h2 == 2) {
                    this.f47198e.add(next.a().f47185e.f47184b);
                } else if (h2 == 3) {
                    this.f47197d.add(next.a().f47185e.f47184b);
                } else if (h2 != 10) {
                    if (d.a.h0.l.f.f47117a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f47196c.add(next.a().f47185e.f47184b);
                }
            }
        }
        d();
    }

    public void c(d.a.h0.l.l.h.b bVar) {
        if (bVar != null) {
            this.f47194a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f47194a.isEmpty()) {
            this.f47195b.c();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f47193f) {
            Log.i("PMSTaskGroup", d.a.h0.l.f.b().u() + " startDownload: total=" + this.f47194a.size());
        }
        for (d.a.h0.l.l.h.b bVar : this.f47194a) {
            if (f47193f) {
                Log.i("PMSTaskGroup", d.a.h0.l.f.b().u() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
