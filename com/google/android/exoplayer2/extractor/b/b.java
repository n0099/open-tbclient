package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements e {
    public static final h meI = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duU() {
            return new e[]{new b()};
        }
    };
    private static final int mgM = v.QF("Xing");
    private static final int mgN = v.QF("Info");
    private static final int mgO = v.QF("VBRI");
    private final int flags;
    private final l meK;
    private g meO;
    private Metadata metadata;
    private final long mgP;
    private final j mgQ;
    private final i mgR;
    private m mgS;
    private int mgT;
    private a mgU;
    private long mgV;
    private long mgW;
    private int mgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a extends com.google.android.exoplayer2.extractor.l {
        long fN(long j);
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = i;
        this.mgP = j;
        this.meK = new l(10);
        this.mgQ = new j();
        this.mgR = new i();
        this.mgV = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meO = gVar;
        this.mgS = this.meO.dK(0, 1);
        this.meO.duV();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mgT = 0;
        this.mgV = -9223372036854775807L;
        this.mgW = 0L;
        this.mgX = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mgT == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mgU == null) {
            this.mgU = l(fVar);
            if (this.mgU == null || (!this.mgU.duR() && (this.flags & 1) != 0)) {
                this.mgU = m(fVar);
            }
            this.meO.a(this.mgU);
            this.mgS.h(Format.a((String) null, this.mgQ.mimeType, (String) null, -1, 4096, this.mgQ.channels, this.mgQ.sampleRate, -1, this.mgR.encoderDelay, this.mgR.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mgX == 0) {
            fVar.duS();
            if (!fVar.e(this.meK.data, 0, 4, true)) {
                return -1;
            }
            this.meK.setPosition(0);
            int readInt = this.meK.readInt();
            if (!D(readInt, this.mgT) || j.JC(readInt) == -1) {
                fVar.Jv(1);
                this.mgT = 0;
                return 0;
            }
            j.a(readInt, this.mgQ);
            if (this.mgV == -9223372036854775807L) {
                this.mgV = this.mgU.fN(fVar.getPosition());
                if (this.mgP != -9223372036854775807L) {
                    this.mgV = (this.mgP - this.mgU.fN(0L)) + this.mgV;
                }
            }
            this.mgX = this.mgQ.frameSize;
        }
        int a2 = this.mgS.a(fVar, this.mgX, true);
        if (a2 == -1) {
            return -1;
        }
        this.mgX -= a2;
        if (this.mgX <= 0) {
            this.mgS.a(((this.mgW * TimeUtils.NANOS_PER_MS) / this.mgQ.sampleRate) + this.mgV, 1, this.mgQ.frameSize, 0, null);
            this.mgW += this.mgQ.samplesPerFrame;
            this.mgX = 0;
            return 0;
        }
        return 0;
    }

    private boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        int i;
        int i2;
        int i3;
        int i4;
        int JC;
        int i5 = z ? 16384 : 131072;
        fVar.duS();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int duT = (int) fVar.duT();
            if (!z) {
                fVar.Jv(duT);
            }
            i2 = duT;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        while (true) {
            if (!fVar.e(this.meK.data, 0, 4, i4 > 0)) {
                break;
            }
            this.meK.setPosition(0);
            int readInt = this.meK.readInt();
            if ((i3 != 0 && !D(readInt, i3)) || (JC = j.JC(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.duS();
                    fVar.Jw(i2 + i6);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                } else {
                    fVar.Jv(1);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                }
            } else {
                i4++;
                if (i4 == 1) {
                    j.a(readInt, this.mgQ);
                    i3 = readInt;
                } else if (i4 == 4) {
                    break;
                }
                fVar.Jw(JC - 4);
            }
        }
        if (z) {
            fVar.Jv(i2 + i);
        } else {
            fVar.duS();
        }
        this.mgT = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.s(this.meK.data, 0, 10);
            this.meK.setPosition(0);
            if (this.meK.dzy() == com.google.android.exoplayer2.metadata.id3.a.mmC) {
                this.meK.skipBytes(3);
                int dzE = this.meK.dzE();
                int i2 = dzE + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.meK.data, 0, bArr, 0, 10);
                    fVar.s(bArr, 10, dzE);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.met : null).z(bArr, i2);
                    if (this.metadata != null) {
                        this.mgR.c(this.metadata);
                    }
                } else {
                    fVar.Jw(dzE);
                }
                i += i2;
            } else {
                fVar.duS();
                fVar.Jw(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mgQ.frameSize);
        fVar.s(lVar.data, 0, this.mgQ.frameSize);
        int i = (this.mgQ.version & 1) != 0 ? this.mgQ.channels != 1 ? 36 : 21 : this.mgQ.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mgM || c == mgN) {
            d b = d.b(this.mgQ, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mgR.duW()) {
                fVar.duS();
                fVar.Jw(i + 141);
                fVar.s(this.meK.data, 0, 3);
                this.meK.setPosition(0);
                this.mgR.JB(this.meK.dzy());
            }
            fVar.Jv(this.mgQ.frameSize);
            if (b != null && !b.duR() && c == mgN) {
                return m(fVar);
            }
            return b;
        } else if (c == mgO) {
            c a2 = c.a(this.mgQ, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jv(this.mgQ.frameSize);
            return a2;
        } else {
            fVar.duS();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.s(this.meK.data, 0, 4);
        this.meK.setPosition(0);
        j.a(this.meK.readInt(), this.mgQ);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mgQ.bitrate, fVar.getLength());
    }

    private static boolean D(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dzv() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mgM || readInt == mgN) {
                return readInt;
            }
        }
        if (lVar.dzv() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mgO) {
                return mgO;
            }
        }
        return 0;
    }
}
