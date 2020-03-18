package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class b implements f {
    private static final byte[] mfM = new byte[4096];
    private long fOW;
    private final com.google.android.exoplayer2.upstream.e mfN;
    private final long mfO;
    private byte[] mfP = new byte[65536];
    private int mfQ;
    private int mfR;

    public b(com.google.android.exoplayer2.upstream.e eVar, long j, long j2) {
        this.mfN = eVar;
        this.fOW = j;
        this.mfO = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int t = t(bArr, i, i2);
        if (t == 0) {
            t = a(bArr, i, i2, 0, true);
        }
        JG(t);
        return t;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int t = t(bArr, i, i2);
        while (t < i2 && t != -1) {
            t = a(bArr, i, i2, t, z);
        }
        JG(t);
        return t != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        d(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int JA(int i) throws IOException, InterruptedException {
        int JE = JE(i);
        if (JE == 0) {
            JE = a(mfM, 0, Math.min(i, mfM.length), 0, true);
        }
        JG(JE);
        return JE;
    }

    public boolean Z(int i, boolean z) throws IOException, InterruptedException {
        int JE = JE(i);
        while (JE < i && JE != -1) {
            JE = a(mfM, -JE, Math.min(i, mfM.length + JE), JE, z);
        }
        JG(JE);
        return JE != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void JB(int i) throws IOException, InterruptedException {
        Z(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!aa(i2, z)) {
            return false;
        }
        System.arraycopy(this.mfP, this.mfQ - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void s(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        e(bArr, i, i2, false);
    }

    public boolean aa(int i, boolean z) throws IOException, InterruptedException {
        JD(i);
        int min = Math.min(this.mfR - this.mfQ, i);
        while (min < i) {
            min = a(this.mfP, this.mfQ, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.mfQ += i;
        this.mfR = Math.max(this.mfR, this.mfQ);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void JC(int i) throws IOException, InterruptedException {
        aa(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void dvp() {
        this.mfQ = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long dvq() {
        return this.fOW + this.mfQ;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getPosition() {
        return this.fOW;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getLength() {
        return this.mfO;
    }

    private void JD(int i) {
        int i2 = this.mfQ + i;
        if (i2 > this.mfP.length) {
            this.mfP = Arrays.copyOf(this.mfP, v.am(this.mfP.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int JE(int i) {
        int min = Math.min(this.mfR, i);
        JF(min);
        return min;
    }

    private int t(byte[] bArr, int i, int i2) {
        if (this.mfR == 0) {
            return 0;
        }
        int min = Math.min(this.mfR, i2);
        System.arraycopy(this.mfP, 0, bArr, i, min);
        JF(min);
        return min;
    }

    private void JF(int i) {
        this.mfR -= i;
        this.mfQ = 0;
        byte[] bArr = this.mfP;
        if (this.mfR < this.mfP.length - 524288) {
            bArr = new byte[this.mfR + 65536];
        }
        System.arraycopy(this.mfP, i, bArr, 0, this.mfR);
        this.mfP = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.mfN.read(bArr, i + i3, i2 - i3);
        if (read == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + read;
    }

    private void JG(int i) {
        if (i != -1) {
            this.fOW += i;
        }
    }
}
