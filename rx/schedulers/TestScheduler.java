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
    public static long f69282c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f69283a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f69284b;

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f69291a;
            long j2 = cVar2.f69291a;
            if (j == j2) {
                if (cVar.f69294d < cVar2.f69294d) {
                    return -1;
                }
                return cVar.f69294d > cVar2.f69294d ? 1 : 0;
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
        public final h.u.a f69285e = new h.u.a();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69287e;

            public a(c cVar) {
                this.f69287e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69283a.remove(this.f69287e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1932b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f69289e;

            public C1932b(c cVar) {
                this.f69289e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f69283a.remove(this.f69289e);
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
            TestScheduler.this.f69283a.add(cVar);
            return e.a(new C1932b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f69284b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f69283a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69285e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69285e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f69291a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f69292b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f69293c;

        /* renamed from: d  reason: collision with root package name */
        public final long f69294d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f69282c;
            TestScheduler.f69282c = 1 + j2;
            this.f69294d = j2;
            this.f69291a = j;
            this.f69292b = aVar2;
            this.f69293c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f69291a), this.f69292b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f69283a.isEmpty()) {
            c peek = this.f69283a.peek();
            long j2 = peek.f69291a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f69284b;
            }
            this.f69284b = j2;
            this.f69283a.remove();
            if (!peek.f69293c.isUnsubscribed()) {
                peek.f69292b.call();
            }
        }
        this.f69284b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f69284b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
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
        return TimeUnit.NANOSECONDS.toMillis(this.f69284b);
    }

    public void triggerActions() {
        a(this.f69284b);
    }
}
