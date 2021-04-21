package h.o.a;

import h.g;
import h.o.a.w;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class v<T> extends w<T> {

    /* loaded from: classes7.dex */
    public class a implements w.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68971a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68972b;

        /* renamed from: h.o.a.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1913a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w.c f68973e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68974f;

            public C1913a(a aVar, w.c cVar, Long l) {
                this.f68973e = cVar;
                this.f68974f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68973e.b(this.f68974f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f68971a = j;
            this.f68972b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(w.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1913a(this, cVar, l), this.f68971a, this.f68972b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements w.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68976b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w.c f68977e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68978f;

            public a(b bVar, w.c cVar, Long l) {
                this.f68977e = cVar;
                this.f68978f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68977e.b(this.f68978f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f68975a = j;
            this.f68976b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(w.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f68975a, this.f68976b);
        }
    }

    public v(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
