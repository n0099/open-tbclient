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
    private com.google.android.exoplayer2.extractor.g meB;
    private m mgF;
    private final d mlF = new d();
    private f mlG;
    private long mlH;
    private long mlI;
    private a mlJ;
    private long mlK;
    private boolean mlL;
    private boolean mlM;
    private long mlc;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Format lZw;
        f mlG;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.meB = gVar;
        this.mgF = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mlJ = new a();
            this.mlH = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mlc = -1L;
        this.mlI = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(long j, long j2) {
        this.mlF.reset();
        if (j == 0) {
            reset(!this.mlL);
        } else if (this.state != 0) {
            this.mlc = this.mlG.fS(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jv((int) this.mlH);
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
            if (!this.mlF.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mlK = fVar.getPosition() - this.mlH;
            z = a(this.mlF.dvj(), this.mlH, this.mlJ);
            if (z) {
                this.mlH = fVar.getPosition();
            }
        }
        this.sampleRate = this.mlJ.lZw.sampleRate;
        if (!this.mlM) {
            this.mgF.h(this.mlJ.lZw);
            this.mlM = true;
        }
        if (this.mlJ.mlG != null) {
            this.mlG = this.mlJ.mlG;
        } else if (fVar.getLength() == -1) {
            this.mlG = new b();
        } else {
            e dvi = this.mlF.dvi();
            this.mlG = new com.google.android.exoplayer2.extractor.d.a(this.mlH, fVar.getLength(), this, dvi.mlA + dvi.mgP, dvi.mlv);
        }
        this.mlJ = null;
        this.state = 2;
        this.mlF.dvk();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mlG.u(fVar);
        if (u >= 0) {
            kVar.fNZ = u;
            return 1;
        }
        if (u < -1) {
            fW(-(u + 2));
        }
        if (!this.mlL) {
            this.meB.a(this.mlG.dvh());
            this.mlL = true;
        }
        if (this.mlK > 0 || this.mlF.y(fVar)) {
            this.mlK = 0L;
            l dvj = this.mlF.dvj();
            long B = B(dvj);
            if (B >= 0 && this.mlI + B >= this.mlc) {
                long fU = fU(this.mlI);
                this.mgF.a(dvj, dvj.dzs());
                this.mgF.a(fU, 1, dvj.dzs(), 0, null);
                this.mlc = -1L;
            }
            this.mlI += B;
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
        this.mlI = j;
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
        public com.google.android.exoplayer2.extractor.l dvh() {
            return new l.a(-9223372036854775807L);
        }
    }
}
