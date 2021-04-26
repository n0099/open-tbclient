package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f67927a = new j();

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f67928e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f67929f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f67930g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f67931h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1869a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f67932e;

            public C1869a(b bVar) {
                this.f67932e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f67929f.remove(this.f67932e);
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
            if (this.f67930g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f67928e.incrementAndGet());
            this.f67929f.add(bVar);
            if (this.f67931h.getAndIncrement() == 0) {
                do {
                    b poll = this.f67929f.poll();
                    if (poll != null) {
                        poll.f67934e.call();
                    }
                } while (this.f67931h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1869a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67930g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67930g.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f67934e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f67935f;

        /* renamed from: g  reason: collision with root package name */
        public final int f67936g;

        public b(h.n.a aVar, Long l, int i2) {
            this.f67934e = aVar;
            this.f67935f = l;
            this.f67936g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f67935f.compareTo(bVar.f67935f);
            return compareTo == 0 ? j.a(this.f67936g, bVar.f67936g) : compareTo;
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
