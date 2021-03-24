package io.reactivex.internal.operators.parallel;

import f.a.p;
import g.d.c;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    public static final long serialVersionUID = 1075119423897941642L;
    public final c<? super T> actual;

    public ParallelRunOn$RunOnSubscriber(c<? super T> cVar, int i, SpscArrayQueue<T> spscArrayQueue, p.c cVar2) {
        super(i, spscArrayQueue, cVar2);
        this.actual = cVar;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Throwable th;
        int i2 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        c<? super T> cVar = this.actual;
        int i3 = this.limit;
        int i4 = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z = this.done;
                if (z && (th = this.error) != null) {
                    spscArrayQueue.clear();
                    cVar.onError(th);
                    this.worker.dispose();
                    return;
                }
                T poll = spscArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                } else if (z2) {
                    break;
                } else {
                    cVar.onNext(poll);
                    j2++;
                    i2++;
                    if (i2 == i3) {
                        i = i4;
                        this.s.request(i2);
                        i2 = 0;
                    } else {
                        i = i4;
                    }
                    i4 = i;
                }
            }
            int i5 = i4;
            if (j2 == j) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else if (this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            int i6 = get();
            if (i6 == i5) {
                this.consumed = i2;
                i6 = addAndGet(-i5);
                if (i6 == 0) {
                    return;
                }
            }
            i4 = i6;
        }
    }
}
