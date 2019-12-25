package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes4.dex */
final class e {
    private static final int mgR = v.Qg("OggS");
    public int mcp;
    public int mgS;
    public long mgT;
    public long mgU;
    public long mgV;
    public long mgW;
    public int mgX;
    public int mgY;
    public int type;
    public final int[] mgZ = new int[255];
    private final l lZU = new l(255);

    public void reset() {
        this.mgS = 0;
        this.type = 0;
        this.mgT = 0L;
        this.mgU = 0L;
        this.mgV = 0L;
        this.mgW = 0L;
        this.mgX = 0;
        this.mcp = 0;
        this.mgY = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.lZU.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.dsr() >= 27) || !fVar.e(this.lZU.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.lZU.readUnsignedInt() != mgR) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mgS = this.lZU.readUnsignedByte();
            if (this.mgS != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.lZU.readUnsignedByte();
            this.mgT = this.lZU.dxd();
            this.mgU = this.lZU.dxb();
            this.mgV = this.lZU.dxb();
            this.mgW = this.lZU.dxb();
            this.mgX = this.lZU.readUnsignedByte();
            this.mcp = this.mgX + 27;
            this.lZU.reset();
            fVar.p(this.lZU.data, 0, this.mgX);
            for (int i = 0; i < this.mgX; i++) {
                this.mgZ[i] = this.lZU.readUnsignedByte();
                this.mgY += this.mgZ[i];
            }
            return true;
        }
    }
}
