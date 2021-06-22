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
/* loaded from: classes8.dex */
public final class c extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f71981a;

    /* loaded from: classes8.dex */
    public static final class a extends g.a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Executor f71982e;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f71984g = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f71985h = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f71983f = new h.u.b();

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f71986i = d.a();

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1987a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f71987e;

            public C1987a(h.u.c cVar) {
                this.f71987e = cVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f71983f.b(this.f71987e);
            }
        }

        /* loaded from: classes8.dex */
        public class b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f71989e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71990f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f71991g;

            public b(h.u.c cVar, h.n.a aVar, k kVar) {
                this.f71989e = cVar;
                this.f71990f = aVar;
                this.f71991g = kVar;
            }

            @Override // h.n.a
            public void call() {
                if (this.f71989e.isUnsubscribed()) {
                    return;
                }
                k b2 = a.this.b(this.f71990f);
                this.f71989e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f71991g);
                }
            }
        }

        public a(Executor executor) {
            this.f71982e = executor;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f71983f);
            this.f71983f.a(scheduledAction);
            this.f71984g.offer(scheduledAction);
            if (this.f71985h.getAndIncrement() == 0) {
                try {
                    this.f71982e.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f71983f.b(scheduledAction);
                    this.f71985h.decrementAndGet();
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
            this.f71983f.a(cVar2);
            k a2 = h.u.e.a(new C1987a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, q, a2));
            cVar.a(scheduledAction);
            try {
                scheduledAction.add(this.f71986i.schedule(scheduledAction, j, timeUnit));
                return a2;
            } catch (RejectedExecutionException e2) {
                h.r.c.j(e2);
                throw e2;
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71983f.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f71983f.isUnsubscribed()) {
                ScheduledAction poll = this.f71984g.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f71983f.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f71984g.clear();
                        return;
                    }
                }
                if (this.f71985h.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f71984g.clear();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71983f.unsubscribe();
            this.f71984g.clear();
        }
    }

    public c(Executor executor) {
        this.f71981a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f71981a);
    }
}
