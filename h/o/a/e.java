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
    public final h.d<? extends T> f67711e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends h.d<? extends R>> f67712f;

    /* renamed from: g  reason: collision with root package name */
    public final int f67713g;

    /* renamed from: h  reason: collision with root package name */
    public final int f67714h;

    /* loaded from: classes7.dex */
    public class a implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67715e;

        public a(e eVar, d dVar) {
            this.f67715e = dVar;
        }

        @Override // h.f
        public void request(long j) {
            this.f67715e.h(j);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T, R> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final R f67716e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T, R> f67717f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67718g;

        public b(R r, d<T, R> dVar) {
            this.f67716e = r;
            this.f67717f = dVar;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f67718g || j <= 0) {
                return;
            }
            this.f67718g = true;
            d<T, R> dVar = this.f67717f;
            dVar.f(this.f67716e);
            dVar.d(1L);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T, R> extends h.j<R> {

        /* renamed from: e  reason: collision with root package name */
        public final d<T, R> f67719e;

        /* renamed from: f  reason: collision with root package name */
        public long f67720f;

        public c(d<T, R> dVar) {
            this.f67719e = dVar;
        }

        @Override // h.e
        public void onCompleted() {
            this.f67719e.d(this.f67720f);
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f67719e.e(th, this.f67720f);
        }

        @Override // h.e
        public void onNext(R r) {
            this.f67720f++;
            this.f67719e.f(r);
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67719e.f67724h.c(fVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67721e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends h.d<? extends R>> f67722f;

        /* renamed from: g  reason: collision with root package name */
        public final int f67723g;
        public final Queue<Object> i;
        public final h.u.d l;
        public volatile boolean m;
        public volatile boolean n;

        /* renamed from: h  reason: collision with root package name */
        public final h.o.b.a f67724h = new h.o.b.a();
        public final AtomicInteger j = new AtomicInteger();
        public final AtomicReference<Throwable> k = new AtomicReference<>();

        public d(h.j<? super R> jVar, h.n.f<? super T, ? extends h.d<? extends R>> fVar, int i, int i2) {
            Queue<Object> cVar;
            this.f67721e = jVar;
            this.f67722f = fVar;
            this.f67723g = i2;
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
            int i = this.f67723g;
            while (!this.f67721e.isUnsubscribed()) {
                if (!this.n) {
                    if (i == 1 && this.k.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.k);
                        if (ExceptionsUtils.isTerminated(terminate)) {
                            return;
                        }
                        this.f67721e.onError(terminate);
                        return;
                    }
                    boolean z = this.m;
                    Object poll = this.i.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.k);
                        if (terminate2 == null) {
                            this.f67721e.onCompleted();
                            return;
                        } else if (ExceptionsUtils.isTerminated(terminate2)) {
                            return;
                        } else {
                            this.f67721e.onError(terminate2);
                            return;
                        }
                    } else if (!z2) {
                        try {
                            h.d<? extends R> call = this.f67722f.call((Object) NotificationLite.d(poll));
                            if (call == null) {
                                c(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            } else if (call != h.d.f()) {
                                if (call instanceof ScalarSynchronousObservable) {
                                    this.n = true;
                                    this.f67724h.c(new b(((ScalarSynchronousObservable) call).M(), this));
                                } else {
                                    c cVar = new c(this);
                                    this.l.a(cVar);
                                    if (cVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.n = true;
                                    call.J(cVar);
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
                this.f67721e.onError(terminate);
                return;
            }
            g(th);
        }

        public void d(long j) {
            if (j != 0) {
                this.f67724h.b(j);
            }
            this.n = false;
            b();
        }

        public void e(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.k, th)) {
                g(th);
            } else if (this.f67723g == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.k);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f67721e.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j != 0) {
                    this.f67724h.b(j);
                }
                this.n = false;
                b();
            }
        }

        public void f(R r) {
            this.f67721e.onNext(r);
        }

        public void g(Throwable th) {
            h.r.c.j(th);
        }

        public void h(long j) {
            if (j > 0) {
                this.f67724h.request(j);
            } else if (j >= 0) {
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
                if (this.f67723g == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.k);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.f67721e.onError(terminate);
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
            if (!this.i.offer(NotificationLite.g(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            b();
        }
    }

    public e(h.d<? extends T> dVar, h.n.f<? super T, ? extends h.d<? extends R>> fVar, int i, int i2) {
        this.f67711e = dVar;
        this.f67712f = fVar;
        this.f67713g = i;
        this.f67714h = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        d dVar = new d(this.f67714h == 0 ? new h.q.e<>(jVar) : jVar, this.f67712f, this.f67713g, this.f67714h);
        jVar.add(dVar);
        jVar.add(dVar.l);
        jVar.setProducer(new a(this, dVar));
        if (jVar.isUnsubscribed()) {
            return;
        }
        this.f67711e.J(dVar);
    }
}
