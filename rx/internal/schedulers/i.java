package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kAS;
    private final g.a kAT;
    private final long kAU;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kAS = aVar;
        this.kAT = aVar2;
        this.kAU = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kAT.isUnsubscribed()) {
            long now = this.kAU - this.kAT.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.kAT.isUnsubscribed()) {
                this.kAS.call();
            }
        }
    }
}
