package rx.internal.schedulers;

import com.baidu.tieba.a8b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.icb;
import com.baidu.tieba.j7b;
import com.baidu.tieba.l7b;
import com.baidu.tieba.nbb;
import com.baidu.tieba.p7b;
import com.baidu.tieba.v7b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes10.dex */
public class SchedulerWhen extends l7b implements p7b {
    public static final p7b d = new c();
    public static final p7b e = icb.c();
    public final l7b a;
    public final j7b<i7b<g7b>> b;
    public final p7b c;

    /* loaded from: classes10.dex */
    public static class c implements p7b {
        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
        }
    }

    /* loaded from: classes10.dex */
    public class a implements a8b<ScheduledAction, g7b> {
        public final /* synthetic */ l7b.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0764a implements g7b.f {
            public final /* synthetic */ ScheduledAction a;

            public C0764a(ScheduledAction scheduledAction) {
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.g7b.f, com.baidu.tieba.w7b
            public void call(h7b h7bVar) {
                h7bVar.onSubscribe(this.a);
                this.a.call(a.this.a, h7bVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, l7b.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public g7b call(ScheduledAction scheduledAction) {
            return g7b.b(new C0764a(scheduledAction));
        }
    }

    /* loaded from: classes10.dex */
    public static class DelayedAction extends ScheduledAction {
        public final v7b action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(v7b v7bVar, long j, TimeUnit timeUnit) {
            this.action = v7bVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public p7b callActual(l7b.a aVar, h7b h7bVar) {
            return aVar.c(new d(this.action, h7bVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes10.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final v7b action;

        public ImmediateAction(v7b v7bVar) {
            this.action = v7bVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public p7b callActual(l7b.a aVar, h7b h7bVar) {
            return aVar.b(new d(this.action, h7bVar));
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class ScheduledAction extends AtomicReference<p7b> implements p7b {
        public abstract p7b callActual(l7b.a aVar, h7b h7bVar);

        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            p7b p7bVar;
            p7b p7bVar2 = SchedulerWhen.e;
            do {
                p7bVar = get();
                if (p7bVar == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(p7bVar, p7bVar2));
            if (p7bVar != SchedulerWhen.d) {
                p7bVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(l7b.a aVar, h7b h7bVar) {
            p7b p7bVar = get();
            if (p7bVar == SchedulerWhen.e || p7bVar != SchedulerWhen.d) {
                return;
            }
            p7b callActual = callActual(aVar, h7bVar);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends l7b.a {
        public final AtomicBoolean a = new AtomicBoolean();
        public final /* synthetic */ l7b.a b;
        public final /* synthetic */ j7b c;

        public b(SchedulerWhen schedulerWhen, l7b.a aVar, j7b j7bVar) {
            this.b = aVar;
            this.c = j7bVar;
        }

        @Override // com.baidu.tieba.l7b.a
        public p7b c(v7b v7bVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(v7bVar, j, timeUnit);
            this.c.onNext(delayedAction);
            return delayedAction;
        }

        @Override // com.baidu.tieba.l7b.a
        public p7b b(v7b v7bVar) {
            ImmediateAction immediateAction = new ImmediateAction(v7bVar);
            this.c.onNext(immediateAction);
            return immediateAction;
        }

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.a.get();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements v7b {
        public h7b a;
        public v7b b;

        public d(v7b v7bVar, h7b h7bVar) {
            this.b = v7bVar;
            this.a = h7bVar;
        }

        @Override // com.baidu.tieba.v7b
        public void call() {
            try {
                this.b.call();
            } finally {
                this.a.onCompleted();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.j7b<com.baidu.tieba.i7b<com.baidu.tieba.g7b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.l7b
    public l7b.a createWorker() {
        l7b.a createWorker = this.a.createWorker();
        BufferUntilSubscriber H = BufferUntilSubscriber.H();
        nbb nbbVar = new nbb(H);
        Object j = H.j(new a(this, createWorker));
        b bVar = new b(this, createWorker, nbbVar);
        this.b.onNext(j);
        return bVar;
    }

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public SchedulerWhen(a8b<i7b<i7b<g7b>>, g7b> a8bVar, l7b l7bVar) {
        this.a = l7bVar;
        PublishSubject H = PublishSubject.H();
        this.b = new nbb(H);
        this.c = a8bVar.call(H.p()).f();
    }
}
