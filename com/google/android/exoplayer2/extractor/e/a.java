package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class a implements e {
    private static final int mhK = v.Qg("RCC\u0001");
    private final Format lUU;
    private int mbr;
    private m mcf;
    private long mhM;
    private int mhN;
    private int version;
    private final l mhL = new l(9);
    private int lZZ = 0;

    public a(Format format) {
        this.lUU = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mcf = gVar.dJ(0, 3);
        gVar.dst();
        this.mcf.h(this.lUU);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mhL.reset();
        fVar.p(this.mhL.data, 0, 8);
        return this.mhL.readInt() == mhK;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.lZZ) {
                case 0:
                    if (A(fVar)) {
                        this.lZZ = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.lZZ = 2;
                        break;
                    } else {
                        this.lZZ = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.lZZ = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.lZZ = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mhL.reset();
        if (fVar.d(this.mhL.data, 0, 8, true)) {
            if (this.mhL.readInt() != mhK) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mhL.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mhL.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mhL.data, 0, 5, true)) {
                return false;
            }
            this.mhM = (this.mhL.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mhL.data, 0, 9, true)) {
                return false;
            }
            this.mhM = this.mhL.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mhN = this.mhL.readUnsignedByte();
        this.mbr = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mhN > 0) {
            this.mhL.reset();
            fVar.readFully(this.mhL.data, 0, 3);
            this.mcf.a(this.mhL, 3);
            this.mbr += 3;
            this.mhN--;
        }
        if (this.mbr > 0) {
            this.mcf.a(this.mhM, 1, this.mbr, 0, null);
        }
    }
}
