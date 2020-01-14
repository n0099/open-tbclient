package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class a implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mdP = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dtG() {
            return new com.google.android.exoplayer2.extractor.e[]{new a()};
        }
    };
    private static final int mlJ = com.google.android.exoplayer2.util.v.Qr("ID3");
    private final long mlK;
    private final b mlL;
    private final com.google.android.exoplayer2.util.l mlM;
    private boolean mlN;

    public a() {
        this(0L);
    }

    public a(long j) {
        this.mlK = j;
        this.mlL = new b();
        this.mlM = new com.google.android.exoplayer2.util.l(2786);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        int i = 0;
        while (true) {
            fVar.o(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dyl() != mlJ) {
                break;
            }
            lVar.skipBytes(3);
            int dyr = lVar.dyr();
            i += dyr + 10;
            fVar.Jr(dyr);
        }
        fVar.dtE();
        fVar.Jr(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            fVar.o(lVar.data, 0, 5);
            lVar.setPosition(0);
            if (lVar.readUnsignedShort() != 2935) {
                fVar.dtE();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                fVar.Jr(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int al = com.google.android.exoplayer2.audio.a.al(lVar.data);
                if (al == -1) {
                    return false;
                }
                fVar.Jr(al - 5);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mlL.a(gVar, new w.d(0, 1));
        gVar.dtH();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mlN = false;
        this.mlL.cxH();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mlM.data, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.mlM.setPosition(0);
        this.mlM.setLimit(read);
        if (!this.mlN) {
            this.mlL.m(this.mlK, true);
            this.mlN = true;
        }
        this.mlL.I(this.mlM);
        return 0;
    }
}
