package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nWm;
    private final rx.functions.a ooB;
    private final g.a ooC;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ooB = aVar;
        this.ooC = aVar2;
        this.nWm = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ooC.isUnsubscribed()) {
            long now = this.nWm - this.ooC.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.x(e);
                }
            }
            if (!this.ooC.isUnsubscribed()) {
                this.ooB.call();
            }
        }
    }
}
