package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kDb;
    private final g.a kDc;
    private final long kDd;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kDb = aVar;
        this.kDc = aVar2;
        this.kDd = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kDc.isUnsubscribed()) {
            long now = this.kDd - this.kDc.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.kDc.isUnsubscribed()) {
                this.kDb.call();
            }
        }
    }
}
