package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class a implements e, l {
    public static final h meI = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duU() {
            return new e[]{new a()};
        }
    };
    private g meO;
    private m mgS;
    private b mps;
    private int mpt;
    private int mpu;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meO = gVar;
        this.mgS = gVar.dK(0, 1);
        this.mps = null;
        gVar.duV();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mpu = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mps == null) {
            this.mps = c.D(fVar);
            if (this.mps == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mgS.h(Format.a((String) null, "audio/raw", (String) null, this.mps.getBitrate(), 32768, this.mps.dvL(), this.mps.dvK(), this.mps.dvN(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mpt = this.mps.dvJ();
        }
        if (!this.mps.dvM()) {
            c.a(fVar, this.mps);
            this.meO.a(this);
        }
        int a = this.mgS.a(fVar, 32768 - this.mpu, true);
        if (a != -1) {
            this.mpu += a;
        }
        int i = this.mpu / this.mpt;
        if (i > 0) {
            long fN = this.mps.fN(fVar.getPosition() - this.mpu);
            int i2 = i * this.mpt;
            this.mpu -= i2;
            this.mgS.a(fN, 1, i2, this.mpu, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mps.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duR() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.mps.fL(j);
    }
}
