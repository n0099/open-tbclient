package rx.internal.schedulers;

import com.baidu.tieba.c6b;
import com.baidu.tieba.d1b;
import com.baidu.tieba.e1b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.h5b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.x1b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public class SchedulerWhen extends i1b implements m1b {
    public static final m1b d = new c();
    public static final m1b e = c6b.c();
    public final i1b a;
    public final g1b<f1b<d1b>> b;
    public final m1b c;

    /* loaded from: classes9.dex */
    public static class c implements m1b {
        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements x1b<ScheduledAction, d1b> {
        public final /* synthetic */ i1b.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0748a implements d1b.f {
            public final /* synthetic */ ScheduledAction a;

            public C0748a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.d1b.f, com.baidu.tieba.t1b
            public void call(e1b e1bVar) {
                e1bVar.onSubscribe(this.a);
                this.a.call(a.this.a, e1bVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, i1b.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public d1b call(ScheduledAction scheduledAction) {
            return d1b.b(new C0748a(scheduledAction));
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public final s1b action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(s1b s1bVar, long j, TimeUnit timeUnit) {
            this.action = s1bVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public m1b callActual(i1b.a aVar, e1b e1bVar) {
            return aVar.c(new d(this.action, e1bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final s1b action;

        public ImmediateAction(s1b s1bVar) {
            this.action = s1bVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public m1b callActual(i1b.a aVar, e1b e1bVar) {
            return aVar.b(new d(this.action, e1bVar));
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<m1b> implements m1b {
        public abstract m1b callActual(i1b.a aVar, e1b e1bVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            m1b m1bVar;
            m1b m1bVar2 = SchedulerWhen.e;
            do {
                m1bVar = get();
                if (m1bVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(m1bVar, m1bVar2));
            if (m1bVar != SchedulerWhen.d) {
                m1bVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(i1b.a aVar, e1b e1bVar) {
            m1b m1bVar = get();
            if (m1bVar == SchedulerWhen.e || m1bVar != SchedulerWhen.d) {
                return;
            }
            m1b callActual = callActual(aVar, e1bVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends i1b.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ i1b.a b;
        public final /* synthetic */ g1b c;

        public b(SchedulerWhen schedulerWhen, i1b.a aVar, g1b g1bVar) {
            this.b = aVar;
            this.c = g1bVar;
        }

        @Override // com.baidu.tieba.i1b.a
        public m1b c(s1b s1bVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(s1bVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.i1b.a
        public m1b b(s1b s1bVar) {
            ImmediateAction immediateAction = new ImmediateAction(s1bVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements s1b {
        public e1b a;
        public s1b b;

        public d(s1b s1bVar, e1b e1bVar) {
            this.b = s1bVar;
            this.a = e1bVar;
        }

        @Override // com.baidu.tieba.s1b
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.g1b<com.baidu.tieba.f1b<com.baidu.tieba.d1b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.i1b
    public i1b.a createWorker() {
        i1b.a createWorker = this.a.createWorker();
        BufferUntilSubscriber D = BufferUntilSubscriber.D();
        h5b h5bVar = new h5b(D);
        Object h = D.h(new a(this, createWorker));
        b bVar = new b(this, createWorker, h5bVar);
        this.b.onNext(h);
        return bVar;
    }

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(x1b<f1b<f1b<d1b>>, d1b> x1bVar, i1b i1bVar) {
        this.a = i1bVar;
        PublishSubject D = PublishSubject.D();
        this.b = new h5b(D);
        this.c = x1bVar.call(D.n()).f();
    }
}
