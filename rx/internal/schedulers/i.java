package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kzM;
    private final g.a kzN;
    private final long kzO;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kzM = aVar;
        this.kzN = aVar2;
        this.kzO = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kzN.isUnsubscribed()) {
            long now = this.kzO - this.kzN.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.kzN.isUnsubscribed()) {
                this.kzM.call();
            }
        }
    }
}
