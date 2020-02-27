package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class b implements f {
    private static final byte[] mdT = new byte[4096];
    private long fNZ;
    private final com.google.android.exoplayer2.upstream.e mdU;
    private final long mdV;
    private byte[] mdW = new byte[65536];
    private int mdX;
    private int mdY;

    public b(com.google.android.exoplayer2.upstream.e eVar, long j, long j2) {
        this.mdU = eVar;
        this.fNZ = j;
        this.mdV = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int t = t(bArr, i, i2);
        if (t == 0) {
            t = a(bArr, i, i2, 0, true);
        }
        JA(t);
        return t;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int t = t(bArr, i, i2);
        while (t < i2 && t != -1) {
            t = a(bArr, i, i2, t, z);
        }
        JA(t);
        return t != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        d(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int Ju(int i) throws IOException, InterruptedException {
        int Jy = Jy(i);
        if (Jy == 0) {
            Jy = a(mdT, 0, Math.min(i, mdT.length), 0, true);
        }
        JA(Jy);
        return Jy;
    }

    public boolean Z(int i, boolean z) throws IOException, InterruptedException {
        int Jy = Jy(i);
        while (Jy < i && Jy != -1) {
            Jy = a(mdT, -Jy, Math.min(i, mdT.length + Jy), Jy, z);
        }
        JA(Jy);
        return Jy != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jv(int i) throws IOException, InterruptedException {
        Z(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!aa(i2, z)) {
            return false;
        }
        System.arraycopy(this.mdW, this.mdX - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void s(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        e(bArr, i, i2, false);
    }

    public boolean aa(int i, boolean z) throws IOException, InterruptedException {
        Jx(i);
        int min = Math.min(this.mdY - this.mdX, i);
        while (min < i) {
            min = a(this.mdW, this.mdX, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.mdX += i;
        this.mdY = Math.max(this.mdY, this.mdX);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jw(int i) throws IOException, InterruptedException {
        aa(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void duP() {
        this.mdX = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long duQ() {
        return this.fNZ + this.mdX;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getPosition() {
        return this.fNZ;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getLength() {
        return this.mdV;
    }

    private void Jx(int i) {
        int i2 = this.mdX + i;
        if (i2 > this.mdW.length) {
            this.mdW = Arrays.copyOf(this.mdW, v.am(this.mdW.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int Jy(int i) {
        int min = Math.min(this.mdY, i);
        Jz(min);
        return min;
    }

    private int t(byte[] bArr, int i, int i2) {
        if (this.mdY == 0) {
            return 0;
        }
        int min = Math.min(this.mdY, i2);
        System.arraycopy(this.mdW, 0, bArr, i, min);
        Jz(min);
        return min;
    }

    private void Jz(int i) {
        this.mdY -= i;
        this.mdX = 0;
        byte[] bArr = this.mdW;
        if (this.mdY < this.mdW.length - 524288) {
            bArr = new byte[this.mdY + 65536];
        }
        System.arraycopy(this.mdW, i, bArr, 0, this.mdY);
        this.mdW = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.mdU.read(bArr, i + i3, i2 - i3);
        if (read == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + read;
    }

    private void JA(int i) {
        if (i != -1) {
            this.fNZ += i;
        }
    }
}
