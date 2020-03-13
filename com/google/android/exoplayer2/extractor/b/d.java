package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class d implements b.a {
    private final long lZO;
    private final long mgL;
    private final long mgZ;
    private final long[] mha;
    private final long mhb;
    private final int mhc;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dzF;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dzF = lVar.dzF()) == 0) {
            return null;
        }
        long i3 = v.i(dzF, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, i3, j2);
        }
        long dzF2 = lVar.dzF();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i4 = 0; i4 < 99; i4++) {
            jArr[i4] = lVar.readUnsignedByte();
        }
        return new d(j3, i3, j2, jArr, dzF2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mgL = j;
        this.lZO = j2;
        this.mgZ = j3;
        this.mha = jArr;
        this.mhb = j4;
        this.mhc = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duR() {
        return this.mha != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (!duR()) {
            return this.mgL;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lZO);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mha[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mha[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mgL + Math.round(r0 * 0.00390625d * this.mhb), this.mgZ != -1 ? this.mgZ - 1 : ((this.mgL - this.mhc) + this.mhb) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        if (!duR() || j < this.mgL) {
            return 0L;
        }
        double d = (256.0d * (j - this.mgL)) / this.mhb;
        int a = v.a(this.mha, (long) d, true, false) + 1;
        long JH = JH(a);
        long j2 = a == 0 ? 0L : this.mha[a - 1];
        long j3 = a == 99 ? 256L : this.mha[a];
        return JH + (j3 == j2 ? 0L : (long) (((JH(a + 1) - JH) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZO;
    }

    private long JH(int i) {
        return (this.lZO * i) / 100;
    }
}
