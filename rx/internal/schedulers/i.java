package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iCL;
    private final g.a iCM;
    private final long iCN;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iCL = aVar;
        this.iCM = aVar2;
        this.iCN = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iCM.isUnsubscribed()) {
            long now = this.iCN - this.iCM.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iCM.isUnsubscribed()) {
                this.iCL.call();
            }
        }
    }
}
