package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes5.dex */
final class a implements b {
    private final byte[] meh = new byte[8];
    private final Stack<C0665a> mei = new Stack<>();
    private final f mej = new f();
    private c mek;
    private int mel;
    private int mem;
    private long men;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.mek = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.mel = 0;
        this.mei.clear();
        this.mej.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.mek != null);
        while (true) {
            if (this.mei.isEmpty() || fVar.getPosition() < this.mei.peek().meo) {
                if (this.mel == 0) {
                    long a = this.mej.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.mem = (int) a;
                    this.mel = 1;
                }
                if (this.mel == 1) {
                    this.men = this.mej.a(fVar, false, true, 8);
                    this.mel = 2;
                }
                int Jy = this.mek.Jy(this.mem);
                switch (Jy) {
                    case 0:
                        fVar.Jq((int) this.men);
                        this.mel = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.mei.add(new C0665a(this.mem, this.men + position));
                        this.mek.k(this.mem, position, this.men);
                        this.mel = 0;
                        return true;
                    case 2:
                        if (this.men > 8) {
                            throw new ParserException("Invalid integer size: " + this.men);
                        }
                        this.mek.D(this.mem, a(fVar, (int) this.men));
                        this.mel = 0;
                        return true;
                    case 3:
                        if (this.men > 2147483647L) {
                            throw new ParserException("String element size: " + this.men);
                        }
                        this.mek.bi(this.mem, c(fVar, (int) this.men));
                        this.mel = 0;
                        return true;
                    case 4:
                        this.mek.a(this.mem, (int) this.men, fVar);
                        this.mel = 0;
                        return true;
                    case 5:
                        if (this.men != 4 && this.men != 8) {
                            throw new ParserException("Invalid float size: " + this.men);
                        }
                        this.mek.d(this.mem, b(fVar, (int) this.men));
                        this.mel = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + Jy);
                }
            } else {
                this.mek.JA(this.mei.pop().mem);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.dtE();
        while (true) {
            fVar.o(this.meh, 0, 4);
            int JB = f.JB(this.meh[0]);
            if (JB != -1 && JB <= 4) {
                int a = (int) f.a(this.meh, JB, false);
                if (this.mek.Jz(a)) {
                    fVar.Jq(JB);
                    return a;
                }
            }
            fVar.Jq(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.meh, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.meh[i2] & 255);
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
    /* loaded from: classes5.dex */
    private static final class C0665a {
        private final int mem;
        private final long meo;

        private C0665a(int i, long j) {
            this.mem = i;
            this.meo = j;
        }
    }
}
