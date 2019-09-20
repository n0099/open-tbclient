package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kDk;
    private final g.a kDl;
    private final long kDm;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kDk = aVar;
        this.kDl = aVar2;
        this.kDm = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kDl.isUnsubscribed()) {
            long now = this.kDm - this.kDl.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.kDl.isUnsubscribed()) {
                this.kDk.call();
            }
        }
    }
}
