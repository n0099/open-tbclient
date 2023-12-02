package rx.internal.schedulers;

import com.baidu.tieba.boc;
import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.goc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.koc;
import com.baidu.tieba.osc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.woc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends goc implements koc {
    public static final koc d = new c();
    public static final koc e = jtc.c();
    public final goc a;
    public final eoc<doc<boc>> b;
    public final koc c;

    /* loaded from: classes2.dex */
    public static class c implements koc {
        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements woc<ScheduledAction, boc> {
        public final /* synthetic */ goc.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0772a implements boc.f {
            public final /* synthetic */ ScheduledAction a;

            public C0772a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.roc
            /* renamed from: a */
            public void call(coc cocVar) {
                cocVar.onSubscribe(this.a);
                this.a.call(a.this.a, cocVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, goc.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public boc call(ScheduledAction scheduledAction) {
            return boc.b(new C0772a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final qoc action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(qoc qocVar, long j, TimeUnit timeUnit) {
            this.action = qocVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public koc callActual(goc.a aVar, coc cocVar) {
            return aVar.c(new d(this.action, cocVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final qoc action;

        public ImmediateAction(qoc qocVar) {
            this.action = qocVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public koc callActual(goc.a aVar, coc cocVar) {
            return aVar.b(new d(this.action, cocVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<koc> implements koc {
        public abstract koc callActual(goc.a aVar, coc cocVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            koc kocVar;
            koc kocVar2 = SchedulerWhen.e;
            do {
                kocVar = get();
                if (kocVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(kocVar, kocVar2));
            if (kocVar != SchedulerWhen.d) {
                kocVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(goc.a aVar, coc cocVar) {
            koc kocVar = get();
            if (kocVar == SchedulerWhen.e || kocVar != SchedulerWhen.d) {
                return;
            }
            koc callActual = callActual(aVar, cocVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends goc.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ goc.a b;
        public final /* synthetic */ eoc c;

        public b(SchedulerWhen schedulerWhen, goc.a aVar, eoc eocVar) {
            this.b = aVar;
            this.c = eocVar;
        }

        @Override // com.baidu.tieba.goc.a
        public koc c(qoc qocVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(qocVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.goc.a
        public koc b(qoc qocVar) {
            ImmediateAction immediateAction = new ImmediateAction(qocVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements qoc {
        public coc a;
        public qoc b;

        public d(qoc qocVar, coc cocVar) {
            this.b = qocVar;
            this.a = cocVar;
        }

        @Override // com.baidu.tieba.qoc
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.eoc<com.baidu.tieba.doc<com.baidu.tieba.boc>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.goc
    public goc.a createWorker() {
        goc.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        osc oscVar = new osc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, oscVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(woc<doc<doc<boc>>, boc> wocVar, goc gocVar) {
        this.a = gocVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new osc(Q);
        this.c = wocVar.call(Q.v()).f();
    }
}
