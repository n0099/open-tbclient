package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f68650a = new j();

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f68651e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f68652f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f68653g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f68654h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1936a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f68655e;

            public C1936a(b bVar) {
                this.f68655e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f68652f.remove(this.f68655e);
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
            if (this.f68653g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f68651e.incrementAndGet());
            this.f68652f.add(bVar);
            if (this.f68654h.getAndIncrement() == 0) {
                do {
                    b poll = this.f68652f.poll();
                    if (poll != null) {
                        poll.f68657e.call();
                    }
                } while (this.f68654h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1936a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68653g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68653g.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68657e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f68658f;

        /* renamed from: g  reason: collision with root package name */
        public final int f68659g;

        public b(h.n.a aVar, Long l, int i2) {
            this.f68657e = aVar;
            this.f68658f = l;
            this.f68659g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f68658f.compareTo(bVar.f68658f);
            return compareTo == 0 ? j.a(this.f68659g, bVar.f68659g) : compareTo;
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
