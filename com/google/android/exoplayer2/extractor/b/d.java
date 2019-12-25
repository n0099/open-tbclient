package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
final class d implements b.a {
    private final long lUZ;
    private final long mbY;
    private final long mcm;
    private final long[] mcn;
    private final long mco;
    private final int mcp;

    public static d b(j jVar, l lVar, long j, long j2) {
        int dxg;
        int i = jVar.samplesPerFrame;
        int i2 = jVar.sampleRate;
        long j3 = j + jVar.frameSize;
        int readInt = lVar.readInt();
        if ((readInt & 1) != 1 || (dxg = lVar.dxg()) == 0) {
            return null;
        }
        long h = v.h(dxg, i * TimeUtils.NANOS_PER_MS, i2);
        if ((readInt & 6) != 6) {
            return new d(j3, h, j2);
        }
        long dxg2 = lVar.dxg();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i3 = 0; i3 < 99; i3++) {
            jArr[i3] = lVar.readUnsignedByte();
        }
        return new d(j3, h, j2, jArr, dxg2, jVar.frameSize);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.mbY = j;
        this.lUZ = j2;
        this.mcm = j3;
        this.mcn = jArr;
        this.mco = j4;
        this.mcp = i;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return this.mcn != null;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        if (!dsp()) {
            return this.mbY;
        }
        float f = (((float) j) * 100.0f) / ((float) this.lUZ);
        if (f <= 0.0f) {
            r0 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            float f2 = i != 0 ? (float) this.mcn[i - 1] : 0.0f;
            r0 = (((i < 99 ? (float) this.mcn[i] : 256.0f) - f2) * (f - i)) + f2;
        }
        return Math.min(this.mbY + Math.round(r0 * 0.00390625d * this.mco), this.mcm != -1 ? this.mcm - 1 : ((this.mbY - this.mcp) + this.mco) - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fK(long j) {
        if (!dsp() || j < this.mbY) {
            return 0L;
        }
        double d = (256.0d * (j - this.mbY)) / this.mco;
        int a = v.a(this.mcn, (long) d, true, false) + 1;
        long Jt = Jt(a);
        long j2 = a == 0 ? 0L : this.mcn[a - 1];
        long j3 = a == 99 ? 256L : this.mcn[a];
        return Jt + (j3 == j2 ? 0L : (long) (((Jt(a + 1) - Jt) * (d - j2)) / (j3 - j2)));
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.lUZ;
    }

    private long Jt(int i) {
        return (this.lUZ * i) / 100;
    }
}
