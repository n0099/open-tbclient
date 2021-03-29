package d.b.g0.l.l.h.f;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f48958e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f48959f;

    /* renamed from: g  reason: collision with root package name */
    public a f48960g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f48959f = atomicBoolean;
        this.f48958e = bVar;
        this.f48960g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f48958e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48889a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f48958e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f48959f.get() && (a2 = this.f48960g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.b.g0.l.f.f48889a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
