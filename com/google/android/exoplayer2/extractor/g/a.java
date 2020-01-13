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
/* loaded from: classes5.dex */
public final class a implements e, l {
    public static final h mdK = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtE() {
            return new e[]{new a()};
        }
    };
    private g mdQ;
    private m mfU;
    private b mou;
    private int mov;
    private int mow;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdQ = gVar;
        this.mfU = gVar.dH(0, 1);
        this.mou = null;
        gVar.dtF();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mow = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mou == null) {
            this.mou = c.D(fVar);
            if (this.mou == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mfU.h(Format.a((String) null, "audio/raw", (String) null, this.mou.duu(), 32768, this.mou.duw(), this.mou.duv(), this.mou.duy(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mov = this.mou.dut();
        }
        if (!this.mou.dux()) {
            c.a(fVar, this.mou);
            this.mdQ.a(this);
        }
        int a = this.mfU.a(fVar, 32768 - this.mow, true);
        if (a != -1) {
            this.mow += a;
        }
        int i = this.mow / this.mov;
        if (i > 0) {
            long fP = this.mou.fP(fVar.getPosition() - this.mow);
            int i2 = i * this.mov;
            this.mow -= i2;
            this.mfU.a(fP, 1, i2, this.mow, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.mou.dso();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtB() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return this.mou.fN(j);
    }
}
