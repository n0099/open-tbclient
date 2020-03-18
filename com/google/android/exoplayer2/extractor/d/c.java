package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.d.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private h mmS;
    private com.google.android.exoplayer2.extractor.g mng;
    private boolean mnh;

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
        this.mng = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        if (this.mmS != null) {
            this.mmS.N(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        if (this.mmS == null) {
            if (!x(fVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            fVar.dvp();
        }
        if (!this.mnh) {
            m dL = this.mng.dL(0, 1);
            this.mng.dvs();
            this.mmS.a(this.mng, dL);
            this.mnh = true;
        }
        return this.mmS.a(fVar, kVar);
    }

    private boolean x(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.c(fVar, true) && (eVar.type & 2) == 2) {
            int min = Math.min(eVar.mnt, 8);
            l lVar = new l(min);
            fVar.s(lVar.data, 0, min);
            if (b.A(E(lVar))) {
                this.mmS = new b();
            } else if (j.A(E(lVar))) {
                this.mmS = new j();
            } else if (!g.A(E(lVar))) {
                return false;
            } else {
                this.mmS = new g();
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
