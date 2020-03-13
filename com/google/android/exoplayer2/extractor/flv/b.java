package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class b implements e, l {
    public static final h meI = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duU() {
            return new e[]{new b()};
        }
    };
    private static final int meJ = v.QF("FLV");
    public int Xk;
    private g meO;
    private int meQ;
    public int meR;
    public long meS;
    private a meT;
    private d meU;
    private c meV;
    private final com.google.android.exoplayer2.util.l meK = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l meL = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l meM = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l meN = new com.google.android.exoplayer2.util.l();
    private int meP = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.s(this.meK.data, 0, 3);
        this.meK.setPosition(0);
        if (this.meK.dzy() != meJ) {
            return false;
        }
        fVar.s(this.meK.data, 0, 2);
        this.meK.setPosition(0);
        if ((this.meK.readUnsignedShort() & 250) == 0) {
            fVar.s(this.meK.data, 0, 4);
            this.meK.setPosition(0);
            int readInt = this.meK.readInt();
            fVar.duS();
            fVar.Jw(readInt);
            fVar.s(this.meK.data, 0, 4);
            this.meK.setPosition(0);
            return this.meK.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meO = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meP = 1;
        this.meQ = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meP) {
                case 1:
                    if (b(fVar)) {
                        break;
                    } else {
                        return -1;
                    }
                case 2:
                    c(fVar);
                    break;
                case 3:
                    if (d(fVar)) {
                        break;
                    } else {
                        return -1;
                    }
                case 4:
                    if (!e(fVar)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.meL.data, 0, 9, true)) {
            this.meL.setPosition(0);
            this.meL.skipBytes(4);
            int readUnsignedByte = this.meL.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.meT == null) {
                this.meT = new a(this.meO.dK(8, 1));
            }
            if (z2 && this.meU == null) {
                this.meU = new d(this.meO.dK(9, 2));
            }
            if (this.meV == null) {
                this.meV = new c(null);
            }
            this.meO.duV();
            this.meO.a(this);
            this.meQ = (this.meL.readInt() - 9) + 4;
            this.meP = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jv(this.meQ);
        this.meQ = 0;
        this.meP = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.meM.data, 0, 11, true)) {
            this.meM.setPosition(0);
            this.Xk = this.meM.readUnsignedByte();
            this.meR = this.meM.dzy();
            this.meS = this.meM.dzy();
            this.meS = ((this.meM.readUnsignedByte() << 24) | this.meS) * 1000;
            this.meM.skipBytes(3);
            this.meP = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.Xk == 8 && this.meT != null) {
            this.meT.b(f(fVar), this.meS);
        } else if (this.Xk == 9 && this.meU != null) {
            this.meU.b(f(fVar), this.meS);
        } else if (this.Xk == 18 && this.meV != null) {
            this.meV.b(f(fVar), this.meS);
        } else {
            fVar.Jv(this.meR);
            z = false;
        }
        this.meQ = 4;
        this.meP = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.meR > this.meN.capacity()) {
            this.meN.I(new byte[Math.max(this.meN.capacity() * 2, this.meR)], 0);
        } else {
            this.meN.setPosition(0);
        }
        this.meN.setLimit(this.meR);
        fVar.readFully(this.meN.data, 0, this.meR);
        return this.meN;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duR() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.meV.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return 0L;
    }
}
