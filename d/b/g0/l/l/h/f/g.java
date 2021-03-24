package d.b.g0.l.l.h.f;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f48957e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f48958f;

    /* renamed from: g  reason: collision with root package name */
    public a f48959g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f48958f = atomicBoolean;
        this.f48957e = bVar;
        this.f48959g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f48957e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f48957e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f48958f.get() && (a2 = this.f48959g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.b.g0.l.f.f48888a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
