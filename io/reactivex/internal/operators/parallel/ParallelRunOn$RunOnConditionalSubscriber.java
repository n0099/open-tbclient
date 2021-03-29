package io.reactivex.internal.operators.parallel;

import f.a.p;
import f.a.x.c.a;
import g.d.d;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    public static final long serialVersionUID = 1075119423897941642L;
    public final a<? super T> actual;

    public ParallelRunOn$RunOnConditionalSubscriber(a<? super T> aVar, int i, SpscArrayQueue<T> spscArrayQueue, p.c cVar) {
        super(i, spscArrayQueue, cVar);
        this.actual = aVar;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r13 != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r18.cancelled == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        r2.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
        if (r18.done == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        r13 = r18.error;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
        if (r13 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        r2.clear();
        r3.onError(r13);
        r18.worker.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
        if (r2.isEmpty() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
        r3.onComplete();
        r18.worker.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
        if (r11 == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
        if (r7 == Long.MAX_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
        r18.requested.addAndGet(-r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
        r7 = get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        if (r7 != r6) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
        r18.consumed = r1;
        r6 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
        if (r6 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
        r6 = r7;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        int i = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        a<? super T> aVar = this.actual;
        int i2 = this.limit;
        int i3 = 1;
        while (true) {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i4 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i4 == 0) {
                    break;
                } else if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (z2) {
                        break;
                    } else {
                        if (aVar.tryOnNext(poll)) {
                            j2++;
                        }
                        i++;
                        if (i == i2) {
                            this.s.request(i);
                            i = 0;
                        }
                    }
                }
            }
        }
    }
}
