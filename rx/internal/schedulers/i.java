package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a jZU;
    private final g.a jZV;
    private final long jZW;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.jZU = aVar;
        this.jZV = aVar2;
        this.jZW = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.jZV.isUnsubscribed()) {
            long now = this.jZW - this.jZV.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.jZV.isUnsubscribed()) {
                this.jZU.call();
            }
        }
    }
}
