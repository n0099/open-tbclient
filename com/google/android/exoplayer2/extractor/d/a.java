package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.l;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a implements f {
    private long end;
    private final long endPosition;
    private final e mkY = new e();
    private final h mkZ;
    private long mla;
    private long mlb;
    private long mlc;
    private long mld;
    private long mle;
    private long start;
    private final long startPosition;
    private int state;

    public a(long j, long j2, h hVar, int i, long j3) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0 && j2 > j);
        this.mkZ = hVar;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.mla = j3;
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
                this.mlb = fVar.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.mlb) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.mlc != 0) {
                    long a = a(this.mlc, fVar);
                    if (a >= 0) {
                        return a;
                    }
                    j = a(fVar, this.mlc, -(a + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.mla = w(fVar);
        this.state = 3;
        return this.mlb;
    }

    @Override // com.google.android.exoplayer2.extractor.d.f
    public long fS(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(this.state == 3 || this.state == 2);
        this.mlc = j == 0 ? 0L : this.mkZ.fV(j);
        this.state = 2;
        dvg();
        return this.mlc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.d.f
    /* renamed from: dvf */
    public C0676a dvh() {
        if (this.mla != 0) {
            return new C0676a();
        }
        return null;
    }

    public void dvg() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.mld = 0L;
        this.mle = this.mla;
    }

    public long a(long j, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.mld + 2);
        }
        long position = fVar.getPosition();
        if (!a(fVar, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.mkY.c(fVar, false);
        fVar.duP();
        long j2 = j - this.mkY.mlv;
        int i = this.mkY.mgP + this.mkY.mlA;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.mle = this.mkY.mlv;
            } else {
                this.start = fVar.getPosition() + i;
                this.mld = this.mkY.mlv;
                if ((this.end - this.start) + i < 100000) {
                    fVar.Jv(i);
                    return -(this.mld + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((fVar.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.mle - this.mld)), this.start), this.end - 1);
        }
        fVar.Jv(i);
        return -(this.mkY.mlv + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long f(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.mla) - j3) + j;
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
    /* loaded from: classes6.dex */
    public class C0676a implements l {
        private C0676a() {
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duO() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            if (j == 0) {
                return a.this.startPosition;
            }
            return a.this.f(a.this.startPosition, a.this.mkZ.fV(j), 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return a.this.mkZ.fU(a.this.mla);
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
                    fVar.Jv(i);
                    return true;
                }
            }
            fVar.Jv(length - 3);
        }
    }

    long w(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        v(fVar);
        this.mkY.reset();
        while ((this.mkY.type & 4) != 4 && fVar.getPosition() < this.endPosition) {
            this.mkY.c(fVar, false);
            fVar.Jv(this.mkY.mgP + this.mkY.mlA);
        }
        return this.mkY.mlv;
    }

    long a(com.google.android.exoplayer2.extractor.f fVar, long j, long j2) throws IOException, InterruptedException {
        this.mkY.c(fVar, false);
        while (this.mkY.mlv < j) {
            fVar.Jv(this.mkY.mgP + this.mkY.mlA);
            j2 = this.mkY.mlv;
            this.mkY.c(fVar, false);
        }
        fVar.duP();
        return j2;
    }
}
