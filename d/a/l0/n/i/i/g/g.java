package d.a.l0.n.i.i.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f48059e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f48060f;

    /* renamed from: g  reason: collision with root package name */
    public a f48061g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f48060f = atomicBoolean;
        this.f48059e = bVar;
        this.f48061g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f48059e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f48059e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f48060f.get() && (a2 = this.f48061g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
