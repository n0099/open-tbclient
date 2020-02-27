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
    public static final h mev = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duR() {
            return new e[]{new b()};
        }
    };
    private static final int mew = v.QE("FLV");
    public int Xk;
    private g meB;
    private int meD;
    public int meE;
    public long meF;
    private a meG;
    private d meH;
    private c meI;
    private final com.google.android.exoplayer2.util.l mex = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l mey = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l mez = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l meA = new com.google.android.exoplayer2.util.l();
    private int meC = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mex.data, 0, 3);
        this.mex.setPosition(0);
        if (this.mex.dzv() != mew) {
            return false;
        }
        fVar.s(this.mex.data, 0, 2);
        this.mex.setPosition(0);
        if ((this.mex.readUnsignedShort() & 250) == 0) {
            fVar.s(this.mex.data, 0, 4);
            this.mex.setPosition(0);
            int readInt = this.mex.readInt();
            fVar.duP();
            fVar.Jw(readInt);
            fVar.s(this.mex.data, 0, 4);
            this.mex.setPosition(0);
            return this.mex.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meB = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meC = 1;
        this.meD = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meC) {
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
        if (fVar.d(this.mey.data, 0, 9, true)) {
            this.mey.setPosition(0);
            this.mey.skipBytes(4);
            int readUnsignedByte = this.mey.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.meG == null) {
                this.meG = new a(this.meB.dK(8, 1));
            }
            if (z2 && this.meH == null) {
                this.meH = new d(this.meB.dK(9, 2));
            }
            if (this.meI == null) {
                this.meI = new c(null);
            }
            this.meB.duS();
            this.meB.a(this);
            this.meD = (this.mey.readInt() - 9) + 4;
            this.meC = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jv(this.meD);
        this.meD = 0;
        this.meC = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.mez.data, 0, 11, true)) {
            this.mez.setPosition(0);
            this.Xk = this.mez.readUnsignedByte();
            this.meE = this.mez.dzv();
            this.meF = this.mez.dzv();
            this.meF = ((this.mez.readUnsignedByte() << 24) | this.meF) * 1000;
            this.mez.skipBytes(3);
            this.meC = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.Xk == 8 && this.meG != null) {
            this.meG.b(f(fVar), this.meF);
        } else if (this.Xk == 9 && this.meH != null) {
            this.meH.b(f(fVar), this.meF);
        } else if (this.Xk == 18 && this.meI != null) {
            this.meI.b(f(fVar), this.meF);
        } else {
            fVar.Jv(this.meE);
            z = false;
        }
        this.meD = 4;
        this.meC = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.meE > this.meA.capacity()) {
            this.meA.I(new byte[Math.max(this.meA.capacity() * 2, this.meE)], 0);
        } else {
            this.meA.setPosition(0);
        }
        this.meA.setLimit(this.meE);
        fVar.readFully(this.meA.data, 0, this.meE);
        return this.meA;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duO() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.meI.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return 0L;
    }
}
