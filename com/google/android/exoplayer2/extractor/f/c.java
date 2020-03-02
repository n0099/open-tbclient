package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mex = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] duT() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private static final int mmr = com.google.android.exoplayer2.util.v.QE("ID3");
    private final d mmC;
    private final com.google.android.exoplayer2.util.l mmD;
    private final long mms;
    private boolean mmv;

    public c() {
        this(0L);
    }

    public c(long j) {
        this.mms = j;
        this.mmC = new d(true);
        this.mmD = new com.google.android.exoplayer2.util.l(200);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        com.google.android.exoplayer2.util.k kVar = new com.google.android.exoplayer2.util.k(lVar.data);
        int i = 0;
        while (true) {
            fVar.s(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dzx() != mmr) {
                break;
            }
            lVar.skipBytes(3);
            int dzD = lVar.dzD();
            i += dzD + 10;
            fVar.Jw(dzD);
        }
        fVar.duR();
        fVar.Jw(i);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            fVar.s(lVar.data, 0, 2);
            lVar.setPosition(0);
            if ((lVar.readUnsignedShort() & 65526) != 65520) {
                fVar.duR();
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
        this.mmC.a(gVar, new w.d(0, 1));
        gVar.duU();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mmv = false;
        this.mmC.czd();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mmD.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.mmD.setPosition(0);
        this.mmD.setLimit(read);
        if (!this.mmv) {
            this.mmC.o(this.mms, true);
            this.mmv = true;
        }
        this.mmC.I(this.mmD);
        return 0;
    }
}
