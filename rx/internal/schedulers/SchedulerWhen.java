package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.g;
import rx.internal.operators.BufferUntilSubscriber;
import rx.k;
import rx.subjects.PublishSubject;
/* loaded from: classes14.dex */
public class SchedulerWhen extends rx.g implements k {
    static final k qsB = new k() { // from class: rx.internal.schedulers.SchedulerWhen.3
        @Override // rx.k
        public void unsubscribe() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return false;
        }
    };
    static final k qsC = rx.subscriptions.e.eLX();
    private final k qsA;
    private final rx.g qsy;
    private final rx.e<rx.d<rx.b>> qsz;

    public SchedulerWhen(rx.functions.f<rx.d<rx.d<rx.b>>, rx.b> fVar, rx.g gVar) {
        this.qsy = gVar;
        PublishSubject eLM = PublishSubject.eLM();
        this.qsz = new rx.b.d(eLM);
        this.qsA = fVar.call(eLM.eKn()).eKe();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qsA.unsubscribe();
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qsA.isUnsubscribed();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.e<rx.d<rx.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.g
    public g.a createWorker() {
        final g.a createWorker = this.qsy.createWorker();
        BufferUntilSubscriber eKB = BufferUntilSubscriber.eKB();
        final rx.b.d dVar = new rx.b.d(eKB);
        Object d = eKB.d(new rx.functions.f<ScheduledAction, rx.b>() { // from class: rx.internal.schedulers.SchedulerWhen.1
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
            private final AtomicBoolean qhk = new AtomicBoolean();

            @Override // rx.k
            public void unsubscribe() {
                if (this.qhk.compareAndSet(false, true)) {
                    createWorker.unsubscribe();
                    dVar.onCompleted();
                }
            }

            @Override // rx.k
            public boolean isUnsubscribed() {
                return this.qhk.get();
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
        this.qsz.onNext(d);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static abstract class ScheduledAction extends AtomicReference<k> implements k {
        protected abstract k callActual(g.a aVar, rx.c cVar);

        public ScheduledAction() {
            super(SchedulerWhen.qsB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(g.a aVar, rx.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.qsC && kVar == SchedulerWhen.qsB) {
                k callActual = callActual(aVar, cVar);
                if (!compareAndSet(SchedulerWhen.qsB, callActual)) {
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
            k kVar2 = SchedulerWhen.qsC;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.qsC) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.qsB) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    static class a implements rx.functions.a {
        private rx.functions.a action;
        private rx.c qsI;

        public a(rx.functions.a aVar, rx.c cVar) {
            this.action = aVar;
            this.qsI = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.action.call();
            } finally {
                this.qsI.onCompleted();
            }
        }
    }
}
