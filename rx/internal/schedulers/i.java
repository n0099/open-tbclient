package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kDS;
    private final g.a kDT;
    private final long kDU;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kDS = aVar;
        this.kDT = aVar2;
        this.kDU = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kDT.isUnsubscribed()) {
            long now = this.kDU - this.kDT.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.q(e);
                }
            }
            if (!this.kDT.isUnsubscribed()) {
                this.kDS.call();
            }
        }
    }
}
