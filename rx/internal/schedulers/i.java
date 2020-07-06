package rx.internal.schedulers;

import rx.g;
/* loaded from: classes6.dex */
class i implements rx.functions.a {
    private final long nNB;
    private final rx.functions.a ofR;
    private final g.a ofS;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ofR = aVar;
        this.ofS = aVar2;
        this.nNB = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ofS.isUnsubscribed()) {
            long now = this.nNB - this.ofS.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.y(e);
                }
            }
            if (!this.ofS.isUnsubscribed()) {
                this.ofR.call();
            }
        }
    }
}
