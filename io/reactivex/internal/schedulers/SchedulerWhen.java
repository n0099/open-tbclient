package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b qsl = new d();
    static final io.reactivex.disposables.b qsm = io.reactivex.disposables.c.eJZ();
    private final v qsi;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> qsj;
    private io.reactivex.disposables.b qsk;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.qsk.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qsk.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eJY() {
        v.c eJY = this.qsi.eJY();
        io.reactivex.processors.a<T> eKy = UnicastProcessor.eKz().eKy();
        io.reactivex.g<io.reactivex.a> a2 = eKy.a(new a(eJY));
        c cVar = new c(eKy, eJY);
        this.qsj.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.qsl);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.qsm && bVar == SchedulerWhen.qsl) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.qsl, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.qsm;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.qsm) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.qsl) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c qsq;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.qsq = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.qsq.onComplete();
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c qsn;

        a(v.c cVar) {
            this.qsn = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1286a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public final class C1286a extends io.reactivex.a {
            final ScheduledAction qso;

            C1286a(ScheduledAction scheduledAction) {
                this.qso = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.qso);
                this.qso.call(a.this.qsn, cVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class c extends v.c {
        private final v.c qsn;
        private final AtomicBoolean qsr = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> qss;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.qss = aVar;
            this.qsn = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.qsr.compareAndSet(false, true)) {
                this.qss.onComplete();
                this.qsn.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qsr.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.qss.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.qss.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes6.dex */
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
