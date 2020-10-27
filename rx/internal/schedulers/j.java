package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes16.dex */
public final class j extends rx.g {
    public static final j pZe = new j();

    @Override // rx.g
    public g.a createWorker() {
        return new a();
    }

    private j() {
    }

    /* loaded from: classes16.dex */
    static final class a extends g.a implements k {
        final AtomicInteger pGX = new AtomicInteger();
        final PriorityBlockingQueue<b> pGW = new PriorityBlockingQueue<>();
        private final rx.subscriptions.a pYH = new rx.subscriptions.a();
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
            if (this.pYH.isUnsubscribed()) {
                return rx.subscriptions.e.eDj();
            }
            final b bVar = new b(aVar, Long.valueOf(j), this.pGX.incrementAndGet());
            this.pGW.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                do {
                    b poll = this.pGW.poll();
                    if (poll != null) {
                        poll.action.call();
                    }
                } while (this.wip.decrementAndGet() > 0);
                return rx.subscriptions.e.eDj();
            }
            return rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.j.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.pGW.remove(bVar);
                }
            });
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pYH.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pYH.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class b implements Comparable<b> {
        final rx.functions.a action;
        final int count;
        final Long pZh;

        b(rx.functions.a aVar, Long l, int i) {
            this.action = aVar;
            this.pZh = l;
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.pZh.compareTo(bVar.pZh);
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
