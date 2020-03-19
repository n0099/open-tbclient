package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.f.w;
import com.google.android.exoplayer2.extractor.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class a implements com.google.android.exoplayer2.extractor.e {
    public static final com.google.android.exoplayer2.extractor.h mgo = new com.google.android.exoplayer2.extractor.h() { // from class: com.google.android.exoplayer2.extractor.f.a.1
        @Override // com.google.android.exoplayer2.extractor.h
        public com.google.android.exoplayer2.extractor.e[] dvr() {
            return new com.google.android.exoplayer2.extractor.e[]{new a()};
        }
    };
    private static final int moi = com.google.android.exoplayer2.util.v.QF("ID3");
    private final long moj;
    private final b mok;
    private final com.google.android.exoplayer2.util.l mol;
    private boolean mom;

    public a() {
        this(0L);
    }

    public a(long j) {
        this.moj = j;
        this.mok = new b();
        this.mol = new com.google.android.exoplayer2.util.l(2786);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(10);
        int i = 0;
        while (true) {
            fVar.s(lVar.data, 0, 10);
            lVar.setPosition(0);
            if (lVar.dzV() != moi) {
                break;
            }
            lVar.skipBytes(3);
            int dAb = lVar.dAb();
            i += dAb + 10;
            fVar.JC(dAb);
        }
        fVar.dvp();
        fVar.JC(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            fVar.s(lVar.data, 0, 5);
            lVar.setPosition(0);
            if (lVar.readUnsignedShort() != 2935) {
                fVar.dvp();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                fVar.JC(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int aq = com.google.android.exoplayer2.audio.a.aq(lVar.data);
                if (aq == -1) {
                    return false;
                }
                fVar.JC(aq - 5);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mok.a(gVar, new w.d(0, 1));
        gVar.dvs();
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mom = false;
        this.mok.czx();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int read = fVar.read(this.mol.data, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.mol.setPosition(0);
        this.mol.setLimit(read);
        if (!this.mom) {
            this.mok.p(this.moj, true);
            this.mom = true;
        }
        this.mok.I(this.mol);
        return 0;
    }
}
