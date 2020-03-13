package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nAh;
    private final rx.functions.a nSt;
    private final g.a nSu;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nSt = aVar;
        this.nSu = aVar2;
        this.nAh = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nSu.isUnsubscribed()) {
            long now = this.nAh - this.nSu.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.nSu.isUnsubscribed()) {
                this.nSt.call();
            }
        }
    }
}
