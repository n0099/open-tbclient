package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class t<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f68954e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68955f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f68957f;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1910a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f68959e;

            /* renamed from: h.o.a.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1911a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f68961e;

                /* renamed from: h.o.a.t$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1912a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f68963e;

                    public C1912a(long j) {
                        this.f68963e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1911a.this.f68961e.request(this.f68963e);
                    }
                }

                public C1911a(h.f fVar) {
                    this.f68961e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1910a.this.f68959e == Thread.currentThread()) {
                        this.f68961e.request(j);
                    } else {
                        a.this.f68957f.b(new C1912a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1910a(h.j jVar, Thread thread) {
                super(jVar);
                this.f68959e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f68956e.onCompleted();
                } finally {
                    a.this.f68957f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f68956e.onError(th);
                } finally {
                    a.this.f68957f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f68956e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f68956e.setProducer(new C1911a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f68956e = jVar;
            this.f68957f = aVar;
        }

        @Override // h.n.a
        public void call() {
            t.this.f68955f.L(new C1910a(this.f68956e, Thread.currentThread()));
        }
    }

    public t(h.d<T> dVar, h.g gVar) {
        this.f68954e = gVar;
        this.f68955f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f68954e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
