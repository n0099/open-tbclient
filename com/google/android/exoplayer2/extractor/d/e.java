package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes5.dex */
final class e {
    private static final int mkN = v.Qr("OggS");
    public int mgj;
    public int mkO;
    public long mkP;
    public long mkQ;
    public long mkR;
    public long mkS;
    public int mkT;
    public int mkU;
    public int type;
    public final int[] mkV = new int[255];
    private final l mdR = new l(255);

    public void reset() {
        this.mkO = 0;
        this.type = 0;
        this.mkP = 0L;
        this.mkQ = 0L;
        this.mkR = 0L;
        this.mkS = 0L;
        this.mkT = 0;
        this.mgj = 0;
        this.mkU = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.mdR.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.dtF() >= 27) || !fVar.e(this.mdR.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.mdR.readUnsignedInt() != mkN) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mkO = this.mdR.readUnsignedByte();
            if (this.mkO != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.mdR.readUnsignedByte();
            this.mkP = this.mdR.dyp();
            this.mkQ = this.mdR.dyn();
            this.mkR = this.mdR.dyn();
            this.mkS = this.mdR.dyn();
            this.mkT = this.mdR.readUnsignedByte();
            this.mgj = this.mkT + 27;
            this.mdR.reset();
            fVar.o(this.mdR.data, 0, this.mkT);
            for (int i = 0; i < this.mkT; i++) {
                this.mkV[i] = this.mdR.readUnsignedByte();
                this.mkU += this.mkV[i];
            }
            return true;
        }
    }
}
