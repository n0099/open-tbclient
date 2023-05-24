package rx.internal.operators;

import com.baidu.tieba.aab;
import com.baidu.tieba.c8b;
import com.baidu.tieba.d8b;
import com.baidu.tieba.g8b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes10.dex */
public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements k7b, p7b {
    public static final Object MISSING = new Object();
    public static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final o7b<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final c8b<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final aab<Object> queue;
    public final AtomicLong requested;
    public final g8b<T, R>[] subscribers;

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }
    }

    public OnSubscribeCombineLatest$LatestCoordinator(o7b<? super R> o7bVar, c8b<? extends R> c8bVar, int i, int i2, boolean z) {
        this.actual = o7bVar;
        this.combiner = c8bVar;
        this.bufferSize = i2;
        this.delayError = z;
        Object[] objArr = new Object[i];
        this.latest = objArr;
        Arrays.fill(objArr, MISSING);
        this.subscribers = new g8b[i];
        this.queue = new aab<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void cancel(Queue<?> queue) {
        queue.clear();
        for (g8b<T, R> g8bVar : this.subscribers) {
            g8bVar.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                d8b.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    public void subscribe(i7b<? extends T>[] i7bVarArr) {
        g8b<T, R>[] g8bVarArr = this.subscribers;
        int length = g8bVarArr.length;
        for (int i = 0; i < length; i++) {
            g8bVarArr[i] = new g8b<>(this, i);
        }
        lazySet(0);
        this.actual.b(this);
        this.actual.f(this);
        for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
            i7bVarArr[i2].w(g8bVarArr[i2]);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, o7b<?> o7bVar, Queue<?> queue, boolean z3) {
        if (this.cancelled) {
            cancel(queue);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        o7bVar.onError(th);
                    } else {
                        o7bVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error.get();
            if (th2 != null) {
                cancel(queue);
                o7bVar.onError(th2);
                return true;
            } else if (z2) {
                o7bVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void combine(Object obj, int i) {
        boolean z;
        g8b<T, R> g8bVar = this.subscribers[i];
        synchronized (this) {
            int length = this.latest.length;
            Object obj2 = this.latest[i];
            int i2 = this.active;
            if (obj2 == MISSING) {
                i2++;
                this.active = i2;
            }
            int i3 = this.complete;
            if (obj == null) {
                i3++;
                this.complete = i3;
            } else {
                this.latest[i] = NotificationLite.e(obj);
            }
            boolean z2 = false;
            if (i2 == length) {
                z = true;
            } else {
                z = false;
            }
            if (i3 == length || (obj == null && obj2 == MISSING)) {
                z2 = true;
            }
            if (!z2) {
                if (obj != null && z) {
                    this.queue.l(g8bVar, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                    this.done = true;
                }
            } else {
                this.done = true;
            }
        }
        if (!z && obj != null) {
            g8bVar.g(1L);
        } else {
            drain();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: R, ? super R */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
        if (r3 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
        if (r13 == Long.MAX_VALUE) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
        com.baidu.tieba.d8b.g(r10, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
        r12 = addAndGet(-r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r12 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        long j;
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        aab<Object> aabVar = this.queue;
        o7b<? super R> o7bVar = this.actual;
        boolean z2 = this.delayError;
        AtomicLong atomicLong = this.requested;
        int i = 1;
        while (!checkTerminated(this.done, aabVar.isEmpty(), o7bVar, aabVar, z2)) {
            long j2 = atomicLong.get();
            long j3 = 0;
            while (true) {
                if (j3 != j2) {
                    boolean z3 = this.done;
                    g8b g8bVar = (g8b) aabVar.peek();
                    if (g8bVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j4 = j3;
                    if (checkTerminated(z3, z, o7bVar, aabVar, z2)) {
                        return;
                    }
                    if (z) {
                        j = j4;
                        break;
                    }
                    aabVar.poll();
                    Object[] objArr = (Object[]) aabVar.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(aabVar);
                        o7bVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        o7bVar.onNext((R) this.combiner.call(objArr));
                        g8bVar.g(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(aabVar);
                        o7bVar.onError(th);
                        return;
                    }
                } else {
                    j = j3;
                    break;
                }
            }
        }
    }

    public void onError(Throwable th) {
        Throwable th2;
        Throwable th3;
        AtomicReference<Throwable> atomicReference = this.error;
        do {
            th2 = atomicReference.get();
            if (th2 != null) {
                if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } else {
                th3 = th;
            }
        } while (!atomicReference.compareAndSet(th2, th3));
    }
}
