package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b opW = new d();
    static final io.reactivex.disposables.b opX = io.reactivex.disposables.c.eeX();
    private final v opT;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> opU;
    private io.reactivex.disposables.b opV;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.opV.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.opV.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eeU() {
        v.c eeU = this.opT.eeU();
        io.reactivex.processors.a<T> efx = UnicastProcessor.efy().efx();
        io.reactivex.g<io.reactivex.a> a2 = efx.a(new a(eeU));
        c cVar = new c(efx, eeU);
        this.opU.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.opW);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.opX && bVar == SchedulerWhen.opW) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.opW, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.opX;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.opX) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.opW) {
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
            return cVar.G(new b(this.action, cVar2));
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
        final io.reactivex.c oqb;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.oqb = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.oqb.onComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c opY;

        a(v.c cVar) {
            this.opY = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0966a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0966a extends io.reactivex.a {
            final ScheduledAction opZ;

            C0966a(ScheduledAction scheduledAction) {
                this.opZ = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.opZ);
                this.opZ.call(a.this.opY, cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c {
        private final v.c opY;
        private final AtomicBoolean oqc = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> oqd;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.oqd = aVar;
            this.opY = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.oqc.compareAndSet(false, true)) {
                this.oqd.onComplete();
                this.opY.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.oqc.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.oqd.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.oqd.onNext(immediateAction);
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
