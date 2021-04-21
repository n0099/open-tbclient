package d.h.c.i.a;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class m<V> extends FutureTask<V> implements l<V> {

    /* renamed from: e  reason: collision with root package name */
    public final d f67215e;

    public m(Callable<V> callable) {
        super(callable);
        this.f67215e = new d();
    }

    public static <V> m<V> b(Callable<V> callable) {
        return new m<>(callable);
    }

    @Override // d.h.c.i.a.l
    public void a(Runnable runnable, Executor executor) {
        this.f67215e.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f67215e.b();
    }
}
