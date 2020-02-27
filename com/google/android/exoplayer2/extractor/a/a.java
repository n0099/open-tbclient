package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes6.dex */
final class a implements b {
    private final byte[] meN = new byte[8];
    private final Stack<C0673a> meO = new Stack<>();
    private final f meP = new f();
    private c meQ;
    private int meR;
    private int meS;
    private long meT;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.meQ = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.meR = 0;
        this.meO.clear();
        this.meP.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.meQ != null);
        while (true) {
            if (this.meO.isEmpty() || fVar.getPosition() < this.meO.peek().meU) {
                if (this.meR == 0) {
                    long a = this.meP.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.meS = (int) a;
                    this.meR = 1;
                }
                if (this.meR == 1) {
                    this.meT = this.meP.a(fVar, false, true, 8);
                    this.meR = 2;
                }
                int JD = this.meQ.JD(this.meS);
                switch (JD) {
                    case 0:
                        fVar.Jv((int) this.meT);
                        this.meR = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.meO.add(new C0673a(this.meS, this.meT + position));
                        this.meQ.k(this.meS, position, this.meT);
                        this.meR = 0;
                        return true;
                    case 2:
                        if (this.meT > 8) {
                            throw new ParserException("Invalid integer size: " + this.meT);
                        }
                        this.meQ.C(this.meS, a(fVar, (int) this.meT));
                        this.meR = 0;
                        return true;
                    case 3:
                        if (this.meT > 2147483647L) {
                            throw new ParserException("String element size: " + this.meT);
                        }
                        this.meQ.bh(this.meS, c(fVar, (int) this.meT));
                        this.meR = 0;
                        return true;
                    case 4:
                        this.meQ.a(this.meS, (int) this.meT, fVar);
                        this.meR = 0;
                        return true;
                    case 5:
                        if (this.meT != 4 && this.meT != 8) {
                            throw new ParserException("Invalid float size: " + this.meT);
                        }
                        this.meQ.d(this.meS, b(fVar, (int) this.meT));
                        this.meR = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + JD);
                }
            } else {
                this.meQ.JF(this.meO.pop().meS);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.duP();
        while (true) {
            fVar.s(this.meN, 0, 4);
            int JG = f.JG(this.meN[0]);
            if (JG != -1 && JG <= 4) {
                int a = (int) f.a(this.meN, JG, false);
                if (this.meQ.JE(a)) {
                    fVar.Jv(JG);
                    return a;
                }
            }
            fVar.Jv(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.meN, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.meN[i2] & 255);
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
    private static final class C0673a {
        private final int meS;
        private final long meU;

        private C0673a(int i, long j) {
            this.meS = i;
            this.meU = j;
        }
    }
}
