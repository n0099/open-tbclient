package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f68921a = new j();

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f68922e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f68923f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f68924g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f68925h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1918a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f68926e;

            public C1918a(b bVar) {
                this.f68926e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f68923f.remove(this.f68926e);
            }
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return d(aVar, a());
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            long a2 = a() + timeUnit.toMillis(j);
            return d(new i(aVar, this, a2), a2);
        }

        public final k d(h.n.a aVar, long j) {
            if (this.f68924g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f68922e.incrementAndGet());
            this.f68923f.add(bVar);
            if (this.f68925h.getAndIncrement() == 0) {
                do {
                    b poll = this.f68923f.poll();
                    if (poll != null) {
                        poll.f68928e.call();
                    }
                } while (this.f68925h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1918a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68924g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68924g.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68928e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f68929f;

        /* renamed from: g  reason: collision with root package name */
        public final int f68930g;

        public b(h.n.a aVar, Long l, int i) {
            this.f68928e = aVar;
            this.f68929f = l;
            this.f68930g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f68929f.compareTo(bVar.f68929f);
            return compareTo == 0 ? j.a(this.f68930g, bVar.f68930g) : compareTo;
        }
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a();
    }
}
