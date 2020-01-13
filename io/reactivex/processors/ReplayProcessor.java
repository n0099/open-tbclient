package io.reactivex.processors;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class ReplayProcessor<T> extends io.reactivex.processors.a<T> {
    boolean done;
    final a<T> nAj;
    final AtomicReference<ReplaySubscription<T>[]> subscribers;
    private static final Object[] nzY = new Object[0];
    static final ReplaySubscription[] nAk = new ReplaySubscription[0];
    static final ReplaySubscription[] nAl = new ReplaySubscription[0];

    /* loaded from: classes5.dex */
    interface a<T> {
        void c(ReplaySubscription<T> replaySubscription);

        void complete();

        void error(Throwable th);

        void next(T t);
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(cVar, this);
        cVar.onSubscribe(replaySubscription);
        if (a(replaySubscription) && replaySubscription.cancelled) {
            b(replaySubscription);
        } else {
            this.nAj.c(replaySubscription);
        }
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (this.done) {
            dVar.cancel();
        } else {
            dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.h(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done) {
            a<T> aVar = this.nAj;
            aVar.next(t);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                aVar.c(replaySubscription);
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.h(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.done = true;
        a<T> aVar = this.nAj;
        aVar.error(th);
        for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(nAl)) {
            aVar.c(replaySubscription);
        }
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            a<T> aVar = this.nAj;
            aVar.complete();
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(nAl)) {
                aVar.c(replaySubscription);
            }
        }
    }

    boolean a(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr == nAl) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    void b(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.subscribers.get();
            if (replaySubscriptionArr != nAl && replaySubscriptionArr != nAk) {
                int length = replaySubscriptionArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replaySubscriptionArr[i2] == replaySubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        replaySubscriptionArr2 = nAk;
                    } else {
                        replaySubscriptionArr2 = new ReplaySubscription[length - 1];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, i);
                        System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 466549804534799122L;
        final c<? super T> actual;
        volatile boolean cancelled;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(c<? super T> cVar, ReplayProcessor<T> replayProcessor) {
            this.actual = cVar;
            this.state = replayProcessor;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                this.state.nAj.c(this);
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.b(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t) {
            this.value = t;
        }
    }

    /* loaded from: classes5.dex */
    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }
}
