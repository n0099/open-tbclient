package d.b.h0.l.l.h.f;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49682f = d.b.h0.l.f.f49610a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.l.h.d f49684b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.h0.l.k.e> f49685c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.h0.l.k.e> f49686d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.h0.l.k.e> f49687e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.h0.l.l.h.b> f49683a = new ArrayList();

    public i(d.b.h0.l.h.d dVar) {
        this.f49684b = dVar;
        d.b().e(this);
    }

    @Override // d.b.h0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
    }

    @Override // d.b.h0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        if (fVar.j()) {
            return;
        }
        Iterator<d.b.h0.l.l.h.b> it = this.f49683a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.h0.l.l.h.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f49683a.remove(next);
                if (h2 == 2) {
                    this.f49687e.add(next.a().f49675e.f49674b);
                } else if (h2 == 3) {
                    this.f49686d.add(next.a().f49675e.f49674b);
                } else if (h2 != 10) {
                    if (d.b.h0.l.f.f49610a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f49685c.add(next.a().f49675e.f49674b);
                }
            }
        }
        d();
    }

    public void c(d.b.h0.l.l.h.b bVar) {
        if (bVar != null) {
            this.f49683a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f49683a.isEmpty()) {
            this.f49684b.h();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f49682f) {
            Log.i("PMSTaskGroup", d.b.h0.l.f.b().A() + " startDownload: total=" + this.f49683a.size());
        }
        for (d.b.h0.l.l.h.b bVar : this.f49683a) {
            if (f49682f) {
                Log.i("PMSTaskGroup", d.b.h0.l.f.b().A() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
