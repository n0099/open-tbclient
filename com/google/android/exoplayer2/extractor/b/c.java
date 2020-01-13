package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class c implements b.a {
    private final long lYQ;
    private final long[] mdh;
    private final long[] mga;

    public static c a(j jVar, l lVar, long j, long j2) {
        int dyq;
        lVar.skipBytes(10);
        int readInt = lVar.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i = jVar.sampleRate;
        long h = v.h(readInt, (i >= 32000 ? 1152 : 576) * TimeUtils.NANOS_PER_MS, i);
        int readUnsignedShort = lVar.readUnsignedShort();
        int readUnsignedShort2 = lVar.readUnsignedShort();
        int readUnsignedShort3 = lVar.readUnsignedShort();
        lVar.skipBytes(2);
        long j3 = j + jVar.frameSize;
        long[] jArr = new long[readUnsignedShort + 1];
        long[] jArr2 = new long[readUnsignedShort + 1];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (int i2 = 1; i2 < jArr.length; i2++) {
            switch (readUnsignedShort3) {
                case 1:
                    dyq = lVar.readUnsignedByte();
                    break;
                case 2:
                    dyq = lVar.readUnsignedShort();
                    break;
                case 3:
                    dyq = lVar.dyj();
                    break;
                case 4:
                    dyq = lVar.dyq();
                    break;
                default:
                    return null;
            }
            j3 += dyq * readUnsignedShort2;
            jArr[i2] = (i2 * h) / readUnsignedShort;
            jArr2[i2] = j2 == -1 ? j3 : Math.min(j2, j3);
        }
        return new c(jArr, jArr2, h);
    }

    private c(long[] jArr, long[] jArr2, long j) {
        this.mdh = jArr;
        this.mga = jArr2;
        this.lYQ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtB() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return this.mga[v.a(this.mdh, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fP(long j) {
        return this.mdh[v.a(this.mga, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.lYQ;
    }
}
