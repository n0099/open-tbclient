package h.o.a;

import h.g;
import h.o.a.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class t<T> extends u<T> {

    /* loaded from: classes7.dex */
    public class a implements u.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67815a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67816b;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1860a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f67817e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67818f;

            public C1860a(a aVar, u.c cVar, Long l) {
                this.f67817e = cVar;
                this.f67818f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67817e.b(this.f67818f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f67815a = j;
            this.f67816b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1860a(this, cVar, l), this.f67815a, this.f67816b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements u.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f67820b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u.c f67821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f67822f;

            public a(b bVar, u.c cVar, Long l) {
                this.f67821e = cVar;
                this.f67822f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f67821e.b(this.f67822f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f67819a = j;
            this.f67820b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(u.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f67819a, this.f67820b);
        }
    }

    public t(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
