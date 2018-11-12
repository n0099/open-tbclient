package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a iEv;
    private final g.a iEw;
    private final long iEx;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.iEv = aVar;
        this.iEw = aVar2;
        this.iEx = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.iEw.isUnsubscribed()) {
            long now = this.iEx - this.iEw.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.iEw.isUnsubscribed()) {
                this.iEv.call();
            }
        }
    }
}
