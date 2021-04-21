package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f69068a = new j();

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f69069e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f69070f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f69071g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f69072h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1922a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f69073e;

            public C1922a(b bVar) {
                this.f69073e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f69070f.remove(this.f69073e);
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
            if (this.f69071g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f69069e.incrementAndGet());
            this.f69070f.add(bVar);
            if (this.f69072h.getAndIncrement() == 0) {
                do {
                    b poll = this.f69070f.poll();
                    if (poll != null) {
                        poll.f69075e.call();
                    }
                } while (this.f69072h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1922a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69071g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69071g.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f69075e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f69076f;

        /* renamed from: g  reason: collision with root package name */
        public final int f69077g;

        public b(h.n.a aVar, Long l, int i) {
            this.f69075e = aVar;
            this.f69076f = l;
            this.f69077g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f69076f.compareTo(bVar.f69076f);
            return compareTo == 0 ? j.a(this.f69077g, bVar.f69077g) : compareTo;
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
