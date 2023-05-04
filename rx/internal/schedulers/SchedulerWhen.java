package rx.internal.schedulers;

import com.baidu.tieba.b6b;
import com.baidu.tieba.h5b;
import com.baidu.tieba.i5b;
import com.baidu.tieba.iab;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.n9b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.w5b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes9.dex */
public class SchedulerWhen extends m5b implements q5b {
    public static final q5b d = new c();
    public static final q5b e = iab.c();
    public final m5b a;
    public final k5b<j5b<h5b>> b;
    public final q5b c;

    /* loaded from: classes9.dex */
    public static class c implements q5b {
        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements b6b<ScheduledAction, h5b> {
        public final /* synthetic */ m5b.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0750a implements h5b.f {
            public final /* synthetic */ ScheduledAction a;

            public C0750a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.h5b.f, com.baidu.tieba.x5b
            public void call(i5b i5bVar) {
                i5bVar.onSubscribe(this.a);
                this.a.call(a.this.a, i5bVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, m5b.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public h5b call(ScheduledAction scheduledAction) {
            return h5b.b(new C0750a(scheduledAction));
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public final w5b action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(w5b w5bVar, long j, TimeUnit timeUnit) {
            this.action = w5bVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public q5b callActual(m5b.a aVar, i5b i5bVar) {
            return aVar.c(new d(this.action, i5bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final w5b action;

        public ImmediateAction(w5b w5bVar) {
            this.action = w5bVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public q5b callActual(m5b.a aVar, i5b i5bVar) {
            return aVar.b(new d(this.action, i5bVar));
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<q5b> implements q5b {
        public abstract q5b callActual(m5b.a aVar, i5b i5bVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            q5b q5bVar;
            q5b q5bVar2 = SchedulerWhen.e;
            do {
                q5bVar = get();
                if (q5bVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(q5bVar, q5bVar2));
            if (q5bVar != SchedulerWhen.d) {
                q5bVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(m5b.a aVar, i5b i5bVar) {
            q5b q5bVar = get();
            if (q5bVar == SchedulerWhen.e || q5bVar != SchedulerWhen.d) {
                return;
            }
            q5b callActual = callActual(aVar, i5bVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends m5b.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ m5b.a b;
        public final /* synthetic */ k5b c;

        public b(SchedulerWhen schedulerWhen, m5b.a aVar, k5b k5bVar) {
            this.b = aVar;
            this.c = k5bVar;
        }

        @Override // com.baidu.tieba.m5b.a
        public q5b c(w5b w5bVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(w5bVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.m5b.a
        public q5b b(w5b w5bVar) {
            ImmediateAction immediateAction = new ImmediateAction(w5bVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements w5b {
        public i5b a;
        public w5b b;

        public d(w5b w5bVar, i5b i5bVar) {
            this.b = w5bVar;
            this.a = i5bVar;
        }

        @Override // com.baidu.tieba.w5b
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.k5b<com.baidu.tieba.j5b<com.baidu.tieba.h5b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.m5b
    public m5b.a createWorker() {
        m5b.a createWorker = this.a.createWorker();
        BufferUntilSubscriber F = BufferUntilSubscriber.F();
        n9b n9bVar = new n9b(F);
        Object j = F.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, n9bVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(b6b<j5b<j5b<h5b>>, h5b> b6bVar, m5b m5bVar) {
        this.a = m5bVar;
        PublishSubject F = PublishSubject.F();
        this.b = new n9b(F);
        this.c = b6bVar.call(F.p()).f();
    }
}
