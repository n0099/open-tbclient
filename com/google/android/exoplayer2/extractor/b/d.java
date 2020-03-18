package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class d implements b.a {
    private final long mbx;
    private final long miH;
    private final long[] miI;
    private final long miJ;
    private final int miK;
    private final long mit;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dAc;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dAc = lVar.dAc()) == 0) {
            return null;
        }
        long i3 = v.i(dAc, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, i3, j2);
        }
        long dAc2 = lVar.dAc();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i4 = 0; i4 < 99; i4++) {
            jArr[i4] = lVar.readUnsignedByte();
        }
        return new d(j3, i3, j2, jArr, dAc2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mit = j;
        this.mbx = j2;
        this.miH = j3;
        this.miI = jArr;
        this.miJ = j4;
        this.miK = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return this.miI != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        if (!dvo()) {
            return this.mit;
        }
        float f = (((float) j) * 100.0f) / ((float) this.mbx);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.miI[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.miI[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mit + Math.round(r0 * 0.00390625d * this.miJ), this.miH != -1 ? this.miH - 1 : ((this.mit - this.miK) + this.miJ) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fO(long j) {
        if (!dvo() || j < this.mit) {
            return 0L;
        }
        double d = (256.0d * (j - this.mit)) / this.miJ;
        int a = v.a(this.miI, (long) d, true, false) + 1;
        long JN = JN(a);
        long j2 = a == 0 ? 0L : this.miI[a - 1];
        long j3 = a == 99 ? 256L : this.miI[a];
        return JN + (j3 == j2 ? 0L : (long) (((JN(a + 1) - JN) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mbx;
    }

    private long JN(int i) {
        return (this.mbx * i) / 100;
    }
}
