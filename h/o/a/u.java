package h.o.a;

import h.g;
import h.o.a.v;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class u<T> extends v<T> {

    /* loaded from: classes7.dex */
    public class a implements v.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67809b;

        /* renamed from: h.o.a.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1873a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ v.c f67810e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67811f;

            public C1873a(a aVar, v.c cVar, Long l) {
                this.f67810e = cVar;
                this.f67811f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67810e.b(this.f67811f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f67808a = j;
            this.f67809b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(v.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1873a(this, cVar, l), this.f67808a, this.f67809b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements v.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67813b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ v.c f67814e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67815f;

            public a(b bVar, v.c cVar, Long l) {
                this.f67814e = cVar;
                this.f67815f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67814e.b(this.f67815f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f67812a = j;
            this.f67813b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(v.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f67812a, this.f67813b);
        }
    }

    public u(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
