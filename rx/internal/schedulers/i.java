package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iLC;
    private final g.a iLD;
    private final long iLE;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iLC = aVar;
        this.iLD = aVar2;
        this.iLE = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iLD.isUnsubscribed()) {
            long now = this.iLE - this.iLD.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iLD.isUnsubscribed()) {
                this.iLC.call();
            }
        }
    }
}
