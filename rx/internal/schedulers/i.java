package rx.internal.schedulers;

import rx.g;
/* loaded from: classes12.dex */
class i implements rx.functions.a {
    private final long pII;
    private final rx.functions.a pUd;
    private final g.a pUe;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.pUd = aVar;
        this.pUe = aVar2;
        this.pII = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.pUe.isUnsubscribed()) {
            long now = this.pII - this.pUe.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.pUe.isUnsubscribed()) {
                this.pUd.call();
            }
        }
    }
}
