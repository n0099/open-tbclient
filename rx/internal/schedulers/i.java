package rx.internal.schedulers;

import rx.g;
/* loaded from: classes16.dex */
class i implements rx.functions.a {
    private final long oPy;
    private final rx.functions.a phJ;
    private final g.a phK;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.phJ = aVar;
        this.phK = aVar2;
        this.oPy = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.phK.isUnsubscribed()) {
            long now = this.oPy - this.phK.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.v(e);
                }
            }
            if (!this.phK.isUnsubscribed()) {
                this.phJ.call();
            }
        }
    }
}
