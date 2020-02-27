package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mev = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.d.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duR() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private h mkZ;
    private com.google.android.exoplayer2.extractor.g mln;
    private boolean mlo;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        try {
            return x(fVar);
        } catch (ParserException e) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mln = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        if (this.mkZ != null) {
            this.mkZ.N(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        if (this.mkZ == null) {
            if (!x(fVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            fVar.duP();
        }
        if (!this.mlo) {
            m dK = this.mln.dK(0, 1);
            this.mln.duS();
            this.mkZ.a(this.mln, dK);
            this.mlo = true;
        }
        return this.mkZ.a(fVar, kVar);
    }

    private boolean x(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.c(fVar, true) && (eVar.type & 2) == 2) {
            int min = Math.min(eVar.mlA, 8);
            l lVar = new l(min);
            fVar.s(lVar.data, 0, min);
            if (b.A(E(lVar))) {
                this.mkZ = new b();
            } else if (j.A(E(lVar))) {
                this.mkZ = new j();
            } else if (!g.A(E(lVar))) {
                return false;
            } else {
                this.mkZ = new g();
            }
            return true;
        }
        return false;
    }

    private static l E(l lVar) {
        lVar.setPosition(0);
        return lVar;
    }
}
