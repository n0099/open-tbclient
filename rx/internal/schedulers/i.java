package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a qDn;
    private final g.a qDo;
    private final long qrW;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qDn = aVar;
        this.qDo = aVar2;
        this.qrW = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qDo.isUnsubscribed()) {
            long now = this.qrW - this.qDo.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.qDo.isUnsubscribed()) {
                this.qDn.call();
            }
        }
    }
}
