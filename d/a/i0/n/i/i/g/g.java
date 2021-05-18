package d.a.i0.n.i.i.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f47883e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f47884f;

    /* renamed from: g  reason: collision with root package name */
    public a f47885g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f47884f = atomicBoolean;
        this.f47883e = bVar;
        this.f47885g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f47883e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.a.i0.n.c.f47808a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f47883e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f47884f.get() && (a2 = this.f47885g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.a.i0.n.c.f47808a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
