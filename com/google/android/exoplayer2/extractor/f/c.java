package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdK = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtE() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private static final int mlE = com.google.android.exoplayer2.util.v.Qr("ID3");
    private final long mlF;
    private boolean mlI;
    private final d mlP;
    private final com.google.android.exoplayer2.util.l mlQ;

    public c() {
        this(0L);
    }

    public c(long j) {
        this.mlF = j;
        this.mlP = new d(true);
        this.mlQ = new com.google.android.exoplayer2.util.l(200);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        com.google.android.exoplayer2.util.k kVar = new com.google.android.exoplayer2.util.k(lVar.data);
        int i = 0;
        while (true) {
            fVar.o(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dyj() != mlE) {
                break;
            }
            lVar.skipBytes(3);
            int dyp = lVar.dyp();
            i += dyp + 10;
            fVar.Jr(dyp);
        }
        fVar.dtC();
        fVar.Jr(i);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            fVar.o(lVar.data, 0, 2);
            lVar.setPosition(0);
            if ((lVar.readUnsignedShort() & 65526) != 65520) {
                fVar.dtC();
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                fVar.Jr(i4);
                i2 = 0;
                i3 = 0;
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                fVar.o(lVar.data, 0, 4);
                kVar.setPosition(14);
                int readBits = kVar.readBits(13);
                if (readBits <= 6) {
                    return false;
                }
                fVar.Jr(readBits - 6);
                i3 += readBits;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mlP.a(gVar, new w.d(0, 1));
        gVar.dtF();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mlI = false;
        this.mlP.cxF();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mlQ.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.mlQ.setPosition(0);
        this.mlQ.setLimit(read);
        if (!this.mlI) {
            this.mlP.m(this.mlF, true);
            this.mlI = true;
        }
        this.mlP.I(this.mlQ);
        return 0;
    }
}
