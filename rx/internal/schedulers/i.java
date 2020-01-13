package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a nRm;
    private final g.a nRn;
    private final long nzn;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nRm = aVar;
        this.nRn = aVar2;
        this.nzn = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nRn.isUnsubscribed()) {
            long now = this.nzn - this.nRn.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.u(e);
                }
            }
            if (!this.nRn.isUnsubscribed()) {
                this.nRm.call();
            }
        }
    }
}
