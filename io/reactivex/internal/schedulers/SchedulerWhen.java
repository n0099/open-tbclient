package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b pGI = new d();
    static final io.reactivex.disposables.b pGJ = io.reactivex.disposables.c.ewO();
    private final v pGF;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> pGG;
    private io.reactivex.disposables.b pGH;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.pGH.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pGH.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c ewL() {
        v.c ewL = this.pGF.ewL();
        io.reactivex.processors.a<T> exo = UnicastProcessor.exp().exo();
        io.reactivex.g<io.reactivex.a> a2 = exo.a(new a(ewL));
        c cVar = new c(exo, ewL);
        this.pGG.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.pGI);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.pGJ && bVar == SchedulerWhen.pGI) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.pGI, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.pGJ;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.pGJ) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.pGI) {
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
            return cVar.I(new b(this.action, cVar2));
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
        final io.reactivex.c pGN;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.pGN = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.pGN.onComplete();
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c pGK;

        a(v.c cVar) {
            this.pGK = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1053a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public final class C1053a extends io.reactivex.a {
            final ScheduledAction pGL;

            C1053a(ScheduledAction scheduledAction) {
                this.pGL = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.pGL);
                this.pGL.call(a.this.pGK, cVar);
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class c extends v.c {
        private final v.c pGK;
        private final AtomicBoolean pGO = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> pGP;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.pGP = aVar;
            this.pGK = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.pGO.compareAndSet(false, true)) {
                this.pGP.onComplete();
                this.pGK.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.pGO.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.pGP.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.pGP.onNext(immediateAction);
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
