package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a ksk;
    private final g.a ksl;
    private final long ksm;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ksk = aVar;
        this.ksl = aVar2;
        this.ksm = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.ksl.isUnsubscribed()) {
            long now = this.ksm - this.ksl.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.ksl.isUnsubscribed()) {
                this.ksk.call();
            }
        }
    }
}
