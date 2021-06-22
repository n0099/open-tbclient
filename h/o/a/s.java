package h.o.a;

import h.d;
import h.g;
/* loaded from: classes8.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f71887e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f71888f;

    /* loaded from: classes8.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f71890f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1976a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f71892e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1977a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f71894e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class C1978a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f71896e;

                    public C1978a(long j) {
                        this.f71896e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1977a.this.f71894e.request(this.f71896e);
                    }
                }

                public C1977a(h.f fVar) {
                    this.f71894e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1976a.this.f71892e == Thread.currentThread()) {
                        this.f71894e.request(j);
                    } else {
                        a.this.f71890f.b(new C1978a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1976a(h.j jVar, Thread thread) {
                super(jVar);
                this.f71892e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f71889e.onCompleted();
                } finally {
                    a.this.f71890f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f71889e.onError(th);
                } finally {
                    a.this.f71890f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f71889e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f71889e.setProducer(new C1977a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f71889e = jVar;
            this.f71890f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f71888f.I(new C1976a(this.f71889e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f71887e = gVar;
        this.f71888f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f71887e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
