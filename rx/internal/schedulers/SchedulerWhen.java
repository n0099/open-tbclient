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
/* loaded from: classes8.dex */
public class SchedulerWhen extends g implements k {

    /* renamed from: h  reason: collision with root package name */
    public static final k f72457h = new c();

    /* renamed from: i  reason: collision with root package name */
    public static final k f72458i = e.c();

    /* renamed from: e  reason: collision with root package name */
    public final g f72459e;

    /* renamed from: f  reason: collision with root package name */
    public final h.e<h.d<h.b>> f72460f;

    /* renamed from: g  reason: collision with root package name */
    public final k f72461g;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static abstract class ScheduledAction extends AtomicReference<k> implements k {
        public ScheduledAction() {
            super(SchedulerWhen.f72457h);
        }

        public final void a(g.a aVar, h.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.f72458i && kVar == SchedulerWhen.f72457h) {
                k callActual = callActual(aVar, cVar);
                if (compareAndSet(SchedulerWhen.f72457h, callActual)) {
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
            k kVar2 = SchedulerWhen.f72458i;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.f72458i) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.f72457h) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements f<ScheduledAction, h.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f72462e;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C2006a implements b.f {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f72463e;

            public C2006a(ScheduledAction scheduledAction) {
                this.f72463e = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            /* renamed from: a */
            public void call(h.c cVar) {
                cVar.onSubscribe(this.f72463e);
                this.f72463e.a(a.this.f72462e, cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, g.a aVar) {
            this.f72462e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.b call(ScheduledAction scheduledAction) {
            return h.b.b(new C2006a(scheduledAction));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f72465e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f72466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.e f72467g;

        public b(SchedulerWhen schedulerWhen, g.a aVar, h.e eVar) {
            this.f72466f = aVar;
            this.f72467g = eVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            ImmediateAction immediateAction = new ImmediateAction(aVar);
            this.f72467g.onNext(immediateAction);
            return immediateAction;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(aVar, j, timeUnit);
            this.f72467g.onNext(delayedAction);
            return delayedAction;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f72465e.get();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f72465e.compareAndSet(false, true)) {
                this.f72466f.unsubscribe();
                this.f72467g.onCompleted();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements k {
        @Override // h.k
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // h.k
        public void unsubscribe() {
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public h.c f72468e;

        /* renamed from: f  reason: collision with root package name */
        public h.n.a f72469f;

        public d(h.n.a aVar, h.c cVar) {
            this.f72469f = aVar;
            this.f72468e = cVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f72469f.call();
            } finally {
                this.f72468e.onCompleted();
            }
        }
    }

    public SchedulerWhen(f<h.d<h.d<h.b>>, h.b> fVar, g gVar) {
        this.f72459e = gVar;
        PublishSubject K = PublishSubject.K();
        this.f72460f = new h.q.d(K);
        this.f72461g = fVar.call(K.s()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: h.e<h.d<h.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g
    public g.a createWorker() {
        g.a createWorker = this.f72459e.createWorker();
        BufferUntilSubscriber K = BufferUntilSubscriber.K();
        h.q.d dVar = new h.q.d(K);
        Object k = K.k(new a(this, createWorker));
        b bVar = new b(this, createWorker, dVar);
        this.f72460f.onNext(k);
        return bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72461g.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f72461g.unsubscribe();
    }
}
