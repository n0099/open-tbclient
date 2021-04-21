package d.b.h0.l.l.h.f;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f49679e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f49680f;

    /* renamed from: g  reason: collision with root package name */
    public a f49681g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f49680f = atomicBoolean;
        this.f49679e = bVar;
        this.f49681g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f49679e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f49679e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f49680f.get() && (a2 = this.f49681g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.b.h0.l.f.f49610a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
