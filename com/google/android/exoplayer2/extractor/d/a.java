package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.l;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a implements f {
    private long end;
    private final long endPosition;
    private final e mkn = new e();
    private final h mko;
    private long mkp;
    private long mkq;
    private long mkr;
    private long mks;
    private long mkt;
    private long start;
    private final long startPosition;
    private int state;

    public a(long j, long j2, h hVar, int i, long j3) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0 && j2 > j);
        this.mko = hVar;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.mkp = j3;
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
                this.mkq = fVar.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.mkq) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.mkr != 0) {
                    long a = a(this.mkr, fVar);
                    if (a >= 0) {
                        return a;
                    }
                    j = a(fVar, this.mkr, -(a + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.mkp = w(fVar);
        this.state = 3;
        return this.mkq;
    }

    @Override // com.google.android.exoplayer2.extractor.d.f
    public long fU(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(this.state == 3 || this.state == 2);
        this.mkr = j == 0 ? 0L : this.mko.fX(j);
        this.state = 2;
        dtT();
        return this.mkr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.d.f
    /* renamed from: dtS */
    public C0668a dtU() {
        if (this.mkp != 0) {
            return new C0668a();
        }
        return null;
    }

    public void dtT() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.mks = 0L;
        this.mkt = this.mkp;
    }

    public long a(long j, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.mks + 2);
        }
        long position = fVar.getPosition();
        if (!a(fVar, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.mkn.c(fVar, false);
        fVar.dtC();
        long j2 = j - this.mkn.mkK;
        int i = this.mkn.mge + this.mkn.mkP;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.mkt = this.mkn.mkK;
            } else {
                this.start = fVar.getPosition() + i;
                this.mks = this.mkn.mkK;
                if ((this.end - this.start) + i < 100000) {
                    fVar.Jq(i);
                    return -(this.mks + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((fVar.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.mkt - this.mks)), this.start), this.end - 1);
        }
        fVar.Jq(i);
        return -(this.mkn.mkK + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.mkp) - j3) + j;
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
        public boolean dtB() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fN(long j) {
            if (j == 0) {
                return a.this.startPosition;
            }
            return a.this.e(a.this.startPosition, a.this.mko.fX(j), 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long dso() {
            return a.this.mko.fW(a.this.mkp);
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
        this.mkn.reset();
        while ((this.mkn.type & 4) != 4 && fVar.getPosition() < this.endPosition) {
            this.mkn.c(fVar, false);
            fVar.Jq(this.mkn.mge + this.mkn.mkP);
        }
        return this.mkn.mkK;
    }

    long a(com.google.android.exoplayer2.extractor.f fVar, long j, long j2) throws IOException, InterruptedException {
        this.mkn.c(fVar, false);
        while (this.mkn.mkK < j) {
            fVar.Jq(this.mkn.mge + this.mkn.mkP);
            j2 = this.mkn.mkK;
            this.mkn.c(fVar, false);
        }
        fVar.dtC();
        return j2;
    }
}
