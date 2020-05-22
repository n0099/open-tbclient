package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final rx.functions.a nIQ;
    private final g.a nIR;
    private final long nqB;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nIQ = aVar;
        this.nIR = aVar2;
        this.nqB = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nIR.isUnsubscribed()) {
            long now = this.nqB - this.nIR.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.nIR.isUnsubscribed()) {
                this.nIQ.call();
            }
        }
    }
}
