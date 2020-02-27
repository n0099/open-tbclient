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
    private final int flags;
    private g meB;
    private Metadata metadata;
    private final l mex;
    private final long mgC;
    private final j mgD;
    private final i mgE;
    private m mgF;
    private int mgG;
    private a mgH;
    private long mgI;
    private long mgJ;
    private int mgK;
    public static final h mev = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duR() {
            return new e[]{new b()};
        }
    };
    private static final int mgz = v.QE("Xing");
    private static final int mgA = v.QE("Info");
    private static final int mgB = v.QE("VBRI");

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
        this.mgC = j;
        this.mex = new l(10);
        this.mgD = new j();
        this.mgE = new i();
        this.mgI = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meB = gVar;
        this.mgF = this.meB.dK(0, 1);
        this.meB.duS();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mgG = 0;
        this.mgI = -9223372036854775807L;
        this.mgJ = 0L;
        this.mgK = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mgG == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mgH == null) {
            this.mgH = l(fVar);
            if (this.mgH == null || (!this.mgH.duO() && (this.flags & 1) != 0)) {
                this.mgH = m(fVar);
            }
            this.meB.a(this.mgH);
            this.mgF.h(Format.a((String) null, this.mgD.mimeType, (String) null, -1, 4096, this.mgD.channels, this.mgD.sampleRate, -1, this.mgE.encoderDelay, this.mgE.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mgK == 0) {
            fVar.duP();
            if (!fVar.e(this.mex.data, 0, 4, true)) {
                return -1;
            }
            this.mex.setPosition(0);
            int readInt = this.mex.readInt();
            if (!D(readInt, this.mgG) || j.JC(readInt) == -1) {
                fVar.Jv(1);
                this.mgG = 0;
                return 0;
            }
            j.a(readInt, this.mgD);
            if (this.mgI == -9223372036854775807L) {
                this.mgI = this.mgH.fN(fVar.getPosition());
                if (this.mgC != -9223372036854775807L) {
                    this.mgI = (this.mgC - this.mgH.fN(0L)) + this.mgI;
                }
            }
            this.mgK = this.mgD.frameSize;
        }
        int a2 = this.mgF.a(fVar, this.mgK, true);
        if (a2 == -1) {
            return -1;
        }
        this.mgK -= a2;
        if (this.mgK <= 0) {
            this.mgF.a(((this.mgJ * TimeUtils.NANOS_PER_MS) / this.mgD.sampleRate) + this.mgI, 1, this.mgD.frameSize, 0, null);
            this.mgJ += this.mgD.samplesPerFrame;
            this.mgK = 0;
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
        fVar.duP();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int duQ = (int) fVar.duQ();
            if (!z) {
                fVar.Jv(duQ);
            }
            i2 = duQ;
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
            if (!fVar.e(this.mex.data, 0, 4, i4 > 0)) {
                break;
            }
            this.mex.setPosition(0);
            int readInt = this.mex.readInt();
            if ((i3 != 0 && !D(readInt, i3)) || (JC = j.JC(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.duP();
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
                    j.a(readInt, this.mgD);
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
            fVar.duP();
        }
        this.mgG = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.s(this.mex.data, 0, 10);
            this.mex.setPosition(0);
            if (this.mex.dzv() == com.google.android.exoplayer2.metadata.id3.a.mmp) {
                this.mex.skipBytes(3);
                int dzB = this.mex.dzB();
                int i2 = dzB + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.mex.data, 0, bArr, 0, 10);
                    fVar.s(bArr, 10, dzB);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.meg : null).z(bArr, i2);
                    if (this.metadata != null) {
                        this.mgE.c(this.metadata);
                    }
                } else {
                    fVar.Jw(dzB);
                }
                i += i2;
            } else {
                fVar.duP();
                fVar.Jw(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mgD.frameSize);
        fVar.s(lVar.data, 0, this.mgD.frameSize);
        int i = (this.mgD.version & 1) != 0 ? this.mgD.channels != 1 ? 36 : 21 : this.mgD.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mgz || c == mgA) {
            d b = d.b(this.mgD, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mgE.duT()) {
                fVar.duP();
                fVar.Jw(i + 141);
                fVar.s(this.mex.data, 0, 3);
                this.mex.setPosition(0);
                this.mgE.JB(this.mex.dzv());
            }
            fVar.Jv(this.mgD.frameSize);
            if (b != null && !b.duO() && c == mgA) {
                return m(fVar);
            }
            return b;
        } else if (c == mgB) {
            c a2 = c.a(this.mgD, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jv(this.mgD.frameSize);
            return a2;
        } else {
            fVar.duP();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mex.data, 0, 4);
        this.mex.setPosition(0);
        j.a(this.mex.readInt(), this.mgD);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mgD.bitrate, fVar.getLength());
    }

    private static boolean D(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dzs() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mgz || readInt == mgA) {
                return readInt;
            }
        }
        if (lVar.dzs() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mgB) {
                return mgB;
            }
        }
        return 0;
    }
}
