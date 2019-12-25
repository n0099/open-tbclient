package com.google.android.exoplayer2.extractor.d;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class h {
    private com.google.android.exoplayer2.extractor.g lZY;
    private m mcf;
    private long mgA;
    private final d mhd = new d();
    private f mhe;
    private long mhf;
    private long mhg;
    private a mhh;
    private long mhi;
    private boolean mhj;
    private boolean mhk;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        Format lUU;
        f mhe;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.lZY = gVar;
        this.mcf = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mhh = new a();
            this.mhf = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mgA = -1L;
        this.mhg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(long j, long j2) {
        this.mhd.reset();
        if (j == 0) {
            reset(!this.mhj);
        } else if (this.state != 0) {
            this.mgA = this.mhe.fP(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jh((int) this.mhf);
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
            if (!this.mhd.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mhi = fVar.getPosition() - this.mhf;
            z = a(this.mhd.dsK(), this.mhf, this.mhh);
            if (z) {
                this.mhf = fVar.getPosition();
            }
        }
        this.sampleRate = this.mhh.lUU.sampleRate;
        if (!this.mhk) {
            this.mcf.h(this.mhh.lUU);
            this.mhk = true;
        }
        if (this.mhh.mhe != null) {
            this.mhe = this.mhh.mhe;
        } else if (fVar.getLength() == -1) {
            this.mhe = new b();
        } else {
            e dsJ = this.mhd.dsJ();
            this.mhe = new com.google.android.exoplayer2.extractor.d.a(this.mhf, fVar.getLength(), this, dsJ.mgY + dsJ.mcp, dsJ.mgT);
        }
        this.mhh = null;
        this.state = 2;
        this.mhd.dsL();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mhe.u(fVar);
        if (u >= 0) {
            kVar.fIt = u;
            return 1;
        }
        if (u < -1) {
            fT(-(u + 2));
        }
        if (!this.mhj) {
            this.lZY.a(this.mhe.dsI());
            this.mhj = true;
        }
        if (this.mhi > 0 || this.mhd.y(fVar)) {
            this.mhi = 0L;
            l dsK = this.mhd.dsK();
            long B = B(dsK);
            if (B >= 0 && this.mhg + B >= this.mgA) {
                long fR = fR(this.mhg);
                this.mcf.a(dsK, dsK.dwW());
                this.mcf.a(fR, 1, dsK.dwW(), 0, null);
                this.mgA = -1L;
            }
            this.mhg += B;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fR(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fS(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fT(long j) {
        this.mhg = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements f {
        private b() {
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fP(long j) {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dsI() {
            return new l.a(-9223372036854775807L);
        }
    }
}
