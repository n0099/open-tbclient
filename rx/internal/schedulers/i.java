package rx.internal.schedulers;

import rx.g;
/* loaded from: classes5.dex */
class i implements rx.functions.a {
    private final rx.functions.a oIw;
    private final g.a oIx;
    private final long oqj;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.oIw = aVar;
        this.oIx = aVar2;
        this.oqj = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.oIx.isUnsubscribed()) {
            long now = this.oqj - this.oIx.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.oIx.isUnsubscribed()) {
                this.oIw.call();
            }
        }
    }
}
