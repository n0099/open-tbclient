package io.reactivex.subjects;

import f.b.d0.a;
import f.b.l;
import f.b.o;
import f.b.t.b;
import f.b.x.c.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class UnicastSubject<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final f.b.x.f.a<T> f69272e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<o<? super T>> f69273f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Runnable> f69274g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f69275h;
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

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
        public void clear() {
            UnicastSubject.this.f69272e.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
        public void dispose() {
            if (UnicastSubject.this.i) {
                return;
            }
            UnicastSubject.this.i = true;
            UnicastSubject.this.e();
            UnicastSubject.this.f69273f.lazySet(null);
            if (UnicastSubject.this.m.getAndIncrement() == 0) {
                UnicastSubject.this.f69273f.lazySet(null);
                UnicastSubject.this.f69272e.clear();
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
        public boolean isDisposed() {
            return UnicastSubject.this.i;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
        public boolean isEmpty() {
            return UnicastSubject.this.f69272e.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
        public T poll() throws Exception {
            return UnicastSubject.this.f69272e.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.n = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastSubject(int i, boolean z) {
        f.b.x.b.a.c(i, "capacityHint");
        this.f69272e = new f.b.x.f.a<>(i);
        this.f69274g = new AtomicReference<>();
        this.f69275h = z;
        this.f69273f = new AtomicReference<>();
        this.l = new AtomicBoolean();
        this.m = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> c() {
        return new UnicastSubject<>(l.a(), true);
    }

    public static <T> UnicastSubject<T> d(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    @Override // f.b.l
    public void b(o<? super T> oVar) {
        if (!this.l.get() && this.l.compareAndSet(false, true)) {
            oVar.onSubscribe(this.m);
            this.f69273f.lazySet(oVar);
            if (this.i) {
                this.f69273f.lazySet(null);
                return;
            } else {
                f();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), oVar);
    }

    public void e() {
        Runnable runnable = this.f69274g.get();
        if (runnable == null || !this.f69274g.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void f() {
        if (this.m.getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = this.f69273f.get();
        int i = 1;
        while (oVar == null) {
            i = this.m.addAndGet(-i);
            if (i == 0) {
                return;
            }
            oVar = this.f69273f.get();
        }
        if (this.n) {
            g(oVar);
        } else {
            h(oVar);
        }
    }

    public void g(o<? super T> oVar) {
        f.b.x.f.a<T> aVar = this.f69272e;
        int i = 1;
        boolean z = !this.f69275h;
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
        this.f69273f.lazySet(null);
        aVar.clear();
    }

    public void h(o<? super T> oVar) {
        f.b.x.f.a<T> aVar = this.f69272e;
        boolean z = !this.f69275h;
        boolean z2 = true;
        int i = 1;
        while (!this.i) {
            boolean z3 = this.j;
            Object obj = (T) this.f69272e.poll();
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
        this.f69273f.lazySet(null);
        aVar.clear();
    }

    public void i(o<? super T> oVar) {
        this.f69273f.lazySet(null);
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
            this.f69273f.lazySet(null);
            fVar.clear();
            oVar.onError(th);
            return true;
        }
        return false;
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.j || this.i) {
            return;
        }
        this.j = true;
        e();
        f();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        f.b.x.b.a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.j && !this.i) {
            this.k = th;
            this.j = true;
            e();
            f();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        f.b.x.b.a.b(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.j || this.i) {
            return;
        }
        this.f69272e.offer(t);
        f();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (this.j || this.i) {
            bVar.dispose();
        }
    }

    public UnicastSubject(int i, Runnable runnable, boolean z) {
        f.b.x.b.a.c(i, "capacityHint");
        this.f69272e = new f.b.x.f.a<>(i);
        f.b.x.b.a.b(runnable, "onTerminate");
        this.f69274g = new AtomicReference<>(runnable);
        this.f69275h = z;
        this.f69273f = new AtomicReference<>();
        this.l = new AtomicBoolean();
        this.m = new UnicastQueueDisposable();
    }
}
