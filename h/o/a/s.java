package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f67804e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67805f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f67806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f67807f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1857a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f67809e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1858a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f67811e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1859a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f67813e;

                    public C1859a(long j) {
                        this.f67813e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1858a.this.f67811e.request(this.f67813e);
                    }
                }

                public C1858a(h.f fVar) {
                    this.f67811e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1857a.this.f67809e == Thread.currentThread()) {
                        this.f67811e.request(j);
                    } else {
                        a.this.f67807f.b(new C1859a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1857a(h.j jVar, Thread thread) {
                super(jVar);
                this.f67809e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f67806e.onCompleted();
                } finally {
                    a.this.f67807f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f67806e.onError(th);
                } finally {
                    a.this.f67807f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f67806e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f67806e.setProducer(new C1858a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f67806e = jVar;
            this.f67807f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f67805f.I(new C1857a(this.f67806e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f67804e = gVar;
        this.f67805f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f67804e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
