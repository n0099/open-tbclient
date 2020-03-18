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
/* loaded from: classes6.dex */
public final class a implements e {
    private static final int moe = v.QE("RCC\u0001");
    private final Format mbs;
    private int mhK;
    private m miA;
    private long mog;
    private int moh;
    private int version;
    private final l mof = new l(9);
    private int mgv = 0;

    public a(Format format) {
        this.mbs = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.miA = gVar.dL(0, 3);
        gVar.dvs();
        this.miA.h(this.mbs);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mof.reset();
        fVar.s(this.mof.data, 0, 8);
        return this.mof.readInt() == moe;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.mgv) {
                case 0:
                    if (A(fVar)) {
                        this.mgv = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.mgv = 2;
                        break;
                    } else {
                        this.mgv = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.mgv = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mgv = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mof.reset();
        if (fVar.d(this.mof.data, 0, 8, true)) {
            if (this.mof.readInt() != moe) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mof.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mof.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mof.data, 0, 5, true)) {
                return false;
            }
            this.mog = (this.mof.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mof.data, 0, 9, true)) {
                return false;
            }
            this.mog = this.mof.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.moh = this.mof.readUnsignedByte();
        this.mhK = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.moh > 0) {
            this.mof.reset();
            fVar.readFully(this.mof.data, 0, 3);
            this.miA.a(this.mof, 3);
            this.mhK += 3;
            this.moh--;
        }
        if (this.mhK > 0) {
            this.miA.a(this.mog, 1, this.mhK, 0, null);
        }
    }
}
