package h.o.a;

import h.g;
import h.o.a.w;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class v<T> extends w<T> {

    /* loaded from: classes7.dex */
    public class a implements w.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68825b;

        /* renamed from: h.o.a.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1909a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w.c f68826e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68827f;

            public C1909a(a aVar, w.c cVar, Long l) {
                this.f68826e = cVar;
                this.f68827f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68826e.b(this.f68827f.longValue());
            }
        }

        public a(long j, TimeUnit timeUnit) {
            this.f68824a = j;
            this.f68825b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.h
        /* renamed from: b */
        public h.k a(w.c<T> cVar, Long l, g.a aVar) {
            return aVar.c(new C1909a(this, cVar, l), this.f68824a, this.f68825b);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements w.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f68828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f68829b;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w.c f68830e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Long f68831f;

            public a(b bVar, w.c cVar, Long l) {
                this.f68830e = cVar;
                this.f68831f = l;
            }

            @Override // h.n.a
            public void call() {
                this.f68830e.b(this.f68831f.longValue());
            }
        }

        public b(long j, TimeUnit timeUnit) {
            this.f68828a = j;
            this.f68829b = timeUnit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.i
        /* renamed from: b */
        public h.k a(w.c<T> cVar, Long l, T t, g.a aVar) {
            return aVar.c(new a(this, cVar, l), this.f68828a, this.f68829b);
        }
    }

    public v(long j, TimeUnit timeUnit, h.d<? extends T> dVar, h.g gVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), dVar, gVar);
    }
}
