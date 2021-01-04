package io.reactivex.internal.schedulers;

import io.reactivex.processors.UnicastProcessor;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public class SchedulerWhen extends v implements io.reactivex.disposables.b {
    static final io.reactivex.disposables.b qjY = new d();
    static final io.reactivex.disposables.b qjZ = io.reactivex.disposables.c.eLf();
    private final v qjV;
    private final io.reactivex.processors.a<io.reactivex.g<io.reactivex.a>> qjW;
    private io.reactivex.disposables.b qjX;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.qjX.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qjX.isDisposed();
    }

    @Override // io.reactivex.v
    public v.c eLe() {
        v.c eLe = this.qjV.eLe();
        io.reactivex.processors.a<T> eLE = UnicastProcessor.eLF().eLE();
        io.reactivex.g<io.reactivex.a> a2 = eLE.a(new a(eLe));
        c cVar = new c(eLE, eLe);
        this.qjW.onNext(a2);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        protected abstract io.reactivex.disposables.b callActual(v.c cVar, io.reactivex.c cVar2);

        ScheduledAction() {
            super(SchedulerWhen.qjY);
        }

        void call(v.c cVar, io.reactivex.c cVar2) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != SchedulerWhen.qjZ && bVar == SchedulerWhen.qjY) {
                io.reactivex.disposables.b callActual = callActual(cVar, cVar2);
                if (!compareAndSet(SchedulerWhen.qjY, callActual)) {
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
            io.reactivex.disposables.b bVar2 = SchedulerWhen.qjZ;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.qjZ) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.qjY) {
                bVar.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    static class b implements Runnable {
        final Runnable action;
        final io.reactivex.c qkd;

        b(Runnable runnable, io.reactivex.c cVar) {
            this.action = runnable;
            this.qkd = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.qkd.onComplete();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class a implements io.reactivex.b.h<ScheduledAction, io.reactivex.a> {
        final v.c qka;

        a(v.c cVar) {
            this.qka = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.h
        /* renamed from: a */
        public io.reactivex.a apply(ScheduledAction scheduledAction) {
            return new C1268a(scheduledAction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C1268a extends io.reactivex.a {
            final ScheduledAction qkb;

            C1268a(ScheduledAction scheduledAction) {
                this.qkb = scheduledAction;
            }

            @Override // io.reactivex.a
            protected void b(io.reactivex.c cVar) {
                cVar.onSubscribe(this.qkb);
                this.qkb.call(a.this.qka, cVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class c extends v.c {
        private final v.c qka;
        private final AtomicBoolean qke = new AtomicBoolean();
        private final io.reactivex.processors.a<ScheduledAction> qkf;

        c(io.reactivex.processors.a<ScheduledAction> aVar, v.c cVar) {
            this.qkf = aVar;
            this.qka = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.qke.compareAndSet(false, true)) {
                this.qkf.onComplete();
                this.qka.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qke.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j, timeUnit);
            this.qkf.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.qkf.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: classes3.dex */
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
