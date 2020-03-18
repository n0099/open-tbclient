package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes6.dex */
final class a implements b {
    private final byte[] mgG = new byte[8];
    private final Stack<C0674a> mgH = new Stack<>();
    private final f mgI = new f();
    private c mgJ;
    private int mgK;
    private int mgL;
    private long mgM;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.mgJ = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.mgK = 0;
        this.mgH.clear();
        this.mgI.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.mgJ != null);
        while (true) {
            if (this.mgH.isEmpty() || fVar.getPosition() < this.mgH.peek().mgN) {
                if (this.mgK == 0) {
                    long a = this.mgI.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.mgL = (int) a;
                    this.mgK = 1;
                }
                if (this.mgK == 1) {
                    this.mgM = this.mgI.a(fVar, false, true, 8);
                    this.mgK = 2;
                }
                int JJ = this.mgJ.JJ(this.mgL);
                switch (JJ) {
                    case 0:
                        fVar.JB((int) this.mgM);
                        this.mgK = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.mgH.add(new C0674a(this.mgL, this.mgM + position));
                        this.mgJ.k(this.mgL, position, this.mgM);
                        this.mgK = 0;
                        return true;
                    case 2:
                        if (this.mgM > 8) {
                            throw new ParserException("Invalid integer size: " + this.mgM);
                        }
                        this.mgJ.C(this.mgL, a(fVar, (int) this.mgM));
                        this.mgK = 0;
                        return true;
                    case 3:
                        if (this.mgM > 2147483647L) {
                            throw new ParserException("String element size: " + this.mgM);
                        }
                        this.mgJ.bh(this.mgL, c(fVar, (int) this.mgM));
                        this.mgK = 0;
                        return true;
                    case 4:
                        this.mgJ.a(this.mgL, (int) this.mgM, fVar);
                        this.mgK = 0;
                        return true;
                    case 5:
                        if (this.mgM != 4 && this.mgM != 8) {
                            throw new ParserException("Invalid float size: " + this.mgM);
                        }
                        this.mgJ.d(this.mgL, b(fVar, (int) this.mgM));
                        this.mgK = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + JJ);
                }
            } else {
                this.mgJ.JL(this.mgH.pop().mgL);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.dvp();
        while (true) {
            fVar.s(this.mgG, 0, 4);
            int JM = f.JM(this.mgG[0]);
            if (JM != -1 && JM <= 4) {
                int a = (int) f.a(this.mgG, JM, false);
                if (this.mgJ.JK(a)) {
                    fVar.JB(JM);
                    return a;
                }
            }
            fVar.JB(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.mgG, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.mgG[i2] & 255);
        }
        return j;
    }

    private double b(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        long a = a(fVar, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) a);
        }
        return Double.longBitsToDouble(a);
    }

    private String c(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        fVar.readFully(bArr, 0, i);
        return new String(bArr);
    }

    /* renamed from: com.google.android.exoplayer2.extractor.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C0674a {
        private final int mgL;
        private final long mgN;

        private C0674a(int i, long j) {
            this.mgL = i;
            this.mgN = j;
        }
    }
}
