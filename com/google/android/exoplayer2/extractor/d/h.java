package com.google.android.exoplayer2.extractor.d;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class h {
    private com.google.android.exoplayer2.extractor.g mdV;
    private m mfZ;
    private final d mkZ = new d();
    private long mkw;
    private f mla;
    private long mlb;
    private long mlc;
    private a mld;
    private long mle;
    private boolean mlf;
    private boolean mlg;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        Format lYQ;
        f mla;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.mdV = gVar;
        this.mfZ = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mld = new a();
            this.mlb = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mkw = -1L;
        this.mlc = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(long j, long j2) {
        this.mkZ.reset();
        if (j == 0) {
            reset(!this.mlf);
        } else if (this.state != 0) {
            this.mkw = this.mla.fU(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jq((int) this.mlb);
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
            if (!this.mkZ.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mle = fVar.getPosition() - this.mlb;
            z = a(this.mkZ.dtY(), this.mlb, this.mld);
            if (z) {
                this.mlb = fVar.getPosition();
            }
        }
        this.sampleRate = this.mld.lYQ.sampleRate;
        if (!this.mlg) {
            this.mfZ.h(this.mld.lYQ);
            this.mlg = true;
        }
        if (this.mld.mla != null) {
            this.mla = this.mld.mla;
        } else if (fVar.getLength() == -1) {
            this.mla = new b();
        } else {
            e dtX = this.mkZ.dtX();
            this.mla = new com.google.android.exoplayer2.extractor.d.a(this.mlb, fVar.getLength(), this, dtX.mkU + dtX.mgj, dtX.mkP);
        }
        this.mld = null;
        this.state = 2;
        this.mkZ.dtZ();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mla.u(fVar);
        if (u >= 0) {
            kVar.fLD = u;
            return 1;
        }
        if (u < -1) {
            fY(-(u + 2));
        }
        if (!this.mlf) {
            this.mdV.a(this.mla.dtW());
            this.mlf = true;
        }
        if (this.mle > 0 || this.mkZ.y(fVar)) {
            this.mle = 0L;
            l dtY = this.mkZ.dtY();
            long B = B(dtY);
            if (B >= 0 && this.mlc + B >= this.mkw) {
                long fW = fW(this.mlc);
                this.mfZ.a(dtY, dtY.dyi());
                this.mfZ.a(fW, 1, dtY.dyi(), 0, null);
                this.mkw = -1L;
            }
            this.mlc += B;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fW(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long fX(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fY(long j) {
        this.mlc = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements f {
        private b() {
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fU(long j) {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dtW() {
            return new l.a(-9223372036854775807L);
        }
    }
}
