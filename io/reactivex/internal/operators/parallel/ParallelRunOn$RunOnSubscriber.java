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

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        if (r13 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
        if (r18.cancelled == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r2.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        if (r18.done == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
        r13 = r18.error;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
        if (r13 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        r2.clear();
        r3.onError(r13);
        r18.worker.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
        if (r2.isEmpty() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        r3.onComplete();
        r18.worker.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
        if (r11 == 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
        if (r7 == Long.MAX_VALUE) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
        r18.requested.addAndGet(-r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
        r7 = get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        if (r7 != r6) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
        r18.consumed = r1;
        r6 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r6 != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b3, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
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
        c<? super T> cVar = this.actual;
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
