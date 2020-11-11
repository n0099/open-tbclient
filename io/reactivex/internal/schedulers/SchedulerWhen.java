package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b pQc = new d();
    static final io.reactivex.disposables.b pQd = io.reactivex.disposables.c.eAD();
    private final v pPZ;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> pQa;
    private io.reactivex.disposables.b pQb;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.pQb.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pQb.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eAA() {
        v.c eAA = this.pPZ.eAA();
        io.reactivex.processors.a<T> eBd = UnicastProcessor.eBe().eBd();
        io.reactivex.g<io.reactivex.a> a2 = eBd.a(new a(eAA));
        c cVar = new c(eBd, eAA);
        this.pQa.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.pQc);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.pQd && bVar == SchedulerWhen.pQc) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.pQc, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.pQd;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.pQd) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.pQc) {
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
        final io.reactivex.c pQh;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.pQh = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.pQh.onComplete();
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c pQe;

        a(v.c cVar) {
            this.pQe = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1073a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public final class C1073a extends io.reactivex.a {
            final ScheduledAction pQf;

            C1073a(ScheduledAction scheduledAction) {
                this.pQf = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.pQf);
                this.pQf.call(a.this.pQe, cVar);
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class c extends v.c {
        private final v.c pQe;
        private final AtomicBoolean pQi = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> pQj;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.pQj = aVar;
            this.pQe = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.pQi.compareAndSet(false, true)) {
                this.pQj.onComplete();
                this.pQe.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.pQi.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.pQj.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.pQj.onNext(immediateAction);
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
