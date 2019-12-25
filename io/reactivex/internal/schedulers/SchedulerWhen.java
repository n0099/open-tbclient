package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b mWS = new d();
    static final io.reactivex.disposables.b mWT = io.reactivex.disposables.c.dDQ();
    private io.reactivex.disposables.b disposable;
    private final v mWQ;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> mWR;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dDP() {
        v.c dDP = this.mWQ.dDP();
        io.reactivex.processors.a<T> dEo = UnicastProcessor.dEp().dEo();
        io.reactivex.g<io.reactivex.a> a2 = dEo.a(new a(dDP));
        c cVar = new c(dEo, dDP);
        this.mWR.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.mWS);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.mWT && bVar == SchedulerWhen.mWS) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.mWS, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.mWT;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.mWT) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.mWS) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes4.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.C(new b(this.action, cVar2));
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c mWX;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.mWX = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.mWX.onComplete();
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c mWU;

        a(v.c cVar) {
            this.mWU = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0713a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class C0713a extends io.reactivex.a {
            final ScheduledAction mWV;

            C0713a(ScheduledAction scheduledAction) {
                this.mWV = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.mWV);
                this.mWV.call(a.this.mWU, cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class c extends v.c {
        private final v.c mWU;
        private final AtomicBoolean mWY = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> mWZ;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.mWZ = aVar;
            this.mWU = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.mWY.compareAndSet(false, true)) {
                this.mWZ.onComplete();
                this.mWU.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.mWY.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.mWZ.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.mWZ.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes4.dex */
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
