package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nBU;
    private final rx.functions.a nUg;
    private final g.a nUh;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nUg = aVar;
        this.nUh = aVar2;
        this.nBU = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nUh.isUnsubscribed()) {
            long now = this.nBU - this.nUh.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.nUh.isUnsubscribed()) {
                this.nUg.call();
            }
        }
    }
}
