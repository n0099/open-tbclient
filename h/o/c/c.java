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
    public final Executor f67885a;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Executor f67886e;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f67888g = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f67889h = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f67887f = new h.u.b();
        public final ScheduledExecutorService i = d.a();

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1882a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f67890e;

            public C1882a(h.u.c cVar) {
                this.f67890e = cVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f67887f.b(this.f67890e);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f67892e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67893f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f67894g;

            public b(h.u.c cVar, h.n.a aVar, k kVar) {
                this.f67892e = cVar;
                this.f67893f = aVar;
                this.f67894g = kVar;
            }

            @Override // h.n.a
            public void call() {
                if (this.f67892e.isUnsubscribed()) {
                    return;
                }
                k b2 = a.this.b(this.f67893f);
                this.f67892e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f67894g);
                }
            }
        }

        public a(Executor executor) {
            this.f67886e = executor;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f67887f);
            this.f67887f.a(scheduledAction);
            this.f67888g.offer(scheduledAction);
            if (this.f67889h.getAndIncrement() == 0) {
                try {
                    this.f67886e.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f67887f.b(scheduledAction);
                    this.f67889h.decrementAndGet();
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
            this.f67887f.a(cVar2);
            k a2 = h.u.e.a(new C1882a(cVar2));
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
            return this.f67887f.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f67887f.isUnsubscribed()) {
                ScheduledAction poll = this.f67888g.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f67887f.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f67888g.clear();
                        return;
                    }
                }
                if (this.f67889h.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f67888g.clear();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67887f.unsubscribe();
            this.f67888g.clear();
        }
    }

    public c(Executor executor) {
        this.f67885a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67885a);
    }
}
