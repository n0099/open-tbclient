package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h lZS = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dss() {
            return new com.google.android.exoplayer2.extractor.e[]{new a()};
        }
    };
    private static final int mhO = com.google.android.exoplayer2.util.v.Qg("ID3");
    private final long mhP;
    private final b mhQ;
    private final com.google.android.exoplayer2.util.l mhR;
    private boolean mhS;

    public a() {
        this(0L);
    }

    public a(long j) {
        this.mhP = j;
        this.mhQ = new b();
        this.mhR = new com.google.android.exoplayer2.util.l(2786);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
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
        int i3 = i;
        while (true) {
            fVar.p(lVar.data, 0, 5);
            lVar.setPosition(0);
            if (lVar.readUnsignedShort() != 2935) {
                fVar.dsq();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                fVar.Ji(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int am = com.google.android.exoplayer2.audio.a.am(lVar.data);
                if (am == -1) {
                    return false;
                }
                fVar.Ji(am - 5);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mhQ.a(gVar, new w.d(0, 1));
        gVar.dst();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mhS = false;
        this.mhQ.cwy();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mhR.data, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.mhR.setPosition(0);
        this.mhR.setLimit(read);
        if (!this.mhS) {
            this.mhQ.m(this.mhP, true);
            this.mhS = true;
        }
        this.mhQ.I(this.mhR);
        return 0;
    }
}
