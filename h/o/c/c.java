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
    public final Executor f67898a;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Executor f67899e;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f67901g = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f67902h = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f67900f = new h.u.b();

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f67903i = d.a();

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1868a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f67904e;

            public C1868a(h.u.c cVar) {
                this.f67904e = cVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f67900f.b(this.f67904e);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f67906e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67907f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f67908g;

            public b(h.u.c cVar, h.n.a aVar, k kVar) {
                this.f67906e = cVar;
                this.f67907f = aVar;
                this.f67908g = kVar;
            }

            @Override // h.n.a
            public void call() {
                if (this.f67906e.isUnsubscribed()) {
                    return;
                }
                k b2 = a.this.b(this.f67907f);
                this.f67906e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f67908g);
                }
            }
        }

        public a(Executor executor) {
            this.f67899e = executor;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f67900f);
            this.f67900f.a(scheduledAction);
            this.f67901g.offer(scheduledAction);
            if (this.f67902h.getAndIncrement() == 0) {
                try {
                    this.f67899e.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f67900f.b(scheduledAction);
                    this.f67902h.decrementAndGet();
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
            this.f67900f.a(cVar2);
            k a2 = h.u.e.a(new C1868a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, q, a2));
            cVar.a(scheduledAction);
            try {
                scheduledAction.add(this.f67903i.schedule(scheduledAction, j, timeUnit));
                return a2;
            } catch (RejectedExecutionException e2) {
                h.r.c.j(e2);
                throw e2;
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67900f.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f67900f.isUnsubscribed()) {
                ScheduledAction poll = this.f67901g.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f67900f.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f67901g.clear();
                        return;
                    }
                }
                if (this.f67902h.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f67901g.clear();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67900f.unsubscribe();
            this.f67901g.clear();
        }
    }

    public c(Executor executor) {
        this.f67898a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67898a);
    }
}
