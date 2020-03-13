package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h meI = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duU() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private static final int mmC = com.google.android.exoplayer2.util.v.QF("ID3");
    private final long mmD;
    private boolean mmG;
    private final d mmN;
    private final com.google.android.exoplayer2.util.l mmO;

    public c() {
        this(0L);
    }

    public c(long j) {
        this.mmD = j;
        this.mmN = new d(true);
        this.mmO = new com.google.android.exoplayer2.util.l(200);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        com.google.android.exoplayer2.util.k kVar = new com.google.android.exoplayer2.util.k(lVar.data);
        int i = 0;
        while (true) {
            fVar.s(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dzy() != mmC) {
                break;
            }
            lVar.skipBytes(3);
            int dzE = lVar.dzE();
            i += dzE + 10;
            fVar.Jw(dzE);
        }
        fVar.duS();
        fVar.Jw(i);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            fVar.s(lVar.data, 0, 2);
            lVar.setPosition(0);
            if ((lVar.readUnsignedShort() & 65526) != 65520) {
                fVar.duS();
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                fVar.Jw(i4);
                i2 = 0;
                i3 = 0;
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                fVar.s(lVar.data, 0, 4);
                kVar.setPosition(14);
                int readBits = kVar.readBits(13);
                if (readBits <= 6) {
                    return false;
                }
                fVar.Jw(readBits - 6);
                i3 += readBits;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mmN.a(gVar, new w.d(0, 1));
        gVar.duV();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mmG = false;
        this.mmN.cze();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mmO.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.mmO.setPosition(0);
        this.mmO.setLimit(read);
        if (!this.mmG) {
            this.mmN.o(this.mmD, true);
            this.mmG = true;
        }
        this.mmN.I(this.mmO);
        return 0;
    }
}
