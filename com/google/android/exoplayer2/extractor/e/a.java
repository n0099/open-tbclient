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
    private static final int mmy = v.QF("RCC\u0001");
    private final Format lZJ;
    private m mgS;
    private int mge;
    private long mmA;
    private int mmB;
    private int version;
    private final l mmz = new l(9);
    private int meP = 0;

    public a(Format format) {
        this.lZJ = format;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.mgS = gVar.dK(0, 3);
        gVar.duV();
        this.mgS.h(this.lZJ);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        this.mmz.reset();
        fVar.s(this.mmz.data, 0, 8);
        return this.mmz.readInt() == mmy;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            switch (this.meP) {
                case 0:
                    if (A(fVar)) {
                        this.meP = 1;
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (B(fVar)) {
                        this.meP = 2;
                        break;
                    } else {
                        this.meP = 0;
                        return -1;
                    }
                case 2:
                    C(fVar);
                    this.meP = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.meP = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    private boolean A(f fVar) throws IOException, InterruptedException {
        this.mmz.reset();
        if (fVar.d(this.mmz.data, 0, 8, true)) {
            if (this.mmz.readInt() != mmy) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.mmz.readUnsignedByte();
            return true;
        }
        return false;
    }

    private boolean B(f fVar) throws IOException, InterruptedException {
        this.mmz.reset();
        if (this.version == 0) {
            if (!fVar.d(this.mmz.data, 0, 5, true)) {
                return false;
            }
            this.mmA = (this.mmz.readUnsignedInt() * 1000) / 45;
        } else if (this.version == 1) {
            if (!fVar.d(this.mmz.data, 0, 9, true)) {
                return false;
            }
            this.mmA = this.mmz.readLong();
        } else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.mmB = this.mmz.readUnsignedByte();
        this.mge = 0;
        return true;
    }

    private void C(f fVar) throws IOException, InterruptedException {
        while (this.mmB > 0) {
            this.mmz.reset();
            fVar.readFully(this.mmz.data, 0, 3);
            this.mgS.a(this.mmz, 3);
            this.mge += 3;
            this.mmB--;
        }
        if (this.mge > 0) {
            this.mgS.a(this.mmA, 1, this.mge, 0, null);
        }
    }
}
