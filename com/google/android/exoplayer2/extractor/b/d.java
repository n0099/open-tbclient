package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class d implements b.a {
    private final long lYQ;
    private final long mfN;
    private final long mgb;
    private final long[] mgc;
    private final long mgd;
    private final int mge;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dyq;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dyq = lVar.dyq()) == 0) {
            return null;
        }
        long h = v.h(dyq, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, h, j2);
        }
        long dyq2 = lVar.dyq();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i3 = 0; i3 < 99; i3++) {
            jArr[i3] = lVar.readUnsignedByte();
        }
        return new d(j3, h, j2, jArr, dyq2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mfN = j;
        this.lYQ = j2;
        this.mgb = j3;
        this.mgc = jArr;
        this.mgd = j4;
        this.mge = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtB() {
        return this.mgc != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        if (!dtB()) {
            return this.mfN;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lYQ);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mgc[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mgc[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mfN + Math.round(r0 * 0.00390625d * this.mgd), this.mgb != -1 ? this.mgb - 1 : ((this.mfN - this.mge) + this.mgd) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fP(long j) {
        if (!dtB() || j < this.mfN) {
            return 0L;
        }
        double d = (256.0d * (j - this.mfN)) / this.mgd;
        int a = v.a(this.mgc, (long) d, true, false) + 1;
        long JC = JC(a);
        long j2 = a == 0 ? 0L : this.mgc[a - 1];
        long j3 = a == 99 ? 256L : this.mgc[a];
        return JC + (j3 == j2 ? 0L : (long) (((JC(a + 1) - JC) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.lYQ;
    }

    private long JC(int i) {
        return (this.lYQ * i) / 100;
    }
}
