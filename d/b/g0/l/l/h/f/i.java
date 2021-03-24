package d.b.g0.l.l.h.f;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48960f = d.b.g0.l.f.f48888a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.l.h.d f48962b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48963c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48964d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.g0.l.k.e> f48965e = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.g0.l.l.h.b> f48961a = new ArrayList();

    public i(d.b.g0.l.h.d dVar) {
        this.f48962b = dVar;
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
        Iterator<d.b.g0.l.l.h.b> it = this.f48961a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.g0.l.l.h.b next = it.next();
            if (next.b(fVar)) {
                int h2 = fVar.h();
                this.f48961a.remove(next);
                if (h2 == 2) {
                    this.f48965e.add(next.a().f48953e.f48952b);
                } else if (h2 == 3) {
                    this.f48964d.add(next.a().f48953e.f48952b);
                } else if (h2 != 10) {
                    if (d.b.g0.l.f.f48888a) {
                        Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + h2);
                    }
                } else {
                    this.f48963c.add(next.a().f48953e.f48952b);
                }
            }
        }
        d();
    }

    public void c(d.b.g0.l.l.h.b bVar) {
        if (bVar != null) {
            this.f48961a.add(bVar);
        }
    }

    public final boolean d() {
        if (this.f48961a.isEmpty()) {
            this.f48962b.h();
            d.b().g(this);
            return true;
        }
        return false;
    }

    public void e() {
        if (d()) {
            return;
        }
        if (f48960f) {
            Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: total=" + this.f48961a.size());
        }
        for (d.b.g0.l.l.h.b bVar : this.f48961a) {
            if (f48960f) {
                Log.i("PMSTaskGroup", d.b.g0.l.f.b().A() + " startDownload: for handler=" + bVar);
            }
            bVar.c(false);
        }
    }
}
