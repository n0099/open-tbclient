package rx.internal.schedulers;

import com.baidu.tieba.bsa;
import com.baidu.tieba.gsa;
import com.baidu.tieba.lwa;
import com.baidu.tieba.mra;
import com.baidu.tieba.nra;
import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.qva;
import com.baidu.tieba.rra;
import com.baidu.tieba.vra;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public class SchedulerWhen extends rra implements vra {
    public static final vra d = new c();
    public static final vra e = lwa.c();
    public final rra a;
    public final pra<ora<mra>> b;
    public final vra c;

    /* loaded from: classes9.dex */
    public static class c implements vra {
        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements gsa<ScheduledAction, mra> {
        public final /* synthetic */ rra.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0747a implements mra.f {
            public final /* synthetic */ ScheduledAction a;

            public C0747a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.mra.f, com.baidu.tieba.csa
            public void call(nra nraVar) {
                nraVar.onSubscribe(this.a);
                this.a.call(a.this.a, nraVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, rra.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public mra call(ScheduledAction scheduledAction) {
            return mra.b(new C0747a(scheduledAction));
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public final bsa action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(bsa bsaVar, long j, TimeUnit timeUnit) {
            this.action = bsaVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public vra callActual(rra.a aVar, nra nraVar) {
            return aVar.c(new d(this.action, nraVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final bsa action;

        public ImmediateAction(bsa bsaVar) {
            this.action = bsaVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public vra callActual(rra.a aVar, nra nraVar) {
            return aVar.b(new d(this.action, nraVar));
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<vra> implements vra {
        public abstract vra callActual(rra.a aVar, nra nraVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            vra vraVar;
            vra vraVar2 = SchedulerWhen.e;
            do {
                vraVar = get();
                if (vraVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(vraVar, vraVar2));
            if (vraVar != SchedulerWhen.d) {
                vraVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(rra.a aVar, nra nraVar) {
            vra vraVar = get();
            if (vraVar == SchedulerWhen.e || vraVar != SchedulerWhen.d) {
                return;
            }
            vra callActual = callActual(aVar, nraVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends rra.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ rra.a b;
        public final /* synthetic */ pra c;

        public b(SchedulerWhen schedulerWhen, rra.a aVar, pra praVar) {
            this.b = aVar;
            this.c = praVar;
        }

        @Override // com.baidu.tieba.rra.a
        public vra c(bsa bsaVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(bsaVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.rra.a
        public vra b(bsa bsaVar) {
            ImmediateAction immediateAction = new ImmediateAction(bsaVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements bsa {
        public nra a;
        public bsa b;

        public d(bsa bsaVar, nra nraVar) {
            this.b = bsaVar;
            this.a = nraVar;
        }

        @Override // com.baidu.tieba.bsa
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.pra<com.baidu.tieba.ora<com.baidu.tieba.mra>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.rra
    public rra.a createWorker() {
        rra.a createWorker = this.a.createWorker();
        BufferUntilSubscriber D = BufferUntilSubscriber.D();
        qva qvaVar = new qva(D);
        Object h = D.h(new a(this, createWorker));
        b bVar = new b(this, createWorker, qvaVar);
        this.b.onNext(h);
        return bVar;
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(gsa<ora<ora<mra>>, mra> gsaVar, rra rraVar) {
        this.a = rraVar;
        PublishSubject D = PublishSubject.D();
        this.b = new qva(D);
        this.c = gsaVar.call(D.n()).f();
    }
}
