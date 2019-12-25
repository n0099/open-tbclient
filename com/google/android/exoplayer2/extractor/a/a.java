package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes4.dex */
final class a implements b {
    private final byte[] mal = new byte[8];
    private final Stack<C0659a> mam = new Stack<>();
    private final f man = new f();
    private c mao;
    private int maq;
    private int mar;
    private long mas;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.mao = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.maq = 0;
        this.mam.clear();
        this.man.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.mao != null);
        while (true) {
            if (this.mam.isEmpty() || fVar.getPosition() < this.mam.peek().mat) {
                if (this.maq == 0) {
                    long a = this.man.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.mar = (int) a;
                    this.maq = 1;
                }
                if (this.maq == 1) {
                    this.mas = this.man.a(fVar, false, true, 8);
                    this.maq = 2;
                }
                int Jp = this.mao.Jp(this.mar);
                switch (Jp) {
                    case 0:
                        fVar.Jh((int) this.mas);
                        this.maq = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.mam.add(new C0659a(this.mar, this.mas + position));
                        this.mao.k(this.mar, position, this.mas);
                        this.maq = 0;
                        return true;
                    case 2:
                        if (this.mas > 8) {
                            throw new ParserException("Invalid integer size: " + this.mas);
                        }
                        this.mao.D(this.mar, a(fVar, (int) this.mas));
                        this.maq = 0;
                        return true;
                    case 3:
                        if (this.mas > 2147483647L) {
                            throw new ParserException("String element size: " + this.mas);
                        }
                        this.mao.bc(this.mar, c(fVar, (int) this.mas));
                        this.maq = 0;
                        return true;
                    case 4:
                        this.mao.a(this.mar, (int) this.mas, fVar);
                        this.maq = 0;
                        return true;
                    case 5:
                        if (this.mas != 4 && this.mas != 8) {
                            throw new ParserException("Invalid float size: " + this.mas);
                        }
                        this.mao.d(this.mar, b(fVar, (int) this.mas));
                        this.maq = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + Jp);
                }
            } else {
                this.mao.Jr(this.mam.pop().mar);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.dsq();
        while (true) {
            fVar.p(this.mal, 0, 4);
            int Js = f.Js(this.mal[0]);
            if (Js != -1 && Js <= 4) {
                int a = (int) f.a(this.mal, Js, false);
                if (this.mao.Jq(a)) {
                    fVar.Jh(Js);
                    return a;
                }
            }
            fVar.Jh(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.mal, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.mal[i2] & 255);
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
    /* loaded from: classes4.dex */
    private static final class C0659a {
        private final int mar;
        private final long mat;

        private C0659a(int i, long j) {
            this.mar = i;
            this.mat = j;
        }
    }
}
