package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iOM;
    private final g.a iON;
    private final long iOO;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iOM = aVar;
        this.iON = aVar2;
        this.iOO = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iON.isUnsubscribed()) {
            long now = this.iOO - this.iON.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iON.isUnsubscribed()) {
                this.iOM.call();
            }
        }
    }
}
