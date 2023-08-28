package rx.internal.schedulers;

import com.baidu.tieba.c8c;
import com.baidu.tieba.i8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.s7c;
import com.baidu.tieba.tcc;
import com.baidu.tieba.w7c;
import com.baidu.tieba.ybc;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends s7c implements w7c {
    public static final w7c d = new c();
    public static final w7c e = tcc.c();
    public final s7c a;
    public final q7c<p7c<n7c>> b;
    public final w7c c;

    /* loaded from: classes2.dex */
    public static class c implements w7c {
        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements i8c<ScheduledAction, n7c> {
        public final /* synthetic */ s7c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0803a implements n7c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0803a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.n7c.f, com.baidu.tieba.d8c
            public void call(o7c o7cVar) {
                o7cVar.onSubscribe(this.a);
                this.a.call(a.this.a, o7cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, s7c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public n7c call(ScheduledAction scheduledAction) {
            return n7c.b(new C0803a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final c8c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(c8c c8cVar, long j, TimeUnit timeUnit) {
            this.action = c8cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public w7c callActual(s7c.a aVar, o7c o7cVar) {
            return aVar.c(new d(this.action, o7cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final c8c action;

        public ImmediateAction(c8c c8cVar) {
            this.action = c8cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public w7c callActual(s7c.a aVar, o7c o7cVar) {
            return aVar.b(new d(this.action, o7cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<w7c> implements w7c {
        public abstract w7c callActual(s7c.a aVar, o7c o7cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            w7c w7cVar;
            w7c w7cVar2 = SchedulerWhen.e;
            do {
                w7cVar = get();
                if (w7cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(w7cVar, w7cVar2));
            if (w7cVar != SchedulerWhen.d) {
                w7cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(s7c.a aVar, o7c o7cVar) {
            w7c w7cVar = get();
            if (w7cVar == SchedulerWhen.e || w7cVar != SchedulerWhen.d) {
                return;
            }
            w7c callActual = callActual(aVar, o7cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends s7c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ s7c.a b;
        public final /* synthetic */ q7c c;

        public b(SchedulerWhen schedulerWhen, s7c.a aVar, q7c q7cVar) {
            this.b = aVar;
            this.c = q7cVar;
        }

        @Override // com.baidu.tieba.s7c.a
        public w7c c(c8c c8cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(c8cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.s7c.a
        public w7c b(c8c c8cVar) {
            ImmediateAction immediateAction = new ImmediateAction(c8cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements c8c {
        public o7c a;
        public c8c b;

        public d(c8c c8cVar, o7c o7cVar) {
            this.b = c8cVar;
            this.a = o7cVar;
        }

        @Override // com.baidu.tieba.c8c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.q7c<com.baidu.tieba.p7c<com.baidu.tieba.n7c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.s7c
    public s7c.a createWorker() {
        s7c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        ybc ybcVar = new ybc(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, ybcVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(i8c<p7c<p7c<n7c>>, n7c> i8cVar, s7c s7cVar) {
        this.a = s7cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new ybc(Q);
        this.c = i8cVar.call(Q.v()).f();
    }
}
