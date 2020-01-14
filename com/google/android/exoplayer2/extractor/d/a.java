package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.l;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a implements f {
    private long end;
    private final long endPosition;
    private final e mks = new e();
    private final h mkt;
    private long mku;
    private long mkv;
    private long mkw;
    private long mkx;
    private long mky;
    private long start;
    private final long startPosition;
    private int state;

    public a(long j, long j2, h hVar, int i, long j3) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0 && j2 > j);
        this.mkt = hVar;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.mku = j3;
            this.state = 3;
            return;
        }
        this.state = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.extractor.d.f
    public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        long j = 0;
        switch (this.state) {
            case 0:
                this.mkv = fVar.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.mkv) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.mkw != 0) {
                    long a = a(this.mkw, fVar);
                    if (a >= 0) {
                        return a;
                    }
                    j = a(fVar, this.mkw, -(a + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.mku = w(fVar);
        this.state = 3;
        return this.mkv;
    }

    @Override // com.google.android.exoplayer2.extractor.d.f
    public long fU(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(this.state == 3 || this.state == 2);
        this.mkw = j == 0 ? 0L : this.mkt.fX(j);
        this.state = 2;
        dtV();
        return this.mkw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.d.f
    /* renamed from: dtU */
    public C0668a dtW() {
        if (this.mku != 0) {
            return new C0668a();
        }
        return null;
    }

    public void dtV() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.mkx = 0L;
        this.mky = this.mku;
    }

    public long a(long j, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.mkx + 2);
        }
        long position = fVar.getPosition();
        if (!a(fVar, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.mks.c(fVar, false);
        fVar.dtE();
        long j2 = j - this.mks.mkP;
        int i = this.mks.mgj + this.mks.mkU;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.mky = this.mks.mkP;
            } else {
                this.start = fVar.getPosition() + i;
                this.mkx = this.mks.mkP;
                if ((this.end - this.start) + i < 100000) {
                    fVar.Jq(i);
                    return -(this.mkx + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((fVar.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.mky - this.mkx)), this.start), this.end - 1);
        }
        fVar.Jq(i);
        return -(this.mks.mkP + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.mku) - j3) + j;
        if (j4 < this.startPosition) {
            j4 = this.startPosition;
        }
        if (j4 >= this.endPosition) {
            return this.endPosition - 1;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.extractor.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0668a implements l {
        private C0668a() {
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dtD() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fN(long j) {
            if (j == 0) {
                return a.this.startPosition;
            }
            return a.this.e(a.this.startPosition, a.this.mkt.fX(j), 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long dsq() {
            return a.this.mkt.fW(a.this.mku);
        }
    }

    void v(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (!a(fVar, this.endPosition)) {
            throw new EOFException();
        }
    }

    boolean a(com.google.android.exoplayer2.extractor.f fVar, long j) throws IOException, InterruptedException {
        long min = Math.min(3 + j, this.endPosition);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (fVar.getPosition() + length > min && (length = (int) (min - fVar.getPosition())) < 4) {
                return false;
            }
            fVar.e(bArr, 0, length, false);
            for (int i = 0; i < length - 3; i++) {
                if (bArr[i] == 79 && bArr[i + 1] == 103 && bArr[i + 2] == 103 && bArr[i + 3] == 83) {
                    fVar.Jq(i);
                    return true;
                }
            }
            fVar.Jq(length - 3);
        }
    }

    long w(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        v(fVar);
        this.mks.reset();
        while ((this.mks.type & 4) != 4 && fVar.getPosition() < this.endPosition) {
            this.mks.c(fVar, false);
            fVar.Jq(this.mks.mgj + this.mks.mkU);
        }
        return this.mks.mkP;
    }

    long a(com.google.android.exoplayer2.extractor.f fVar, long j, long j2) throws IOException, InterruptedException {
        this.mks.c(fVar, false);
        while (this.mks.mkP < j) {
            fVar.Jq(this.mks.mgj + this.mks.mkU);
            j2 = this.mks.mkP;
            this.mks.c(fVar, false);
        }
        fVar.dtE();
        return j2;
    }
}
