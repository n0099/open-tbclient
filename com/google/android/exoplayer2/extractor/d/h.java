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
    private com.google.android.exoplayer2.extractor.g meD;
    private m mgH;
    private final d mlH = new d();
    private f mlI;
    private long mlJ;
    private long mlK;
    private a mlL;
    private long mlM;
    private boolean mlN;
    private boolean mlO;
    private long mle;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Format lZy;
        f mlI;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.meD = gVar;
        this.mgH = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mlL = new a();
            this.mlJ = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mle = -1L;
        this.mlK = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(long j, long j2) {
        this.mlH.reset();
        if (j == 0) {
            reset(!this.mlN);
        } else if (this.state != 0) {
            this.mle = this.mlI.fS(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jv((int) this.mlJ);
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
            if (!this.mlH.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mlM = fVar.getPosition() - this.mlJ;
            z = a(this.mlH.dvl(), this.mlJ, this.mlL);
            if (z) {
                this.mlJ = fVar.getPosition();
            }
        }
        this.sampleRate = this.mlL.lZy.sampleRate;
        if (!this.mlO) {
            this.mgH.h(this.mlL.lZy);
            this.mlO = true;
        }
        if (this.mlL.mlI != null) {
            this.mlI = this.mlL.mlI;
        } else if (fVar.getLength() == -1) {
            this.mlI = new b();
        } else {
            e dvk = this.mlH.dvk();
            this.mlI = new com.google.android.exoplayer2.extractor.d.a(this.mlJ, fVar.getLength(), this, dvk.mlC + dvk.mgR, dvk.mlx);
        }
        this.mlL = null;
        this.state = 2;
        this.mlH.dvm();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mlI.u(fVar);
        if (u >= 0) {
            kVar.fOb = u;
            return 1;
        }
        if (u < -1) {
            fW(-(u + 2));
        }
        if (!this.mlN) {
            this.meD.a(this.mlI.dvj());
            this.mlN = true;
        }
        if (this.mlM > 0 || this.mlH.y(fVar)) {
            this.mlM = 0L;
            l dvl = this.mlH.dvl();
            long B = B(dvl);
            if (B >= 0 && this.mlK + B >= this.mle) {
                long fU = fU(this.mlK);
                this.mgH.a(dvl, dvl.dzu());
                this.mgH.a(fU, 1, dvl.dzu(), 0, null);
                this.mle = -1L;
            }
            this.mlK += B;
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
        this.mlK = j;
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
        public com.google.android.exoplayer2.extractor.l dvj() {
            return new l.a(-9223372036854775807L);
        }
    }
}
