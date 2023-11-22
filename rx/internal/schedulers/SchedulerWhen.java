package rx.internal.schedulers;

import com.baidu.tieba.ckc;
import com.baidu.tieba.hjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.mjc;
import com.baidu.tieba.poc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.unc;
import com.baidu.tieba.wjc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends mjc implements qjc {
    public static final qjc d = new c();
    public static final qjc e = poc.c();
    public final mjc a;
    public final kjc<jjc<hjc>> b;
    public final qjc c;

    /* loaded from: classes2.dex */
    public static class c implements qjc {
        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ckc<ScheduledAction, hjc> {
        public final /* synthetic */ mjc.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0732a implements hjc.f {
            public final /* synthetic */ ScheduledAction a;

            public C0732a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.xjc
            /* renamed from: a */
            public void call(ijc ijcVar) {
                ijcVar.onSubscribe(this.a);
                this.a.call(a.this.a, ijcVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, mjc.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public hjc call(ScheduledAction scheduledAction) {
            return hjc.b(new C0732a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final wjc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(wjc wjcVar, long j, TimeUnit timeUnit) {
            this.action = wjcVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public qjc callActual(mjc.a aVar, ijc ijcVar) {
            return aVar.c(new d(this.action, ijcVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final wjc action;

        public ImmediateAction(wjc wjcVar) {
            this.action = wjcVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public qjc callActual(mjc.a aVar, ijc ijcVar) {
            return aVar.b(new d(this.action, ijcVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<qjc> implements qjc {
        public abstract qjc callActual(mjc.a aVar, ijc ijcVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            qjc qjcVar;
            qjc qjcVar2 = SchedulerWhen.e;
            do {
                qjcVar = get();
                if (qjcVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(qjcVar, qjcVar2));
            if (qjcVar != SchedulerWhen.d) {
                qjcVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(mjc.a aVar, ijc ijcVar) {
            qjc qjcVar = get();
            if (qjcVar == SchedulerWhen.e || qjcVar != SchedulerWhen.d) {
                return;
            }
            qjc callActual = callActual(aVar, ijcVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends mjc.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ mjc.a b;
        public final /* synthetic */ kjc c;

        public b(SchedulerWhen schedulerWhen, mjc.a aVar, kjc kjcVar) {
            this.b = aVar;
            this.c = kjcVar;
        }

        @Override // com.baidu.tieba.mjc.a
        public qjc c(wjc wjcVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(wjcVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.mjc.a
        public qjc b(wjc wjcVar) {
            ImmediateAction immediateAction = new ImmediateAction(wjcVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements wjc {
        public ijc a;
        public wjc b;

        public d(wjc wjcVar, ijc ijcVar) {
            this.b = wjcVar;
            this.a = ijcVar;
        }

        @Override // com.baidu.tieba.wjc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.kjc<com.baidu.tieba.jjc<com.baidu.tieba.hjc>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.mjc
    public mjc.a createWorker() {
        mjc.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        unc uncVar = new unc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, uncVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(ckc<jjc<jjc<hjc>>, hjc> ckcVar, mjc mjcVar) {
        this.a = mjcVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new unc(Q);
        this.c = ckcVar.call(Q.v()).f();
    }
}
