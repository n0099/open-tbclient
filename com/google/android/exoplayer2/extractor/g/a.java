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
    public static final h mex = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duT() {
            return new e[]{new a()};
        }
    };
    private g meD;
    private m mgH;
    private b mph;
    private int mpi;
    private int mpj;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meD = gVar;
        this.mgH = gVar.dK(0, 1);
        this.mph = null;
        gVar.duU();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mpj = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mph == null) {
            this.mph = c.D(fVar);
            if (this.mph == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mgH.h(Format.a((String) null, "audio/raw", (String) null, this.mph.getBitrate(), 32768, this.mph.dvK(), this.mph.dvJ(), this.mph.dvM(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mpi = this.mph.dvI();
        }
        if (!this.mph.dvL()) {
            c.a(fVar, this.mph);
            this.meD.a(this);
        }
        int a = this.mgH.a(fVar, 32768 - this.mpj, true);
        if (a != -1) {
            this.mpj += a;
        }
        int i = this.mpj / this.mpi;
        if (i > 0) {
            long fN = this.mph.fN(fVar.getPosition() - this.mpj);
            int i2 = i * this.mpi;
            this.mpj -= i2;
            this.mgH.a(fN, 1, i2, this.mpj, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mph.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duQ() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.mph.fL(j);
    }
}
