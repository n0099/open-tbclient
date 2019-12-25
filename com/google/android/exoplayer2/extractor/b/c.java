package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
final class c implements b.a {
    private final long lUZ;
    private final long[] lZp;
    private final long[] mcl;

    public static c a(j jVar, l lVar, long j, long j2) {
        int dxg;
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
                    dxg = lVar.readUnsignedByte();
                    break;
                case 2:
                    dxg = lVar.readUnsignedShort();
                    break;
                case 3:
                    dxg = lVar.dwZ();
                    break;
                case 4:
                    dxg = lVar.dxg();
                    break;
                default:
                    return null;
            }
            j3 += dxg * readUnsignedShort2;
            jArr[i2] = (i2 * h) / readUnsignedShort;
            jArr2[i2] = j2 == -1 ? j3 : Math.min(j2, j3);
        }
        return new c(jArr, jArr2, h);
    }

    private c(long[] jArr, long[] jArr2, long j) {
        this.lZp = jArr;
        this.mcl = jArr2;
        this.lUZ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        return this.mcl[v.a(this.lZp, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fK(long j) {
        return this.lZp[v.a(this.mcl, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.lUZ;
    }
}
