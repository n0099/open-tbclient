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
    private static final byte[] mlW = {73, 68, 51};
    private int Vk;
    private final String language;
    private long mcV;
    private boolean mdN;
    private com.google.android.exoplayer2.extractor.m med;
    private int mlR;
    private long mlT;
    private final boolean mlX;
    private final com.google.android.exoplayer2.util.k mlY;
    private final com.google.android.exoplayer2.util.l mlZ;
    private String mma;
    private com.google.android.exoplayer2.extractor.m mmb;
    private boolean mmc;
    private com.google.android.exoplayer2.extractor.m mmd;
    private long mme;
    private int sampleSize;
    private int state;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.mlY = new com.google.android.exoplayer2.util.k(new byte[7]);
        this.mlZ = new com.google.android.exoplayer2.util.l(Arrays.copyOf(mlW, 10));
        due();
        this.mlX = z;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        due();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mma = dVar.dut();
        this.med = gVar.dH(dVar.dus(), 1);
        if (this.mlX) {
            dVar.dur();
            this.mmb = gVar.dH(dVar.dus(), 4);
            this.mmb.h(Format.a(dVar.dut(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.mmb = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mcV = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) throws ParserException {
        while (lVar.dyh() > 0) {
            switch (this.state) {
                case 0:
                    K(lVar);
                    break;
                case 1:
                    if (!a(lVar, this.mlZ.data, 10)) {
                        break;
                    } else {
                        duh();
                        break;
                    }
                case 2:
                    if (!a(lVar, this.mlY.data, this.mmc ? 7 : 5)) {
                        break;
                    } else {
                        dui();
                        break;
                    }
                case 3:
                    L(lVar);
                    break;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private boolean a(com.google.android.exoplayer2.util.l lVar, byte[] bArr, int i) {
        int min = Math.min(lVar.dyh(), i - this.mlR);
        lVar.C(bArr, this.mlR, min);
        this.mlR = min + this.mlR;
        return this.mlR == i;
    }

    private void due() {
        this.state = 0;
        this.mlR = 0;
        this.Vk = 256;
    }

    private void duf() {
        this.state = 1;
        this.mlR = mlW.length;
        this.sampleSize = 0;
        this.mlZ.setPosition(0);
    }

    private void a(com.google.android.exoplayer2.extractor.m mVar, long j, int i, int i2) {
        this.state = 3;
        this.mlR = i;
        this.mmd = mVar;
        this.mme = j;
        this.sampleSize = i2;
    }

    private void dug() {
        this.state = 2;
        this.mlR = 0;
    }

    private void K(com.google.android.exoplayer2.util.l lVar) {
        byte[] bArr = lVar.data;
        int position = lVar.getPosition();
        int dyi = lVar.dyi();
        while (position < dyi) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            if (this.Vk == 512 && i2 >= 240 && i2 != 255) {
                this.mmc = (i2 & 1) == 0;
                dug();
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
                    duf();
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

    private void duh() {
        this.mmb.a(this.mlZ, 10);
        this.mlZ.setPosition(6);
        a(this.mmb, 0L, 10, this.mlZ.dyr() + 10);
    }

    private void dui() throws ParserException {
        int i = 2;
        this.mlY.setPosition(0);
        if (!this.mdN) {
            int readBits = this.mlY.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i = readBits;
            }
            int readBits2 = this.mlY.readBits(4);
            this.mlY.JP(1);
            byte[] aj = com.google.android.exoplayer2.util.c.aj(i, readBits2, this.mlY.readBits(3));
            Pair<Integer, Integer> au = com.google.android.exoplayer2.util.c.au(aj);
            Format a = Format.a(this.mma, "audio/mp4a-latm", null, -1, -1, ((Integer) au.second).intValue(), ((Integer) au.first).intValue(), Collections.singletonList(aj), null, 0, this.language);
            this.mlT = 1024000000 / a.sampleRate;
            this.med.h(a);
            this.mdN = true;
        } else {
            this.mlY.JP(10);
        }
        this.mlY.JP(4);
        int readBits3 = (this.mlY.readBits(13) - 2) - 5;
        if (this.mmc) {
            readBits3 -= 2;
        }
        a(this.med, this.mlT, 0, readBits3);
    }

    private void L(com.google.android.exoplayer2.util.l lVar) {
        int min = Math.min(lVar.dyh(), this.sampleSize - this.mlR);
        this.mmd.a(lVar, min);
        this.mlR = min + this.mlR;
        if (this.mlR == this.sampleSize) {
            this.mmd.a(this.mcV, 1, this.sampleSize, 0, null);
            this.mcV += this.mme;
            due();
        }
    }
}
