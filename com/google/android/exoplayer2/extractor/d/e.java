package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
final class e {
    private static final int mlG = v.QF("OggS");
    public int mhc;
    public int mlH;
    public long mlI;
    public long mlJ;
    public long mlK;
    public long mlL;
    public int mlM;
    public int mlN;
    public int type;
    public final int[] mlO = new int[255];
    private final l meK = new l(255);

    public void reset() {
        this.mlH = 0;
        this.type = 0;
        this.mlI = 0L;
        this.mlJ = 0L;
        this.mlK = 0L;
        this.mlL = 0L;
        this.mlM = 0;
        this.mhc = 0;
        this.mlN = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.meK.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.duT() >= 27) || !fVar.e(this.meK.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.meK.readUnsignedInt() != mlG) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mlH = this.meK.readUnsignedByte();
            if (this.mlH != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.meK.readUnsignedByte();
            this.mlI = this.meK.dzC();
            this.mlJ = this.meK.dzA();
            this.mlK = this.meK.dzA();
            this.mlL = this.meK.dzA();
            this.mlM = this.meK.readUnsignedByte();
            this.mhc = this.mlM + 27;
            this.meK.reset();
            fVar.s(this.meK.data, 0, this.mlM);
            for (int i = 0; i < this.mlM; i++) {
                this.mlO[i] = this.meK.readUnsignedByte();
                this.mlN += this.mlO[i];
            }
            return true;
        }
    }
}
