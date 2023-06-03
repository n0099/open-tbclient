package rx.internal.schedulers;

import com.baidu.tieba.anb;
import com.baidu.tieba.gmb;
import com.baidu.tieba.hmb;
import com.baidu.tieba.imb;
import com.baidu.tieba.irb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.lmb;
import com.baidu.tieba.nqb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.vmb;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends lmb implements pmb {
    public static final pmb d = new c();
    public static final pmb e = irb.c();
    public final lmb a;
    public final jmb<imb<gmb>> b;
    public final pmb c;

    /* loaded from: classes2.dex */
    public static class c implements pmb {
        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements anb<ScheduledAction, gmb> {
        public final /* synthetic */ lmb.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0785a implements gmb.f {
            public final /* synthetic */ ScheduledAction a;

            public C0785a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.gmb.f, com.baidu.tieba.wmb
            public void call(hmb hmbVar) {
                hmbVar.onSubscribe(this.a);
                this.a.call(a.this.a, hmbVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, lmb.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public gmb call(ScheduledAction scheduledAction) {
            return gmb.b(new C0785a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final vmb action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(vmb vmbVar, long j, TimeUnit timeUnit) {
            this.action = vmbVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public pmb callActual(lmb.a aVar, hmb hmbVar) {
            return aVar.c(new d(this.action, hmbVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final vmb action;

        public ImmediateAction(vmb vmbVar) {
            this.action = vmbVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public pmb callActual(lmb.a aVar, hmb hmbVar) {
            return aVar.b(new d(this.action, hmbVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<pmb> implements pmb {
        public abstract pmb callActual(lmb.a aVar, hmb hmbVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            pmb pmbVar;
            pmb pmbVar2 = SchedulerWhen.e;
            do {
                pmbVar = get();
                if (pmbVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(pmbVar, pmbVar2));
            if (pmbVar != SchedulerWhen.d) {
                pmbVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(lmb.a aVar, hmb hmbVar) {
            pmb pmbVar = get();
            if (pmbVar == SchedulerWhen.e || pmbVar != SchedulerWhen.d) {
                return;
            }
            pmb callActual = callActual(aVar, hmbVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends lmb.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ lmb.a b;
        public final /* synthetic */ jmb c;

        public b(SchedulerWhen schedulerWhen, lmb.a aVar, jmb jmbVar) {
            this.b = aVar;
            this.c = jmbVar;
        }

        @Override // com.baidu.tieba.lmb.a
        public pmb c(vmb vmbVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(vmbVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.lmb.a
        public pmb b(vmb vmbVar) {
            ImmediateAction immediateAction = new ImmediateAction(vmbVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements vmb {
        public hmb a;
        public vmb b;

        public d(vmb vmbVar, hmb hmbVar) {
            this.b = vmbVar;
            this.a = hmbVar;
        }

        @Override // com.baidu.tieba.vmb
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.jmb<com.baidu.tieba.imb<com.baidu.tieba.gmb>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lmb
    public lmb.a createWorker() {
        lmb.a createWorker = this.a.createWorker();
        BufferUntilSubscriber H = BufferUntilSubscriber.H();
        nqb nqbVar = new nqb(H);
        Object j = H.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, nqbVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(anb<imb<imb<gmb>>, gmb> anbVar, lmb lmbVar) {
        this.a = lmbVar;
        PublishSubject H = PublishSubject.H();
        this.b = new nqb(H);
        this.c = anbVar.call(H.p()).f();
    }
}
