package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes6.dex */
final class a implements b {
    private final byte[] mfa = new byte[8];
    private final Stack<C0673a> mfb = new Stack<>();
    private final f mfc = new f();
    private c mfd;
    private int mfe;
    private int mff;
    private long mfg;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.mfd = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.mfe = 0;
        this.mfb.clear();
        this.mfc.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.mfd != null);
        while (true) {
            if (this.mfb.isEmpty() || fVar.getPosition() < this.mfb.peek().mfh) {
                if (this.mfe == 0) {
                    long a = this.mfc.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.mff = (int) a;
                    this.mfe = 1;
                }
                if (this.mfe == 1) {
                    this.mfg = this.mfc.a(fVar, false, true, 8);
                    this.mfe = 2;
                }
                int JD = this.mfd.JD(this.mff);
                switch (JD) {
                    case 0:
                        fVar.Jv((int) this.mfg);
                        this.mfe = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.mfb.add(new C0673a(this.mff, this.mfg + position));
                        this.mfd.k(this.mff, position, this.mfg);
                        this.mfe = 0;
                        return true;
                    case 2:
                        if (this.mfg > 8) {
                            throw new ParserException("Invalid integer size: " + this.mfg);
                        }
                        this.mfd.C(this.mff, a(fVar, (int) this.mfg));
                        this.mfe = 0;
                        return true;
                    case 3:
                        if (this.mfg > 2147483647L) {
                            throw new ParserException("String element size: " + this.mfg);
                        }
                        this.mfd.bh(this.mff, c(fVar, (int) this.mfg));
                        this.mfe = 0;
                        return true;
                    case 4:
                        this.mfd.a(this.mff, (int) this.mfg, fVar);
                        this.mfe = 0;
                        return true;
                    case 5:
                        if (this.mfg != 4 && this.mfg != 8) {
                            throw new ParserException("Invalid float size: " + this.mfg);
                        }
                        this.mfd.d(this.mff, b(fVar, (int) this.mfg));
                        this.mfe = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + JD);
                }
            } else {
                this.mfd.JF(this.mfb.pop().mff);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.duS();
        while (true) {
            fVar.s(this.mfa, 0, 4);
            int JG = f.JG(this.mfa[0]);
            if (JG != -1 && JG <= 4) {
                int a = (int) f.a(this.mfa, JG, false);
                if (this.mfd.JE(a)) {
                    fVar.Jv(JG);
                    return a;
                }
            }
            fVar.Jv(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.mfa, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.mfa[i2] & 255);
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
        private final int mff;
        private final long mfh;

        private C0673a(int i, long j) {
            this.mff = i;
            this.mfh = j;
        }
    }
}
