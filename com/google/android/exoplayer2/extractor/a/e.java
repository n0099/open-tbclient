package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes6.dex */
final class e {
    private final l mgq = new l(8);
    private int mir;

    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        long length = fVar.getLength();
        int i = (int) ((length == -1 || length > 1024) ? 1024L : length);
        fVar.s(this.mgq.data, 0, 4);
        long readUnsignedInt = this.mgq.readUnsignedInt();
        this.mir = 4;
        while (readUnsignedInt != 440786851) {
            int i2 = this.mir + 1;
            this.mir = i2;
            if (i2 == i) {
                return false;
            }
            fVar.s(this.mgq.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.mgq.data[0] & 255);
        }
        long i3 = i(fVar);
        long j = this.mir;
        if (i3 != Long.MIN_VALUE) {
            if (length == -1 || j + i3 < length) {
                while (this.mir < j + i3) {
                    if (i(fVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long i4 = i(fVar);
                    if (i4 < 0 || i4 > 2147483647L) {
                        return false;
                    }
                    if (i4 != 0) {
                        fVar.JC((int) i4);
                        this.mir = (int) (i4 + this.mir);
                    }
                }
                return ((long) this.mir) == i3 + j;
            }
            return false;
        }
        return false;
    }

    private long i(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.s(this.mgq.data, 0, 1);
        int i = this.mgq.data[0] & 255;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((i & i2) == 0) {
            i3++;
            i2 >>= 1;
        }
        int i4 = (i2 ^ (-1)) & i;
        fVar.s(this.mgq.data, 1, i3);
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 << 8) + (this.mgq.data[i5 + 1] & 255);
        }
        this.mir += i3 + 1;
        return i4;
    }
}
