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
    private static final int mlA = v.Qr("RCC\u0001");
    private final Format lYL;
    private m mfU;
    private int mfg;
    private long mlC;
    private int mlD;
    private int version;
    private final l mlB = new l(9);
    private int mdR = 0;

    public a(Format format) {
        this.lYL = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mfU = gVar.dH(0, 3);
        gVar.dtF();
        this.mfU.h(this.lYL);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mlB.reset();
        fVar.o(this.mlB.data, 0, 8);
        return this.mlB.readInt() == mlA;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mdR) {
                case 0:
                    if (A(fVar)) {
                        this.mdR = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.mdR = 2;
                        break;
                    } else {
                        this.mdR = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.mdR = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mdR = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mlB.reset();
        if (fVar.d(this.mlB.data, 0, 8, true)) {
            if (this.mlB.readInt() != mlA) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mlB.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mlB.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mlB.data, 0, 5, true)) {
                return false;
            }
            this.mlC = (this.mlB.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mlB.data, 0, 9, true)) {
                return false;
            }
            this.mlC = this.mlB.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mlD = this.mlB.readUnsignedByte();
        this.mfg = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mlD > 0) {
            this.mlB.reset();
            fVar.readFully(this.mlB.data, 0, 3);
            this.mfU.a(this.mlB, 3);
            this.mfg += 3;
            this.mlD--;
        }
        if (this.mfg > 0) {
            this.mfU.a(this.mlC, 1, this.mfg, 0, null);
        }
    }
}
