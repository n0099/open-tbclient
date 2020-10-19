package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b oPl = new d();
    static final io.reactivex.disposables.b oPm = io.reactivex.disposables.c.emO();
    private final v oPi;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> oPj;
    private io.reactivex.disposables.b oPk;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.oPk.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.oPk.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c emL() {
        v.c emL = this.oPi.emL();
        io.reactivex.processors.a<T> enp = UnicastProcessor.enq().enp();
        io.reactivex.g<io.reactivex.a> a2 = enp.a(new a(emL));
        c cVar = new c(enp, emL);
        this.oPj.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.oPl);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.oPm && bVar == SchedulerWhen.oPl) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.oPl, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.oPm;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.oPm) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.oPl) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes17.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.G(new b(this.action, cVar2));
        }
    }

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c oPq;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.oPq = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.oPq.onComplete();
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c oPn;

        a(v.c cVar) {
            this.oPn = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0981a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public final class C0981a extends io.reactivex.a {
            final ScheduledAction oPo;

            C0981a(ScheduledAction scheduledAction) {
                this.oPo = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.oPo);
                this.oPo.call(a.this.oPn, cVar);
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class c extends v.c {
        private final v.c oPn;
        private final AtomicBoolean oPr = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> oPs;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.oPs = aVar;
            this.oPn = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.oPr.compareAndSet(false, true)) {
                this.oPs.onComplete();
                this.oPn.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.oPr.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.oPs.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.oPs.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes17.dex */
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
