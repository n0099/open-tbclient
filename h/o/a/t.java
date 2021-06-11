package h.o.a;

import h.g;
import h.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class t<T> extends u<T> {

    /* loaded from: classes8.dex */
    public class a implements u.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71795b;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1976a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f71796e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71797f;

            public C1976a(a aVar, u.c cVar, Long l) {
                this.f71796e = cVar;
                this.f71797f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f71796e.b(this.f71797f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f71794a = j;
            this.f71795b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1976a(this, cVar, l), this.f71794a, this.f71795b);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements u.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71798a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71799b;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f71800e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71801f;

            public a(b bVar, u.c cVar, Long l) {
                this.f71800e = cVar;
                this.f71801f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f71800e.b(this.f71801f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f71798a = j;
            this.f71799b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f71798a, this.f71799b);
        }
    }

    public t(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
