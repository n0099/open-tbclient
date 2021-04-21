package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes7.dex */
public final class c extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f69042a;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Executor f69043e;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f69045g = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f69046h = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f69044f = new h.u.b();
        public final ScheduledExecutorService i = d.a();

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1921a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f69047e;

            public C1921a(h.u.c cVar) {
                this.f69047e = cVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f69044f.b(this.f69047e);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f69049e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69050f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f69051g;

            public b(h.u.c cVar, h.n.a aVar, k kVar) {
                this.f69049e = cVar;
                this.f69050f = aVar;
                this.f69051g = kVar;
            }

            @Override // h.n.a
            public void call() {
                if (this.f69049e.isUnsubscribed()) {
                    return;
                }
                k b2 = a.this.b(this.f69050f);
                this.f69049e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f69051g);
                }
            }
        }

        public a(Executor executor) {
            this.f69043e = executor;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f69044f);
            this.f69044f.a(scheduledAction);
            this.f69045g.offer(scheduledAction);
            if (this.f69046h.getAndIncrement() == 0) {
                try {
                    this.f69043e.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f69044f.b(scheduledAction);
                    this.f69046h.decrementAndGet();
                    h.r.c.j(e2);
                    throw e2;
                }
            }
            return scheduledAction;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return b(aVar);
            }
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            h.n.a q = h.r.c.q(aVar);
            h.u.c cVar = new h.u.c();
            h.u.c cVar2 = new h.u.c();
            cVar2.a(cVar);
            this.f69044f.a(cVar2);
            k a2 = h.u.e.a(new C1921a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, q, a2));
            cVar.a(scheduledAction);
            try {
                scheduledAction.add(this.i.schedule(scheduledAction, j, timeUnit));
                return a2;
            } catch (RejectedExecutionException e2) {
                h.r.c.j(e2);
                throw e2;
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69044f.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f69044f.isUnsubscribed()) {
                ScheduledAction poll = this.f69045g.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f69044f.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f69045g.clear();
                        return;
                    }
                }
                if (this.f69046h.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f69045g.clear();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69044f.unsubscribe();
            this.f69045g.clear();
        }
    }

    public c(Executor executor) {
        this.f69042a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f69042a);
    }
}
