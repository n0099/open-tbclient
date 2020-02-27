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
    private static final int mml = v.QE("RCC\u0001");
    private final Format lZw;
    private int mfR;
    private m mgF;
    private long mmn;
    private int mmo;
    private int version;
    private final l mmm = new l(9);
    private int meC = 0;

    public a(Format format) {
        this.lZw = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mgF = gVar.dK(0, 3);
        gVar.duS();
        this.mgF.h(this.lZw);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mmm.reset();
        fVar.s(this.mmm.data, 0, 8);
        return this.mmm.readInt() == mml;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meC) {
                case 0:
                    if (A(fVar)) {
                        this.meC = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.meC = 2;
                        break;
                    } else {
                        this.meC = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.meC = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meC = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mmm.reset();
        if (fVar.d(this.mmm.data, 0, 8, true)) {
            if (this.mmm.readInt() != mml) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mmm.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mmm.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mmm.data, 0, 5, true)) {
                return false;
            }
            this.mmn = (this.mmm.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mmm.data, 0, 9, true)) {
                return false;
            }
            this.mmn = this.mmm.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mmo = this.mmm.readUnsignedByte();
        this.mfR = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mmo > 0) {
            this.mmm.reset();
            fVar.readFully(this.mmm.data, 0, 3);
            this.mgF.a(this.mmm, 3);
            this.mfR += 3;
            this.mmo--;
        }
        if (this.mfR > 0) {
            this.mgF.a(this.mmn, 1, this.mfR, 0, null);
        }
    }
}
