package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b nBH = new d();
    static final io.reactivex.disposables.b nBI = io.reactivex.disposables.c.dJL();
    private io.reactivex.disposables.b disposable;
    private final v nBF;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> nBG;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dJI() {
        v.c dJI = this.nBF.dJI();
        io.reactivex.processors.a<T> dKk = UnicastProcessor.dKl().dKk();
        io.reactivex.g<io.reactivex.a> a2 = dKk.a(new a(dJI));
        c cVar = new c(dKk, dJI);
        this.nBG.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.nBH);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.nBI && bVar == SchedulerWhen.nBH) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.nBH, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.nBI;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.nBI) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.nBH) {
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
            return cVar.D(new b(this.action, cVar2));
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
        final io.reactivex.c nBM;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.nBM = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.nBM.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c nBJ;

        a(v.c cVar) {
            this.nBJ = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0766a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0766a extends io.reactivex.a {
            final ScheduledAction nBK;

            C0766a(ScheduledAction scheduledAction) {
                this.nBK = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.nBK);
                this.nBK.call(a.this.nBJ, cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c {
        private final v.c nBJ;
        private final AtomicBoolean nBN = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> nBO;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.nBO = aVar;
            this.nBJ = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.nBN.compareAndSet(false, true)) {
                this.nBO.onComplete();
                this.nBJ.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.nBN.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.nBO.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.nBO.onNext(immediateAction);
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
