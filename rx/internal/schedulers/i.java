package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a ksj;
    private final g.a ksk;
    private final long ksl;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ksj = aVar;
        this.ksk = aVar2;
        this.ksl = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ksk.isUnsubscribed()) {
            long now = this.ksl - this.ksk.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.ksk.isUnsubscribed()) {
                this.ksj.call();
            }
        }
    }
}
