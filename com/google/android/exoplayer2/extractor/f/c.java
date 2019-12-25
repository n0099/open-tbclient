package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class c implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.c.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new c()};
        }
    };
    private static final int mhO = com.google.android.exoplayer2.util.v.Qg("ID3");
    private final long mhP;
    private boolean mhS;
    private final d mhZ;
    private final com.google.android.exoplayer2.util.l mia;

    public c() {
        this(0L);
    }

    public c(long j) {
        this.mhP = j;
        this.mhZ = new d(true);
        this.mia = new com.google.android.exoplayer2.util.l(200);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        com.google.android.exoplayer2.util.k kVar = new com.google.android.exoplayer2.util.k(lVar.data);
        int i = 0;
        while (true) {
            fVar.p(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dwZ() != mhO) {
                break;
            }
            lVar.skipBytes(3);
            int dxf = lVar.dxf();
            i += dxf + 10;
            fVar.Ji(dxf);
        }
        fVar.dsq();
        fVar.Ji(i);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            fVar.p(lVar.data, 0, 2);
            lVar.setPosition(0);
            if ((lVar.readUnsignedShort() & 65526) != 65520) {
                fVar.dsq();
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                fVar.Ji(i4);
                i2 = 0;
                i3 = 0;
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                fVar.p(lVar.data, 0, 4);
                kVar.setPosition(14);
                int readBits = kVar.readBits(13);
                if (readBits <= 6) {
                    return false;
                }
                fVar.Ji(readBits - 6);
                i3 += readBits;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mhZ.a(gVar, new w.d(0, 1));
        gVar.dst();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mhS = false;
        this.mhZ.cwy();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mia.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.mia.setPosition(0);
        this.mia.setLimit(read);
        if (!this.mhS) {
            this.mhZ.m(this.mhP, true);
            this.mhS = true;
        }
        this.mhZ.I(this.mia);
        return 0;
    }
}
