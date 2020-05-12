package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.k;
/* loaded from: classes6.dex */
public final class j extends rx.g {
    public static final j nnS = new j();

    @Override // rx.g
    public g.a createWorker() {
        return new a();
    }

    private j() {
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a implements k {
        final AtomicInteger mVA = new AtomicInteger();
        final PriorityBlockingQueue<b> mVz = new PriorityBlockingQueue<>();
        private final rx.subscriptions.a nnv = new rx.subscriptions.a();
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
            if (this.nnv.isUnsubscribed()) {
                return rx.subscriptions.e.dJa();
            }
            final b bVar = new b(aVar, Long.valueOf(j), this.mVA.incrementAndGet());
            this.mVz.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                do {
                    b poll = this.mVz.poll();
                    if (poll != null) {
                        poll.action.call();
                    }
                } while (this.wip.decrementAndGet() > 0);
                return rx.subscriptions.e.dJa();
            }
            return rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.schedulers.j.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.mVz.remove(bVar);
                }
            });
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nnv.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nnv.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements Comparable<b> {
        final rx.functions.a action;
        final int count;
        final Long nnV;

        b(rx.functions.a aVar, Long l, int i) {
            this.action = aVar;
            this.nnV = l;
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.nnV.compareTo(bVar.nnV);
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
