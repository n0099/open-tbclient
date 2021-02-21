package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b qrJ = new d();
    static final io.reactivex.disposables.b qrK = io.reactivex.disposables.c.eKr();
    private final v qrG;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> qrH;
    private io.reactivex.disposables.b qrI;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.qrI.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qrI.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        v.c eKq = this.qrG.eKq();
        io.reactivex.processors.a<T> eKQ = UnicastProcessor.eKR().eKQ();
        io.reactivex.g<io.reactivex.a> a2 = eKQ.a(new a(eKq));
        c cVar = new c(eKQ, eKq);
        this.qrH.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.qrJ);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.qrK && bVar == SchedulerWhen.qrJ) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.qrJ, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.qrK;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.qrK) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.qrJ) {
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
            return cVar.E(new b(this.action, cVar2));
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
        final io.reactivex.c qrO;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.qrO = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.qrO.onComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c qrL;

        a(v.c cVar) {
            this.qrL = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1304a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public final class C1304a extends io.reactivex.a {
            final ScheduledAction qrM;

            C1304a(ScheduledAction scheduledAction) {
                this.qrM = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.qrM);
                this.qrM.call(a.this.qrL, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c {
        private final v.c qrL;
        private final AtomicBoolean qrP = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> qrQ;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.qrQ = aVar;
            this.qrL = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.qrP.compareAndSet(false, true)) {
                this.qrQ.onComplete();
                this.qrL.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qrP.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.qrQ.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b E(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.qrQ.onNext(immediateAction);
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
