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
    public static final k f69234h = new c();
    public static final k i = e.c();

    /* renamed from: e  reason: collision with root package name */
    public final g f69235e;

    /* renamed from: f  reason: collision with root package name */
    public final h.e<h.d<h.b>> f69236f;

    /* renamed from: g  reason: collision with root package name */
    public final k f69237g;

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
            super(SchedulerWhen.f69234h);
        }

        public final void a(g.a aVar, h.c cVar) {
            k kVar = get();
            if (kVar != SchedulerWhen.i && kVar == SchedulerWhen.f69234h) {
                k callActual = callActual(aVar, cVar);
                if (compareAndSet(SchedulerWhen.f69234h, callActual)) {
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
            k kVar2 = SchedulerWhen.i;
            do {
                kVar = get();
                if (kVar == SchedulerWhen.i) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != SchedulerWhen.f69234h) {
                kVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f<ScheduledAction, h.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f69238e;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1931a implements b.f {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f69239e;

            public C1931a(ScheduledAction scheduledAction) {
                this.f69239e = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            /* renamed from: a */
            public void call(h.c cVar) {
                cVar.onSubscribe(this.f69239e);
                this.f69239e.a(a.this.f69238e, cVar);
            }
        }

        public a(SchedulerWhen schedulerWhen, g.a aVar) {
            this.f69238e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.b call(ScheduledAction scheduledAction) {
            return h.b.b(new C1931a(scheduledAction));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f69241e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f69242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.e f69243g;

        public b(SchedulerWhen schedulerWhen, g.a aVar, h.e eVar) {
            this.f69242f = aVar;
            this.f69243g = eVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            ImmediateAction immediateAction = new ImmediateAction(aVar);
            this.f69243g.onNext(immediateAction);
            return immediateAction;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(aVar, j, timeUnit);
            this.f69243g.onNext(delayedAction);
            return delayedAction;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69241e.get();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f69241e.compareAndSet(false, true)) {
                this.f69242f.unsubscribe();
                this.f69243g.onCompleted();
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
        public h.c f69244e;

        /* renamed from: f  reason: collision with root package name */
        public h.n.a f69245f;

        public d(h.n.a aVar, h.c cVar) {
            this.f69245f = aVar;
            this.f69244e = cVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f69245f.call();
            } finally {
                this.f69244e.onCompleted();
            }
        }
    }

    public SchedulerWhen(f<h.d<h.d<h.b>>, h.b> fVar, g gVar) {
        this.f69235e = gVar;
        PublishSubject N = PublishSubject.N();
        this.f69236f = new h.q.d(N);
        this.f69237g = fVar.call(N.t()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: h.e<h.d<h.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g
    public g.a createWorker() {
        g.a createWorker = this.f69235e.createWorker();
        BufferUntilSubscriber N = BufferUntilSubscriber.N();
        h.q.d dVar = new h.q.d(N);
        Object l = N.l(new a(this, createWorker));
        b bVar = new b(this, createWorker, dVar);
        this.f69236f.onNext(l);
        return bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69237g.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f69237g.unsubscribe();
    }
}
