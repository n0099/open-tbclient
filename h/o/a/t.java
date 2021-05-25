package h.o.a;

import h.g;
import h.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class t<T> extends u<T> {

    /* loaded from: classes7.dex */
    public class a implements u.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68538a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68539b;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1927a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f68540e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68541f;

            public C1927a(a aVar, u.c cVar, Long l) {
                this.f68540e = cVar;
                this.f68541f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68540e.b(this.f68541f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f68538a = j;
            this.f68539b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1927a(this, cVar, l), this.f68538a, this.f68539b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements u.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68542a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68543b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f68544e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68545f;

            public a(b bVar, u.c cVar, Long l) {
                this.f68544e = cVar;
                this.f68545f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68544e.b(this.f68545f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f68542a = j;
            this.f68543b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f68542a, this.f68543b);
        }
    }

    public t(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
