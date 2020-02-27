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
    public static final h mev = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duR() {
            return new e[]{new a()};
        }
    };
    private g meB;
    private m mgF;
    private b mpf;
    private int mpg;
    private int mph;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meB = gVar;
        this.mgF = gVar.dK(0, 1);
        this.mpf = null;
        gVar.duS();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mph = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mpf == null) {
            this.mpf = c.D(fVar);
            if (this.mpf == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mgF.h(Format.a((String) null, "audio/raw", (String) null, this.mpf.getBitrate(), 32768, this.mpf.dvI(), this.mpf.dvH(), this.mpf.dvK(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mpg = this.mpf.dvG();
        }
        if (!this.mpf.dvJ()) {
            c.a(fVar, this.mpf);
            this.meB.a(this);
        }
        int a = this.mgF.a(fVar, 32768 - this.mph, true);
        if (a != -1) {
            this.mph += a;
        }
        int i = this.mph / this.mpg;
        if (i > 0) {
            long fN = this.mpf.fN(fVar.getPosition() - this.mph);
            int i2 = i * this.mpg;
            this.mph -= i2;
            this.mgF.a(fN, 1, i2, this.mph, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mpf.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duO() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.mpf.fL(j);
    }
}
