package f.b.x.g;

import f.b.p;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class a extends p.c implements f.b.t.b {

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f68534e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f68535f;

    @Override // f.b.p.c
    public f.b.t.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // f.b.p.c
    public f.b.t.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f68535f) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j, timeUnit, null);
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.f68535f) {
            return;
        }
        this.f68535f = true;
        this.f68534e.shutdownNow();
    }

    public ScheduledRunnable e(Runnable runnable, long j, TimeUnit timeUnit, f.b.x.a.a aVar) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(f.b.a0.a.g(runnable), aVar);
        if (aVar == null || aVar.b(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.f68534e.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f68534e.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.a(scheduledRunnable);
                }
                f.b.a0.a.f(e2);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    public void f() {
        if (this.f68535f) {
            return;
        }
        this.f68535f = true;
        this.f68534e.shutdown();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f68535f;
    }
}
