package com.google.android.exoplayer2.extractor.f;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class d implements h {
    private static final byte[] mlR = {73, 68, 51};
    private int Vk;
    private final String language;
    private long mcQ;
    private boolean mdI;
    private com.google.android.exoplayer2.extractor.m mdY;
    private int mlM;
    private long mlO;
    private final boolean mlS;
    private final com.google.android.exoplayer2.util.k mlT;
    private final com.google.android.exoplayer2.util.l mlU;
    private String mlV;
    private com.google.android.exoplayer2.extractor.m mlW;
    private boolean mlX;
    private com.google.android.exoplayer2.extractor.m mlY;
    private long mlZ;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mlT = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mlU = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mlR, 10));
        duc();
        this.mlS = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        duc();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlV = dVar.dur();
        this.mdY = gVar.dH(dVar.duq(), 1);
        if (this.mlS) {
            dVar.dup();
            this.mlW = gVar.dH(dVar.duq(), 4);
            this.mlW.h(Format.a(dVar.dur(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mlW = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcQ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dyf() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mlU.data, 10)) {
                        break;
                    } else {
                        duf();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mlT.data, this.mlX ? 7 : 5)) {
                        break;
                    } else {
                        dug();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyf(), i - this.mlM);
        lVar.C(bArr, this.mlM, min);
        this.mlM = min + this.mlM;
        return this.mlM == i;
    }

    private void duc() {
        this.state = 0;
        this.mlM = 0;
        this.Vk = 256;
    }

    private void dud() {
        this.state = 1;
        this.mlM = mlR.length;
        this.sampleSize = 0;
        this.mlU.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mlM = i;
        this.mlY = mVar;
        this.mlZ = j;
        this.sampleSize = i2;
    }

    private void due() {
        this.state = 2;
        this.mlM = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dyg = lVar.dyg();
        while (position < dyg) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.Vk == 512 && i2 >= 240 && i2 != 255) {
                this.mlX = (i2 & 1) == 0;
                due();
                lVar.setPosition(i);
                return;
            }
            switch (i2 | this.Vk) {
                case 329:
                    this.Vk = 768;
                    position = i;
                    break;
                case 511:
                    this.Vk = 512;
                    position = i;
                    break;
                case 836:
                    this.Vk = 1024;
                    position = i;
                    break;
                case 1075:
                    dud();
                    lVar.setPosition(i);
                    return;
                default:
                    if (this.Vk == 256) {
                        position = i;
                        break;
                    } else {
                        this.Vk = 256;
                        position = i - 1;
                        break;
                    }
            }
        }
        lVar.setPosition(position);
    }

    private void duf() {
        this.mlW.a(this.mlU, 10);
        this.mlU.setPosition(6);
        a(this.mlW, 0L, 10, this.mlU.dyp() + 10);
    }

    private void dug() throws ParserException {
        int i = 2;
        this.mlT.setPosition(0);
        if (!this.mdI) {
            int readBits = this.mlT.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mlT.readBits(4);
            this.mlT.JP(1);
            byte[] aj = com.google.android.exoplayer2.util.c.aj(i, readBits2, this.mlT.readBits(3));
            Pair<Integer, Integer> au = com.google.android.exoplayer2.util.c.au(aj);
            Format a = Format.a(this.mlV, "audio/mp4a-latm", null, -1, -1, ((Integer) au.second).intValue(), ((Integer) au.first).intValue(), Collections.singletonList(aj), null, 0, this.language);
            this.mlO = 1024000000 / a.sampleRate;
            this.mdY.h(a);
            this.mdI = true;
        } else {
            this.mlT.JP(10);
        }
        this.mlT.JP(4);
        int readBits3 = (this.mlT.readBits(13) - 2) - 5;
        if (this.mlX) {
            readBits3 -= 2;
        }
        a(this.mdY, this.mlO, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyf(), this.sampleSize - this.mlM);
        this.mlY.a(lVar, min);
        this.mlM = min + this.mlM;
        if (this.mlM == this.sampleSize) {
            this.mlY.a(this.mcQ, 1, this.sampleSize, 0, null);
            this.mcQ += this.mlZ;
            duc();
        }
    }
}
