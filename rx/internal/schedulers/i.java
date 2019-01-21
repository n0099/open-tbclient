package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iPU;
    private final g.a iPV;
    private final long iPW;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iPU = aVar;
        this.iPV = aVar2;
        this.iPW = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iPV.isUnsubscribed()) {
            long now = this.iPW - this.iPV.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iPV.isUnsubscribed()) {
                this.iPU.call();
            }
        }
    }
}
