package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class b implements f {
    private static final byte[] lZq = new byte[4096];
    private long fIt;
    private final com.google.android.exoplayer2.upstream.e lZr;
    private final long lZs;
    private byte[] lZt = new byte[65536];
    private int lZu;
    private int lZv;

    public b(com.google.android.exoplayer2.upstream.e eVar, long j, long j2) {
        this.lZr = eVar;
        this.fIt = j;
        this.lZs = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int q = q(bArr, i, i2);
        if (q == 0) {
            q = a(bArr, i, i2, 0, true);
        }
        Jm(q);
        return q;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int q = q(bArr, i, i2);
        while (q < i2 && q != -1) {
            q = a(bArr, i, i2, q, z);
        }
        Jm(q);
        return q != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        d(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int Jg(int i) throws IOException, InterruptedException {
        int Jk = Jk(i);
        if (Jk == 0) {
            Jk = a(lZq, 0, Math.min(i, lZq.length), 0, true);
        }
        Jm(Jk);
        return Jk;
    }

    public boolean aa(int i, boolean z) throws IOException, InterruptedException {
        int Jk = Jk(i);
        while (Jk < i && Jk != -1) {
            Jk = a(lZq, -Jk, Math.min(i, lZq.length + Jk), Jk, z);
        }
        Jm(Jk);
        return Jk != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jh(int i) throws IOException, InterruptedException {
        aa(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!ab(i2, z)) {
            return false;
        }
        System.arraycopy(this.lZt, this.lZu - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void p(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        e(bArr, i, i2, false);
    }

    public boolean ab(int i, boolean z) throws IOException, InterruptedException {
        Jj(i);
        int min = Math.min(this.lZv - this.lZu, i);
        while (min < i) {
            min = a(this.lZt, this.lZu, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.lZu += i;
        this.lZv = Math.max(this.lZv, this.lZu);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Ji(int i) throws IOException, InterruptedException {
        ab(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void dsq() {
        this.lZu = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long dsr() {
        return this.fIt + this.lZu;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getPosition() {
        return this.fIt;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getLength() {
        return this.lZs;
    }

    private void Jj(int i) {
        int i2 = this.lZu + i;
        if (i2 > this.lZt.length) {
            this.lZt = Arrays.copyOf(this.lZt, v.al(this.lZt.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int Jk(int i) {
        int min = Math.min(this.lZv, i);
        Jl(min);
        return min;
    }

    private int q(byte[] bArr, int i, int i2) {
        if (this.lZv == 0) {
            return 0;
        }
        int min = Math.min(this.lZv, i2);
        System.arraycopy(this.lZt, 0, bArr, i, min);
        Jl(min);
        return min;
    }

    private void Jl(int i) {
        this.lZv -= i;
        this.lZu = 0;
        byte[] bArr = this.lZt;
        if (this.lZv < this.lZt.length - 524288) {
            bArr = new byte[this.lZv + 65536];
        }
        System.arraycopy(this.lZt, i, bArr, 0, this.lZv);
        this.lZt = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.lZr.read(bArr, i + i3, i2 - i3);
        if (read == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + read;
    }

    private void Jm(int i) {
        if (i != -1) {
            this.fIt += i;
        }
    }
}
