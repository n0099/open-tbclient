package rx.internal.schedulers;

import com.baidu.tieba.ddc;
import com.baidu.tieba.icc;
import com.baidu.tieba.jcc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.lcc;
import com.baidu.tieba.ncc;
import com.baidu.tieba.ohc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.tgc;
import com.baidu.tieba.xcc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends ncc implements rcc {
    public static final rcc d = new c();
    public static final rcc e = ohc.c();
    public final ncc a;
    public final lcc<kcc<icc>> b;
    public final rcc c;

    /* loaded from: classes2.dex */
    public static class c implements rcc {
        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ddc<ScheduledAction, icc> {
        public final /* synthetic */ ncc.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0791a implements icc.f {
            public final /* synthetic */ ScheduledAction a;

            public C0791a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.icc.f, com.baidu.tieba.ycc
            public void call(jcc jccVar) {
                jccVar.onSubscribe(this.a);
                this.a.call(a.this.a, jccVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, ncc.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public icc call(ScheduledAction scheduledAction) {
            return icc.b(new C0791a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final xcc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(xcc xccVar, long j, TimeUnit timeUnit) {
            this.action = xccVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public rcc callActual(ncc.a aVar, jcc jccVar) {
            return aVar.c(new d(this.action, jccVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final xcc action;

        public ImmediateAction(xcc xccVar) {
            this.action = xccVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public rcc callActual(ncc.a aVar, jcc jccVar) {
            return aVar.b(new d(this.action, jccVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<rcc> implements rcc {
        public abstract rcc callActual(ncc.a aVar, jcc jccVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            rcc rccVar;
            rcc rccVar2 = SchedulerWhen.e;
            do {
                rccVar = get();
                if (rccVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(rccVar, rccVar2));
            if (rccVar != SchedulerWhen.d) {
                rccVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(ncc.a aVar, jcc jccVar) {
            rcc rccVar = get();
            if (rccVar == SchedulerWhen.e || rccVar != SchedulerWhen.d) {
                return;
            }
            rcc callActual = callActual(aVar, jccVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ncc.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ ncc.a b;
        public final /* synthetic */ lcc c;

        public b(SchedulerWhen schedulerWhen, ncc.a aVar, lcc lccVar) {
            this.b = aVar;
            this.c = lccVar;
        }

        @Override // com.baidu.tieba.ncc.a
        public rcc c(xcc xccVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(xccVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.ncc.a
        public rcc b(xcc xccVar) {
            ImmediateAction immediateAction = new ImmediateAction(xccVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements xcc {
        public jcc a;
        public xcc b;

        public d(xcc xccVar, jcc jccVar) {
            this.b = xccVar;
            this.a = jccVar;
        }

        @Override // com.baidu.tieba.xcc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.lcc<com.baidu.tieba.kcc<com.baidu.tieba.icc>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.ncc
    public ncc.a createWorker() {
        ncc.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        tgc tgcVar = new tgc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, tgcVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.rcc
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(ddc<kcc<kcc<icc>>, icc> ddcVar, ncc nccVar) {
        this.a = nccVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new tgc(Q);
        this.c = ddcVar.call(Q.v()).f();
    }
}
