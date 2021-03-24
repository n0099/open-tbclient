package io.reactivex.internal.schedulers;

import f.a.p;
import f.a.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends p implements f.a.t.b {

    /* renamed from: f  reason: collision with root package name */
    public static final f.a.t.b f68088f = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final f.a.t.b f68089g = c.a();

    /* loaded from: classes7.dex */
    public static class DelayedAction extends ScheduledAction {
        public final Runnable action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public f.a.t.b callActual(p.c cVar, f.a.b bVar) {
            return cVar.c(new a(this.action, bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes7.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final Runnable action;

        public ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public f.a.t.b callActual(p.c cVar, f.a.b bVar) {
            return cVar.b(new a(this.action, bVar));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<f.a.t.b> implements f.a.t.b {
        public ScheduledAction() {
            super(SchedulerWhen.f68088f);
        }

        public void call(p.c cVar, f.a.b bVar) {
            f.a.t.b bVar2 = get();
            if (bVar2 != SchedulerWhen.f68089g && bVar2 == SchedulerWhen.f68088f) {
                f.a.t.b callActual = callActual(cVar, bVar);
                if (compareAndSet(SchedulerWhen.f68088f, callActual)) {
                    return;
                }
                callActual.dispose();
            }
        }

        public abstract f.a.t.b callActual(p.c cVar, f.a.b bVar);

        @Override // f.a.t.b
        public void dispose() {
            f.a.t.b bVar;
            f.a.t.b bVar2 = SchedulerWhen.f68089g;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.f68089g) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.f68088f) {
                bVar.dispose();
            }
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final f.a.b f68090e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f68091f;

        public a(Runnable runnable, f.a.b bVar) {
            this.f68091f = runnable;
            this.f68090e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f68091f.run();
            } finally {
                this.f68090e.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements f.a.t.b {
        @Override // f.a.t.b
        public void dispose() {
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return false;
        }
    }
}
