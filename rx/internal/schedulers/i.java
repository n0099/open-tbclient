package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a nRr;
    private final g.a nRs;
    private final long nzs;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nRr = aVar;
        this.nRs = aVar2;
        this.nzs = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nRs.isUnsubscribed()) {
            long now = this.nzs - this.nRs.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.u(e);
                }
            }
            if (!this.nRs.isUnsubscribed()) {
                this.nRr.call();
            }
        }
    }
}
