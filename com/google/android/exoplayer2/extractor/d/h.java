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
    private com.google.android.exoplayer2.extractor.g mdQ;
    private m mfU;
    private final d mkU = new d();
    private f mkV;
    private long mkW;
    private long mkX;
    private a mkY;
    private long mkZ;
    private long mkr;
    private boolean mla;
    private boolean mlb;
    private int sampleRate;
    private int state;

    protected abstract long B(l lVar);

    protected abstract boolean a(l lVar, long j, a aVar) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        Format lYL;
        f mkV;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.extractor.g gVar, m mVar) {
        this.mdQ = gVar;
        this.mfU = mVar;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z) {
        if (z) {
            this.mkY = new a();
            this.mkW = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.mkr = -1L;
        this.mkX = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(long j, long j2) {
        this.mkU.reset();
        if (j == 0) {
            reset(!this.mla);
        } else if (this.state != 0) {
            this.mkr = this.mkV.fU(j2);
            this.state = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        switch (this.state) {
            case 0:
                return z(fVar);
            case 1:
                fVar.Jq((int) this.mkW);
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
            if (!this.mkU.y(fVar)) {
                this.state = 3;
                return -1;
            }
            this.mkZ = fVar.getPosition() - this.mkW;
            z = a(this.mkU.dtW(), this.mkW, this.mkY);
            if (z) {
                this.mkW = fVar.getPosition();
            }
        }
        this.sampleRate = this.mkY.lYL.sampleRate;
        if (!this.mlb) {
            this.mfU.h(this.mkY.lYL);
            this.mlb = true;
        }
        if (this.mkY.mkV != null) {
            this.mkV = this.mkY.mkV;
        } else if (fVar.getLength() == -1) {
            this.mkV = new b();
        } else {
            e dtV = this.mkU.dtV();
            this.mkV = new com.google.android.exoplayer2.extractor.d.a(this.mkW, fVar.getLength(), this, dtV.mkP + dtV.mge, dtV.mkK);
        }
        this.mkY = null;
        this.state = 2;
        this.mkU.dtX();
        return 0;
    }

    private int d(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        long u = this.mkV.u(fVar);
        if (u >= 0) {
            kVar.fLD = u;
            return 1;
        }
        if (u < -1) {
            fY(-(u + 2));
        }
        if (!this.mla) {
            this.mdQ.a(this.mkV.dtU());
            this.mla = true;
        }
        if (this.mkZ > 0 || this.mkU.y(fVar)) {
            this.mkZ = 0L;
            l dtW = this.mkU.dtW();
            long B = B(dtW);
            if (B >= 0 && this.mkX + B >= this.mkr) {
                long fW = fW(this.mkX);
                this.mfU.a(dtW, dtW.dyg());
                this.mfU.a(fW, 1, dtW.dyg(), 0, null);
                this.mkr = -1L;
            }
            this.mkX += B;
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
        this.mkX = j;
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
        public com.google.android.exoplayer2.extractor.l dtU() {
            return new l.a(-9223372036854775807L);
        }
    }
}
