package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class b implements f {
    private static final byte[] mdn = new byte[4096];
    private long fLD;
    private final com.google.android.exoplayer2.upstream.e mdo;
    private final long mdp;
    private byte[] mdq = new byte[65536];
    private int mdr;
    private int mds;

    public b(com.google.android.exoplayer2.upstream.e eVar, long j, long j2) {
        this.mdo = eVar;
        this.fLD = j;
        this.mdp = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int p = p(bArr, i, i2);
        if (p == 0) {
            p = a(bArr, i, i2, 0, true);
        }
        Jv(p);
        return p;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean d(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int p = p(bArr, i, i2);
        while (p < i2 && p != -1) {
            p = a(bArr, i, i2, p, z);
        }
        Jv(p);
        return p != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        d(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public int Jp(int i) throws IOException, InterruptedException {
        int Jt = Jt(i);
        if (Jt == 0) {
            Jt = a(mdn, 0, Math.min(i, mdn.length), 0, true);
        }
        Jv(Jt);
        return Jt;
    }

    public boolean aa(int i, boolean z) throws IOException, InterruptedException {
        int Jt = Jt(i);
        while (Jt < i && Jt != -1) {
            Jt = a(mdn, -Jt, Math.min(i, mdn.length + Jt), Jt, z);
        }
        Jv(Jt);
        return Jt != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jq(int i) throws IOException, InterruptedException {
        aa(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public boolean e(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!ab(i2, z)) {
            return false;
        }
        System.arraycopy(this.mdq, this.mdr - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void o(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        e(bArr, i, i2, false);
    }

    public boolean ab(int i, boolean z) throws IOException, InterruptedException {
        Js(i);
        int min = Math.min(this.mds - this.mdr, i);
        while (min < i) {
            min = a(this.mdq, this.mdr, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.mdr += i;
        this.mds = Math.max(this.mds, this.mdr);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void Jr(int i) throws IOException, InterruptedException {
        ab(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public void dtE() {
        this.mdr = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long dtF() {
        return this.fLD + this.mdr;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getPosition() {
        return this.fLD;
    }

    @Override // com.google.android.exoplayer2.extractor.f
    public long getLength() {
        return this.mdp;
    }

    private void Js(int i) {
        int i2 = this.mdr + i;
        if (i2 > this.mdq.length) {
            this.mdq = Arrays.copyOf(this.mdq, v.al(this.mdq.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int Jt(int i) {
        int min = Math.min(this.mds, i);
        Ju(min);
        return min;
    }

    private int p(byte[] bArr, int i, int i2) {
        if (this.mds == 0) {
            return 0;
        }
        int min = Math.min(this.mds, i2);
        System.arraycopy(this.mdq, 0, bArr, i, min);
        Ju(min);
        return min;
    }

    private void Ju(int i) {
        this.mds -= i;
        this.mdr = 0;
        byte[] bArr = this.mdq;
        if (this.mds < this.mdq.length - 524288) {
            bArr = new byte[this.mds + 65536];
        }
        System.arraycopy(this.mdq, i, bArr, 0, this.mds);
        this.mdq = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.mdo.read(bArr, i + i3, i2 - i3);
        if (read == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + read;
    }

    private void Jv(int i) {
        if (i != -1) {
            this.fLD += i;
        }
    }
}
