package rx.internal.schedulers;

import rx.g;
/* loaded from: classes4.dex */
class i implements rx.functions.a {
    private final long mXf;
    private final rx.functions.a nip;
    private final g.a niq;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.nip = aVar;
        this.niq = aVar2;
        this.mXf = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.niq.isUnsubscribed()) {
            long now = this.mXf - this.niq.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.u(e);
                }
            }
            if (!this.niq.isUnsubscribed()) {
                this.nip.call();
            }
        }
    }
}
