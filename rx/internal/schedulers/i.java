package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a qCN;
    private final g.a qCO;
    private final long qrw;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qCN = aVar;
        this.qCO = aVar2;
        this.qrw = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qCO.isUnsubscribed()) {
            long now = this.qrw - this.qCO.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.qCO.isUnsubscribed()) {
                this.qCN.call();
            }
        }
    }
}
