package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final rx.functions.a nKa;
    private final g.a nKb;
    private final long nrL;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nKa = aVar;
        this.nKb = aVar2;
        this.nrL = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nKb.isUnsubscribed()) {
            long now = this.nrL - this.nKb.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.nKb.isUnsubscribed()) {
                this.nKa.call();
            }
        }
    }
}
