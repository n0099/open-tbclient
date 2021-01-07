package rx.internal.schedulers;

import rx.g;
/* loaded from: classes15.dex */
class i implements rx.functions.a {
    private final long qlT;
    private final rx.functions.a qxl;
    private final g.a qxm;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qxl = aVar;
        this.qxm = aVar2;
        this.qlT = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qxm.isUnsubscribed()) {
            long now = this.qlT - this.qxm.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.t(e);
                }
            }
            if (!this.qxm.isUnsubscribed()) {
                this.qxl.call();
            }
        }
    }
}
