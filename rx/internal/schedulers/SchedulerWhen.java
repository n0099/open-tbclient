package rx.internal.schedulers;

import com.baidu.tieba.bkc;
import com.baidu.tieba.gjc;
import com.baidu.tieba.hjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.ooc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.tnc;
import com.baidu.tieba.vjc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends ljc implements pjc {
    public static final pjc d = new c();
    public static final pjc e = ooc.c();
    public final ljc a;
    public final jjc<ijc<gjc>> b;
    public final pjc c;

    /* loaded from: classes2.dex */
    public static class c implements pjc {
        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements bkc<ScheduledAction, gjc> {
        public final /* synthetic */ ljc.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0732a implements gjc.f {
            public final /* synthetic */ ScheduledAction a;

            public C0732a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wjc
            /* renamed from: a */
            public void call(hjc hjcVar) {
                hjcVar.onSubscribe(this.a);
                this.a.call(a.this.a, hjcVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, ljc.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public gjc call(ScheduledAction scheduledAction) {
            return gjc.b(new C0732a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final vjc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(vjc vjcVar, long j, TimeUnit timeUnit) {
            this.action = vjcVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public pjc callActual(ljc.a aVar, hjc hjcVar) {
            return aVar.c(new d(this.action, hjcVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final vjc action;

        public ImmediateAction(vjc vjcVar) {
            this.action = vjcVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public pjc callActual(ljc.a aVar, hjc hjcVar) {
            return aVar.b(new d(this.action, hjcVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<pjc> implements pjc {
        public abstract pjc callActual(ljc.a aVar, hjc hjcVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
            pjc pjcVar;
            pjc pjcVar2 = SchedulerWhen.e;
            do {
                pjcVar = get();
                if (pjcVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(pjcVar, pjcVar2));
            if (pjcVar != SchedulerWhen.d) {
                pjcVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(ljc.a aVar, hjc hjcVar) {
            pjc pjcVar = get();
            if (pjcVar == SchedulerWhen.e || pjcVar != SchedulerWhen.d) {
                return;
            }
            pjc callActual = callActual(aVar, hjcVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ljc.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ ljc.a b;
        public final /* synthetic */ jjc c;

        public b(SchedulerWhen schedulerWhen, ljc.a aVar, jjc jjcVar) {
            this.b = aVar;
            this.c = jjcVar;
        }

        @Override // com.baidu.tieba.ljc.a
        public pjc c(vjc vjcVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(vjcVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.ljc.a
        public pjc b(vjc vjcVar) {
            ImmediateAction immediateAction = new ImmediateAction(vjcVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.pjc
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.pjc
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements vjc {
        public hjc a;
        public vjc b;

        public d(vjc vjcVar, hjc hjcVar) {
            this.b = vjcVar;
            this.a = hjcVar;
        }

        @Override // com.baidu.tieba.vjc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.jjc<com.baidu.tieba.ijc<com.baidu.tieba.gjc>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.ljc
    public ljc.a createWorker() {
        ljc.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        tnc tncVar = new tnc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, tncVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(bkc<ijc<ijc<gjc>>, gjc> bkcVar, ljc ljcVar) {
        this.a = ljcVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new tnc(Q);
        this.c = bkcVar.call(Q.v()).f();
    }
}
