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
    private com.google.android.exoplayer2.extractor.g mgu;
    private m miA;
    private long mmV;
    private long mnA;
    private long mnB;
    private a mnC;
    private long mnD;
    private boolean mnE;
    private boolean mnF;
    private final d mny = new d();
    private f mnz;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Format mbs;
        f mnz;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.mgu = gVar;
        this.miA = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mnC = new a();
            this.mnA = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mmV = -1L;
        this.mnB = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(long j, long j2) {
        this.mny.reset();
        if (j == 0) {
            reset(!this.mnE);
        } else if (this.state != 0) {
            this.mmV = this.mnz.fT(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.JB((int) this.mnA);
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
            if (!this.mny.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mnD = fVar.getPosition() - this.mnA;
            z = a(this.mny.dvJ(), this.mnA, this.mnC);
            if (z) {
                this.mnA = fVar.getPosition();
            }
        }
        this.sampleRate = this.mnC.mbs.sampleRate;
        if (!this.mnF) {
            this.miA.h(this.mnC.mbs);
            this.mnF = true;
        }
        if (this.mnC.mnz != null) {
            this.mnz = this.mnC.mnz;
        } else if (fVar.getLength() == -1) {
            this.mnz = new b();
        } else {
            e dvI = this.mny.dvI();
            this.mnz = new com.google.android.exoplayer2.extractor.d.a(this.mnA, fVar.getLength(), this, dvI.mnt + dvI.miK, dvI.mno);
        }
        this.mnC = null;
        this.state = 2;
        this.mny.dvK();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mnz.u(fVar);
        if (u >= 0) {
            kVar.fOW = u;
            return 1;
        }
        if (u < -1) {
            fX(-(u + 2));
        }
        if (!this.mnE) {
            this.mgu.a(this.mnz.dvH());
            this.mnE = true;
        }
        if (this.mnD > 0 || this.mny.y(fVar)) {
            this.mnD = 0L;
            l dvJ = this.mny.dvJ();
            long B = B(dvJ);
            if (B >= 0 && this.mnB + B >= this.mmV) {
                long fV = fV(this.mnB);
                this.miA.a(dvJ, dvJ.dzS());
                this.miA.a(fV, 1, dvJ.dzS(), 0, null);
                this.mmV = -1L;
            }
            this.mnB += B;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fV(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fW(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fX(long j) {
        this.mnB = j;
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
        public long fT(long j) {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dvH() {
            return new l.a(-9223372036854775807L);
        }
    }
}
