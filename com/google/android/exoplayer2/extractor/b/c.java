package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class c implements b.a {
    private final long mbx;
    private final long[] mfL;
    private final long[] miG;

    public static c a(j jVar, l lVar, long j, long j2) {
        int dAc;
        lVar.skipBytes(10);
        int readInt = lVar.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i = jVar.sampleRate;
        long i2 = v.i(readInt, (i >= 32000 ? 1152 : 576) * TimeUtils.NANOS_PER_MS, i);
        int readUnsignedShort = lVar.readUnsignedShort();
        int readUnsignedShort2 = lVar.readUnsignedShort();
        int readUnsignedShort3 = lVar.readUnsignedShort();
        lVar.skipBytes(2);
        long j3 = j + jVar.frameSize;
        long[] jArr = new long[readUnsignedShort + 1];
        long[] jArr2 = new long[readUnsignedShort + 1];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (int i3 = 1; i3 < jArr.length; i3++) {
            switch (readUnsignedShort3) {
                case 1:
                    dAc = lVar.readUnsignedByte();
                    break;
                case 2:
                    dAc = lVar.readUnsignedShort();
                    break;
                case 3:
                    dAc = lVar.dzV();
                    break;
                case 4:
                    dAc = lVar.dAc();
                    break;
                default:
                    return null;
            }
            j3 += dAc * readUnsignedShort2;
            jArr[i3] = (i3 * i2) / readUnsignedShort;
            jArr2[i3] = j2 == -1 ? j3 : Math.min(j2, j3);
        }
        return new c(jArr, jArr2, i2);
    }

    private c(long[] jArr, long[] jArr2, long j) {
        this.mfL = jArr;
        this.miG = jArr2;
        this.mbx = j;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        return this.miG[v.a(this.mfL, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fO(long j) {
        return this.mfL[v.a(this.miG, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mbx;
    }
}
