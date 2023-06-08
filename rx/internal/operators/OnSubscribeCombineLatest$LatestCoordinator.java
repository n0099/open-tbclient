package rx.internal.operators;

import com.baidu.tieba.fpb;
import com.baidu.tieba.hnb;
import com.baidu.tieba.inb;
import com.baidu.tieba.lnb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements pmb, umb {
    public static final Object MISSING = new Object();
    public static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final tmb<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final hnb<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final fpb<Object> queue;
    public final AtomicLong requested;
    public final lnb<T, R>[] subscribers;

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }
    }

    public OnSubscribeCombineLatest$LatestCoordinator(tmb<? super R> tmbVar, hnb<? extends R> hnbVar, int i, int i2, boolean z) {
        this.actual = tmbVar;
        this.combiner = hnbVar;
        this.bufferSize = i2;
        this.delayError = z;
        Object[] objArr = new Object[i];
        this.latest = objArr;
        Arrays.fill(objArr, MISSING);
        this.subscribers = new lnb[i];
        this.queue = new fpb<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void cancel(Queue<?> queue) {
        queue.clear();
        for (lnb<T, R> lnbVar : this.subscribers) {
            lnbVar.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                inb.b(this.requested, j);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= required but it was " + j);
    }

    public void subscribe(nmb<? extends T>[] nmbVarArr) {
        lnb<T, R>[] lnbVarArr = this.subscribers;
        int length = lnbVarArr.length;
        for (int i = 0; i < length; i++) {
            lnbVarArr[i] = new lnb<>(this, i);
        }
        lazySet(0);
        this.actual.b(this);
        this.actual.f(this);
        for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
            nmbVarArr[i2].w(lnbVarArr[i2]);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, tmb<?> tmbVar, Queue<?> queue, boolean z3) {
        if (this.cancelled) {
            cancel(queue);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        tmbVar.onError(th);
                    } else {
                        tmbVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error.get();
            if (th2 != null) {
                cancel(queue);
                tmbVar.onError(th2);
                return true;
            } else if (z2) {
                tmbVar.onCompleted();
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
        lnb<T, R> lnbVar = this.subscribers[i];
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
                    this.queue.l(lnbVar, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                    this.done = true;
                }
            } else {
                this.done = true;
            }
        }
        if (!z && obj != null) {
            lnbVar.g(1L);
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
        com.baidu.tieba.inb.g(r10, r3);
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
        fpb<Object> fpbVar = this.queue;
        tmb<? super R> tmbVar = this.actual;
        boolean z2 = this.delayError;
        AtomicLong atomicLong = this.requested;
        int i = 1;
        while (!checkTerminated(this.done, fpbVar.isEmpty(), tmbVar, fpbVar, z2)) {
            long j2 = atomicLong.get();
            long j3 = 0;
            while (true) {
                if (j3 != j2) {
                    boolean z3 = this.done;
                    lnb lnbVar = (lnb) fpbVar.peek();
                    if (lnbVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j4 = j3;
                    if (checkTerminated(z3, z, tmbVar, fpbVar, z2)) {
                        return;
                    }
                    if (z) {
                        j = j4;
                        break;
                    }
                    fpbVar.poll();
                    Object[] objArr = (Object[]) fpbVar.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(fpbVar);
                        tmbVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        tmbVar.onNext((R) this.combiner.call(objArr));
                        lnbVar.g(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(fpbVar);
                        tmbVar.onError(th);
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
