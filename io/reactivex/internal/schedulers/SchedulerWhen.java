package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b nzf = new d();
    static final io.reactivex.disposables.b nzg = io.reactivex.disposables.c.dIb();
    private io.reactivex.disposables.b disposable;
    private final v nzd;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> nze;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c dHY() {
        v.c dHY = this.nzd.dHY();
        io.reactivex.processors.a<T> dIA = UnicastProcessor.dIB().dIA();
        io.reactivex.g<io.reactivex.a> a2 = dIA.a(new a(dHY));
        c cVar = new c(dIA, dHY);
        this.nze.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.nzf);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.nzg && bVar == SchedulerWhen.nzf) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.nzf, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.nzg;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.nzg) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.nzf) {
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
            return cVar.D(new b(this.action, cVar2));
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
        final io.reactivex.c nzk;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.nzk = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.nzk.onComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements io.reactivex.c.h<ScheduledAction, io.reactivex.a> {
        final v.c nzh;

        a(v.c cVar) {
            this.nzh = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C0757a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public final class C0757a extends io.reactivex.a {
            final ScheduledAction nzi;

            C0757a(ScheduledAction scheduledAction) {
                this.nzi = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.nzi);
                this.nzi.call(a.this.nzh, cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c {
        private final v.c nzh;
        private final AtomicBoolean nzl = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> nzm;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.nzm = aVar;
            this.nzh = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.nzl.compareAndSet(false, true)) {
                this.nzm.onComplete();
                this.nzh.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.nzl.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.nzm.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.nzm.onNext(immediateAction);
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
