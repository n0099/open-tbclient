package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b nVX = new d();
    static final io.reactivex.disposables.b nVY = io.reactivex.disposables.c.dSU();
    private final v nVU;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> nVV;
    private io.reactivex.disposables.b nVW;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.nVW.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nVW.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dSR() {
        v.c dSR = this.nVU.dSR();
        io.reactivex.processors.a<T> dTu = UnicastProcessor.dTv().dTu();
        io.reactivex.g<io.reactivex.a> a2 = dTu.a(new a(dSR));
        c cVar = new c(dTu, dSR);
        this.nVV.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.nVX);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.nVY && bVar == SchedulerWhen.nVX) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.nVX, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.nVY;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.nVY) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.nVX) {
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
            return cVar.J(new b(this.action, cVar2));
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
        final io.reactivex.c nWc;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.nWc = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.nWc.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c nVZ;

        a(v.c cVar) {
            this.nVZ = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0908a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0908a extends io.reactivex.a {
            final ScheduledAction nWa;

            C0908a(ScheduledAction scheduledAction) {
                this.nWa = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.nWa);
                this.nWa.call(a.this.nVZ, cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c {
        private final v.c nVZ;
        private final AtomicBoolean nWd = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> nWe;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.nWe = aVar;
            this.nVZ = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.nWd.compareAndSet(false, true)) {
                this.nWe.onComplete();
                this.nVZ.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.nWd.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.nWe.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b J(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.nWe.onNext(immediateAction);
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
