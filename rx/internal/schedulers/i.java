package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nNy;
    private final rx.functions.a ofO;
    private final g.a ofP;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ofO = aVar;
        this.ofP = aVar2;
        this.nNy = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ofP.isUnsubscribed()) {
            long now = this.nNy - this.ofP.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.ofP.isUnsubscribed()) {
                this.ofO.call();
            }
        }
    }
}
