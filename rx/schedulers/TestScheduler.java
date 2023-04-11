package rx.schedulers;

import com.baidu.tieba.c6b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.y5b;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class TestScheduler extends i1b {
    public static long c;
    public final Queue<c> a = new PriorityQueue(11, new a());
    public long b;

    /* loaded from: classes9.dex */
    public final class b extends i1b.a {
        public final y5b a = new y5b();

        /* loaded from: classes9.dex */
        public class a implements s1b {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // com.baidu.tieba.s1b
            public void call() {
                TestScheduler.this.a.remove(this.a);
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0749b implements s1b {
            public final /* synthetic */ c a;

            public C0749b(c cVar) {
                this.a = cVar;
            }

            @Override // com.baidu.tieba.s1b
            public void call() {
                TestScheduler.this.a.remove(this.a);
            }
        }

        public b() {
        }

        @Override // com.baidu.tieba.i1b.a
        public m1b b(s1b s1bVar) {
            c cVar = new c(this, 0L, s1bVar);
            TestScheduler.this.a.add(cVar);
            return c6b.a(new C0749b(cVar));
        }

        @Override // com.baidu.tieba.i1b.a
        public long a() {
            return TestScheduler.this.now();
        }

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.a.isUnsubscribed();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            this.a.unsubscribe();
        }

        @Override // com.baidu.tieba.i1b.a
        public m1b c(s1b s1bVar, long j, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.b + timeUnit.toNanos(j), s1bVar);
            TestScheduler.this.a.add(cVar);
            return c6b.a(new a(cVar));
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public final long a;
        public final s1b b;
        public final i1b.a c;
        public final long d;

        public c(i1b.a aVar, long j, s1b s1bVar) {
            long j2 = TestScheduler.c;
            TestScheduler.c = 1 + j2;
            this.d = j2;
            this.a = j;
            this.b = s1bVar;
            this.c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.a), this.b.toString());
        }
    }

    @Override // com.baidu.tieba.i1b
    public i1b.a createWorker() {
        return new b();
    }

    @Override // com.baidu.tieba.i1b
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.b);
    }

    public void triggerActions() {
        a(this.b);
    }

    /* loaded from: classes9.dex */
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
