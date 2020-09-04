package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a oIO;
    private final g.a oIP;
    private final long oqB;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.oIO = aVar;
        this.oIP = aVar2;
        this.oqB = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.oIP.isUnsubscribed()) {
            long now = this.oqB - this.oIP.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.oIP.isUnsubscribed()) {
                this.oIO.call();
            }
        }
    }
}
