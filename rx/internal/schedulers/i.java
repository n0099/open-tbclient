package rx.internal.schedulers;

import rx.g;
/* loaded from: classes16.dex */
class i implements rx.functions.a {
    private final long pQp;
    private final rx.functions.a qix;
    private final g.a qiy;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qix = aVar;
        this.qiy = aVar2;
        this.pQp = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qiy.isUnsubscribed()) {
            long now = this.pQp - this.qiy.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.qiy.isUnsubscribed()) {
                this.qix.call();
            }
        }
    }
}
