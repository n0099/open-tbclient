package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.util.l;
import java.io.IOException;
/* loaded from: classes5.dex */
final class e {
    private final l mdR = new l(8);
    private int mfQ;

    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        long length = fVar.getLength();
        int i = (int) ((length == -1 || length > 1024) ? 1024L : length);
        fVar.o(this.mdR.data, 0, 4);
        long readUnsignedInt = this.mdR.readUnsignedInt();
        this.mfQ = 4;
        while (readUnsignedInt != 440786851) {
            int i2 = this.mfQ + 1;
            this.mfQ = i2;
            if (i2 == i) {
                return false;
            }
            fVar.o(this.mdR.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.mdR.data[0] & 255);
        }
        long i3 = i(fVar);
        long j = this.mfQ;
        if (i3 != Long.MIN_VALUE) {
            if (length == -1 || j + i3 < length) {
                while (this.mfQ < j + i3) {
                    if (i(fVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long i4 = i(fVar);
                    if (i4 < 0 || i4 > 2147483647L) {
                        return false;
                    }
                    if (i4 != 0) {
                        fVar.Jr((int) i4);
                        this.mfQ = (int) (i4 + this.mfQ);
                    }
                }
                return ((long) this.mfQ) == i3 + j;
            }
            return false;
        }
        return false;
    }

    private long i(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.o(this.mdR.data, 0, 1);
        int i = this.mdR.data[0] & 255;
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
        fVar.o(this.mdR.data, 1, i3);
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 << 8) + (this.mdR.data[i5 + 1] & 255);
        }
        this.mfQ += i3 + 1;
        return i4;
    }
}
