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
    public static long f69155c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f69156a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f69157b;

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f69164a;
            long j2 = cVar2.f69164a;
            if (j == j2) {
                if (cVar.f69167d < cVar2.f69167d) {
                    return -1;
                }
                return cVar.f69167d > cVar2.f69167d ? 1 : 0;
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
        public final h.u.a f69158e = new h.u.a();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69160e;

            public a(c cVar) {
                this.f69160e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69156a.remove(this.f69160e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1953b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69162e;

            public C1953b(c cVar) {
                this.f69162e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69156a.remove(this.f69162e);
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
            TestScheduler.this.f69156a.add(cVar);
            return e.a(new C1953b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f69157b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f69156a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69158e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69158e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f69164a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f69165b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f69166c;

        /* renamed from: d  reason: collision with root package name */
        public final long f69167d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f69155c;
            TestScheduler.f69155c = 1 + j2;
            this.f69167d = j2;
            this.f69164a = j;
            this.f69165b = aVar2;
            this.f69166c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f69164a), this.f69165b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f69156a.isEmpty()) {
            c peek = this.f69156a.peek();
            long j2 = peek.f69164a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f69157b;
            }
            this.f69157b = j2;
            this.f69156a.remove();
            if (!peek.f69166c.isUnsubscribed()) {
                peek.f69165b.call();
            }
        }
        this.f69157b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f69157b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
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
        return TimeUnit.NANOSECONDS.toMillis(this.f69157b);
    }

    public void triggerActions() {
        a(this.f69157b);
    }
}
