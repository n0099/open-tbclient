package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.l;
import java.io.EOFException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a implements f {
    private long end;
    private final long endPosition;
    private long mgA;
    private long mgB;
    private long mgC;
    private final e mgw = new e();
    private final h mgx;
    private long mgy;
    private long mgz;
    private long start;
    private final long startPosition;
    private int state;

    public a(long j, long j2, h hVar, int i, long j3) {
        com.google.android.exoplayer2.util.a.checkArgument(j >= 0 && j2 > j);
        this.mgx = hVar;
        this.startPosition = j;
        this.endPosition = j2;
        if (i == j2 - j) {
            this.mgy = j3;
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
                this.mgz = fVar.getPosition();
                this.state = 1;
                long j2 = this.endPosition - 65307;
                if (j2 > this.mgz) {
                    return j2;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.mgA != 0) {
                    long a = a(this.mgA, fVar);
                    if (a >= 0) {
                        return a;
                    }
                    j = a(fVar, this.mgA, -(a + 2));
                }
                this.state = 3;
                return -(j + 2);
            case 3:
                return -1L;
            default:
                throw new IllegalStateException();
        }
        this.mgy = w(fVar);
        this.state = 3;
        return this.mgz;
    }

    @Override // com.google.android.exoplayer2.extractor.d.f
    public long fP(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(this.state == 3 || this.state == 2);
        this.mgA = j == 0 ? 0L : this.mgx.fS(j);
        this.state = 2;
        dsH();
        return this.mgA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.d.f
    /* renamed from: dsG */
    public C0662a dsI() {
        if (this.mgy != 0) {
            return new C0662a();
        }
        return null;
    }

    public void dsH() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.mgB = 0L;
        this.mgC = this.mgy;
    }

    public long a(long j, com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        if (this.start == this.end) {
            return -(this.mgB + 2);
        }
        long position = fVar.getPosition();
        if (!a(fVar, this.end)) {
            if (this.start == position) {
                throw new IOException("No ogg page can be found.");
            }
            return this.start;
        }
        this.mgw.c(fVar, false);
        fVar.dsq();
        long j2 = j - this.mgw.mgT;
        int i = this.mgw.mcp + this.mgw.mgY;
        if (j2 < 0 || j2 > 72000) {
            if (j2 < 0) {
                this.end = position;
                this.mgC = this.mgw.mgT;
            } else {
                this.start = fVar.getPosition() + i;
                this.mgB = this.mgw.mgT;
                if ((this.end - this.start) + i < 100000) {
                    fVar.Jh(i);
                    return -(this.mgB + 2);
                }
            }
            if (this.end - this.start < 100000) {
                this.end = this.start;
                return this.start;
            }
            return Math.min(Math.max((fVar.getPosition() - ((j2 <= 0 ? 2 : 1) * i)) + ((j2 * (this.end - this.start)) / (this.mgC - this.mgB)), this.start), this.end - 1);
        }
        fVar.Jh(i);
        return -(this.mgw.mgT + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e(long j, long j2, long j3) {
        long j4 = ((((this.endPosition - this.startPosition) * j2) / this.mgy) - j3) + j;
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
    /* loaded from: classes4.dex */
    public class C0662a implements l {
        private C0662a() {
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dsp() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fI(long j) {
            if (j == 0) {
                return a.this.startPosition;
            }
            return a.this.e(a.this.startPosition, a.this.mgx.fS(j), 30000L);
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long drc() {
            return a.this.mgx.fR(a.this.mgy);
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
                    fVar.Jh(i);
                    return true;
                }
            }
            fVar.Jh(length - 3);
        }
    }

    long w(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        v(fVar);
        this.mgw.reset();
        while ((this.mgw.type & 4) != 4 && fVar.getPosition() < this.endPosition) {
            this.mgw.c(fVar, false);
            fVar.Jh(this.mgw.mcp + this.mgw.mgY);
        }
        return this.mgw.mgT;
    }

    long a(com.google.android.exoplayer2.extractor.f fVar, long j, long j2) throws IOException, InterruptedException {
        this.mgw.c(fVar, false);
        while (this.mgw.mgT < j) {
            fVar.Jh(this.mgw.mcp + this.mgw.mgY);
            j2 = this.mgw.mgT;
            this.mgw.c(fVar, false);
        }
        fVar.dsq();
        return j2;
    }
}
