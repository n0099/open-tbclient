package d.b.h0.l.l.h.f;

import android.util.Log;
import java.util.Iterator;
import java.util.Vector;
/* loaded from: classes3.dex */
public class l implements b {

    /* renamed from: b  reason: collision with root package name */
    public Object f49695b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Vector<b> f49694a = new Vector<>();

    public l(b bVar) {
        c(bVar);
    }

    @Override // d.b.h0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
        try {
            synchronized (this.f49695b) {
                Iterator<b> it = this.f49694a.iterator();
                while (it.hasNext()) {
                    it.next().a(fVar);
                }
            }
        } catch (Throwable th) {
            if (d.b.h0.l.f.f49610a) {
                Log.w("RuntimeTaskObserver", "notifyTaskRunning error:" + th.toString());
            }
        }
    }

    @Override // d.b.h0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        Vector vector = new Vector();
        try {
            synchronized (this.f49695b) {
                Iterator<b> it = this.f49694a.iterator();
                while (it.hasNext()) {
                    vector.add(it.next());
                }
            }
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).b(fVar);
            }
        } catch (Throwable th) {
            if (d.b.h0.l.f.f49610a) {
                Log.w("RuntimeTaskObserver", "notifyTaskEnd error:" + th.toString());
            }
        }
    }

    public void c(b bVar) {
        if (bVar != null) {
            synchronized (this.f49695b) {
                this.f49694a.add(bVar);
            }
        }
    }

    public void d(b bVar) {
        if (bVar != null) {
            synchronized (this.f49695b) {
                if (!this.f49694a.remove(bVar)) {
                    this.f49694a.remove(this.f49694a.indexOf(bVar));
                }
            }
        }
    }
}
