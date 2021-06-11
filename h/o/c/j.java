package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f71906a = new j();

    /* loaded from: classes8.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f71907e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f71908f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f71909g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f71910h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1985a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f71911e;

            public C1985a(b bVar) {
                this.f71911e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f71908f.remove(this.f71911e);
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
            if (this.f71909g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f71907e.incrementAndGet());
            this.f71908f.add(bVar);
            if (this.f71910h.getAndIncrement() == 0) {
                do {
                    b poll = this.f71908f.poll();
                    if (poll != null) {
                        poll.f71913e.call();
                    }
                } while (this.f71910h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1985a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71909g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71909g.unsubscribe();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f71913e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f71914f;

        /* renamed from: g  reason: collision with root package name */
        public final int f71915g;

        public b(h.n.a aVar, Long l, int i2) {
            this.f71913e = aVar;
            this.f71914f = l;
            this.f71915g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f71914f.compareTo(bVar.f71914f);
            return compareTo == 0 ? j.a(this.f71915g, bVar.f71915g) : compareTo;
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
