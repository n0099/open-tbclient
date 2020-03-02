package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
final class e {
    private static final int mlv = v.QE("OggS");
    public int mgR;
    public long mlA;
    public int mlB;
    public int mlC;
    public int mlw;
    public long mlx;
    public long mly;
    public long mlz;
    public int type;
    public final int[] mlD = new int[255];
    private final l mez = new l(255);

    public void reset() {
        this.mlw = 0;
        this.type = 0;
        this.mlx = 0L;
        this.mly = 0L;
        this.mlz = 0L;
        this.mlA = 0L;
        this.mlB = 0;
        this.mgR = 0;
        this.mlC = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.mez.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.duS() >= 27) || !fVar.e(this.mez.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.mez.readUnsignedInt() != mlv) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mlw = this.mez.readUnsignedByte();
            if (this.mlw != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.mez.readUnsignedByte();
            this.mlx = this.mez.dzB();
            this.mly = this.mez.dzz();
            this.mlz = this.mez.dzz();
            this.mlA = this.mez.dzz();
            this.mlB = this.mez.readUnsignedByte();
            this.mgR = this.mlB + 27;
            this.mez.reset();
            fVar.s(this.mez.data, 0, this.mlB);
            for (int i = 0; i < this.mlB; i++) {
                this.mlD[i] = this.mez.readUnsignedByte();
                this.mlC += this.mlD[i];
            }
            return true;
        }
    }
}
