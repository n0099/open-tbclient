package rx.internal.schedulers;

import rx.g;
/* loaded from: classes14.dex */
class i implements rx.functions.a {
    private final long pRS;
    private final rx.functions.a qka;
    private final g.a qkb;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.qka = aVar;
        this.qkb = aVar2;
        this.pRS = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.qkb.isUnsubscribed()) {
            long now = this.pRS - this.qkb.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.qkb.isUnsubscribed()) {
                this.qka.call();
            }
        }
    }
}
