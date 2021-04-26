package d.a.h0.l.l.h.f;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f47190e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f47191f;

    /* renamed from: g  reason: collision with root package name */
    public a f47192g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f47191f = atomicBoolean;
        this.f47190e = bVar;
        this.f47192g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f47190e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f47190e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f47191f.get() && (a2 = this.f47192g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
