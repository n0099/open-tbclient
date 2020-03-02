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
    public static final h mex = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duT() {
            return new e[]{new b()};
        }
    };
    private static final int mey = v.QE("FLV");
    public int Xk;
    private g meD;
    private int meF;
    public int meG;
    public long meH;
    private a meI;
    private d meJ;
    private c meK;
    private final com.google.android.exoplayer2.util.l mez = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l meA = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l meB = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l meC = new com.google.android.exoplayer2.util.l();
    private int meE = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mez.data, 0, 3);
        this.mez.setPosition(0);
        if (this.mez.dzx() != mey) {
            return false;
        }
        fVar.s(this.mez.data, 0, 2);
        this.mez.setPosition(0);
        if ((this.mez.readUnsignedShort() & 250) == 0) {
            fVar.s(this.mez.data, 0, 4);
            this.mez.setPosition(0);
            int readInt = this.mez.readInt();
            fVar.duR();
            fVar.Jw(readInt);
            fVar.s(this.mez.data, 0, 4);
            this.mez.setPosition(0);
            return this.mez.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meD = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meE = 1;
        this.meF = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meE) {
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
        if (fVar.d(this.meA.data, 0, 9, true)) {
            this.meA.setPosition(0);
            this.meA.skipBytes(4);
            int readUnsignedByte = this.meA.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.meI == null) {
                this.meI = new a(this.meD.dK(8, 1));
            }
            if (z2 && this.meJ == null) {
                this.meJ = new d(this.meD.dK(9, 2));
            }
            if (this.meK == null) {
                this.meK = new c(null);
            }
            this.meD.duU();
            this.meD.a(this);
            this.meF = (this.meA.readInt() - 9) + 4;
            this.meE = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jv(this.meF);
        this.meF = 0;
        this.meE = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.meB.data, 0, 11, true)) {
            this.meB.setPosition(0);
            this.Xk = this.meB.readUnsignedByte();
            this.meG = this.meB.dzx();
            this.meH = this.meB.dzx();
            this.meH = ((this.meB.readUnsignedByte() << 24) | this.meH) * 1000;
            this.meB.skipBytes(3);
            this.meE = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.Xk == 8 && this.meI != null) {
            this.meI.b(f(fVar), this.meH);
        } else if (this.Xk == 9 && this.meJ != null) {
            this.meJ.b(f(fVar), this.meH);
        } else if (this.Xk == 18 && this.meK != null) {
            this.meK.b(f(fVar), this.meH);
        } else {
            fVar.Jv(this.meG);
            z = false;
        }
        this.meF = 4;
        this.meE = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.meG > this.meC.capacity()) {
            this.meC.I(new byte[Math.max(this.meC.capacity() * 2, this.meG)], 0);
        } else {
            this.meC.setPosition(0);
        }
        this.meC.setLimit(this.meG);
        fVar.readFully(this.meC.data, 0, this.meG);
        return this.meC;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duQ() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.meK.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return 0L;
    }
}
