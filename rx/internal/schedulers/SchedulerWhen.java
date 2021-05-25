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
    public static final k f69148h = new c();

    /* renamed from: i  reason: collision with root package name */
    public static final k f69149i = e.c();

    /* renamed from: e  reason: collision with root package name */
    public final g f69150e;

    /* renamed from: f  reason: collision with root package name */
    public final h.e<h.d<h.b>> f69151f;

    /* renamed from: g  reason: collision with root package name */
    public final k f69152g;

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
            super(SchedulerWhen.f69148h);
        }

        public final void a(g.a aVar, h.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.f69149i && kVar == SchedulerWhen.f69148h) {
                k callActual = callActual(aVar, cVar);
                if (compareAndSet(SchedulerWhen.f69148h, callActual)) {
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
            k kVar2 = SchedulerWhen.f69149i;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.f69149i) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.f69148h) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f<ScheduledAction, h.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f69153e;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1956a implements b.f {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f69154e;

            public C1956a(ScheduledAction scheduledAction) {
                this.f69154e = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            /* renamed from: a */
            public void call(h.c cVar) {
                cVar.onSubscribe(this.f69154e);
                this.f69154e.a(a.this.f69153e, cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, g.a aVar) {
            this.f69153e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.b call(ScheduledAction scheduledAction) {
            return h.b.b(new C1956a(scheduledAction));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f69156e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f69157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.e f69158g;

        public b(SchedulerWhen schedulerWhen, g.a aVar, h.e eVar) {
            this.f69157f = aVar;
            this.f69158g = eVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            ImmediateAction immediateAction = new ImmediateAction(aVar);
            this.f69158g.onNext(immediateAction);
            return immediateAction;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(aVar, j, timeUnit);
            this.f69158g.onNext(delayedAction);
            return delayedAction;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69156e.get();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f69156e.compareAndSet(false, true)) {
                this.f69157f.unsubscribe();
                this.f69158g.onCompleted();
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
        public h.c f69159e;

        /* renamed from: f  reason: collision with root package name */
        public h.n.a f69160f;

        public d(h.n.a aVar, h.c cVar) {
            this.f69160f = aVar;
            this.f69159e = cVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f69160f.call();
            } finally {
                this.f69159e.onCompleted();
            }
        }
    }

    public SchedulerWhen(f<h.d<h.d<h.b>>, h.b> fVar, g gVar) {
        this.f69150e = gVar;
        PublishSubject K = PublishSubject.K();
        this.f69151f = new h.q.d(K);
        this.f69152g = fVar.call(K.s()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: h.e<h.d<h.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g
    public g.a createWorker() {
        g.a createWorker = this.f69150e.createWorker();
        BufferUntilSubscriber K = BufferUntilSubscriber.K();
        h.q.d dVar = new h.q.d(K);
        Object k = K.k(new a(this, createWorker));
        b bVar = new b(this, createWorker, dVar);
        this.f69151f.onNext(k);
        return bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69152g.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f69152g.unsubscribe();
    }
}
