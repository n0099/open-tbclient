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
    private static final int mmn = v.QE("RCC\u0001");
    private final Format lZy;
    private int mfT;
    private m mgH;
    private long mmp;
    private int mmq;
    private int version;
    private final l mmo = new l(9);
    private int meE = 0;

    public a(Format format) {
        this.lZy = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mgH = gVar.dK(0, 3);
        gVar.duU();
        this.mgH.h(this.lZy);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mmo.reset();
        fVar.s(this.mmo.data, 0, 8);
        return this.mmo.readInt() == mmn;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meE) {
                case 0:
                    if (A(fVar)) {
                        this.meE = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.meE = 2;
                        break;
                    } else {
                        this.meE = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.meE = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meE = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mmo.reset();
        if (fVar.d(this.mmo.data, 0, 8, true)) {
            if (this.mmo.readInt() != mmn) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mmo.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mmo.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mmo.data, 0, 5, true)) {
                return false;
            }
            this.mmp = (this.mmo.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mmo.data, 0, 9, true)) {
                return false;
            }
            this.mmp = this.mmo.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mmq = this.mmo.readUnsignedByte();
        this.mfT = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mmq > 0) {
            this.mmo.reset();
            fVar.readFully(this.mmo.data, 0, 3);
            this.mgH.a(this.mmo, 3);
            this.mfT += 3;
            this.mmq--;
        }
        if (this.mfT > 0) {
            this.mgH.a(this.mmp, 1, this.mfT, 0, null);
        }
    }
}
