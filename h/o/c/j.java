package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f72010a = new j();

    /* loaded from: classes8.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f72011e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f72012f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f72013g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f72014h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1988a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f72015e;

            public C1988a(b bVar) {
                this.f72015e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f72012f.remove(this.f72015e);
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
            if (this.f72013g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f72011e.incrementAndGet());
            this.f72012f.add(bVar);
            if (this.f72014h.getAndIncrement() == 0) {
                do {
                    b poll = this.f72012f.poll();
                    if (poll != null) {
                        poll.f72017e.call();
                    }
                } while (this.f72014h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1988a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f72013g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f72013g.unsubscribe();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f72017e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f72018f;

        /* renamed from: g  reason: collision with root package name */
        public final int f72019g;

        public b(h.n.a aVar, Long l, int i2) {
            this.f72017e = aVar;
            this.f72018f = l;
            this.f72019g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f72018f.compareTo(bVar.f72018f);
            return compareTo == 0 ? j.a(this.f72019g, bVar.f72019g) : compareTo;
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    @Override // h.g
    public g.a createWorker() {
        return new a();
    }
}
