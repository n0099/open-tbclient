package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.d.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private com.google.android.exoplayer2.extractor.g mkC;
    private boolean mkD;
    private h mko;

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
        this.mkC = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        if (this.mko != null) {
            this.mko.O(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        if (this.mko == null) {
            if (!x(fVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            fVar.dtC();
        }
        if (!this.mkD) {
            m dH = this.mkC.dH(0, 1);
            this.mkC.dtF();
            this.mko.a(this.mkC, dH);
            this.mkD = true;
        }
        return this.mko.a(fVar, kVar);
    }

    private boolean x(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.c(fVar, true) && (eVar.type & 2) == 2) {
            int min = Math.min(eVar.mkP, 8);
            l lVar = new l(min);
            fVar.o(lVar.data, 0, min);
            if (b.A(E(lVar))) {
                this.mko = new b();
            } else if (j.A(E(lVar))) {
                this.mko = new j();
            } else if (!g.A(E(lVar))) {
                return false;
            } else {
                this.mko = new g();
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
