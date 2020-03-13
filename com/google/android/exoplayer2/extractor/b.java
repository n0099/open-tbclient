package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class b implements f {
    private static final byte[] meg = new byte[4096];
    private long fOo;
    private final com.google.android.exoplayer2.upstream.e meh;
    private final long mei;
    private byte[] mej = new byte[65536];
    private int mek;
    private int mel;

    public b(com.google.android.exoplayer2.upstream.e eVar, long j, long j2) {
        this.meh = eVar;
        this.fOo = j;
        this.mei = j2;
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
            Jy = a(meg, 0, Math.min(i, meg.length), 0, true);
        }
        JA(Jy);
        return Jy;
    }

    public boolean Z(int i, boolean z) throws IOException, InterruptedException {
        int Jy = Jy(i);
        while (Jy < i && Jy != -1) {
            Jy = a(meg, -Jy, Math.min(i, meg.length + Jy), Jy, z);
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
        System.arraycopy(this.mej, this.mek - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void s(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        e(bArr, i, i2, false);
    }

    public boolean aa(int i, boolean z) throws IOException, InterruptedException {
        Jx(i);
        int min = Math.min(this.mel - this.mek, i);
        while (min < i) {
            min = a(this.mej, this.mek, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.mek += i;
        this.mel = Math.max(this.mel, this.mek);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jw(int i) throws IOException, InterruptedException {
        aa(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void duS() {
        this.mek = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long duT() {
        return this.fOo + this.mek;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getPosition() {
        return this.fOo;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getLength() {
        return this.mei;
    }

    private void Jx(int i) {
        int i2 = this.mek + i;
        if (i2 > this.mej.length) {
            this.mej = Arrays.copyOf(this.mej, v.am(this.mej.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int Jy(int i) {
        int min = Math.min(this.mel, i);
        Jz(min);
        return min;
    }

    private int t(byte[] bArr, int i, int i2) {
        if (this.mel == 0) {
            return 0;
        }
        int min = Math.min(this.mel, i2);
        System.arraycopy(this.mej, 0, bArr, i, min);
        Jz(min);
        return min;
    }

    private void Jz(int i) {
        this.mel -= i;
        this.mek = 0;
        byte[] bArr = this.mej;
        if (this.mel < this.mej.length - 524288) {
            bArr = new byte[this.mel + 65536];
        }
        System.arraycopy(this.mej, i, bArr, 0, this.mel);
        this.mej = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.meh.read(bArr, i + i3, i2 - i3);
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
            this.fOo += i;
        }
    }
}
