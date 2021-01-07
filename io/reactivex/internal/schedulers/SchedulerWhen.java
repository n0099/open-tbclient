package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b qlG = new d();
    static final io.reactivex.disposables.b qlH = io.reactivex.disposables.c.eLJ();
    private final v qlD;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> qlE;
    private io.reactivex.disposables.b qlF;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.qlF.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qlF.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eLI() {
        v.c eLI = this.qlD.eLI();
        io.reactivex.processors.a<T> eMi = UnicastProcessor.eMj().eMi();
        io.reactivex.g<io.reactivex.a> a2 = eMi.a(new a(eLI));
        c cVar = new c(eMi, eLI);
        this.qlE.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.qlG);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.qlH && bVar == SchedulerWhen.qlG) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.qlG, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.qlH;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.qlH) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.qlG) {
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
            return cVar.F(new b(this.action, cVar2));
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
        final io.reactivex.c qlL;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.qlL = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.qlL.onComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c qlI;

        a(v.c cVar) {
            this.qlI = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1309a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public final class C1309a extends io.reactivex.a {
            final ScheduledAction qlJ;

            C1309a(ScheduledAction scheduledAction) {
                this.qlJ = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.qlJ);
                this.qlJ.call(a.this.qlI, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c {
        private final v.c qlI;
        private final AtomicBoolean qlM = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> qlN;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.qlN = aVar;
            this.qlI = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.qlM.compareAndSet(false, true)) {
                this.qlN.onComplete();
                this.qlI.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qlM.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.qlN.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.qlN.onNext(immediateAction);
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
