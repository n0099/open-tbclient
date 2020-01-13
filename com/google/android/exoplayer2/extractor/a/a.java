package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes5.dex */
final class a implements b {
    private final byte[] mec = new byte[8];
    private final Stack<C0665a> med = new Stack<>();
    private final f mee = new f();
    private c mef;
    private int meg;
    private int meh;
    private long mei;

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void a(c cVar) {
        this.mef = cVar;
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public void reset() {
        this.meg = 0;
        this.med.clear();
        this.mee.reset();
    }

    @Override // com.google.android.exoplayer2.extractor.a.b
    public boolean g(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkState(this.mef != null);
        while (true) {
            if (this.med.isEmpty() || fVar.getPosition() < this.med.peek().mej) {
                if (this.meg == 0) {
                    long a = this.mee.a(fVar, true, false, 4);
                    if (a == -2) {
                        a = h(fVar);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.meh = (int) a;
                    this.meg = 1;
                }
                if (this.meg == 1) {
                    this.mei = this.mee.a(fVar, false, true, 8);
                    this.meg = 2;
                }
                int Jy = this.mef.Jy(this.meh);
                switch (Jy) {
                    case 0:
                        fVar.Jq((int) this.mei);
                        this.meg = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.med.add(new C0665a(this.meh, this.mei + position));
                        this.mef.k(this.meh, position, this.mei);
                        this.meg = 0;
                        return true;
                    case 2:
                        if (this.mei > 8) {
                            throw new ParserException("Invalid integer size: " + this.mei);
                        }
                        this.mef.D(this.meh, a(fVar, (int) this.mei));
                        this.meg = 0;
                        return true;
                    case 3:
                        if (this.mei > 2147483647L) {
                            throw new ParserException("String element size: " + this.mei);
                        }
                        this.mef.bi(this.meh, c(fVar, (int) this.mei));
                        this.meg = 0;
                        return true;
                    case 4:
                        this.mef.a(this.meh, (int) this.mei, fVar);
                        this.meg = 0;
                        return true;
                    case 5:
                        if (this.mei != 4 && this.mei != 8) {
                            throw new ParserException("Invalid float size: " + this.mei);
                        }
                        this.mef.d(this.meh, b(fVar, (int) this.mei));
                        this.meg = 0;
                        return true;
                    default:
                        throw new ParserException("Invalid element type " + Jy);
                }
            } else {
                this.mef.JA(this.med.pop().meh);
                return true;
            }
        }
    }

    private long h(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.dtC();
        while (true) {
            fVar.o(this.mec, 0, 4);
            int JB = f.JB(this.mec[0]);
            if (JB != -1 && JB <= 4) {
                int a = (int) f.a(this.mec, JB, false);
                if (this.mef.Jz(a)) {
                    fVar.Jq(JB);
                    return a;
                }
            }
            fVar.Jq(1);
        }
    }

    private long a(com.google.android.exoplayer2.extractor.f fVar, int i) throws IOException, InterruptedException {
        fVar.readFully(this.mec, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.mec[i2] & 255);
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
        private final int meh;
        private final long mej;

        private C0665a(int i, long j) {
            this.meh = i;
            this.mej = j;
        }
    }
}
