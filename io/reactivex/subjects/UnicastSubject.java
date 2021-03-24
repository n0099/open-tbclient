package io.reactivex.subjects;

import f.a.d0.a;
import f.a.l;
import f.a.o;
import f.a.t.b;
import f.a.x.c.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class UnicastSubject<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final f.a.x.f.a<T> f68114e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<o<? super T>> f68115f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Runnable> f68116g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f68117h;
    public volatile boolean i;
    public volatile boolean j;
    public Throwable k;
    public final AtomicBoolean l;
    public final BasicIntQueueDisposable<T> m;
    public boolean n;

    /* loaded from: classes7.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        public static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
        public void clear() {
            UnicastSubject.this.f68114e.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
        public void dispose() {
            if (UnicastSubject.this.i) {
                return;
            }
            UnicastSubject.this.i = true;
            UnicastSubject.this.e();
            UnicastSubject.this.f68115f.lazySet(null);
            if (UnicastSubject.this.m.getAndIncrement() == 0) {
                UnicastSubject.this.f68115f.lazySet(null);
                UnicastSubject.this.f68114e.clear();
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
        public boolean isDisposed() {
            return UnicastSubject.this.i;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
        public boolean isEmpty() {
            return UnicastSubject.this.f68114e.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
        public T poll() throws Exception {
            return UnicastSubject.this.f68114e.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.n = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastSubject(int i, boolean z) {
        f.a.x.b.a.c(i, "capacityHint");
        this.f68114e = new f.a.x.f.a<>(i);
        this.f68116g = new AtomicReference<>();
        this.f68117h = z;
        this.f68115f = new AtomicReference<>();
        this.l = new AtomicBoolean();
        this.m = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> c() {
        return new UnicastSubject<>(l.a(), true);
    }

    public static <T> UnicastSubject<T> d(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    @Override // f.a.l
    public void b(o<? super T> oVar) {
        if (!this.l.get() && this.l.compareAndSet(false, true)) {
            oVar.onSubscribe(this.m);
            this.f68115f.lazySet(oVar);
            if (this.i) {
                this.f68115f.lazySet(null);
                return;
            } else {
                f();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), oVar);
    }

    public void e() {
        Runnable runnable = this.f68116g.get();
        if (runnable == null || !this.f68116g.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void f() {
        if (this.m.getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = this.f68115f.get();
        int i = 1;
        while (oVar == null) {
            i = this.m.addAndGet(-i);
            if (i == 0) {
                return;
            }
            oVar = this.f68115f.get();
        }
        if (this.n) {
            g(oVar);
        } else {
            h(oVar);
        }
    }

    public void g(o<? super T> oVar) {
        f.a.x.f.a<T> aVar = this.f68114e;
        int i = 1;
        boolean z = !this.f68117h;
        while (!this.i) {
            boolean z2 = this.j;
            if (z && z2 && j(aVar, oVar)) {
                return;
            }
            oVar.onNext(null);
            if (z2) {
                i(oVar);
                return;
            }
            i = this.m.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.f68115f.lazySet(null);
        aVar.clear();
    }

    public void h(o<? super T> oVar) {
        f.a.x.f.a<T> aVar = this.f68114e;
        boolean z = !this.f68117h;
        boolean z2 = true;
        int i = 1;
        while (!this.i) {
            boolean z3 = this.j;
            Object obj = (T) this.f68114e.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (j(aVar, oVar)) {
                        return;
                    }
                    z2 = false;
                }
                if (z4) {
                    i(oVar);
                    return;
                }
            }
            if (z4) {
                i = this.m.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                oVar.onNext(obj);
            }
        }
        this.f68115f.lazySet(null);
        aVar.clear();
    }

    public void i(o<? super T> oVar) {
        this.f68115f.lazySet(null);
        Throwable th = this.k;
        if (th != null) {
            oVar.onError(th);
        } else {
            oVar.onComplete();
        }
    }

    public boolean j(f<T> fVar, o<? super T> oVar) {
        Throwable th = this.k;
        if (th != null) {
            this.f68115f.lazySet(null);
            fVar.clear();
            oVar.onError(th);
            return true;
        }
        return false;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.j || this.i) {
            return;
        }
        this.j = true;
        e();
        f();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        f.a.x.b.a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.j && !this.i) {
            this.k = th;
            this.j = true;
            e();
            f();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        f.a.x.b.a.b(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.j || this.i) {
            return;
        }
        this.f68114e.offer(t);
        f();
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (this.j || this.i) {
            bVar.dispose();
        }
    }

    public UnicastSubject(int i, Runnable runnable, boolean z) {
        f.a.x.b.a.c(i, "capacityHint");
        this.f68114e = new f.a.x.f.a<>(i);
        f.a.x.b.a.b(runnable, "onTerminate");
        this.f68116g = new AtomicReference<>(runnable);
        this.f68117h = z;
        this.f68115f = new AtomicReference<>();
        this.l = new AtomicBoolean();
        this.m = new UnicastQueueDisposable();
    }
}
