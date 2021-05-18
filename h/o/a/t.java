package h.o.a;

import h.g;
import h.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class t<T> extends u<T> {

    /* loaded from: classes7.dex */
    public class a implements u.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68495a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68496b;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1923a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f68497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68498f;

            public C1923a(a aVar, u.c cVar, Long l) {
                this.f68497e = cVar;
                this.f68498f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68497e.b(this.f68498f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f68495a = j;
            this.f68496b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1923a(this, cVar, l), this.f68495a, this.f68496b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements u.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68499a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68500b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f68501e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68502f;

            public a(b bVar, u.c cVar, Long l) {
                this.f68501e = cVar;
                this.f68502f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68501e.b(this.f68502f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f68499a = j;
            this.f68500b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f68499a, this.f68500b);
        }
    }

    public t(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
