package h.o.a;

import h.g;
import h.o.a.v;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class u<T> extends v<T> {

    /* loaded from: classes7.dex */
    public class a implements v.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67813a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67814b;

        /* renamed from: h.o.a.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1874a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ v.c f67815e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67816f;

            public C1874a(a aVar, v.c cVar, Long l) {
                this.f67815e = cVar;
                this.f67816f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67815e.b(this.f67816f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f67813a = j;
            this.f67814b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(v.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1874a(this, cVar, l), this.f67813a, this.f67814b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements v.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67817a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67818b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ v.c f67819e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67820f;

            public a(b bVar, v.c cVar, Long l) {
                this.f67819e = cVar;
                this.f67820f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67819e.b(this.f67820f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f67817a = j;
            this.f67818b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(v.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f67817a, this.f67818b);
        }
    }

    public u(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
