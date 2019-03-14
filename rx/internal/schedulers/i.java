package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kaB;
    private final g.a kaC;
    private final long kaD;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kaB = aVar;
        this.kaC = aVar2;
        this.kaD = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kaC.isUnsubscribed()) {
            long now = this.kaD - this.kaC.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.kaC.isUnsubscribed()) {
                this.kaB.call();
            }
        }
    }
}
