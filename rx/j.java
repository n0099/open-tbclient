package rx;
/* loaded from: classes2.dex */
public abstract class j<T> implements e<T>, k {
    private static final long NOT_SET = Long.MIN_VALUE;
    private f producer;
    private long requested;
    private final j<?> subscriber;
    private final rx.internal.util.i subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public j() {
        this(null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(j<?> jVar) {
        this(jVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(j<?> jVar, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = jVar;
        this.subscriptions = (!z || jVar == null) ? new rx.internal.util.i() : jVar.subscriptions;
    }

    public final void add(k kVar) {
        this.subscriptions.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
        synchronized (this) {
            if (this.producer != null) {
                this.producer.request(j);
                return;
            }
            addToRequested(j);
        }
    }

    private void addToRequested(long j) {
        if (this.requested == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j2 = this.requested + j;
        if (j2 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j2;
        }
    }

    public void setProducer(f fVar) {
        long j;
        boolean z = false;
        synchronized (this) {
            j = this.requested;
            this.producer = fVar;
            if (this.subscriber != null && j == Long.MIN_VALUE) {
                z = true;
            }
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == Long.MIN_VALUE) {
            this.producer.request(Long.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }
}
