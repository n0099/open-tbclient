package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final rx.functions.a nSg;
    private final g.a nSh;
    private final long nzU;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nSg = aVar;
        this.nSh = aVar2;
        this.nzU = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nSh.isUnsubscribed()) {
            long now = this.nzU - this.nSh.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.nSh.isUnsubscribed()) {
                this.nSg.call();
            }
        }
    }
}
