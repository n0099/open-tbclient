package d.a.l0.n.i.i.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f51733e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f51734f;

    /* renamed from: g  reason: collision with root package name */
    public a f51735g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f51734f = atomicBoolean;
        this.f51733e = bVar;
        this.f51735g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f51733e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.a.l0.n.c.f51658a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f51733e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f51734f.get() && (a2 = this.f51735g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.a.l0.n.c.f51658a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
