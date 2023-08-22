package rx.schedulers;

import com.baidu.tieba.a8c;
import com.baidu.tieba.ncc;
import com.baidu.tieba.q7c;
import com.baidu.tieba.rcc;
import com.baidu.tieba.u7c;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class TestScheduler extends q7c {
    public static long c;
    public final Queue<c> a = new PriorityQueue(11, new a());
    public long b;

    /* loaded from: classes2.dex */
    public final class b extends q7c.a {
        public final ncc a = new ncc();

        /* loaded from: classes2.dex */
        public class a implements a8c {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // com.baidu.tieba.a8c
            public void call() {
                TestScheduler.this.a.remove(this.a);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0803b implements a8c {
            public final /* synthetic */ c a;

            public C0803b(c cVar) {
                this.a = cVar;
            }

            @Override // com.baidu.tieba.a8c
            public void call() {
                TestScheduler.this.a.remove(this.a);
            }
        }

        public b() {
        }

        @Override // com.baidu.tieba.q7c.a
        public u7c b(a8c a8cVar) {
            c cVar = new c(this, 0L, a8cVar);
            TestScheduler.this.a.add(cVar);
            return rcc.a(new C0803b(cVar));
        }

        @Override // com.baidu.tieba.q7c.a
        public long a() {
            return TestScheduler.this.now();
        }

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.a.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            this.a.unsubscribe();
        }

        @Override // com.baidu.tieba.q7c.a
        public u7c c(a8c a8cVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.b + timeUnit.toNanos(j), a8cVar);
            TestScheduler.this.a.add(cVar);
            return rcc.a(new a(cVar));
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public final long a;
        public final a8c b;
        public final q7c.a c;
        public final long d;

        public c(q7c.a aVar, long j, a8c a8cVar) {
            long j2 = TestScheduler.c;
            TestScheduler.c = 1 + j2;
            this.d = j2;
            this.a = j;
            this.b = a8cVar;
            this.c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.a), this.b.toString());
        }
    }

    @Override // com.baidu.tieba.q7c
    public q7c.a createWorker() {
        return new b();
    }

    @Override // com.baidu.tieba.q7c
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.b);
    }

    public void triggerActions() {
        a(this.b);
    }

    /* loaded from: classes2.dex */
    public static final class a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j = cVar.a;
            long j2 = cVar2.a;
            if (j == j2) {
                if (cVar.d < cVar2.d) {
                    return -1;
                }
                if (cVar.d > cVar2.d) {
                    return 1;
                }
                return 0;
            } else if (j < j2) {
                return -1;
            } else {
                if (j > j2) {
                    return 1;
                }
                return 0;
            }
        }
    }

    public final void a(long j) {
        while (!this.a.isEmpty()) {
            c peek = this.a.peek();
            long j2 = peek.a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.b;
            }
            this.b = j2;
            this.a.remove();
            if (!peek.c.isUnsubscribed()) {
                peek.b.call();
            }
        }
        this.b = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j));
    }
}
