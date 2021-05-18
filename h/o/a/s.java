package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class s<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f68484e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68485f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f68487f;

        /* renamed from: h.o.a.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1920a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f68489e;

            /* renamed from: h.o.a.s$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1921a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f68491e;

                /* renamed from: h.o.a.s$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1922a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f68493e;

                    public C1922a(long j) {
                        this.f68493e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1921a.this.f68491e.request(this.f68493e);
                    }
                }

                public C1921a(h.f fVar) {
                    this.f68491e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1920a.this.f68489e == Thread.currentThread()) {
                        this.f68491e.request(j);
                    } else {
                        a.this.f68487f.b(new C1922a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1920a(h.j jVar, Thread thread) {
                super(jVar);
                this.f68489e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f68486e.onCompleted();
                } finally {
                    a.this.f68487f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f68486e.onError(th);
                } finally {
                    a.this.f68487f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f68486e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f68486e.setProducer(new C1921a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f68486e = jVar;
            this.f68487f = aVar;
        }

        @Override // h.n.a
        public void call() {
            s.this.f68485f.I(new C1920a(this.f68486e, Thread.currentThread()));
        }
    }

    public s(h.d<T> dVar, h.g gVar) {
        this.f68484e = gVar;
        this.f68485f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f68484e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
