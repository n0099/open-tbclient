package rx.internal.schedulers;

import com.baidu.tieba.a1c;
import com.baidu.tieba.a6c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f5c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.p1c;
import com.baidu.tieba.v0c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.y0c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public class SchedulerWhen extends a1c implements e1c {
    public static final e1c d = new c();
    public static final e1c e = a6c.c();
    public final a1c a;
    public final y0c<x0c<v0c>> b;
    public final e1c c;

    /* loaded from: classes2.dex */
    public static class c implements e1c {
        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements p1c<ScheduledAction, v0c> {
        public final /* synthetic */ a1c.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0802a implements v0c.f {
            public final /* synthetic */ ScheduledAction a;

            public C0802a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.v0c.f, com.baidu.tieba.l1c
            public void call(w0c w0cVar) {
                w0cVar.onSubscribe(this.a);
                this.a.call(a.this.a, w0cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, a1c.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public v0c call(ScheduledAction scheduledAction) {
            return v0c.b(new C0802a(scheduledAction));
        }
    }

    /* loaded from: classes2.dex */
    public static class DelayedAction extends ScheduledAction {
        public final k1c action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(k1c k1cVar, long j, TimeUnit timeUnit) {
            this.action = k1cVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public e1c callActual(a1c.a aVar, w0c w0cVar) {
            return aVar.c(new d(this.action, w0cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final k1c action;

        public ImmediateAction(k1c k1cVar) {
            this.action = k1cVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public e1c callActual(a1c.a aVar, w0c w0cVar) {
            return aVar.b(new d(this.action, w0cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ScheduledAction extends AtomicReference<e1c> implements e1c {
        public abstract e1c callActual(a1c.a aVar, w0c w0cVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            e1c e1cVar;
            e1c e1cVar2 = SchedulerWhen.e;
            do {
                e1cVar = get();
                if (e1cVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(e1cVar, e1cVar2));
            if (e1cVar != SchedulerWhen.d) {
                e1cVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(a1c.a aVar, w0c w0cVar) {
            e1c e1cVar = get();
            if (e1cVar == SchedulerWhen.e || e1cVar != SchedulerWhen.d) {
                return;
            }
            e1c callActual = callActual(aVar, w0cVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a1c.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ a1c.a b;
        public final /* synthetic */ y0c c;

        public b(SchedulerWhen schedulerWhen, a1c.a aVar, y0c y0cVar) {
            this.b = aVar;
            this.c = y0cVar;
        }

        @Override // com.baidu.tieba.a1c.a
        public e1c c(k1c k1cVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(k1cVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.a1c.a
        public e1c b(k1c k1cVar) {
            ImmediateAction immediateAction = new ImmediateAction(k1cVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements k1c {
        public w0c a;
        public k1c b;

        public d(k1c k1cVar, w0c w0cVar) {
            this.b = k1cVar;
            this.a = w0cVar;
        }

        @Override // com.baidu.tieba.k1c
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.y0c<com.baidu.tieba.x0c<com.baidu.tieba.v0c>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.a1c
    public a1c.a createWorker() {
        a1c.a createWorker = this.a.createWorker();
        BufferUntilSubscriber Q = BufferUntilSubscriber.Q();
        f5c f5cVar = new f5c(Q);
        Object p = Q.p(new a(this, createWorker));
        b bVar = new b(this, createWorker, f5cVar);
        this.b.onNext(p);
        return bVar;
    }

    @Override // com.baidu.tieba.e1c
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(p1c<x0c<x0c<v0c>>, v0c> p1cVar, a1c a1cVar) {
        this.a = a1cVar;
        PublishSubject Q = PublishSubject.Q();
        this.b = new f5c(Q);
        this.c = p1cVar.call(Q.v()).f();
    }
}
