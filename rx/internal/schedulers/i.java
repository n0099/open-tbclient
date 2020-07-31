package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nWk;
    private final g.a ooA;
    private final rx.functions.a ooz;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ooz = aVar;
        this.ooA = aVar2;
        this.nWk = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ooA.isUnsubscribed()) {
            long now = this.nWk - this.ooA.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.x(e);
                }
            }
            if (!this.ooA.isUnsubscribed()) {
                this.ooz.call();
            }
        }
    }
}
