package d.a.h0.l.l.h.f;

import android.util.Log;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes3.dex */
public class l implements b {

    /* renamed from: b  reason: collision with root package name */
    public Object f47206b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Vector<b> f47205a = new Vector<>();

    public l(b bVar) {
        c(bVar);
    }

    @Override // d.a.h0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
        try {
            synchronized (this.f47206b) {
                Iterator<b> it = this.f47205a.iterator();
                while (it.hasNext()) {
                    it.next().a(fVar);
                }
            }
        } catch (Throwable th) {
            if (d.a.h0.l.f.f47117a) {
                Log.w("RuntimeTaskObserver", "notifyTaskRunning error:" + th.toString());
            }
        }
    }

    @Override // d.a.h0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        Vector vector = new Vector();
        try {
            synchronized (this.f47206b) {
                Iterator<b> it = this.f47205a.iterator();
                while (it.hasNext()) {
                    vector.add(it.next());
                }
            }
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).b(fVar);
            }
        } catch (Throwable th) {
            if (d.a.h0.l.f.f47117a) {
                Log.w("RuntimeTaskObserver", "notifyTaskEnd error:" + th.toString());
            }
        }
    }

    public void c(b bVar) {
        if (bVar != null) {
            synchronized (this.f47206b) {
                this.f47205a.add(bVar);
            }
        }
    }

    public void d(b bVar) {
        if (bVar != null) {
            synchronized (this.f47206b) {
                if (!this.f47205a.remove(bVar)) {
                    this.f47205a.remove(this.f47205a.indexOf(bVar));
                }
            }
        }
    }
}
