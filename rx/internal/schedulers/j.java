package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes2.dex */
public final class j extends rx.g {
    public static final j kDn = new j();

    @Override // rx.g
    public g.a createWorker() {
        return new a();
    }

    private j() {
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a implements k {
        final AtomicInteger kDo = new AtomicInteger();
        final PriorityBlockingQueue<b> kDp = new PriorityBlockingQueue<>();
        private final rx.subscriptions.a kCO = new rx.subscriptions.a();
        private final AtomicInteger wip = new AtomicInteger();

        a() {
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, now());
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            long now = now() + timeUnit.toMillis(j);
            return a(new i(aVar, this, now), now);
        }

        private k a(rx.functions.a aVar, long j) {
            if (this.kCO.isUnsubscribed()) {
                return rx.subscriptions.e.cSa();
            }
            final b bVar = new b(aVar, Long.valueOf(j), this.kDo.incrementAndGet());
            this.kDp.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                do {
                    b poll = this.kDp.poll();
                    if (poll != null) {
                        poll.action.call();
                    }
                } while (this.wip.decrementAndGet() > 0);
                return rx.subscriptions.e.cSa();
            }
            return rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.j.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.kDp.remove(bVar);
                }
            });
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kCO.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCO.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b implements Comparable<b> {
        final rx.functions.a action;
        final int count;
        final Long kDs;

        b(rx.functions.a aVar, Long l, int i) {
            this.action = aVar;
            this.kDs = l;
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.kDs.compareTo(bVar.kDs);
            if (compareTo == 0) {
                return j.compare(this.count, bVar.count);
            }
            return compareTo;
        }
    }

    static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
