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
/* loaded from: classes5.dex */
public final class a implements e {
    private static final int mlF = v.Qr("RCC\u0001");
    private final Format lYQ;
    private m mfZ;
    private int mfl;
    private long mlH;
    private int mlI;
    private int version;
    private final l mlG = new l(9);
    private int mdW = 0;

    public a(Format format) {
        this.lYQ = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mfZ = gVar.dH(0, 3);
        gVar.dtH();
        this.mfZ.h(this.lYQ);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mlG.reset();
        fVar.o(this.mlG.data, 0, 8);
        return this.mlG.readInt() == mlF;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdW) {
                case 0:
                    if (A(fVar)) {
                        this.mdW = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.mdW = 2;
                        break;
                    } else {
                        this.mdW = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.mdW = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mdW = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mlG.reset();
        if (fVar.d(this.mlG.data, 0, 8, true)) {
            if (this.mlG.readInt() != mlF) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mlG.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mlG.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mlG.data, 0, 5, true)) {
                return false;
            }
            this.mlH = (this.mlG.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mlG.data, 0, 9, true)) {
                return false;
            }
            this.mlH = this.mlG.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mlI = this.mlG.readUnsignedByte();
        this.mfl = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mlI > 0) {
            this.mlG.reset();
            fVar.readFully(this.mlG.data, 0, 3);
            this.mfZ.a(this.mlG, 3);
            this.mfl += 3;
            this.mlI--;
        }
        if (this.mfl > 0) {
            this.mfZ.a(this.mlH, 1, this.mfl, 0, null);
        }
    }
}
