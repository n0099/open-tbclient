package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
final class e {
    private static final int mlt = v.QE("OggS");
    public int mgP;
    public int mlA;
    public int mlu;
    public long mlv;
    public long mlw;
    public long mlx;
    public long mly;
    public int mlz;
    public int type;
    public final int[] mlB = new int[255];
    private final l mex = new l(255);

    public void reset() {
        this.mlu = 0;
        this.type = 0;
        this.mlv = 0L;
        this.mlw = 0L;
        this.mlx = 0L;
        this.mly = 0L;
        this.mlz = 0;
        this.mgP = 0;
        this.mlA = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.mex.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.duQ() >= 27) || !fVar.e(this.mex.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.mex.readUnsignedInt() != mlt) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mlu = this.mex.readUnsignedByte();
            if (this.mlu != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.mex.readUnsignedByte();
            this.mlv = this.mex.dzz();
            this.mlw = this.mex.dzx();
            this.mlx = this.mex.dzx();
            this.mly = this.mex.dzx();
            this.mlz = this.mex.readUnsignedByte();
            this.mgP = this.mlz + 27;
            this.mex.reset();
            fVar.s(this.mex.data, 0, this.mlz);
            for (int i = 0; i < this.mlz; i++) {
                this.mlB[i] = this.mex.readUnsignedByte();
                this.mlA += this.mlB[i];
            }
            return true;
        }
    }
}
