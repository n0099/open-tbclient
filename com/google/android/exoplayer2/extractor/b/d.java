package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class d implements b.a {
    private final long lZD;
    private final long mgA;
    private final long mgO;
    private final long[] mgP;
    private final long mgQ;
    private final int mgR;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dzE;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dzE = lVar.dzE()) == 0) {
            return null;
        }
        long i3 = v.i(dzE, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, i3, j2);
        }
        long dzE2 = lVar.dzE();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i4 = 0; i4 < 99; i4++) {
            jArr[i4] = lVar.readUnsignedByte();
        }
        return new d(j3, i3, j2, jArr, dzE2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mgA = j;
        this.lZD = j2;
        this.mgO = j3;
        this.mgP = jArr;
        this.mgQ = j4;
        this.mgR = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duQ() {
        return this.mgP != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (!duQ()) {
            return this.mgA;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lZD);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mgP[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mgP[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mgA + Math.round(r0 * 0.00390625d * this.mgQ), this.mgO != -1 ? this.mgO - 1 : ((this.mgA - this.mgR) + this.mgQ) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        if (!duQ() || j < this.mgA) {
            return 0L;
        }
        double d = (256.0d * (j - this.mgA)) / this.mgQ;
        int a = v.a(this.mgP, (long) d, true, false) + 1;
        long JH = JH(a);
        long j2 = a == 0 ? 0L : this.mgP[a - 1];
        long j3 = a == 99 ? 256L : this.mgP[a];
        return JH + (j3 == j2 ? 0L : (long) (((JH(a + 1) - JH) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZD;
    }

    private long JH(int i) {
        return (this.lZD * i) / 100;
    }
}
