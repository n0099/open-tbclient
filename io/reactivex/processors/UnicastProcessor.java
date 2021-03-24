package io.reactivex.processors;

import f.a.b0.a;
import f.a.e;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* renamed from: f  reason: collision with root package name */
    public final f.a.x.f.a<T> f68099f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Runnable> f68100g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f68101h;
    public volatile boolean i;
    public Throwable j;
    public final AtomicReference<c<? super T>> k;
    public volatile boolean l;
    public final AtomicBoolean m;
    public final BasicIntQueueSubscription<T> n;
    public final AtomicLong o;
    public boolean p;

    /* loaded from: classes7.dex */
    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        public static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
        public void cancel() {
            if (UnicastProcessor.this.l) {
                return;
            }
            UnicastProcessor.this.l = true;
            UnicastProcessor.this.g();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.p || unicastProcessor.n.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.f68099f.clear();
            UnicastProcessor.this.k.lazySet(null);
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
        public void clear() {
            UnicastProcessor.this.f68099f.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
        public boolean isEmpty() {
            return UnicastProcessor.this.f68099f.isEmpty();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
        public T poll() {
            return UnicastProcessor.this.f68099f.poll();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(UnicastProcessor.this.o, j);
                UnicastProcessor.this.h();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.p = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastProcessor(int i) {
        this(i, null, true);
    }

    public static <T> UnicastProcessor<T> e() {
        return new UnicastProcessor<>(e.a());
    }

    public static <T> UnicastProcessor<T> f(int i, Runnable runnable) {
        f.a.x.b.a.b(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    @Override // f.a.e
    public void c(c<? super T> cVar) {
        if (!this.m.get() && this.m.compareAndSet(false, true)) {
            cVar.onSubscribe(this.n);
            this.k.set(cVar);
            if (this.l) {
                this.k.lazySet(null);
                return;
            } else {
                h();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
    }

    public boolean d(boolean z, boolean z2, boolean z3, c<? super T> cVar, f.a.x.f.a<T> aVar) {
        if (this.l) {
            aVar.clear();
            this.k.lazySet(null);
            return true;
        } else if (z2) {
            if (z && this.j != null) {
                aVar.clear();
                this.k.lazySet(null);
                cVar.onError(this.j);
                return true;
            } else if (z3) {
                Throwable th = this.j;
                this.k.lazySet(null);
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void g() {
        Runnable runnable = this.f68100g.get();
        if (runnable == null || !this.f68100g.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void h() {
        if (this.n.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        c<? super T> cVar = this.k.get();
        while (cVar == null) {
            i = this.n.addAndGet(-i);
            if (i == 0) {
                return;
            }
            cVar = this.k.get();
        }
        if (this.p) {
            i(cVar);
        } else {
            j(cVar);
        }
    }

    public void i(c<? super T> cVar) {
        f.a.x.f.a<T> aVar = this.f68099f;
        int i = 1;
        boolean z = !this.f68101h;
        while (!this.l) {
            boolean z2 = this.i;
            if (z && z2 && this.j != null) {
                aVar.clear();
                this.k.lazySet(null);
                cVar.onError(this.j);
                return;
            }
            cVar.onNext(null);
            if (z2) {
                this.k.lazySet(null);
                Throwable th = this.j;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            i = this.n.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.clear();
        this.k.lazySet(null);
    }

    public void j(c<? super T> cVar) {
        long j;
        f.a.x.f.a<T> aVar = this.f68099f;
        boolean z = !this.f68101h;
        int i = 1;
        do {
            long j2 = this.o.get();
            long j3 = 0;
            while (true) {
                if (j2 == j3) {
                    j = j3;
                    break;
                }
                boolean z2 = this.i;
                T poll = aVar.poll();
                boolean z3 = poll == null;
                j = j3;
                if (d(z, z2, z3, cVar, aVar)) {
                    return;
                }
                if (z3) {
                    break;
                }
                cVar.onNext(poll);
                j3 = 1 + j;
            }
            if (j2 == j && d(z, this.i, aVar.isEmpty(), cVar, aVar)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.o.addAndGet(-j);
            }
            i = this.n.addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.i || this.l) {
            return;
        }
        this.i = true;
        g();
        h();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        f.a.x.b.a.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.i && !this.l) {
            this.j = th;
            this.i = true;
            g();
            h();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        f.a.x.b.a.b(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.i || this.l) {
            return;
        }
        this.f68099f.offer(t);
        h();
    }

    @Override // g.d.c
    public void onSubscribe(d dVar) {
        if (!this.i && !this.l) {
            dVar.request(Long.MAX_VALUE);
        } else {
            dVar.cancel();
        }
    }

    public UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    public UnicastProcessor(int i, Runnable runnable, boolean z) {
        f.a.x.b.a.c(i, "capacityHint");
        this.f68099f = new f.a.x.f.a<>(i);
        this.f68100g = new AtomicReference<>(runnable);
        this.f68101h = z;
        this.k = new AtomicReference<>();
        this.m = new AtomicBoolean();
        this.n = new UnicastQueueSubscription();
        this.o = new AtomicLong();
    }
}
