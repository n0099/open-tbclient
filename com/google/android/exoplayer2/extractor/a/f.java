package com.google.android.exoplayer2.extractor.a;

import java.io.IOException;
/* loaded from: classes6.dex */
final class f {
    private static final long[] mgK = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] mfa = new byte[8];
    private int state;

    public void reset() {
        this.state = 0;
        this.length = 0;
    }

    public long a(com.google.android.exoplayer2.extractor.f fVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!fVar.d(this.mfa, 0, 1, z)) {
                return -1L;
            }
            this.length = JG(this.mfa[0] & 255);
            if (this.length == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.state = 1;
        }
        if (this.length > i) {
            this.state = 0;
            return -2L;
        }
        if (this.length != 1) {
            fVar.readFully(this.mfa, 1, this.length - 1);
        }
        this.state = 0;
        return a(this.mfa, this.length, z2);
    }

    public int dvc() {
        return this.length;
    }

    public static int JG(int i) {
        for (int i2 = 0; i2 < mgK.length; i2++) {
            if ((mgK[i2] & i) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= mgK[i - 1] ^ (-1);
        }
        long j2 = j;
        for (int i2 = 1; i2 < i; i2++) {
            j2 = (j2 << 8) | (bArr[i2] & 255);
        }
        return j2;
    }
}
