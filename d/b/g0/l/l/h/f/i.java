package d.b.g0.l.l.h.f;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48961f = d.b.g0.l.f.f48889a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.l.h.d f48963b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48964c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48965d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48966e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.g0.l.l.h.b> f48962a = new ArrayList();

    public i(d.b.g0.l.h.d dVar) {
        this.f48963b = dVar;
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
        Iterator<d.b.g0.l.l.h.b> it = this.f48962a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.g0.l.l.h.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f48962a.remove(next);
                if (h2 == 2) {
                    this.f48966e.add(next.a().f48954e.f48953b);
                } else if (h2 == 3) {
                    this.f48965d.add(next.a().f48954e.f48953b);
                } else if (h2 != 10) {
                    if (d.b.g0.l.f.f48889a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f48964c.add(next.a().f48954e.f48953b);
                }
            }
        }
        d();
    }

    public void c(d.b.g0.l.l.h.b bVar) {
        if (bVar != null) {
            this.f48962a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f48962a.isEmpty()) {
            this.f48963b.h();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f48961f) {
            Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: total=" + this.f48962a.size());
        }
        for (d.b.g0.l.l.h.b bVar : this.f48962a) {
            if (f48961f) {
                Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
