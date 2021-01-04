package rx.internal.schedulers;

import rx.g;
/* loaded from: classes15.dex */
class i implements rx.functions.a {
    private final long qkl;
    private final rx.functions.a qvD;
    private final g.a qvE;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qvD = aVar;
        this.qvE = aVar2;
        this.qkl = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qvE.isUnsubscribed()) {
            long now = this.qkl - this.qvE.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.qvE.isUnsubscribed()) {
                this.qvD.call();
            }
        }
    }
}
