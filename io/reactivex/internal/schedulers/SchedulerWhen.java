package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b nqo = new d();
    static final io.reactivex.disposables.b nqp = io.reactivex.disposables.c.dKA();
    private final v nql;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> nqm;
    private io.reactivex.disposables.b nqn;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.nqn.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nqn.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dKx() {
        v.c dKx = this.nql.dKx();
        io.reactivex.processors.a<T> dLa = UnicastProcessor.dLb().dLa();
        io.reactivex.g<io.reactivex.a> a2 = dLa.a(new a(dKx));
        c cVar = new c(dLa, dKx);
        this.nqm.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.nqo);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.nqp && bVar == SchedulerWhen.nqo) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.nqo, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.nqp;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.nqp) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.nqo) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes7.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.K(new b(this.action, cVar2));
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c nqt;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.nqt = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.nqt.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c nqq;

        a(v.c cVar) {
            this.nqq = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0872a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0872a extends io.reactivex.a {
            final ScheduledAction nqr;

            C0872a(ScheduledAction scheduledAction) {
                this.nqr = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.nqr);
                this.nqr.call(a.this.nqq, cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c {
        private final v.c nqq;
        private final AtomicBoolean nqu = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> nqv;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.nqv = aVar;
            this.nqq = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.nqu.compareAndSet(false, true)) {
                this.nqv.onComplete();
                this.nqq.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.nqu.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.nqv.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b K(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.nqv.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes7.dex */
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
