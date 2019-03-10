package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kaJ;
    private final g.a kaK;
    private final long kaL;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kaJ = aVar;
        this.kaK = aVar2;
        this.kaL = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kaK.isUnsubscribed()) {
            long now = this.kaL - this.kaK.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.kaK.isUnsubscribed()) {
                this.kaJ.call();
            }
        }
    }
}
