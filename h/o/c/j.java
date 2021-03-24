package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f67906a = new j();

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f67907e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f67908f = new PriorityBlockingQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f67909g = new h.u.a();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f67910h = new AtomicInteger();

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1882a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f67911e;

            public C1882a(b bVar) {
                this.f67911e = bVar;
            }

            @Override // h.n.a
            public void call() {
                a.this.f67908f.remove(this.f67911e);
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
            if (this.f67909g.isUnsubscribed()) {
                return h.u.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j), this.f67907e.incrementAndGet());
            this.f67908f.add(bVar);
            if (this.f67910h.getAndIncrement() == 0) {
                do {
                    b poll = this.f67908f.poll();
                    if (poll != null) {
                        poll.f67913e.call();
                    }
                } while (this.f67910h.decrementAndGet() > 0);
                return h.u.e.c();
            }
            return h.u.e.a(new C1882a(bVar));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67909g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67909g.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f67913e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f67914f;

        /* renamed from: g  reason: collision with root package name */
        public final int f67915g;

        public b(h.n.a aVar, Long l, int i) {
            this.f67913e = aVar;
            this.f67914f = l;
            this.f67915g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f67914f.compareTo(bVar.f67914f);
            return compareTo == 0 ? j.a(this.f67915g, bVar.f67915g) : compareTo;
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
