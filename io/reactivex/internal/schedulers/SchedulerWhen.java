package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b pIt = new d();
    static final io.reactivex.disposables.b pIu = io.reactivex.disposables.c.eCW();
    private final v pIq;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> pIr;
    private io.reactivex.disposables.b pIs;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.pIs.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pIs.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eCV() {
        v.c eCV = this.pIq.eCV();
        io.reactivex.processors.a<T> eDv = UnicastProcessor.eDw().eDv();
        io.reactivex.g<io.reactivex.a> a2 = eDv.a(new a(eCV));
        c cVar = new c(eDv, eCV);
        this.pIr.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.pIt);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.pIu && bVar == SchedulerWhen.pIt) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.pIt, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.pIu;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.pIu) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.pIt) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes9.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2) {
            return cVar.H(new b(this.action, cVar2));
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c pIy;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.pIy = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.pIy.onComplete();
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c pIv;

        a(v.c cVar) {
            this.pIv = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1050a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C1050a extends io.reactivex.a {
            final ScheduledAction pIw;

            C1050a(ScheduledAction scheduledAction) {
                this.pIw = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.pIw);
                this.pIw.call(a.this.pIv, cVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class c extends v.c {
        private final io.reactivex.processors.a<ScheduledAction> pIA;
        private final v.c pIv;
        private final AtomicBoolean pIz = new AtomicBoolean();

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.pIA = aVar;
            this.pIv = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.pIz.compareAndSet(false, true)) {
                this.pIA.onComplete();
                this.pIv.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.pIz.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.pIA.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b H(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.pIA.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes9.dex */
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
