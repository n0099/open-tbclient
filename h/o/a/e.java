package h.o.a;

import h.d;
import h.o.d.k.f0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
/* loaded from: classes7.dex */
public final class e<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<? extends T> f68870e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends h.d<? extends R>> f68871f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68872g;

    /* renamed from: h  reason: collision with root package name */
    public final int f68873h;

    /* loaded from: classes7.dex */
    public class a implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68874e;

        public a(e eVar, d dVar) {
            this.f68874e = dVar;
        }

        @Override // h.f
        public void request(long j) {
            this.f68874e.h(j);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T, R> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final R f68875e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T, R> f68876f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68877g;

        public b(R r, d<T, R> dVar) {
            this.f68875e = r;
            this.f68876f = dVar;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f68877g || j <= 0) {
                return;
            }
            this.f68877g = true;
            d<T, R> dVar = this.f68876f;
            dVar.f(this.f68875e);
            dVar.d(1L);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T, R> extends h.j<R> {

        /* renamed from: e  reason: collision with root package name */
        public final d<T, R> f68878e;

        /* renamed from: f  reason: collision with root package name */
        public long f68879f;

        public c(d<T, R> dVar) {
            this.f68878e = dVar;
        }

        @Override // h.e
        public void onCompleted() {
            this.f68878e.d(this.f68879f);
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f68878e.e(th, this.f68879f);
        }

        @Override // h.e
        public void onNext(R r) {
            this.f68879f++;
            this.f68878e.f(r);
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f68878e.f68883h.c(fVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f68880e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends h.d<? extends R>> f68881f;

        /* renamed from: g  reason: collision with root package name */
        public final int f68882g;
        public final Queue<Object> i;
        public final h.u.d l;
        public volatile boolean m;
        public volatile boolean n;

        /* renamed from: h  reason: collision with root package name */
        public final h.o.b.a f68883h = new h.o.b.a();
        public final AtomicInteger j = new AtomicInteger();
        public final AtomicReference<Throwable> k = new AtomicReference<>();

        public d(h.j<? super R> jVar, h.n.f<? super T, ? extends h.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.f68880e = jVar;
            this.f68881f = fVar;
            this.f68882g = i2;
            if (f0.b()) {
                cVar = new h.o.d.k.r<>(i);
            } else {
                cVar = new h.o.d.j.c<>(i);
            }
            this.i = cVar;
            this.l = new h.u.d();
            request(i);
        }

        public void b() {
            if (this.j.getAndIncrement() != 0) {
                return;
            }
            int i = this.f68882g;
            while (!this.f68880e.isUnsubscribed()) {
                if (!this.n) {
                    if (i == 1 && this.k.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.k);
                        if (ExceptionsUtils.isTerminated(terminate)) {
                            return;
                        }
                        this.f68880e.onError(terminate);
                        return;
                    }
                    boolean z = this.m;
                    Object poll = this.i.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.k);
                        if (terminate2 == null) {
                            this.f68880e.onCompleted();
                            return;
                        } else if (ExceptionsUtils.isTerminated(terminate2)) {
                            return;
                        } else {
                            this.f68880e.onError(terminate2);
                            return;
                        }
                    } else if (!z2) {
                        try {
                            h.d<? extends R> call = this.f68881f.call((Object) NotificationLite.e(poll));
                            if (call == null) {
                                c(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            } else if (call != h.d.f()) {
                                if (call instanceof ScalarSynchronousObservable) {
                                    this.n = true;
                                    this.f68883h.c(new b(((ScalarSynchronousObservable) call).O(), this));
                                } else {
                                    c cVar = new c(this);
                                    this.l.a(cVar);
                                    if (cVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.n = true;
                                    call.L(cVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            h.m.a.e(th);
                            c(th);
                            return;
                        }
                    }
                }
                if (this.j.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void c(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.k, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.k);
                if (ExceptionsUtils.isTerminated(terminate)) {
                    return;
                }
                this.f68880e.onError(terminate);
                return;
            }
            g(th);
        }

        public void d(long j) {
            if (j != 0) {
                this.f68883h.b(j);
            }
            this.n = false;
            b();
        }

        public void e(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.k, th)) {
                g(th);
            } else if (this.f68882g == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.k);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f68880e.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.f68883h.b(j);
                }
                this.n = false;
                b();
            }
        }

        public void f(R r) {
            this.f68880e.onNext(r);
        }

        public void g(Throwable th) {
            h.r.c.j(th);
        }

        public void h(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i > 0) {
                this.f68883h.request(j);
            } else if (i >= 0) {
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }

        @Override // h.e
        public void onCompleted() {
            this.m = true;
            b();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.k, th)) {
                this.m = true;
                if (this.f68882g == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.k);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.f68880e.onError(terminate);
                    }
                    this.l.unsubscribe();
                    return;
                }
                b();
                return;
            }
            g(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (!this.i.offer(NotificationLite.h(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            b();
        }
    }

    public e(h.d<? extends T> dVar, h.n.f<? super T, ? extends h.d<? extends R>> fVar, int i, int i2) {
        this.f68870e = dVar;
        this.f68871f = fVar;
        this.f68872g = i;
        this.f68873h = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        d dVar = new d(this.f68873h == 0 ? new h.q.e<>(jVar) : jVar, this.f68871f, this.f68872g, this.f68873h);
        jVar.add(dVar);
        jVar.add(dVar.l);
        jVar.setProducer(new a(this, dVar));
        if (jVar.isUnsubscribed()) {
            return;
        }
        this.f68870e.L(dVar);
    }
}
