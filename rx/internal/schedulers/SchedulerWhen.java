package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.g;
import rx.internal.operators.BufferUntilSubscriber;
import rx.k;
import rx.subjects.PublishSubject;
/* loaded from: classes12.dex */
public class SchedulerWhen extends rx.g implements k {
    static final k pTV = new k() { // from class: rx.internal.schedulers.SchedulerWhen.3
        @Override // rx.k
        public void unsubscribe() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return false;
        }
    };
    static final k pTW = rx.subscriptions.e.eHb();
    private final rx.g pTS;
    private final rx.e<rx.d<rx.b>> pTT;
    private final k pTU;

    public SchedulerWhen(rx.functions.f<rx.d<rx.d<rx.b>>, rx.b> fVar, rx.g gVar) {
        this.pTS = gVar;
        PublishSubject eGQ = PublishSubject.eGQ();
        this.pTT = new rx.b.d(eGQ);
        this.pTU = fVar.call(eGQ.eFr()).eFi();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.pTU.unsubscribe();
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pTU.isUnsubscribed();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.e<rx.d<rx.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.g
    public g.a createWorker() {
        final g.a createWorker = this.pTS.createWorker();
        BufferUntilSubscriber eFF = BufferUntilSubscriber.eFF();
        final rx.b.d dVar = new rx.b.d(eFF);
        Object d = eFF.d(new rx.functions.f<ScheduledAction, rx.b>() { // from class: rx.internal.schedulers.SchedulerWhen.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: a */
            public rx.b call(final ScheduledAction scheduledAction) {
                return rx.b.a(new b.a() { // from class: rx.internal.schedulers.SchedulerWhen.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: a */
                    public void call(rx.c cVar) {
                        cVar.onSubscribe(scheduledAction);
                        scheduledAction.a(createWorker, cVar);
                    }
                });
            }
        });
        g.a aVar = new g.a() { // from class: rx.internal.schedulers.SchedulerWhen.2
            private final AtomicBoolean pIB = new AtomicBoolean();

            @Override // rx.k
            public void unsubscribe() {
                if (this.pIB.compareAndSet(false, true)) {
                    createWorker.unsubscribe();
                    dVar.onCompleted();
                }
            }

            @Override // rx.k
            public boolean isUnsubscribed() {
                return this.pIB.get();
            }

            @Override // rx.g.a
            public k a(rx.functions.a aVar2, long j, TimeUnit timeUnit) {
                DelayedAction delayedAction = new DelayedAction(aVar2, j, timeUnit);
                dVar.onNext(delayedAction);
                return delayedAction;
            }

            @Override // rx.g.a
            public k c(rx.functions.a aVar2) {
                ImmediateAction immediateAction = new ImmediateAction(aVar2);
                dVar.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.pTT.onNext(d);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static abstract class ScheduledAction extends AtomicReference<k> implements k {
        protected abstract k callActual(g.a aVar, rx.c cVar);

        public ScheduledAction() {
            super(SchedulerWhen.pTV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(g.a aVar, rx.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.pTW && kVar == SchedulerWhen.pTV) {
                k callActual = callActual(aVar, cVar);
                if (!compareAndSet(SchedulerWhen.pTV, callActual)) {
                    callActual.unsubscribe();
                }
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            k kVar;
            k kVar2 = SchedulerWhen.pTW;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.pTW) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.pTV) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes12.dex */
    static class ImmediateAction extends ScheduledAction {
        private final rx.functions.a action;

        public ImmediateAction(rx.functions.a aVar) {
            this.action = aVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected k callActual(g.a aVar, rx.c cVar) {
            return aVar.c(new a(this.action, cVar));
        }
    }

    /* loaded from: classes12.dex */
    static class DelayedAction extends ScheduledAction {
        private final rx.functions.a action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            this.action = aVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected k callActual(g.a aVar, rx.c cVar) {
            return aVar.a(new a(this.action, cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes12.dex */
    static class a implements rx.functions.a {
        private rx.functions.a action;
        private rx.c pUc;

        public a(rx.functions.a aVar, rx.c cVar) {
            this.action = aVar;
            this.pUc = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.action.call();
            } finally {
                this.pUc.onCompleted();
            }
        }
    }
}
