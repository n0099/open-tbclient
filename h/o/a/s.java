package h.o.a;

import h.d;
import h.g;
/* loaded from: classes8.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f71783e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f71784f;

    /* loaded from: classes8.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f71786f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1973a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f71788e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1974a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f71790e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class C1975a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f71792e;

                    public C1975a(long j) {
                        this.f71792e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1974a.this.f71790e.request(this.f71792e);
                    }
                }

                public C1974a(h.f fVar) {
                    this.f71790e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1973a.this.f71788e == Thread.currentThread()) {
                        this.f71790e.request(j);
                    } else {
                        a.this.f71786f.b(new C1975a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1973a(h.j jVar, Thread thread) {
                super(jVar);
                this.f71788e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f71785e.onCompleted();
                } finally {
                    a.this.f71786f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f71785e.onError(th);
                } finally {
                    a.this.f71786f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f71785e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f71785e.setProducer(new C1974a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f71785e = jVar;
            this.f71786f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f71784f.I(new C1973a(this.f71785e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f71783e = gVar;
        this.f71784f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f71783e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
