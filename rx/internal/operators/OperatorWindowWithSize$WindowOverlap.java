package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.v5c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.z0c;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends d1c<T> implements k1c {
    public final d1c<? super x0c<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public final ArrayDeque<v5c<T, T>> i;
    public final AtomicLong j;
    public final AtomicInteger k;
    public final Queue<v5c<T, T>> l;
    public Throwable m;
    public volatile boolean n;
    public int o;
    public int p;

    /* loaded from: classes2.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements z0c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // com.baidu.tieba.z0c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(t1c.a(t1c.c(operatorWindowWithSize$WindowOverlap.g, j - 1), operatorWindowWithSize$WindowOverlap.f));
                    } else {
                        OperatorWindowWithSize$WindowOverlap.this.e(t1c.c(operatorWindowWithSize$WindowOverlap.g, j));
                    }
                    t1c.b(operatorWindowWithSize$WindowOverlap.j, j);
                    operatorWindowWithSize$WindowOverlap.j();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    @Override // com.baidu.tieba.k1c
    public void call() {
        if (this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.y0c
    public void onCompleted() {
        Iterator<v5c<T, T>> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onCompleted();
        }
        this.i.clear();
        this.n = true;
        j();
    }

    public boolean i(boolean z, boolean z2, d1c<? super v5c<T, T>> d1cVar, Queue<v5c<T, T>> queue) {
        if (d1cVar.isUnsubscribed()) {
            queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.m;
            if (th != null) {
                queue.clear();
                d1cVar.onError(th);
                return true;
            } else if (z2) {
                d1cVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: rx.internal.operators.OperatorWindowWithSize$WindowOverlap<T> */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r11 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (i(r15.n, r2.isEmpty(), r1, r2) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r9 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r5 == Long.MAX_VALUE) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        r15.j.addAndGet(-r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        r4 = r0.addAndGet(-r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        boolean z;
        AtomicInteger atomicInteger = this.k;
        if (atomicInteger.getAndIncrement() != 0) {
            return;
        }
        d1c<? super x0c<T>> d1cVar = this.e;
        Queue<v5c<T, T>> queue = this.l;
        int i = 1;
        do {
            long j = this.j.get();
            long j2 = 0;
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z2 = this.n;
                v5c<T, T> poll = queue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (i(z2, z, d1cVar, queue)) {
                    return;
                }
                if (z) {
                    break;
                }
                d1cVar.onNext(poll);
                j2++;
            }
        } while (i != 0);
    }

    @Override // com.baidu.tieba.y0c
    public void onError(Throwable th) {
        Iterator<v5c<T, T>> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onError(th);
        }
        this.i.clear();
        this.m = th;
        this.n = true;
        j();
    }

    @Override // com.baidu.tieba.y0c
    public void onNext(T t) {
        int i = this.o;
        ArrayDeque<v5c<T, T>> arrayDeque = this.i;
        if (i == 0 && !this.e.isUnsubscribed()) {
            this.h.getAndIncrement();
            UnicastSubject Q = UnicastSubject.Q(16, this);
            arrayDeque.offer(Q);
            this.l.offer(Q);
            j();
        }
        Iterator<v5c<T, T>> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onNext(t);
        }
        int i2 = this.p + 1;
        if (i2 == this.f) {
            this.p = i2 - this.g;
            v5c<T, T> poll = arrayDeque.poll();
            if (poll != null) {
                poll.onCompleted();
            }
        } else {
            this.p = i2;
        }
        int i3 = i + 1;
        if (i3 == this.g) {
            this.o = 0;
        } else {
            this.o = i3;
        }
    }
}
