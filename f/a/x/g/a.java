package f.a.x.g;

import f.a.p;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class a extends p.c implements f.a.t.b {

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f67523e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f67524f;

    @Override // f.a.p.c
    public f.a.t.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // f.a.p.c
    public f.a.t.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f67524f) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j, timeUnit, null);
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.f67524f) {
            return;
        }
        this.f67524f = true;
        this.f67523e.shutdownNow();
    }

    public ScheduledRunnable e(Runnable runnable, long j, TimeUnit timeUnit, f.a.x.a.a aVar) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(f.a.a0.a.g(runnable), aVar);
        if (aVar == null || aVar.b(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.f67523e.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f67523e.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.a(scheduledRunnable);
                }
                f.a.a0.a.f(e2);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    public void f() {
        if (this.f67524f) {
            return;
        }
        this.f67524f = true;
        this.f67523e.shutdown();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f67524f;
    }
}
