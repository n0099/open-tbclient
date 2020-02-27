package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class d implements b.a {
    private final long lZB;
    private final long mgM;
    private final long[] mgN;
    private final long mgO;
    private final int mgP;
    private final long mgy;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dzC;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dzC = lVar.dzC()) == 0) {
            return null;
        }
        long i3 = v.i(dzC, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, i3, j2);
        }
        long dzC2 = lVar.dzC();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i4 = 0; i4 < 99; i4++) {
            jArr[i4] = lVar.readUnsignedByte();
        }
        return new d(j3, i3, j2, jArr, dzC2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mgy = j;
        this.lZB = j2;
        this.mgM = j3;
        this.mgN = jArr;
        this.mgO = j4;
        this.mgP = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duO() {
        return this.mgN != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (!duO()) {
            return this.mgy;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lZB);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mgN[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mgN[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mgy + Math.round(r0 * 0.00390625d * this.mgO), this.mgM != -1 ? this.mgM - 1 : ((this.mgy - this.mgP) + this.mgO) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        if (!duO() || j < this.mgy) {
            return 0L;
        }
        double d = (256.0d * (j - this.mgy)) / this.mgO;
        int a = v.a(this.mgN, (long) d, true, false) + 1;
        long JH = JH(a);
        long j2 = a == 0 ? 0L : this.mgN[a - 1];
        long j3 = a == 99 ? 256L : this.mgN[a];
        return JH + (j3 == j2 ? 0L : (long) (((JH(a + 1) - JH) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZB;
    }

    private long JH(int i) {
        return (this.lZB * i) / 100;
    }
}
