package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long mVy;
    private final rx.functions.a nnQ;
    private final g.a nnR;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nnQ = aVar;
        this.nnR = aVar2;
        this.mVy = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nnR.isUnsubscribed()) {
            long now = this.mVy - this.nnR.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.nnR.isUnsubscribed()) {
                this.nnQ.call();
            }
        }
    }
}
