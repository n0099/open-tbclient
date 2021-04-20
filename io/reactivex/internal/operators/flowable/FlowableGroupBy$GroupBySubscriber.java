package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.v.b;
import f.b.w.h;
import f.b.x.e.a.f;
import f.b.x.f.a;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<b<K, V>> implements g<T> {
    public static final Object NULL_KEY = new Object();
    public static final long serialVersionUID = -3688291656102519502L;
    public final c<? super b<K, V>> actual;
    public final int bufferSize;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final h<? super T, ? extends K> keySelector;
    public boolean outputFused;
    public final a<b<K, V>> queue;
    public d s;
    public final h<? super T, ? extends V> valueSelector;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger groupCount = new AtomicInteger(1);
    public final Map<Object, f<K, V>> groups = new ConcurrentHashMap();

    public FlowableGroupBy$GroupBySubscriber(c<? super b<K, V>> cVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i, boolean z) {
        this.actual = cVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i;
        this.delayError = z;
        this.queue = new a<>(i);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
            this.s.cancel();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<?> cVar, a<?> aVar) {
        if (this.cancelled.get()) {
            aVar.clear();
            return true;
        } else if (this.delayError) {
            if (z && z2) {
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            return false;
        } else if (z) {
            Throwable th2 = this.error;
            if (th2 != null) {
                aVar.clear();
                cVar.onError(th2);
                return true;
            } else if (z2) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void drainFused() {
        Throwable th;
        a<b<K, V>> aVar = this.queue;
        c<? super b<K, V>> cVar = this.actual;
        int i = 1;
        while (!this.cancelled.get()) {
            boolean z = this.done;
            if (z && !this.delayError && (th = this.error) != null) {
                aVar.clear();
                cVar.onError(th);
                return;
            }
            cVar.onNext(null);
            if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    cVar.onError(th2);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.clear();
    }

    public void drainNormal() {
        int i;
        a<b<K, V>> aVar = this.queue;
        c<? super b<K, V>> cVar = this.actual;
        int i2 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                b<K, V> poll = aVar.poll();
                boolean z2 = poll == null;
                if (checkTerminated(z, z2, cVar, aVar)) {
                    return;
                }
                if (z2) {
                    break;
                }
                cVar.onNext(poll);
                j2++;
            }
            if (i == 0 && checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                return;
            }
            if (j2 != 0) {
                if (j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                this.s.request(j2);
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        for (f<K, V> fVar : this.groups.values()) {
            fVar.onComplete();
        }
        this.groups.clear();
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            f.b.a0.a.f(th);
            return;
        }
        for (f<K, V> fVar : this.groups.values()) {
            fVar.onError(th);
        }
        this.groups.clear();
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        a<b<K, V>> aVar = this.queue;
        try {
            K apply = this.keySelector.apply(t);
            boolean z = false;
            Object obj = apply != null ? apply : NULL_KEY;
            f fVar = this.groups.get(obj);
            if (fVar == null) {
                if (this.cancelled.get()) {
                    return;
                }
                fVar = f.d(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, fVar);
                this.groupCount.getAndIncrement();
                z = true;
            }
            try {
                V apply2 = this.valueSelector.apply(t);
                f.b.x.b.a.b(apply2, "The valueSelector returned null");
                fVar.onNext(apply2);
                if (z) {
                    aVar.offer(fVar);
                    drain();
                }
            } catch (Throwable th) {
                f.b.u.a.a(th);
                this.s.cancel();
                onError(th);
            }
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            this.s.cancel();
            onError(th2);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(this.bufferSize);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
            drain();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.b.x.c.f
    public b<K, V> poll() {
        return this.queue.poll();
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (this.groupCount.decrementAndGet() == 0) {
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }
}
