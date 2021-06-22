package d.a.m0.n.i.i.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f51841e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f51842f;

    /* renamed from: g  reason: collision with root package name */
    public a f51843g;

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        this.f51842f = atomicBoolean;
        this.f51841e = bVar;
        this.f51843g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        this.f51841e.a(fVar);
        try {
            try {
                fVar.run();
            } catch (Exception e2) {
                if (d.a.m0.n.c.f51766a) {
                    Log.e("PMSTaskExecutor", "run task error:" + e2.toString());
                }
            }
        } finally {
            this.f51841e.b(fVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable a2;
        while (!this.f51842f.get() && (a2 = this.f51843g.a(true)) != null && (a2 instanceof f)) {
            try {
                a((f) a2);
            } catch (Throwable th) {
                if (d.a.m0.n.c.f51766a) {
                    Log.e("PMSTaskExecutor", "runTask error:" + th.toString());
                }
            }
        }
    }
}
