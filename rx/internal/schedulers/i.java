package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long mVv;
    private final rx.functions.a nnN;
    private final g.a nnO;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nnN = aVar;
        this.nnO = aVar2;
        this.mVv = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nnO.isUnsubscribed()) {
            long now = this.mVv - this.nnO.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.nnO.isUnsubscribed()) {
                this.nnN.call();
            }
        }
    }
}
