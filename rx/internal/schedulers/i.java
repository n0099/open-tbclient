package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iPT;
    private final g.a iPU;
    private final long iPV;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iPT = aVar;
        this.iPU = aVar2;
        this.iPV = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iPU.isUnsubscribed()) {
            long now = this.iPV - this.iPU.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iPU.isUnsubscribed()) {
                this.iPT.call();
            }
        }
    }
}
