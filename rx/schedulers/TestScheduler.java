package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.g;
import rx.k;
import rx.subscriptions.e;
/* loaded from: classes2.dex */
public class TestScheduler extends g {
    static long kuh;
    final Queue<c> queue = new PriorityQueue(11, new a());
    long time;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c {
        final rx.functions.a action;
        private final long count;
        final g.a kum;
        final long time;

        c(g.a aVar, long j, rx.functions.a aVar2) {
            long j2 = TestScheduler.kuh;
            TestScheduler.kuh = 1 + j2;
            this.count = j2;
            this.time = j;
            this.action = aVar2;
            this.kum = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.action.toString());
        }
    }

    /* loaded from: classes2.dex */
    static final class a implements Comparator<c> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if (cVar.time == cVar2.time) {
                if (cVar.count < cVar2.count) {
                    return -1;
                }
                return cVar.count > cVar2.count ? 1 : 0;
            } else if (cVar.time >= cVar2.time) {
                return cVar.time > cVar2.time ? 1 : 0;
            } else {
                return -1;
            }
        }
    }

    @Override // rx.g
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        eV(timeUnit.toNanos(j));
    }

    public void triggerActions() {
        eV(this.time);
    }

    private void eV(long j) {
        while (!this.queue.isEmpty()) {
            c peek = this.queue.peek();
            if (peek.time > j) {
                break;
            }
            this.time = peek.time == 0 ? this.time : peek.time;
            this.queue.remove();
            if (!peek.kum.isUnsubscribed()) {
                peek.action.call();
            }
        }
        this.time = j;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b();
    }

    /* loaded from: classes2.dex */
    final class b extends g.a {
        private final rx.subscriptions.a kui = new rx.subscriptions.a();

        b() {
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kui.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kui.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            final c cVar = new c(this, TestScheduler.this.time + timeUnit.toNanos(j), aVar);
            TestScheduler.this.queue.add(cVar);
            return e.l(new rx.functions.a() { // from class: rx.schedulers.TestScheduler.b.1
                @Override // rx.functions.a
                public void call() {
                    TestScheduler.this.queue.remove(cVar);
                }
            });
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            final c cVar = new c(this, 0L, aVar);
            TestScheduler.this.queue.add(cVar);
            return e.l(new rx.functions.a() { // from class: rx.schedulers.TestScheduler.b.2
                @Override // rx.functions.a
                public void call() {
                    TestScheduler.this.queue.remove(cVar);
                }
            });
        }

        @Override // rx.g.a
        public long now() {
            return TestScheduler.this.now();
        }
    }
}
