package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f67791e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67792f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f67793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f67794f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1870a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f67796e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1871a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f67798e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1872a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f67800e;

                    public C1872a(long j) {
                        this.f67800e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1871a.this.f67798e.request(this.f67800e);
                    }
                }

                public C1871a(h.f fVar) {
                    this.f67798e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1870a.this.f67796e == Thread.currentThread()) {
                        this.f67798e.request(j);
                    } else {
                        a.this.f67794f.b(new C1872a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1870a(h.j jVar, Thread thread) {
                super(jVar);
                this.f67796e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f67793e.onCompleted();
                } finally {
                    a.this.f67794f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f67793e.onError(th);
                } finally {
                    a.this.f67794f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f67793e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f67793e.setProducer(new C1871a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f67793e = jVar;
            this.f67794f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f67792f.J(new C1870a(this.f67793e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f67791e = gVar;
        this.f67792f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f67791e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
