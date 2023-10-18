package rx.internal.schedulers;

import com.baidu.tieba.a7c;
import com.baidu.tieba.f6c;
import com.baidu.tieba.g6c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.i6c;
import com.baidu.tieba.k6c;
import com.baidu.tieba.nbc;
import com.baidu.tieba.o6c;
import com.baidu.tieba.sac;
import com.baidu.tieba.u6c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends k6c implements o6c {
    public static final o6c d = new c();
    public static final o6c e = nbc.c();
    public final k6c a;
    public final i6c<h6c<f6c>> b;
    public final o6c c;

    /* loaded from: classes2.dex */
    public static class c implements o6c {
        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements a7c<ScheduledAction, f6c> {
        public final /* synthetic */ k6c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0726a implements f6c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0726a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.v6c
            /* renamed from: a */
            public void call(g6c g6cVar) {
                g6cVar.onSubscribe(this.a);
                this.a.call(a.this.a, g6cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, k6c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public f6c call(ScheduledAction scheduledAction) {
            return f6c.b(new C0726a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final u6c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(u6c u6cVar, long j, TimeUnit timeUnit) {
            this.action = u6cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public o6c callActual(k6c.a aVar, g6c g6cVar) {
            return aVar.c(new d(this.action, g6cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final u6c action;

        public ImmediateAction(u6c u6cVar) {
            this.action = u6cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public o6c callActual(k6c.a aVar, g6c g6cVar) {
            return aVar.b(new d(this.action, g6cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<o6c> implements o6c {
        public abstract o6c callActual(k6c.a aVar, g6c g6cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            o6c o6cVar;
            o6c o6cVar2 = SchedulerWhen.e;
            do {
                o6cVar = get();
                if (o6cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(o6cVar, o6cVar2));
            if (o6cVar != SchedulerWhen.d) {
                o6cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(k6c.a aVar, g6c g6cVar) {
            o6c o6cVar = get();
            if (o6cVar == SchedulerWhen.e || o6cVar != SchedulerWhen.d) {
                return;
            }
            o6c callActual = callActual(aVar, g6cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends k6c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ k6c.a b;
        public final /* synthetic */ i6c c;

        public b(SchedulerWhen schedulerWhen, k6c.a aVar, i6c i6cVar) {
            this.b = aVar;
            this.c = i6cVar;
        }

        @Override // com.baidu.tieba.k6c.a
        public o6c c(u6c u6cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(u6cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.k6c.a
        public o6c b(u6c u6cVar) {
            ImmediateAction immediateAction = new ImmediateAction(u6cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements u6c {
        public g6c a;
        public u6c b;

        public d(u6c u6cVar, g6c g6cVar) {
            this.b = u6cVar;
            this.a = g6cVar;
        }

        @Override // com.baidu.tieba.u6c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.i6c<com.baidu.tieba.h6c<com.baidu.tieba.f6c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.k6c
    public k6c.a createWorker() {
        k6c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        sac sacVar = new sac(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, sacVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(a7c<h6c<h6c<f6c>>, f6c> a7cVar, k6c k6cVar) {
        this.a = k6cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new sac(Q);
        this.c = a7cVar.call(Q.v()).f();
    }
}
