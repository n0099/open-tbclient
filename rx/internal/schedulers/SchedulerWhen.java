package rx.internal.schedulers;

import com.baidu.tieba.b1c;
import com.baidu.tieba.b6c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.g5c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.z0c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends b1c implements f1c {
    public static final f1c d = new c();
    public static final f1c e = b6c.c();
    public final b1c a;
    public final z0c<y0c<w0c>> b;
    public final f1c c;

    /* loaded from: classes2.dex */
    public static class c implements f1c {
        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements q1c<ScheduledAction, w0c> {
        public final /* synthetic */ b1c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0802a implements w0c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0802a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.w0c.f, com.baidu.tieba.m1c
            public void call(x0c x0cVar) {
                x0cVar.onSubscribe(this.a);
                this.a.call(a.this.a, x0cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, b1c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public w0c call(ScheduledAction scheduledAction) {
            return w0c.b(new C0802a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final l1c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(l1c l1cVar, long j, TimeUnit timeUnit) {
            this.action = l1cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public f1c callActual(b1c.a aVar, x0c x0cVar) {
            return aVar.c(new d(this.action, x0cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final l1c action;

        public ImmediateAction(l1c l1cVar) {
            this.action = l1cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public f1c callActual(b1c.a aVar, x0c x0cVar) {
            return aVar.b(new d(this.action, x0cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<f1c> implements f1c {
        public abstract f1c callActual(b1c.a aVar, x0c x0cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
            f1c f1cVar;
            f1c f1cVar2 = SchedulerWhen.e;
            do {
                f1cVar = get();
                if (f1cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(f1cVar, f1cVar2));
            if (f1cVar != SchedulerWhen.d) {
                f1cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(b1c.a aVar, x0c x0cVar) {
            f1c f1cVar = get();
            if (f1cVar == SchedulerWhen.e || f1cVar != SchedulerWhen.d) {
                return;
            }
            f1c callActual = callActual(aVar, x0cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends b1c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ b1c.a b;
        public final /* synthetic */ z0c c;

        public b(SchedulerWhen schedulerWhen, b1c.a aVar, z0c z0cVar) {
            this.b = aVar;
            this.c = z0cVar;
        }

        @Override // com.baidu.tieba.b1c.a
        public f1c c(l1c l1cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(l1cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.b1c.a
        public f1c b(l1c l1cVar) {
            ImmediateAction immediateAction = new ImmediateAction(l1cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.f1c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.f1c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements l1c {
        public x0c a;
        public l1c b;

        public d(l1c l1cVar, x0c x0cVar) {
            this.b = l1cVar;
            this.a = x0cVar;
        }

        @Override // com.baidu.tieba.l1c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.z0c<com.baidu.tieba.y0c<com.baidu.tieba.w0c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.b1c
    public b1c.a createWorker() {
        b1c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        g5c g5cVar = new g5c(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, g5cVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(q1c<y0c<y0c<w0c>>, w0c> q1cVar, b1c b1cVar) {
        this.a = b1cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new g5c(Q);
        this.c = q1cVar.call(Q.v()).f();
    }
}
