package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a jZT;
    private final g.a jZU;
    private final long jZV;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.jZT = aVar;
        this.jZU = aVar2;
        this.jZV = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.jZU.isUnsubscribed()) {
            long now = this.jZV - this.jZU.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.jZU.isUnsubscribed()) {
                this.jZT.call();
            }
        }
    }
}
