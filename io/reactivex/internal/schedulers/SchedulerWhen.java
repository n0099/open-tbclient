package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b qhe = new d();
    static final io.reactivex.disposables.b qhf = io.reactivex.disposables.c.eHT();
    private final v qhb;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> qhc;
    private io.reactivex.disposables.b qhd;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.qhd.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qhd.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        v.c eHS = this.qhb.eHS();
        io.reactivex.processors.a<T> eIs = UnicastProcessor.eIt().eIs();
        io.reactivex.g<io.reactivex.a> a2 = eIs.a(new a(eHS));
        c cVar = new c(eIs, eHS);
        this.qhc.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.qhe);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.qhf && bVar == SchedulerWhen.qhe) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.qhe, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.qhf;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.qhf) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.qhe) {
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
        final io.reactivex.c qhj;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.qhj = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.qhj.onComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c qhg;

        a(v.c cVar) {
            this.qhg = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1292a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public final class C1292a extends io.reactivex.a {
            final ScheduledAction qhh;

            C1292a(ScheduledAction scheduledAction) {
                this.qhh = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.qhh);
                this.qhh.call(a.this.qhg, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c {
        private final v.c qhg;
        private final AtomicBoolean qhk = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> qhl;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.qhl = aVar;
            this.qhg = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.qhk.compareAndSet(false, true)) {
                this.qhl.onComplete();
                this.qhg.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qhk.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.qhl.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.qhl.onNext(immediateAction);
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
