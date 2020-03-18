package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
final class e {
    private static final int mnm = v.QE("OggS");
    public int miK;
    public int mnn;
    public long mno;
    public long mnp;
    public long mnq;
    public long mnr;
    public int mns;
    public int mnt;
    public int type;
    public final int[] mnu = new int[255];
    private final l mgq = new l(255);

    public void reset() {
        this.mnn = 0;
        this.type = 0;
        this.mno = 0L;
        this.mnp = 0L;
        this.mnq = 0L;
        this.mnr = 0L;
        this.mns = 0;
        this.miK = 0;
        this.mnt = 0;
    }

    public boolean c(com.google.android.exoplayer2.extractor.f fVar, boolean z) throws IOException, InterruptedException {
        this.mgq.reset();
        reset();
        if (!(fVar.getLength() == -1 || fVar.getLength() - fVar.dvq() >= 27) || !fVar.e(this.mgq.data, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.mgq.readUnsignedInt() != mnm) {
            if (z) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        } else {
            this.mnn = this.mgq.readUnsignedByte();
            if (this.mnn != 0) {
                if (z) {
                    return false;
                }
                throw new ParserException("unsupported bit stream revision");
            }
            this.type = this.mgq.readUnsignedByte();
            this.mno = this.mgq.dzZ();
            this.mnp = this.mgq.dzX();
            this.mnq = this.mgq.dzX();
            this.mnr = this.mgq.dzX();
            this.mns = this.mgq.readUnsignedByte();
            this.miK = this.mns + 27;
            this.mgq.reset();
            fVar.s(this.mgq.data, 0, this.mns);
            for (int i = 0; i < this.mns; i++) {
                this.mnu[i] = this.mgq.readUnsignedByte();
                this.mnt += this.mnu[i];
            }
            return true;
        }
    }
}
