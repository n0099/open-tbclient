package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes6.dex */
final class a implements b {
    private final byte[] meP = new byte[8];
    private final Stack<C0673a> meQ = new Stack<>();
    private final f meR = new f();
    private c meS;
    private int meT;
    private int meU;
    private long meV;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.meS = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.meT = 0;
        this.meQ.clear();
        this.meR.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.meS != null);
        while (true) {
            if (this.meQ.isEmpty() || fVar.getPosition() < this.meQ.peek().meW) {
                if (this.meT == 0) {
                    long a = this.meR.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.meU = (int) a;
                    this.meT = 1;
                }
                if (this.meT == 1) {
                    this.meV = this.meR.a(fVar, false, true, 8);
                    this.meT = 2;
                }
                int JD = this.meS.JD(this.meU);
                switch (JD) {
                    case 0:
                        fVar.Jv((int) this.meV);
                        this.meT = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.meQ.add(new C0673a(this.meU, this.meV + position));
                        this.meS.k(this.meU, position, this.meV);
                        this.meT = 0;
                        return true;
                    case 2:
                        if (this.meV > 8) {
                            throw new ParserException("Invalid integer size: " + this.meV);
                        }
                        this.meS.C(this.meU, a(fVar, (int) this.meV));
                        this.meT = 0;
                        return true;
                    case 3:
                        if (this.meV > 2147483647L) {
                            throw new ParserException("String element size: " + this.meV);
                        }
                        this.meS.bh(this.meU, c(fVar, (int) this.meV));
                        this.meT = 0;
                        return true;
                    case 4:
                        this.meS.a(this.meU, (int) this.meV, fVar);
                        this.meT = 0;
                        return true;
                    case 5:
                        if (this.meV != 4 && this.meV != 8) {
                            throw new ParserException("Invalid float size: " + this.meV);
                        }
                        this.meS.d(this.meU, b(fVar, (int) this.meV));
                        this.meT = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + JD);
                }
            } else {
                this.meS.JF(this.meQ.pop().meU);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.duR();
        while (true) {
            fVar.s(this.meP, 0, 4);
            int JG = f.JG(this.meP[0]);
            if (JG != -1 && JG <= 4) {
                int a = (int) f.a(this.meP, JG, false);
                if (this.meS.JE(a)) {
                    fVar.Jv(JG);
                    return a;
                }
            }
            fVar.Jv(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.meP, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.meP[i2] & 255);
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
        private final int meU;
        private final long meW;

        private C0673a(int i, long j) {
            this.meU = i;
            this.meW = j;
        }
    }
}
