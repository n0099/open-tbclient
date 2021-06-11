package rx.schedulers;

import h.g;
import h.k;
import h.u.e;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class TestScheduler extends g {

    /* renamed from: c  reason: collision with root package name */
    public static long f72507c;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f72508a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    public long f72509b;

    /* loaded from: classes8.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.f72516a;
            long j2 = cVar2.f72516a;
            if (j == j2) {
                if (cVar.f72519d < cVar2.f72519d) {
                    return -1;
                }
                return cVar.f72519d > cVar2.f72519d ? 1 : 0;
            } else if (j < j2) {
                return -1;
            } else {
                return j > j2 ? 1 : 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class b extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.a f72510e = new h.u.a();

        /* loaded from: classes8.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f72512e;

            public a(c cVar) {
                this.f72512e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f72508a.remove(this.f72512e);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C2007b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f72514e;

            public C2007b(c cVar) {
                this.f72514e = cVar;
            }

            @Override // h.n.a
            public void call() {
                TestScheduler.this.f72508a.remove(this.f72514e);
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
            TestScheduler.this.f72508a.add(cVar);
            return e.a(new C2007b(cVar));
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f72509b + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f72508a.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f72510e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f72510e.unsubscribe();
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f72516a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f72517b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f72518c;

        /* renamed from: d  reason: collision with root package name */
        public final long f72519d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            long j2 = TestScheduler.f72507c;
            TestScheduler.f72507c = 1 + j2;
            this.f72519d = j2;
            this.f72516a = j;
            this.f72517b = aVar2;
            this.f72518c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f72516a), this.f72517b.toString());
        }
    }

    public final void a(long j) {
        while (!this.f72508a.isEmpty()) {
            c peek = this.f72508a.peek();
            long j2 = peek.f72516a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.f72509b;
            }
            this.f72509b = j2;
            this.f72508a.remove();
            if (!peek.f72518c.isUnsubscribed()) {
                peek.f72517b.call();
            }
        }
        this.f72509b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f72509b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
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
        return TimeUnit.NANOSECONDS.toMillis(this.f72509b);
    }

    public void triggerActions() {
        a(this.f72509b);
    }
}
