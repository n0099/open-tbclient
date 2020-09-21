package rx.internal.schedulers;

import rx.g;
/* loaded from: classes7.dex */
class i implements rx.functions.a {
    private final long oAj;
    private final rx.functions.a oSt;
    private final g.a oSu;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.oSt = aVar;
        this.oSu = aVar2;
        this.oAj = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.oSu.isUnsubscribed()) {
            long now = this.oAj - this.oSu.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.oSu.isUnsubscribed()) {
                this.oSt.call();
            }
        }
    }
}
