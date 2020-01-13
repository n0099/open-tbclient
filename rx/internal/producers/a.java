package rx.internal.producers;

import com.google.android.exoplayer2.Format;
import rx.f;
/* loaded from: classes5.dex */
public final class a implements f {
    static final f nQn = new f() { // from class: rx.internal.producers.a.1
        @Override // rx.f
        public void request(long j) {
        }
    };
    boolean emitting;
    f nQj;
    long nQk;
    long nQl;
    f nQm;
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
                    this.nQk += j;
                } else {
                    this.emitting = true;
                    try {
                        long j2 = this.requested + j;
                        if (j2 < 0) {
                            j2 = Format.OFFSET_SAMPLE_RELATIVE;
                        }
                        this.requested = j2;
                        f fVar = this.nQj;
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
                this.nQl += j;
                return;
            }
            this.emitting = true;
            try {
                long j2 = this.requested;
                if (j2 != Format.OFFSET_SAMPLE_RELATIVE) {
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
                    fVar = nQn;
                }
                this.nQm = fVar;
                return;
            }
            this.emitting = true;
            try {
                this.nQj = fVar;
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
                long j = this.nQk;
                long j2 = this.nQl;
                f fVar = this.nQm;
                if (j == 0 && j2 == 0 && fVar == null) {
                    this.emitting = false;
                    return;
                }
                this.nQk = 0L;
                this.nQl = 0L;
                this.nQm = null;
                long j3 = this.requested;
                if (j3 != Format.OFFSET_SAMPLE_RELATIVE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Format.OFFSET_SAMPLE_RELATIVE) {
                        this.requested = Format.OFFSET_SAMPLE_RELATIVE;
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
                    if (fVar == nQn) {
                        this.nQj = null;
                    } else {
                        this.nQj = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.nQj;
                    if (fVar2 != null && j != 0) {
                        fVar2.request(j);
                    }
                }
            }
        }
    }
}
