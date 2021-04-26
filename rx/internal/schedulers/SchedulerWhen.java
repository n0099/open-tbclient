package rx.internal.schedulers;

import h.b;
import h.g;
import h.k;
import h.n.f;
import h.u.e;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes7.dex */
public class SchedulerWhen extends g implements k {

    /* renamed from: h  reason: collision with root package name */
    public static final k f68425h = new c();

    /* renamed from: i  reason: collision with root package name */
    public static final k f68426i = e.c();

    /* renamed from: e  reason: collision with root package name */
    public final g f68427e;

    /* renamed from: f  reason: collision with root package name */
    public final h.e<h.d<h.b>> f68428f;

    /* renamed from: g  reason: collision with root package name */
    public final k f68429g;

    /* loaded from: classes7.dex */
    public static class DelayedAction extends ScheduledAction {
        public final h.n.a action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(h.n.a aVar, long j, TimeUnit timeUnit) {
            this.action = aVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public k callActual(g.a aVar, h.c cVar) {
            return aVar.c(new d(this.action, cVar), this.delayTime, this.unit);
        }
    }

    /* loaded from: classes7.dex */
    public static class ImmediateAction extends ScheduledAction {
        public final h.n.a action;

        public ImmediateAction(h.n.a aVar) {
            this.action = aVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public k callActual(g.a aVar, h.c cVar) {
            return aVar.b(new d(this.action, cVar));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class ScheduledAction extends AtomicReference<k> implements k {
        public ScheduledAction() {
            super(SchedulerWhen.f68425h);
        }

        public final void a(g.a aVar, h.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.f68426i && kVar == SchedulerWhen.f68425h) {
                k callActual = callActual(aVar, cVar);
                if (compareAndSet(SchedulerWhen.f68425h, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract k callActual(g.a aVar, h.c cVar);

        @Override // h.k
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            k kVar;
            k kVar2 = SchedulerWhen.f68426i;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.f68426i) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.f68425h) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f<ScheduledAction, h.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f68430e;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1889a implements b.f {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f68431e;

            public C1889a(ScheduledAction scheduledAction) {
                this.f68431e = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            /* renamed from: a */
            public void call(h.c cVar) {
                cVar.onSubscribe(this.f68431e);
                this.f68431e.a(a.this.f68430e, cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, g.a aVar) {
            this.f68430e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.b call(ScheduledAction scheduledAction) {
            return h.b.b(new C1889a(scheduledAction));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f68433e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f68434f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.e f68435g;

        public b(SchedulerWhen schedulerWhen, g.a aVar, h.e eVar) {
            this.f68434f = aVar;
            this.f68435g = eVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            ImmediateAction immediateAction = new ImmediateAction(aVar);
            this.f68435g.onNext(immediateAction);
            return immediateAction;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(aVar, j, timeUnit);
            this.f68435g.onNext(delayedAction);
            return delayedAction;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68433e.get();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f68433e.compareAndSet(false, true)) {
                this.f68434f.unsubscribe();
                this.f68435g.onCompleted();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements k {
        @Override // h.k
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // h.k
        public void unsubscribe() {
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public h.c f68436e;

        /* renamed from: f  reason: collision with root package name */
        public h.n.a f68437f;

        public d(h.n.a aVar, h.c cVar) {
            this.f68437f = aVar;
            this.f68436e = cVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f68437f.call();
            } finally {
                this.f68436e.onCompleted();
            }
        }
    }

    public SchedulerWhen(f<h.d<h.d<h.b>>, h.b> fVar, g gVar) {
        this.f68427e = gVar;
        PublishSubject K = PublishSubject.K();
        this.f68428f = new h.q.d(K);
        this.f68429g = fVar.call(K.s()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: h.e<h.d<h.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g
    public g.a createWorker() {
        g.a createWorker = this.f68427e.createWorker();
        BufferUntilSubscriber K = BufferUntilSubscriber.K();
        h.q.d dVar = new h.q.d(K);
        Object k = K.k(new a(this, createWorker));
        b bVar = new b(this, createWorker, dVar);
        this.f68428f.onNext(k);
        return bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f68429g.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f68429g.unsubscribe();
    }
}
