package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final rx.functions.a nSi;
    private final g.a nSj;
    private final long nzW;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nSi = aVar;
        this.nSj = aVar2;
        this.nzW = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.nSj.isUnsubscribed()) {
            long now = this.nzW - this.nSj.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.nSj.isUnsubscribed()) {
                this.nSi.call();
            }
        }
    }
}
