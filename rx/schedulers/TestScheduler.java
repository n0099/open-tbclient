package rx.schedulers;

import h.g;
import h.k;
import h.u.e;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class TestScheduler extends g {

    /* renamed from: c  reason: collision with root package name */
    public static long f68475c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f68476a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f68477b;

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f68484a;
            long j2 = cVar2.f68484a;
            if (j == j2) {
                if (cVar.f68487d < cVar2.f68487d) {
                    return -1;
                }
                return cVar.f68487d > cVar2.f68487d ? 1 : 0;
            } else if (j < j2) {
                return -1;
            } else {
                return j > j2 ? 1 : 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.a f68478e = new h.u.a();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f68480e;

            public a(c cVar) {
                this.f68480e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f68476a.remove(this.f68480e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1890b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f68482e;

            public C1890b(c cVar) {
                this.f68482e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f68476a.remove(this.f68482e);
            }
        }

        public b() {
        }

        @Override // h.g.a
        public long a() {
            return TestScheduler.this.now();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            c cVar = new c(this, 0L, aVar);
            TestScheduler.this.f68476a.add(cVar);
            return e.a(new C1890b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f68477b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f68476a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68478e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68478e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f68484a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f68485b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f68486c;

        /* renamed from: d  reason: collision with root package name */
        public final long f68487d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f68475c;
            TestScheduler.f68475c = 1 + j2;
            this.f68487d = j2;
            this.f68484a = j;
            this.f68485b = aVar2;
            this.f68486c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f68484a), this.f68485b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f68476a.isEmpty()) {
            c peek = this.f68476a.peek();
            long j2 = peek.f68484a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f68477b;
            }
            this.f68477b = j2;
            this.f68476a.remove();
            if (!peek.f68486c.isUnsubscribed()) {
                peek.f68485b.call();
            }
        }
        this.f68477b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f68477b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j));
    }

    @Override // h.g
    public g.a createWorker() {
        return new b();
    }

    @Override // h.g
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.f68477b);
    }

    public void triggerActions() {
        a(this.f68477b);
    }
}
