package rx.internal.schedulers;

import rx.g;
/* loaded from: classes4.dex */
class i implements rx.functions.a {
    private final rx.functions.a qDP;
    private final g.a qDQ;
    private final long qsy;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qDP = aVar;
        this.qDQ = aVar2;
        this.qsy = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qDQ.isUnsubscribed()) {
            long now = this.qsy - this.qDQ.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.qDQ.isUnsubscribed()) {
                this.qDP.call();
            }
        }
    }
}
