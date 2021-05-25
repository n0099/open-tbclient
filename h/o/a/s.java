package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f68527e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68528f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f68530f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1924a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f68532e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1925a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f68534e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1926a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f68536e;

                    public C1926a(long j) {
                        this.f68536e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1925a.this.f68534e.request(this.f68536e);
                    }
                }

                public C1925a(h.f fVar) {
                    this.f68534e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1924a.this.f68532e == Thread.currentThread()) {
                        this.f68534e.request(j);
                    } else {
                        a.this.f68530f.b(new C1926a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1924a(h.j jVar, Thread thread) {
                super(jVar);
                this.f68532e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f68529e.onCompleted();
                } finally {
                    a.this.f68530f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f68529e.onError(th);
                } finally {
                    a.this.f68530f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f68529e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f68529e.setProducer(new C1925a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f68529e = jVar;
            this.f68530f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f68528f.I(new C1924a(this.f68529e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f68527e = gVar;
        this.f68528f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f68527e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
