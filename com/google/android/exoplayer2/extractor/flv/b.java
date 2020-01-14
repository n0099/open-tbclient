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
    public static final h mdP = new h() { // from class: com.google.android.exoplayer2.extractor.flv.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtG() {
            return new e[]{new b()};
        }
    };
    private static final int mdQ = v.Qr("FLV");
    public int VE;
    private g mdV;
    private int mdX;
    public int mdY;
    public long mdZ;
    private a mea;
    private d meb;
    private c mec;
    private final com.google.android.exoplayer2.util.l mdR = new com.google.android.exoplayer2.util.l(4);
    private final com.google.android.exoplayer2.util.l mdS = new com.google.android.exoplayer2.util.l(9);
    private final com.google.android.exoplayer2.util.l mdT = new com.google.android.exoplayer2.util.l(11);
    private final com.google.android.exoplayer2.util.l mdU = new com.google.android.exoplayer2.util.l();
    private int mdW = 1;

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        fVar.o(this.mdR.data, 0, 3);
        this.mdR.setPosition(0);
        if (this.mdR.dyl() != mdQ) {
            return false;
        }
        fVar.o(this.mdR.data, 0, 2);
        this.mdR.setPosition(0);
        if ((this.mdR.readUnsignedShort() & 250) == 0) {
            fVar.o(this.mdR.data, 0, 4);
            this.mdR.setPosition(0);
            int readInt = this.mdR.readInt();
            fVar.dtE();
            fVar.Jr(readInt);
            fVar.o(this.mdR.data, 0, 4);
            this.mdR.setPosition(0);
            return this.mdR.readInt() == 0;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdV = gVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mdW = 1;
        this.mdX = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdW) {
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
        if (fVar.d(this.mdS.data, 0, 9, true)) {
            this.mdS.setPosition(0);
            this.mdS.skipBytes(4);
            int readUnsignedByte = this.mdS.readUnsignedByte();
            boolean z = (readUnsignedByte & 4) != 0;
            boolean z2 = (readUnsignedByte & 1) != 0;
            if (z && this.mea == null) {
                this.mea = new a(this.mdV.dH(8, 1));
            }
            if (z2 && this.meb == null) {
                this.meb = new d(this.mdV.dH(9, 2));
            }
            if (this.mec == null) {
                this.mec = new c(null);
            }
            this.mdV.dtH();
            this.mdV.a(this);
            this.mdX = (this.mdS.readInt() - 9) + 4;
            this.mdW = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        fVar.Jq(this.mdX);
        this.mdX = 0;
        this.mdW = 3;
    }

    private boolean d(f fVar) throws IOException, InterruptedException {
        if (fVar.d(this.mdT.data, 0, 11, true)) {
            this.mdT.setPosition(0);
            this.VE = this.mdT.readUnsignedByte();
            this.mdY = this.mdT.dyl();
            this.mdZ = this.mdT.dyl();
            this.mdZ = ((this.mdT.readUnsignedByte() << 24) | this.mdZ) * 1000;
            this.mdT.skipBytes(3);
            this.mdW = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        if (this.VE == 8 && this.mea != null) {
            this.mea.b(f(fVar), this.mdZ);
        } else if (this.VE == 9 && this.meb != null) {
            this.meb.b(f(fVar), this.mdZ);
        } else if (this.VE == 18 && this.mec != null) {
            this.mec.b(f(fVar), this.mdZ);
        } else {
            fVar.Jq(this.mdY);
            z = false;
        }
        this.mdX = 4;
        this.mdW = 2;
        return z;
    }

    private com.google.android.exoplayer2.util.l f(f fVar) throws IOException, InterruptedException {
        if (this.mdY > this.mdU.capacity()) {
            this.mdU.G(new byte[Math.max(this.mdU.capacity() * 2, this.mdY)], 0);
        } else {
            this.mdU.setPosition(0);
        }
        this.mdU.setLimit(this.mdY);
        fVar.readFully(this.mdU.data, 0, this.mdY);
        return this.mdU;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtD() {
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.mec.dsq();
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return 0L;
    }
}
