package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a ksn;
    private final g.a kso;
    private final long ksp;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.ksn = aVar;
        this.kso = aVar2;
        this.ksp = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kso.isUnsubscribed()) {
            long now = this.ksp - this.kso.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.r(e);
                }
            }
            if (!this.kso.isUnsubscribed()) {
                this.ksn.call();
            }
        }
    }
}
