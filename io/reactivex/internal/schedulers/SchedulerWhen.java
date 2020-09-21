package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b ozW = new d();
    static final io.reactivex.disposables.b ozX = io.reactivex.disposables.c.ejd();
    private final v ozT;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> ozU;
    private io.reactivex.disposables.b ozV;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.ozV.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.ozV.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eja() {
        v.c eja = this.ozT.eja();
        io.reactivex.processors.a<T> ejD = UnicastProcessor.ejE().ejD();
        io.reactivex.g<io.reactivex.a> a2 = ejD.a(new a(eja));
        c cVar = new c(ejD, eja);
        this.ozU.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.ozW);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.ozX && bVar == SchedulerWhen.ozW) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.ozW, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.ozX;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.ozX) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.ozW) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c oAb;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.oAb = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.oAb.onComplete();
            }
        }
    }

    /* loaded from: classes25.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c ozY;

        a(v.c cVar) {
            this.ozY = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0963a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public final class C0963a extends io.reactivex.a {
            final ScheduledAction ozZ;

            C0963a(ScheduledAction scheduledAction) {
                this.ozZ = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.ozZ);
                this.ozZ.call(a.this.ozY, cVar);
            }
        }
    }

    /* loaded from: classes25.dex */
    static final class c extends v.c {
        private final AtomicBoolean oAc = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> oAd;
        private final v.c ozY;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.oAd = aVar;
            this.ozY = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.oAc.compareAndSet(false, true)) {
                this.oAd.onComplete();
                this.ozY.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.oAc.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.oAd.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.oAd.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes25.dex */
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
