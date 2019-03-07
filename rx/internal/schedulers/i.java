package rx.internal.schedulers;

import rx.g;
/* loaded from: classes2.dex */
class i implements rx.functions.a {
    private final rx.functions.a kaq;
    private final g.a kar;
    private final long kas;

    public i(rx.functions.a aVar, g.a aVar2, long j) {
        this.kaq = aVar;
        this.kar = aVar2;
        this.kas = j;
    }

    @Override // rx.functions.a
    public void call() {
        if (!this.kar.isUnsubscribed()) {
            long now = this.kas - this.kar.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.s(e);
                }
            }
            if (!this.kar.isUnsubscribed()) {
                this.kaq.call();
            }
        }
    }
}
