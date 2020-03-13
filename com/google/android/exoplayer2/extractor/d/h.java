package com.google.android.exoplayer2.extractor.d;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class h {
    private com.google.android.exoplayer2.extractor.g meO;
    private m mgS;
    private final d mlS = new d();
    private f mlT;
    private long mlU;
    private long mlV;
    private a mlW;
    private long mlX;
    private boolean mlY;
    private boolean mlZ;
    private long mlp;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Format lZJ;
        f mlT;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.meO = gVar;
        this.mgS = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mlW = new a();
            this.mlU = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mlp = -1L;
        this.mlV = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(long j, long j2) {
        this.mlS.reset();
        if (j == 0) {
            reset(!this.mlY);
        } else if (this.state != 0) {
            this.mlp = this.mlT.fS(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jv((int) this.mlU);
                this.state = 2;
                return 0;
            case 2:
                return d(fVar, kVar);
            default:
                throw new IllegalStateException();
        }
    }

    private int z(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.mlS.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mlX = fVar.getPosition() - this.mlU;
            z = a(this.mlS.dvm(), this.mlU, this.mlW);
            if (z) {
                this.mlU = fVar.getPosition();
            }
        }
        this.sampleRate = this.mlW.lZJ.sampleRate;
        if (!this.mlZ) {
            this.mgS.h(this.mlW.lZJ);
            this.mlZ = true;
        }
        if (this.mlW.mlT != null) {
            this.mlT = this.mlW.mlT;
        } else if (fVar.getLength() == -1) {
            this.mlT = new b();
        } else {
            e dvl = this.mlS.dvl();
            this.mlT = new com.google.android.exoplayer2.extractor.d.a(this.mlU, fVar.getLength(), this, dvl.mlN + dvl.mhc, dvl.mlI);
        }
        this.mlW = null;
        this.state = 2;
        this.mlS.dvn();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mlT.u(fVar);
        if (u >= 0) {
            kVar.fOo = u;
            return 1;
        }
        if (u < -1) {
            fW(-(u + 2));
        }
        if (!this.mlY) {
            this.meO.a(this.mlT.dvk());
            this.mlY = true;
        }
        if (this.mlX > 0 || this.mlS.y(fVar)) {
            this.mlX = 0L;
            l dvm = this.mlS.dvm();
            long B = B(dvm);
            if (B >= 0 && this.mlV + B >= this.mlp) {
                long fU = fU(this.mlV);
                this.mgS.a(dvm, dvm.dzv());
                this.mgS.a(fU, 1, dvm.dzv(), 0, null);
                this.mlp = -1L;
            }
            this.mlV += B;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fU(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fV(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fW(long j) {
        this.mlV = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements f {
        private b() {
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fS(long j) {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dvk() {
            return new l.a(-9223372036854775807L);
        }
    }
}
