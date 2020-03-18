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
    public static final h mgo = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dvr() {
            return new e[]{new a()};
        }
    };
    private g mgu;
    private m miA;
    private b mqY;
    private int mqZ;
    private int mra;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mgu = gVar;
        this.miA = gVar.dL(0, 1);
        this.mqY = null;
        gVar.dvs();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mra = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mqY == null) {
            this.mqY = c.D(fVar);
            if (this.mqY == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.miA.h(Format.a((String) null, "audio/raw", (String) null, this.mqY.getBitrate(), 32768, this.mqY.dwi(), this.mqY.dwh(), this.mqY.dwk(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.mqZ = this.mqY.dwg();
        }
        if (!this.mqY.dwj()) {
            c.a(fVar, this.mqY);
            this.mgu.a(this);
        }
        int a = this.miA.a(fVar, 32768 - this.mra, true);
        if (a != -1) {
            this.mra += a;
        }
        int i = this.mra / this.mqZ;
        if (i > 0) {
            long fO = this.mqY.fO(fVar.getPosition() - this.mra);
            int i2 = i * this.mqZ;
            this.mra -= i2;
            this.miA.a(fO, 1, i2, this.mra, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mqY.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        return this.mqY.fM(j);
    }
}
