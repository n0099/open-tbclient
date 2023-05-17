package rx.internal.schedulers;

import com.baidu.tieba.f7b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.hcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.mbb;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.z7b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes10.dex */
public class SchedulerWhen extends k7b implements o7b {
    public static final o7b d = new c();
    public static final o7b e = hcb.c();
    public final k7b a;
    public final i7b<h7b<f7b>> b;
    public final o7b c;

    /* loaded from: classes10.dex */
    public static class c implements o7b {
        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
        }
    }

    /* loaded from: classes10.dex */
    public class a implements z7b<ScheduledAction, f7b> {
        public final /* synthetic */ k7b.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0764a implements f7b.f {
            public final /* synthetic */ ScheduledAction a;

            public C0764a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.f7b.f, com.baidu.tieba.v7b
            public void call(g7b g7bVar) {
                g7bVar.onSubscribe(this.a);
                this.a.call(a.this.a, g7bVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, k7b.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public f7b call(ScheduledAction scheduledAction) {
            return f7b.b(new C0764a(scheduledAction));
        }
    }

    /* loaded from: classes10.dex */
    public static class DelayedAction extends ScheduledAction {
        public final u7b action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(u7b u7bVar, long j, TimeUnit timeUnit) {
            this.action = u7bVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public o7b callActual(k7b.a aVar, g7b g7bVar) {
            return aVar.c(new d(this.action, g7bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes10.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final u7b action;

        public ImmediateAction(u7b u7bVar) {
            this.action = u7bVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public o7b callActual(k7b.a aVar, g7b g7bVar) {
            return aVar.b(new d(this.action, g7bVar));
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class ScheduledAction extends AtomicReference<o7b> implements o7b {
        public abstract o7b callActual(k7b.a aVar, g7b g7bVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
            o7b o7bVar;
            o7b o7bVar2 = SchedulerWhen.e;
            do {
                o7bVar = get();
                if (o7bVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(o7bVar, o7bVar2));
            if (o7bVar != SchedulerWhen.d) {
                o7bVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(k7b.a aVar, g7b g7bVar) {
            o7b o7bVar = get();
            if (o7bVar == SchedulerWhen.e || o7bVar != SchedulerWhen.d) {
                return;
            }
            o7b callActual = callActual(aVar, g7bVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends k7b.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ k7b.a b;
        public final /* synthetic */ i7b c;

        public b(SchedulerWhen schedulerWhen, k7b.a aVar, i7b i7bVar) {
            this.b = aVar;
            this.c = i7bVar;
        }

        @Override // com.baidu.tieba.k7b.a
        public o7b c(u7b u7bVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(u7bVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.k7b.a
        public o7b b(u7b u7bVar) {
            ImmediateAction immediateAction = new ImmediateAction(u7bVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.o7b
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.o7b
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements u7b {
        public g7b a;
        public u7b b;

        public d(u7b u7bVar, g7b g7bVar) {
            this.b = u7bVar;
            this.a = g7bVar;
        }

        @Override // com.baidu.tieba.u7b
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.i7b<com.baidu.tieba.h7b<com.baidu.tieba.f7b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.k7b
    public k7b.a createWorker() {
        k7b.a createWorker = this.a.createWorker();
        BufferUntilSubscriber H = BufferUntilSubscriber.H();
        mbb mbbVar = new mbb(H);
        Object j = H.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, mbbVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(z7b<h7b<h7b<f7b>>, f7b> z7bVar, k7b k7bVar) {
        this.a = k7bVar;
        PublishSubject H = PublishSubject.H();
        this.b = new mbb(H);
        this.c = z7bVar.call(H.p()).f();
    }
}
