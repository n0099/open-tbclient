package rx.internal.schedulers;

import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.foc;
import com.baidu.tieba.hoc;
import com.baidu.tieba.ktc;
import com.baidu.tieba.loc;
import com.baidu.tieba.psc;
import com.baidu.tieba.roc;
import com.baidu.tieba.xoc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends hoc implements loc {
    public static final loc d = new c();
    public static final loc e = ktc.c();
    public final hoc a;
    public final foc<eoc<coc>> b;
    public final loc c;

    /* loaded from: classes2.dex */
    public static class c implements loc {
        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements xoc<ScheduledAction, coc> {
        public final /* synthetic */ hoc.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0772a implements coc.f {
            public final /* synthetic */ ScheduledAction a;

            public C0772a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.soc
            /* renamed from: a */
            public void call(doc docVar) {
                docVar.onSubscribe(this.a);
                this.a.call(a.this.a, docVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, hoc.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public coc call(ScheduledAction scheduledAction) {
            return coc.b(new C0772a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final roc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(roc rocVar, long j, TimeUnit timeUnit) {
            this.action = rocVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public loc callActual(hoc.a aVar, doc docVar) {
            return aVar.c(new d(this.action, docVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final roc action;

        public ImmediateAction(roc rocVar) {
            this.action = rocVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public loc callActual(hoc.a aVar, doc docVar) {
            return aVar.b(new d(this.action, docVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<loc> implements loc {
        public abstract loc callActual(hoc.a aVar, doc docVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
            loc locVar;
            loc locVar2 = SchedulerWhen.e;
            do {
                locVar = get();
                if (locVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(locVar, locVar2));
            if (locVar != SchedulerWhen.d) {
                locVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(hoc.a aVar, doc docVar) {
            loc locVar = get();
            if (locVar == SchedulerWhen.e || locVar != SchedulerWhen.d) {
                return;
            }
            loc callActual = callActual(aVar, docVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends hoc.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ hoc.a b;
        public final /* synthetic */ foc c;

        public b(SchedulerWhen schedulerWhen, hoc.a aVar, foc focVar) {
            this.b = aVar;
            this.c = focVar;
        }

        @Override // com.baidu.tieba.hoc.a
        public loc c(roc rocVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(rocVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.hoc.a
        public loc b(roc rocVar) {
            ImmediateAction immediateAction = new ImmediateAction(rocVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.loc
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.loc
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements roc {
        public doc a;
        public roc b;

        public d(roc rocVar, doc docVar) {
            this.b = rocVar;
            this.a = docVar;
        }

        @Override // com.baidu.tieba.roc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.foc<com.baidu.tieba.eoc<com.baidu.tieba.coc>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.hoc
    public hoc.a createWorker() {
        hoc.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        psc pscVar = new psc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, pscVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(xoc<eoc<eoc<coc>>, coc> xocVar, hoc hocVar) {
        this.a = hocVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new psc(Q);
        this.c = xocVar.call(Q.v()).f();
    }
}
