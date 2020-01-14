package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class d implements b.a {
    private final long lYV;
    private final long mfS;
    private final long mgg;
    private final long[] mgh;
    private final long mgi;
    private final int mgj;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dys;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dys = lVar.dys()) == 0) {
            return null;
        }
        long h = v.h(dys, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, h, j2);
        }
        long dys2 = lVar.dys();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i3 = 0; i3 < 99; i3++) {
            jArr[i3] = lVar.readUnsignedByte();
        }
        return new d(j3, h, j2, jArr, dys2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mfS = j;
        this.lYV = j2;
        this.mgg = j3;
        this.mgh = jArr;
        this.mgi = j4;
        this.mgj = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtD() {
        return this.mgh != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        if (!dtD()) {
            return this.mfS;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lYV);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mgh[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mgh[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mfS + Math.round(r0 * 0.00390625d * this.mgi), this.mgg != -1 ? this.mgg - 1 : ((this.mfS - this.mgj) + this.mgi) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fP(long j) {
        if (!dtD() || j < this.mfS) {
            return 0L;
        }
        double d = (256.0d * (j - this.mfS)) / this.mgi;
        int a = v.a(this.mgh, (long) d, true, false) + 1;
        long JC = JC(a);
        long j2 = a == 0 ? 0L : this.mgh[a - 1];
        long j3 = a == 99 ? 256L : this.mgh[a];
        return JC + (j3 == j2 ? 0L : (long) (((JC(a + 1) - JC) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.lYV;
    }

    private long JC(int i) {
        return (this.lYV * i) / 100;
    }
}
