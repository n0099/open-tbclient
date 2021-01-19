package rx.internal.schedulers;

import rx.g;
/* loaded from: classes14.dex */
class i implements rx.functions.a {
    private final long qhs;
    private final rx.functions.a qsK;
    private final g.a qsL;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qsK = aVar;
        this.qsL = aVar2;
        this.qhs = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qsL.isUnsubscribed()) {
            long now = this.qhs - this.qsL.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.qsL.isUnsubscribed()) {
                this.qsK.call();
            }
        }
    }
}
