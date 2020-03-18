package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.l;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a implements f {
    private long end;
    private final long endPosition;
    private final e mmR = new e();
    private final h mmS;
    private long mmT;
    private long mmU;
    private long mmV;
    private long mmW;
    private long mmX;
    private long start;
    private final long startPosition;
    private int state;

    public a(long j, long j2, h hVar, int i, long j3) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0 && j2 > j);
        this.mmS = hVar;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.mmT = j3;
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
                this.mmU = fVar.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.mmU) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.mmV != 0) {
                    long a = a(this.mmV, fVar);
                    if (a >= 0) {
                        return a;
                    }
                    j = a(fVar, this.mmV, -(a + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.mmT = w(fVar);
        this.state = 3;
        return this.mmU;
    }

    @Override // com.google.android.exoplayer2.extractor.d.f
    public long fT(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(this.state == 3 || this.state == 2);
        this.mmV = j == 0 ? 0L : this.mmS.fW(j);
        this.state = 2;
        dvG();
        return this.mmV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.d.f
    /* renamed from: dvF */
    public C0677a dvH() {
        if (this.mmT != 0) {
            return new C0677a();
        }
        return null;
    }

    public void dvG() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.mmW = 0L;
        this.mmX = this.mmT;
    }

    public long a(long j, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.mmW + 2);
        }
        long position = fVar.getPosition();
        if (!a(fVar, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.mmR.c(fVar, false);
        fVar.dvp();
        long j2 = j - this.mmR.mno;
        int i = this.mmR.miK + this.mmR.mnt;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.mmX = this.mmR.mno;
            } else {
                this.start = fVar.getPosition() + i;
                this.mmW = this.mmR.mno;
                if ((this.end - this.start) + i < 100000) {
                    fVar.JB(i);
                    return -(this.mmW + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((fVar.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.mmX - this.mmW)), this.start), this.end - 1);
        }
        fVar.JB(i);
        return -(this.mmR.mno + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long f(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.mmT) - j3) + j;
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
    public class C0677a implements l {
        private C0677a() {
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dvo() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fM(long j) {
            if (j == 0) {
                return a.this.startPosition;
            }
            return a.this.f(a.this.startPosition, a.this.mmS.fW(j), 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return a.this.mmS.fV(a.this.mmT);
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
                    fVar.JB(i);
                    return true;
                }
            }
            fVar.JB(length - 3);
        }
    }

    long w(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        v(fVar);
        this.mmR.reset();
        while ((this.mmR.type & 4) != 4 && fVar.getPosition() < this.endPosition) {
            this.mmR.c(fVar, false);
            fVar.JB(this.mmR.miK + this.mmR.mnt);
        }
        return this.mmR.mno;
    }

    long a(com.google.android.exoplayer2.extractor.f fVar, long j, long j2) throws IOException, InterruptedException {
        this.mmR.c(fVar, false);
        while (this.mmR.mno < j) {
            fVar.JB(this.mmR.miK + this.mmR.mnt);
            j2 = this.mmR.mno;
            this.mmR.c(fVar, false);
        }
        fVar.dvp();
        return j2;
    }
}
