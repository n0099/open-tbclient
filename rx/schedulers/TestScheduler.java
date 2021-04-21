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
    public static long f69429c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f69430a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f69431b;

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f69438a;
            long j2 = cVar2.f69438a;
            if (j == j2) {
                if (cVar.f69441d < cVar2.f69441d) {
                    return -1;
                }
                return cVar.f69441d > cVar2.f69441d ? 1 : 0;
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
        public final h.u.a f69432e = new h.u.a();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69434e;

            public a(c cVar) {
                this.f69434e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69430a.remove(this.f69434e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1936b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69436e;

            public C1936b(c cVar) {
                this.f69436e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69430a.remove(this.f69436e);
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
            TestScheduler.this.f69430a.add(cVar);
            return e.a(new C1936b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f69431b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f69430a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69432e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69432e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f69438a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f69439b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f69440c;

        /* renamed from: d  reason: collision with root package name */
        public final long f69441d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f69429c;
            TestScheduler.f69429c = 1 + j2;
            this.f69441d = j2;
            this.f69438a = j;
            this.f69439b = aVar2;
            this.f69440c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f69438a), this.f69439b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f69430a.isEmpty()) {
            c peek = this.f69430a.peek();
            long j2 = peek.f69438a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f69431b;
            }
            this.f69431b = j2;
            this.f69430a.remove();
            if (!peek.f69440c.isUnsubscribed()) {
                peek.f69439b.call();
            }
        }
        this.f69431b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f69431b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
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
        return TimeUnit.NANOSECONDS.toMillis(this.f69431b);
    }

    public void triggerActions() {
        a(this.f69431b);
    }
}
