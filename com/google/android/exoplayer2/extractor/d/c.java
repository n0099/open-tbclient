package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.d.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private com.google.android.exoplayer2.extractor.g mkH;
    private boolean mkI;
    private h mkt;

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
        this.mkH = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        if (this.mkt != null) {
            this.mkt.O(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        if (this.mkt == null) {
            if (!x(fVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            fVar.dtE();
        }
        if (!this.mkI) {
            m dH = this.mkH.dH(0, 1);
            this.mkH.dtH();
            this.mkt.a(this.mkH, dH);
            this.mkI = true;
        }
        return this.mkt.a(fVar, kVar);
    }

    private boolean x(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.c(fVar, true) && (eVar.type & 2) == 2) {
            int min = Math.min(eVar.mkU, 8);
            l lVar = new l(min);
            fVar.o(lVar.data, 0, min);
            if (b.A(E(lVar))) {
                this.mkt = new b();
            } else if (j.A(E(lVar))) {
                this.mkt = new j();
            } else if (!g.A(E(lVar))) {
                return false;
            } else {
                this.mkt = new g();
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
