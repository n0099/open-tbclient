package rx.internal.schedulers;

import com.baidu.tieba.a8c;
import com.baidu.tieba.g8c;
import com.baidu.tieba.l7c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.rcc;
import com.baidu.tieba.u7c;
import com.baidu.tieba.wbc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends q7c implements u7c {
    public static final u7c d = new c();
    public static final u7c e = rcc.c();
    public final q7c a;
    public final o7c<n7c<l7c>> b;
    public final u7c c;

    /* loaded from: classes2.dex */
    public static class c implements u7c {
        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements g8c<ScheduledAction, l7c> {
        public final /* synthetic */ q7c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0802a implements l7c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0802a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l7c.f, com.baidu.tieba.b8c
            public void call(m7c m7cVar) {
                m7cVar.onSubscribe(this.a);
                this.a.call(a.this.a, m7cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, q7c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public l7c call(ScheduledAction scheduledAction) {
            return l7c.b(new C0802a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final a8c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(a8c a8cVar, long j, TimeUnit timeUnit) {
            this.action = a8cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public u7c callActual(q7c.a aVar, m7c m7cVar) {
            return aVar.c(new d(this.action, m7cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final a8c action;

        public ImmediateAction(a8c a8cVar) {
            this.action = a8cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public u7c callActual(q7c.a aVar, m7c m7cVar) {
            return aVar.b(new d(this.action, m7cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<u7c> implements u7c {
        public abstract u7c callActual(q7c.a aVar, m7c m7cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            u7c u7cVar;
            u7c u7cVar2 = SchedulerWhen.e;
            do {
                u7cVar = get();
                if (u7cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(u7cVar, u7cVar2));
            if (u7cVar != SchedulerWhen.d) {
                u7cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(q7c.a aVar, m7c m7cVar) {
            u7c u7cVar = get();
            if (u7cVar == SchedulerWhen.e || u7cVar != SchedulerWhen.d) {
                return;
            }
            u7c callActual = callActual(aVar, m7cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends q7c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ q7c.a b;
        public final /* synthetic */ o7c c;

        public b(SchedulerWhen schedulerWhen, q7c.a aVar, o7c o7cVar) {
            this.b = aVar;
            this.c = o7cVar;
        }

        @Override // com.baidu.tieba.q7c.a
        public u7c c(a8c a8cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(a8cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.q7c.a
        public u7c b(a8c a8cVar) {
            ImmediateAction immediateAction = new ImmediateAction(a8cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements a8c {
        public m7c a;
        public a8c b;

        public d(a8c a8cVar, m7c m7cVar) {
            this.b = a8cVar;
            this.a = m7cVar;
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.o7c<com.baidu.tieba.n7c<com.baidu.tieba.l7c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.q7c
    public q7c.a createWorker() {
        q7c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        wbc wbcVar = new wbc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, wbcVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(g8c<n7c<n7c<l7c>>, l7c> g8cVar, q7c q7cVar) {
        this.a = q7cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new wbc(Q);
        this.c = g8cVar.call(Q.v()).f();
    }
}
