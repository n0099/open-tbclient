package h.o.a;

import h.d;
import h.g;
/* loaded from: classes7.dex */
public final class t<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f68807e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68808f;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f68810f;

        /* renamed from: h.o.a.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1906a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Thread f68812e;

            /* renamed from: h.o.a.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1907a implements h.f {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h.f f68814e;

                /* renamed from: h.o.a.t$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class C1908a implements h.n.a {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f68816e;

                    public C1908a(long j) {
                        this.f68816e = j;
                    }

                    @Override // h.n.a
                    public void call() {
                        C1907a.this.f68814e.request(this.f68816e);
                    }
                }

                public C1907a(h.f fVar) {
                    this.f68814e = fVar;
                }

                @Override // h.f
                public void request(long j) {
                    if (C1906a.this.f68812e == Thread.currentThread()) {
                        this.f68814e.request(j);
                    } else {
                        a.this.f68810f.b(new C1908a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1906a(h.j jVar, Thread thread) {
                super(jVar);
                this.f68812e = thread;
            }

            @Override // h.e
            public void onCompleted() {
                try {
                    a.this.f68809e.onCompleted();
                } finally {
                    a.this.f68810f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                try {
                    a.this.f68809e.onError(th);
                } finally {
                    a.this.f68810f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                a.this.f68809e.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                a.this.f68809e.setProducer(new C1907a(fVar));
            }
        }

        public a(h.j jVar, g.a aVar) {
            this.f68809e = jVar;
            this.f68810f = aVar;
        }

        @Override // h.n.a
        public void call() {
            t.this.f68808f.L(new C1906a(this.f68809e, Thread.currentThread()));
        }
    }

    public t(h.d<T> dVar, h.g gVar) {
        this.f68807e = gVar;
        this.f68808f = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        g.a createWorker = this.f68807e.createWorker();
        jVar.add(createWorker);
        createWorker.b(new a(jVar, createWorker));
    }
}
