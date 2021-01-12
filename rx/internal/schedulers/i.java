package rx.internal.schedulers;

import rx.g;
/* loaded from: classes14.dex */
class i implements rx.functions.a {
    private final long qhr;
    private final rx.functions.a qsJ;
    private final g.a qsK;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qsJ = aVar;
        this.qsK = aVar2;
        this.qhr = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qsK.isUnsubscribed()) {
            long now = this.qhr - this.qsK.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.qsK.isUnsubscribed()) {
                this.qsJ.call();
            }
        }
    }
}
