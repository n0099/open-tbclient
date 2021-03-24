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
    public static long f68271c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f68272a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f68273b;

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f68280a;
            long j2 = cVar2.f68280a;
            if (j == j2) {
                if (cVar.f68283d < cVar2.f68283d) {
                    return -1;
                }
                return cVar.f68283d > cVar2.f68283d ? 1 : 0;
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
        public final h.u.a f68274e = new h.u.a();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f68276e;

            public a(c cVar) {
                this.f68276e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f68272a.remove(this.f68276e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1896b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f68278e;

            public C1896b(c cVar) {
                this.f68278e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f68272a.remove(this.f68278e);
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
            TestScheduler.this.f68272a.add(cVar);
            return e.a(new C1896b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f68273b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f68272a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68274e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68274e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f68280a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f68281b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f68282c;

        /* renamed from: d  reason: collision with root package name */
        public final long f68283d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f68271c;
            TestScheduler.f68271c = 1 + j2;
            this.f68283d = j2;
            this.f68280a = j;
            this.f68281b = aVar2;
            this.f68282c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f68280a), this.f68281b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f68272a.isEmpty()) {
            c peek = this.f68272a.peek();
            long j2 = peek.f68280a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f68273b;
            }
            this.f68273b = j2;
            this.f68272a.remove();
            if (!peek.f68282c.isUnsubscribed()) {
                peek.f68281b.call();
            }
        }
        this.f68273b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f68273b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
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
        return TimeUnit.NANOSECONDS.toMillis(this.f68273b);
    }

    public void triggerActions() {
        a(this.f68273b);
    }
}
