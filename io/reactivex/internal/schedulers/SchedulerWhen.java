package io.reactivex.internal.schedulers;

import f.b.p;
import f.b.t.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends p implements f.b.t.b {

    /* renamed from: f  reason: collision with root package name */
    public static final f.b.t.b f69246f = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final f.b.t.b f69247g = c.a();

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
        public f.b.t.b callActual(p.c cVar, f.b.b bVar) {
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
        public f.b.t.b callActual(p.c cVar, f.b.b bVar) {
            return cVar.b(new a(this.action, bVar));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<f.b.t.b> implements f.b.t.b {
        public ScheduledAction() {
            super(SchedulerWhen.f69246f);
        }

        public void call(p.c cVar, f.b.b bVar) {
            f.b.t.b bVar2 = get();
            if (bVar2 != SchedulerWhen.f69247g && bVar2 == SchedulerWhen.f69246f) {
                f.b.t.b callActual = callActual(cVar, bVar);
                if (compareAndSet(SchedulerWhen.f69246f, callActual)) {
                    return;
                }
                callActual.dispose();
            }
        }

        public abstract f.b.t.b callActual(p.c cVar, f.b.b bVar);

        @Override // f.b.t.b
        public void dispose() {
            f.b.t.b bVar;
            f.b.t.b bVar2 = SchedulerWhen.f69247g;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.f69247g) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.f69246f) {
                bVar.dispose();
            }
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final f.b.b f69248e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f69249f;

        public a(Runnable runnable, f.b.b bVar) {
            this.f69249f = runnable;
            this.f69248e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f69249f.run();
            } finally {
                this.f69248e.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements f.b.t.b {
        @Override // f.b.t.b
        public void dispose() {
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return false;
        }
    }
}
