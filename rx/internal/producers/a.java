package rx.internal.producers;

import rx.f;
/* loaded from: classes2.dex */
public final class a implements f {
    static final f iOK = new f() { // from class: rx.internal.producers.a.1
        @Override // rx.f
        public void request(long j) {
        }
    };
    boolean emitting;
    long iMa;
    f iOH;
    long iOI;
    f iOJ;
    long requested;

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // rx.f
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.iMa += j;
                } else {
                    this.emitting = true;
                    try {
                        long j2 = this.requested + j;
                        if (j2 < 0) {
                            j2 = Long.MAX_VALUE;
                        }
                        this.requested = j2;
                        f fVar = this.iOH;
                        if (fVar != null) {
                            fVar.request(j);
                        }
                        cfd();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.emitting = false;
                            throw th;
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void dQ(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.emitting) {
                this.iOI += j;
                return;
            }
            this.emitting = true;
            try {
                long j2 = this.requested;
                if (j2 != Long.MAX_VALUE) {
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.requested = j3;
                }
                cfd();
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void setProducer(f fVar) {
        synchronized (this) {
            if (this.emitting) {
                if (fVar == null) {
                    fVar = iOK;
                }
                this.iOJ = fVar;
                return;
            }
            this.emitting = true;
            try {
                this.iOH = fVar;
                if (fVar != null) {
                    fVar.request(this.requested);
                }
                cfd();
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    public void cfd() {
        while (true) {
            synchronized (this) {
                long j = this.iMa;
                long j2 = this.iOI;
                f fVar = this.iOJ;
                if (j == 0 && j2 == 0 && fVar == null) {
                    this.emitting = false;
                    return;
                }
                this.iMa = 0L;
                this.iOI = 0L;
                this.iOJ = null;
                long j3 = this.requested;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.requested = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.requested = j3;
                    }
                }
                if (fVar != null) {
                    if (fVar == iOK) {
                        this.iOH = null;
                    } else {
                        this.iOH = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.iOH;
                    if (fVar2 != null && j != 0) {
                        fVar2.request(j);
                    }
                }
            }
        }
    }
}
