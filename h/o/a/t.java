package h.o.a;

import h.g;
import h.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class t<T> extends u<T> {

    /* loaded from: classes8.dex */
    public class a implements u.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71898a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71899b;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1979a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f71900e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71901f;

            public C1979a(a aVar, u.c cVar, Long l) {
                this.f71900e = cVar;
                this.f71901f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f71900e.b(this.f71901f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f71898a = j;
            this.f71899b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1979a(this, cVar, l), this.f71898a, this.f71899b);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements u.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f71902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f71903b;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f71904e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f71905f;

            public a(b bVar, u.c cVar, Long l) {
                this.f71904e = cVar;
                this.f71905f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f71904e.b(this.f71905f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f71902a = j;
            this.f71903b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f71902a, this.f71903b);
        }
    }

    public t(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
