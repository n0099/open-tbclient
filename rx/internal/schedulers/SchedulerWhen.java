package rx.internal.schedulers;

import com.baidu.tieba.a2b;
import com.baidu.tieba.f2b;
import com.baidu.tieba.k6b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public class SchedulerWhen extends q1b implements u1b {
    public static final u1b d = new c();
    public static final u1b e = k6b.c();
    public final q1b a;
    public final o1b<n1b<l1b>> b;
    public final u1b c;

    /* loaded from: classes9.dex */
    public static class c implements u1b {
        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements f2b<ScheduledAction, l1b> {
        public final /* synthetic */ q1b.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0747a implements l1b.f {
            public final /* synthetic */ ScheduledAction a;

            public C0747a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l1b.f, com.baidu.tieba.b2b
            public void call(m1b m1bVar) {
                m1bVar.onSubscribe(this.a);
                this.a.call(a.this.a, m1bVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, q1b.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public l1b call(ScheduledAction scheduledAction) {
            return l1b.b(new C0747a(scheduledAction));
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public final a2b action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(a2b a2bVar, long j, TimeUnit timeUnit) {
            this.action = a2bVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public u1b callActual(q1b.a aVar, m1b m1bVar) {
            return aVar.c(new d(this.action, m1bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final a2b action;

        public ImmediateAction(a2b a2bVar) {
            this.action = a2bVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public u1b callActual(q1b.a aVar, m1b m1bVar) {
            return aVar.b(new d(this.action, m1bVar));
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<u1b> implements u1b {
        public abstract u1b callActual(q1b.a aVar, m1b m1bVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            u1b u1bVar;
            u1b u1bVar2 = SchedulerWhen.e;
            do {
                u1bVar = get();
                if (u1bVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(u1bVar, u1bVar2));
            if (u1bVar != SchedulerWhen.d) {
                u1bVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(q1b.a aVar, m1b m1bVar) {
            u1b u1bVar = get();
            if (u1bVar == SchedulerWhen.e || u1bVar != SchedulerWhen.d) {
                return;
            }
            u1b callActual = callActual(aVar, m1bVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends q1b.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ q1b.a b;
        public final /* synthetic */ o1b c;

        public b(SchedulerWhen schedulerWhen, q1b.a aVar, o1b o1bVar) {
            this.b = aVar;
            this.c = o1bVar;
        }

        @Override // com.baidu.tieba.q1b.a
        public u1b c(a2b a2bVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(a2bVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.q1b.a
        public u1b b(a2b a2bVar) {
            ImmediateAction immediateAction = new ImmediateAction(a2bVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements a2b {
        public m1b a;
        public a2b b;

        public d(a2b a2bVar, m1b m1bVar) {
            this.b = a2bVar;
            this.a = m1bVar;
        }

        @Override // com.baidu.tieba.a2b
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.o1b<com.baidu.tieba.n1b<com.baidu.tieba.l1b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.q1b
    public q1b.a createWorker() {
        q1b.a createWorker = this.a.createWorker();
        BufferUntilSubscriber D = BufferUntilSubscriber.D();
        p5b p5bVar = new p5b(D);
        Object h = D.h(new a(this, createWorker));
        b bVar = new b(this, createWorker, p5bVar);
        this.b.onNext(h);
        return bVar;
    }

    @Override // com.baidu.tieba.u1b
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(f2b<n1b<n1b<l1b>>, l1b> f2bVar, q1b q1bVar) {
        this.a = q1bVar;
        PublishSubject D = PublishSubject.D();
        this.b = new p5b(D);
        this.c = f2bVar.call(D.n()).f();
    }
}
