package rx.internal.schedulers;

import com.baidu.tieba.anb;
import com.baidu.tieba.fnb;
import com.baidu.tieba.lmb;
import com.baidu.tieba.mmb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.nrb;
import com.baidu.tieba.omb;
import com.baidu.tieba.qmb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.umb;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends qmb implements umb {
    public static final umb d = new c();
    public static final umb e = nrb.c();
    public final qmb a;
    public final omb<nmb<lmb>> b;
    public final umb c;

    /* loaded from: classes2.dex */
    public static class c implements umb {
        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements fnb<ScheduledAction, lmb> {
        public final /* synthetic */ qmb.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0785a implements lmb.f {
            public final /* synthetic */ ScheduledAction a;

            public C0785a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.lmb.f, com.baidu.tieba.bnb
            public void call(mmb mmbVar) {
                mmbVar.onSubscribe(this.a);
                this.a.call(a.this.a, mmbVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, qmb.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public lmb call(ScheduledAction scheduledAction) {
            return lmb.b(new C0785a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final anb action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(anb anbVar, long j, TimeUnit timeUnit) {
            this.action = anbVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public umb callActual(qmb.a aVar, mmb mmbVar) {
            return aVar.c(new d(this.action, mmbVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final anb action;

        public ImmediateAction(anb anbVar) {
            this.action = anbVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public umb callActual(qmb.a aVar, mmb mmbVar) {
            return aVar.b(new d(this.action, mmbVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<umb> implements umb {
        public abstract umb callActual(qmb.a aVar, mmb mmbVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            umb umbVar;
            umb umbVar2 = SchedulerWhen.e;
            do {
                umbVar = get();
                if (umbVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(umbVar, umbVar2));
            if (umbVar != SchedulerWhen.d) {
                umbVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(qmb.a aVar, mmb mmbVar) {
            umb umbVar = get();
            if (umbVar == SchedulerWhen.e || umbVar != SchedulerWhen.d) {
                return;
            }
            umb callActual = callActual(aVar, mmbVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends qmb.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ qmb.a b;
        public final /* synthetic */ omb c;

        public b(SchedulerWhen schedulerWhen, qmb.a aVar, omb ombVar) {
            this.b = aVar;
            this.c = ombVar;
        }

        @Override // com.baidu.tieba.qmb.a
        public umb c(anb anbVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(anbVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.qmb.a
        public umb b(anb anbVar) {
            ImmediateAction immediateAction = new ImmediateAction(anbVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements anb {
        public mmb a;
        public anb b;

        public d(anb anbVar, mmb mmbVar) {
            this.b = anbVar;
            this.a = mmbVar;
        }

        @Override // com.baidu.tieba.anb
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.omb<com.baidu.tieba.nmb<com.baidu.tieba.lmb>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.qmb
    public qmb.a createWorker() {
        qmb.a createWorker = this.a.createWorker();
        BufferUntilSubscriber H = BufferUntilSubscriber.H();
        sqb sqbVar = new sqb(H);
        Object j = H.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, sqbVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(fnb<nmb<nmb<lmb>>, lmb> fnbVar, qmb qmbVar) {
        this.a = qmbVar;
        PublishSubject H = PublishSubject.H();
        this.b = new sqb(H);
        this.c = fnbVar.call(H.p()).f();
    }
}
