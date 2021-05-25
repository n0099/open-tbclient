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
    public final Executor f68621a;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Executor f68622e;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f68624g = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f68625h = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f68623f = new h.u.b();

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f68626i = d.a();

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1935a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f68627e;

            public C1935a(h.u.c cVar) {
                this.f68627e = cVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f68623f.b(this.f68627e);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f68629e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68630f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f68631g;

            public b(h.u.c cVar, h.n.a aVar, k kVar) {
                this.f68629e = cVar;
                this.f68630f = aVar;
                this.f68631g = kVar;
            }

            @Override // h.n.a
            public void call() {
                if (this.f68629e.isUnsubscribed()) {
                    return;
                }
                k b2 = a.this.b(this.f68630f);
                this.f68629e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f68631g);
                }
            }
        }

        public a(Executor executor) {
            this.f68622e = executor;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f68623f);
            this.f68623f.a(scheduledAction);
            this.f68624g.offer(scheduledAction);
            if (this.f68625h.getAndIncrement() == 0) {
                try {
                    this.f68622e.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f68623f.b(scheduledAction);
                    this.f68625h.decrementAndGet();
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
            this.f68623f.a(cVar2);
            k a2 = h.u.e.a(new C1935a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, q, a2));
            cVar.a(scheduledAction);
            try {
                scheduledAction.add(this.f68626i.schedule(scheduledAction, j, timeUnit));
                return a2;
            } catch (RejectedExecutionException e2) {
                h.r.c.j(e2);
                throw e2;
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68623f.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f68623f.isUnsubscribed()) {
                ScheduledAction poll = this.f68624g.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f68623f.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f68624g.clear();
                        return;
                    }
                }
                if (this.f68625h.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f68624g.clear();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68623f.unsubscribe();
            this.f68624g.clear();
        }
    }

    public c(Executor executor) {
        this.f68621a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68621a);
    }
}
