package rx.internal.schedulers;

import rx.g;
/* loaded from: classes16.dex */
class i implements rx.functions.a {
    private final long pGV;
    private final rx.functions.a pZc;
    private final g.a pZd;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.pZc = aVar;
        this.pZd = aVar2;
        this.pGV = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.pZd.isUnsubscribed()) {
            long now = this.pGV - this.pZd.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.pZd.isUnsubscribed()) {
                this.pZc.call();
            }
        }
    }
}
