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
/* loaded from: classes4.dex */
public final class a implements e, l {
    public static final h lZS = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dss() {
            return new e[]{new a()};
        }
    };
    private g lZY;
    private m mcf;
    private b mkF;
    private int mkG;
    private int mkH;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.lZY = gVar;
        this.mcf = gVar.dJ(0, 1);
        this.mkF = null;
        gVar.dst();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mkH = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mkF == null) {
            this.mkF = c.D(fVar);
            if (this.mkF == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mcf.h(Format.a((String) null, "audio/raw", (String) null, this.mkF.dtj(), 32768, this.mkF.dtl(), this.mkF.dtk(), this.mkF.dtn(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mkG = this.mkF.dti();
        }
        if (!this.mkF.dtm()) {
            c.a(fVar, this.mkF);
            this.lZY.a(this);
        }
        int a = this.mcf.a(fVar, 32768 - this.mkH, true);
        if (a != -1) {
            this.mkH += a;
        }
        int i = this.mkH / this.mkG;
        if (i > 0) {
            long fK = this.mkF.fK(fVar.getPosition() - this.mkH);
            int i2 = i * this.mkG;
            this.mkH -= i2;
            this.mcf.a(fK, 1, i2, this.mkH, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.mkF.drc();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        return this.mkF.fI(j);
    }
}
