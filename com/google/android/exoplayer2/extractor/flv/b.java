package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class b implements e, l {
    public static final h mdK = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtE() {
            return new e[]{new b()};
        }
    };
    private static final int mdL = v.Qr("FLV");
    public int VE;
    private g mdQ;
    private int mdS;
    public int mdT;
    public long mdU;
    private a mdV;
    private d mdW;
    private c mdX;
    private final com.google.android.exoplayer2.util.l mdM = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l mdN = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l mdO = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l mdP = new com.google.android.exoplayer2.util.l();
    private int mdR = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.o(this.mdM.data, 0, 3);
        this.mdM.setPosition(0);
        if (this.mdM.dyj() != mdL) {
            return false;
        }
        fVar.o(this.mdM.data, 0, 2);
        this.mdM.setPosition(0);
        if ((this.mdM.readUnsignedShort() & 250) == 0) {
            fVar.o(this.mdM.data, 0, 4);
            this.mdM.setPosition(0);
            int readInt = this.mdM.readInt();
            fVar.dtC();
            fVar.Jr(readInt);
            fVar.o(this.mdM.data, 0, 4);
            this.mdM.setPosition(0);
            return this.mdM.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdQ = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mdR = 1;
        this.mdS = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdR) {
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
        if (fVar.d(this.mdN.data, 0, 9, true)) {
            this.mdN.setPosition(0);
            this.mdN.skipBytes(4);
            int readUnsignedByte = this.mdN.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.mdV == null) {
                this.mdV = new a(this.mdQ.dH(8, 1));
            }
            if (z2 && this.mdW == null) {
                this.mdW = new d(this.mdQ.dH(9, 2));
            }
            if (this.mdX == null) {
                this.mdX = new c(null);
            }
            this.mdQ.dtF();
            this.mdQ.a(this);
            this.mdS = (this.mdN.readInt() - 9) + 4;
            this.mdR = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jq(this.mdS);
        this.mdS = 0;
        this.mdR = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.mdO.data, 0, 11, true)) {
            this.mdO.setPosition(0);
            this.VE = this.mdO.readUnsignedByte();
            this.mdT = this.mdO.dyj();
            this.mdU = this.mdO.dyj();
            this.mdU = ((this.mdO.readUnsignedByte() << 24) | this.mdU) * 1000;
            this.mdO.skipBytes(3);
            this.mdR = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.VE == 8 && this.mdV != null) {
            this.mdV.b(f(fVar), this.mdU);
        } else if (this.VE == 9 && this.mdW != null) {
            this.mdW.b(f(fVar), this.mdU);
        } else if (this.VE == 18 && this.mdX != null) {
            this.mdX.b(f(fVar), this.mdU);
        } else {
            fVar.Jq(this.mdT);
            z = false;
        }
        this.mdS = 4;
        this.mdR = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.mdT > this.mdP.capacity()) {
            this.mdP.G(new byte[Math.max(this.mdP.capacity() * 2, this.mdT)], 0);
        } else {
            this.mdP.setPosition(0);
        }
        this.mdP.setLimit(this.mdT);
        fVar.readFully(this.mdP.data, 0, this.mdT);
        return this.mdP;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtB() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.mdX.dso();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return 0L;
    }
}
