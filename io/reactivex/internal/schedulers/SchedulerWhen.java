package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b nza = new d();
    static final io.reactivex.disposables.b nzb = io.reactivex.disposables.c.dHZ();
    private io.reactivex.disposables.b disposable;
    private final v nyY;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> nyZ;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dHW() {
        v.c dHW = this.nyY.dHW();
        io.reactivex.processors.a<T> dIy = UnicastProcessor.dIz().dIy();
        io.reactivex.g<io.reactivex.a> a2 = dIy.a(new a(dHW));
        c cVar = new c(dIy, dHW);
        this.nyZ.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.nza);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.nzb && bVar == SchedulerWhen.nza) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.nza, callActual)) {
                    callActual.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get().isDisposed();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar;
            io.reactivex.disposables.b bVar2 = SchedulerWhen.nzb;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.nzb) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.nza) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes5.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.D(new b(this.action, cVar2));
        }
    }

    /* loaded from: classes5.dex */
    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.c(new b(this.action, cVar2), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes5.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c nzf;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.nzf = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.nzf.onComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c nzc;

        a(v.c cVar) {
            this.nzc = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0757a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public final class C0757a extends io.reactivex.a {
            final ScheduledAction nzd;

            C0757a(ScheduledAction scheduledAction) {
                this.nzd = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.nzd);
                this.nzd.call(a.this.nzc, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c {
        private final v.c nzc;
        private final AtomicBoolean nzg = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> nzh;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.nzh = aVar;
            this.nzc = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.nzg.compareAndSet(false, true)) {
                this.nzh.onComplete();
                this.nzc.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.nzg.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.nzh.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.nzh.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes5.dex */
    static final class d implements io.reactivex.disposables.b {
        d() {
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return false;
        }
    }
}
