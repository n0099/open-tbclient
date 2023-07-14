package rx.internal.schedulers;

import com.baidu.tieba.b2c;
import com.baidu.tieba.c6c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.m2c;
import com.baidu.tieba.s1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v1c;
import com.baidu.tieba.x1c;
import com.baidu.tieba.x6c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends x1c implements b2c {
    public static final b2c d = new c();
    public static final b2c e = x6c.c();
    public final x1c a;
    public final v1c<u1c<s1c>> b;
    public final b2c c;

    /* loaded from: classes2.dex */
    public static class c implements b2c {
        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements m2c<ScheduledAction, s1c> {
        public final /* synthetic */ x1c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0801a implements s1c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0801a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
            public void call(t1c t1cVar) {
                t1cVar.onSubscribe(this.a);
                this.a.call(a.this.a, t1cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, x1c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public s1c call(ScheduledAction scheduledAction) {
            return s1c.b(new C0801a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final h2c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(h2c h2cVar, long j, TimeUnit timeUnit) {
            this.action = h2cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public b2c callActual(x1c.a aVar, t1c t1cVar) {
            return aVar.c(new d(this.action, t1cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final h2c action;

        public ImmediateAction(h2c h2cVar) {
            this.action = h2cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public b2c callActual(x1c.a aVar, t1c t1cVar) {
            return aVar.b(new d(this.action, t1cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<b2c> implements b2c {
        public abstract b2c callActual(x1c.a aVar, t1c t1cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            b2c b2cVar;
            b2c b2cVar2 = SchedulerWhen.e;
            do {
                b2cVar = get();
                if (b2cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(b2cVar, b2cVar2));
            if (b2cVar != SchedulerWhen.d) {
                b2cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(x1c.a aVar, t1c t1cVar) {
            b2c b2cVar = get();
            if (b2cVar == SchedulerWhen.e || b2cVar != SchedulerWhen.d) {
                return;
            }
            b2c callActual = callActual(aVar, t1cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends x1c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ x1c.a b;
        public final /* synthetic */ v1c c;

        public b(SchedulerWhen schedulerWhen, x1c.a aVar, v1c v1cVar) {
            this.b = aVar;
            this.c = v1cVar;
        }

        @Override // com.baidu.tieba.x1c.a
        public b2c c(h2c h2cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(h2cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.x1c.a
        public b2c b(h2c h2cVar) {
            ImmediateAction immediateAction = new ImmediateAction(h2cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements h2c {
        public t1c a;
        public h2c b;

        public d(h2c h2cVar, t1c t1cVar) {
            this.b = h2cVar;
            this.a = t1cVar;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.v1c<com.baidu.tieba.u1c<com.baidu.tieba.s1c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.x1c
    public x1c.a createWorker() {
        x1c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        c6c c6cVar = new c6c(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, c6cVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(m2c<u1c<u1c<s1c>>, s1c> m2cVar, x1c x1cVar) {
        this.a = x1cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new c6c(Q);
        this.c = m2cVar.call(Q.v()).f();
    }
}
