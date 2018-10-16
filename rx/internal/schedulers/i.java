package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iCK;
    private final g.a iCL;
    private final long iCM;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iCK = aVar;
        this.iCL = aVar2;
        this.iCM = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iCL.isUnsubscribed()) {
            long now = this.iCM - this.iCL.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iCL.isUnsubscribed()) {
                this.iCK.call();
            }
        }
    }
}
