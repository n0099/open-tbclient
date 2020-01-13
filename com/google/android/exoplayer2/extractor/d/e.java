package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes5.dex */
final class e {
    private static final int mkI = v.Qr("OggS");
    public int mge;
    public int mkJ;
    public long mkK;
    public long mkL;
    public long mkM;
    public long mkN;
    public int mkO;
    public int mkP;
    public int type;
    public final int[] mkQ = new int[255];
    private final l mdM = new l(255);

    public void reset() {
        this.mkJ = 0;
        this.type = 0;
        this.mkK = 0L;
        this.mkL = 0L;
        this.mkM = 0L;
        this.mkN = 0L;
        this.mkO = 0;
        this.mge = 0;
        this.mkP = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.mdM.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.dtD() >= 27) || !fVar.e(this.mdM.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.mdM.readUnsignedInt() != mkI) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mkJ = this.mdM.readUnsignedByte();
            if (this.mkJ != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.mdM.readUnsignedByte();
            this.mkK = this.mdM.dyn();
            this.mkL = this.mdM.dyl();
            this.mkM = this.mdM.dyl();
            this.mkN = this.mdM.dyl();
            this.mkO = this.mdM.readUnsignedByte();
            this.mge = this.mkO + 27;
            this.mdM.reset();
            fVar.o(this.mdM.data, 0, this.mkO);
            for (int i = 0; i < this.mkO; i++) {
                this.mkQ[i] = this.mdM.readUnsignedByte();
                this.mkP += this.mkQ[i];
            }
            return true;
        }
    }
}
