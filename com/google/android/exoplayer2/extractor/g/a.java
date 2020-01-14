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
    public static final h mdP = new h() { // from class: com.google.android.exoplayer2.extractor.g.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtG() {
            return new e[]{new a()};
        }
    };
    private g mdV;
    private m mfZ;
    private int moA;
    private int moB;
    private b moz;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.D(fVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdV = gVar;
        this.mfZ = gVar.dH(0, 1);
        this.moz = null;
        gVar.dtH();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.moB = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.moz == null) {
            this.moz = c.D(fVar);
            if (this.moz == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.mfZ.h(Format.a((String) null, "audio/raw", (String) null, this.moz.duw(), 32768, this.moz.duy(), this.moz.dux(), this.moz.duA(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.moA = this.moz.duv();
        }
        if (!this.moz.duz()) {
            c.a(fVar, this.moz);
            this.mdV.a(this);
        }
        int a = this.mfZ.a(fVar, 32768 - this.moB, true);
        if (a != -1) {
            this.moB += a;
        }
        int i = this.moB / this.moA;
        if (i > 0) {
            long fP = this.moz.fP(fVar.getPosition() - this.moB);
            int i2 = i * this.moA;
            this.moB -= i2;
            this.mfZ.a(fP, 1, i2, this.moB, null);
        }
        return a == -1 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.moz.dsq();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtD() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return this.moz.fN(j);
    }
}
