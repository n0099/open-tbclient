package rx.internal.producers;

import rx.f;
/* loaded from: classes6.dex */
public final class a implements f {
    static final f nJb = new f() { // from class: rx.internal.producers.a.1
        @Override // rx.f
        public void request(long j) {
        }
    };
    boolean emitting;
    f nIX;
    long nIY;
    long nIZ;
    f nJa;
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
                    this.nIY += j;
                } else {
                    this.emitting = true;
                    try {
                        long j2 = this.requested + j;
                        if (j2 < 0) {
                            j2 = Long.MAX_VALUE;
                        }
                        this.requested = j2;
                        f fVar = this.nIX;
                        if (fVar != null) {
                            fVar.request(j);
                        }
                        emitLoop();
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
    public void produced(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.emitting) {
                this.nIZ += j;
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
                emitLoop();
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
                    fVar = nJb;
                }
                this.nJa = fVar;
                return;
            }
            this.emitting = true;
            try {
                this.nIX = fVar;
                if (fVar != null) {
                    fVar.request(this.requested);
                }
                emitLoop();
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    public void emitLoop() {
        while (true) {
            synchronized (this) {
                long j = this.nIY;
                long j2 = this.nIZ;
                f fVar = this.nJa;
                if (j == 0 && j2 == 0 && fVar == null) {
                    this.emitting = false;
                    return;
                }
                this.nIY = 0L;
                this.nIZ = 0L;
                this.nJa = null;
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
                    if (fVar == nJb) {
                        this.nIX = null;
                    } else {
                        this.nIX = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.nIX;
                    if (fVar2 != null && j != 0) {
                        fVar2.request(j);
                    }
                }
            }
        }
    }
}
