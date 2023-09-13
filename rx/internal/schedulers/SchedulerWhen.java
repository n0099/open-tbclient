package rx.internal.schedulers;

import com.baidu.tieba.bfc;
import com.baidu.tieba.fbc;
import com.baidu.tieba.lbc;
import com.baidu.tieba.qac;
import com.baidu.tieba.rac;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.vac;
import com.baidu.tieba.wfc;
import com.baidu.tieba.zac;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends vac implements zac {
    public static final zac d = new c();
    public static final zac e = wfc.c();
    public final vac a;
    public final tac<sac<qac>> b;
    public final zac c;

    /* loaded from: classes2.dex */
    public static class c implements zac {
        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements lbc<ScheduledAction, qac> {
        public final /* synthetic */ vac.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0798a implements qac.f {
            public final /* synthetic */ ScheduledAction a;

            public C0798a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
            public void call(rac racVar) {
                racVar.onSubscribe(this.a);
                this.a.call(a.this.a, racVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, vac.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public qac call(ScheduledAction scheduledAction) {
            return qac.b(new C0798a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final fbc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(fbc fbcVar, long j, TimeUnit timeUnit) {
            this.action = fbcVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public zac callActual(vac.a aVar, rac racVar) {
            return aVar.c(new d(this.action, racVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final fbc action;

        public ImmediateAction(fbc fbcVar) {
            this.action = fbcVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public zac callActual(vac.a aVar, rac racVar) {
            return aVar.b(new d(this.action, racVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<zac> implements zac {
        public abstract zac callActual(vac.a aVar, rac racVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            zac zacVar;
            zac zacVar2 = SchedulerWhen.e;
            do {
                zacVar = get();
                if (zacVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(zacVar, zacVar2));
            if (zacVar != SchedulerWhen.d) {
                zacVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(vac.a aVar, rac racVar) {
            zac zacVar = get();
            if (zacVar == SchedulerWhen.e || zacVar != SchedulerWhen.d) {
                return;
            }
            zac callActual = callActual(aVar, racVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends vac.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ vac.a b;
        public final /* synthetic */ tac c;

        public b(SchedulerWhen schedulerWhen, vac.a aVar, tac tacVar) {
            this.b = aVar;
            this.c = tacVar;
        }

        @Override // com.baidu.tieba.vac.a
        public zac c(fbc fbcVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(fbcVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.vac.a
        public zac b(fbc fbcVar) {
            ImmediateAction immediateAction = new ImmediateAction(fbcVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements fbc {
        public rac a;
        public fbc b;

        public d(fbc fbcVar, rac racVar) {
            this.b = fbcVar;
            this.a = racVar;
        }

        @Override // com.baidu.tieba.fbc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.tac<com.baidu.tieba.sac<com.baidu.tieba.qac>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.vac
    public vac.a createWorker() {
        vac.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        bfc bfcVar = new bfc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, bfcVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(lbc<sac<sac<qac>>, qac> lbcVar, vac vacVar) {
        this.a = vacVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new bfc(Q);
        this.c = lbcVar.call(Q.v()).f();
    }
}
