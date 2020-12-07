package rx.internal.schedulers;

import rx.g;
/* loaded from: classes12.dex */
class i implements rx.functions.a {
    private final long pIG;
    private final rx.functions.a pUb;
    private final g.a pUc;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.pUb = aVar;
        this.pUc = aVar2;
        this.pIG = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.pUc.isUnsubscribed()) {
            long now = this.pIG - this.pUc.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.pUc.isUnsubscribed()) {
                this.pUb.call();
            }
        }
    }
}
