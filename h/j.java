package h;
/* loaded from: classes7.dex */
public abstract class j<T> implements e<T>, k {
    public static final long NOT_SET = Long.MIN_VALUE;
    public f producer;
    public long requested;
    public final j<?> subscriber;
    public final h.o.d.h subscriptions;

    public j() {
        this(null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public final void add(k kVar) {
        this.subscriptions.a(kVar);
    }

    @Override // h.k
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long j) {
        if (j >= 0) {
            synchronized (this) {
                if (this.producer != null) {
                    this.producer.request(j);
                    return;
                }
                addToRequested(j);
                return;
            }
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j);
    }

    public void setProducer(f fVar) {
        long j;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = fVar;
            z = this.subscriber != null && j == Long.MIN_VALUE;
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == Long.MIN_VALUE) {
            this.producer.request(Long.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }

    @Override // h.k
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public j(j<?> jVar) {
        this(jVar, true);
    }

    public j(j<?> jVar, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = jVar;
        this.subscriptions = (!z || jVar == null) ? new h.o.d.h() : jVar.subscriptions;
    }
}
