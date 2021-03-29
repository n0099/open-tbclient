package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f67796e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67797f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f67798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f67799f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1871a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f67801e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1872a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f67803e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1873a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f67805e;

                    public C1873a(long j) {
                        this.f67805e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1872a.this.f67803e.request(this.f67805e);
                    }
                }

                public C1872a(h.f fVar) {
                    this.f67803e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1871a.this.f67801e == Thread.currentThread()) {
                        this.f67803e.request(j);
                    } else {
                        a.this.f67799f.b(new C1873a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1871a(h.j jVar, Thread thread) {
                super(jVar);
                this.f67801e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f67798e.onCompleted();
                } finally {
                    a.this.f67799f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f67798e.onError(th);
                } finally {
                    a.this.f67799f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f67798e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f67798e.setProducer(new C1872a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f67798e = jVar;
            this.f67799f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f67797f.J(new C1871a(this.f67798e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f67796e = gVar;
        this.f67797f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f67796e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
