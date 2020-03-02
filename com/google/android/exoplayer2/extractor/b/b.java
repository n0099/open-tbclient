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
    public static final h mex = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] duT() {
            return new e[]{new b()};
        }
    };
    private static final int mgB = v.QE("Xing");
    private static final int mgC = v.QE("Info");
    private static final int mgD = v.QE("VBRI");
    private final int flags;
    private g meD;
    private Metadata metadata;
    private final l mez;
    private final long mgE;
    private final j mgF;
    private final i mgG;
    private m mgH;
    private int mgI;
    private a mgJ;
    private long mgK;
    private long mgL;
    private int mgM;

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
        this.mgE = j;
        this.mez = new l(10);
        this.mgF = new j();
        this.mgG = new i();
        this.mgK = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.meD = gVar;
        this.mgH = this.meD.dK(0, 1);
        this.meD.duU();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.mgI = 0;
        this.mgK = -9223372036854775807L;
        this.mgL = 0L;
        this.mgM = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mgI == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mgJ == null) {
            this.mgJ = l(fVar);
            if (this.mgJ == null || (!this.mgJ.duQ() && (this.flags & 1) != 0)) {
                this.mgJ = m(fVar);
            }
            this.meD.a(this.mgJ);
            this.mgH.h(Format.a((String) null, this.mgF.mimeType, (String) null, -1, 4096, this.mgF.channels, this.mgF.sampleRate, -1, this.mgG.encoderDelay, this.mgG.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mgM == 0) {
            fVar.duR();
            if (!fVar.e(this.mez.data, 0, 4, true)) {
                return -1;
            }
            this.mez.setPosition(0);
            int readInt = this.mez.readInt();
            if (!D(readInt, this.mgI) || j.JC(readInt) == -1) {
                fVar.Jv(1);
                this.mgI = 0;
                return 0;
            }
            j.a(readInt, this.mgF);
            if (this.mgK == -9223372036854775807L) {
                this.mgK = this.mgJ.fN(fVar.getPosition());
                if (this.mgE != -9223372036854775807L) {
                    this.mgK = (this.mgE - this.mgJ.fN(0L)) + this.mgK;
                }
            }
            this.mgM = this.mgF.frameSize;
        }
        int a2 = this.mgH.a(fVar, this.mgM, true);
        if (a2 == -1) {
            return -1;
        }
        this.mgM -= a2;
        if (this.mgM <= 0) {
            this.mgH.a(((this.mgL * TimeUtils.NANOS_PER_MS) / this.mgF.sampleRate) + this.mgK, 1, this.mgF.frameSize, 0, null);
            this.mgL += this.mgF.samplesPerFrame;
            this.mgM = 0;
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
        fVar.duR();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int duS = (int) fVar.duS();
            if (!z) {
                fVar.Jv(duS);
            }
            i2 = duS;
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
            if (!fVar.e(this.mez.data, 0, 4, i4 > 0)) {
                break;
            }
            this.mez.setPosition(0);
            int readInt = this.mez.readInt();
            if ((i3 != 0 && !D(readInt, i3)) || (JC = j.JC(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.duR();
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
                    j.a(readInt, this.mgF);
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
            fVar.duR();
        }
        this.mgI = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.s(this.mez.data, 0, 10);
            this.mez.setPosition(0);
            if (this.mez.dzx() == com.google.android.exoplayer2.metadata.id3.a.mmr) {
                this.mez.skipBytes(3);
                int dzD = this.mez.dzD();
                int i2 = dzD + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.mez.data, 0, bArr, 0, 10);
                    fVar.s(bArr, 10, dzD);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.mei : null).z(bArr, i2);
                    if (this.metadata != null) {
                        this.mgG.c(this.metadata);
                    }
                } else {
                    fVar.Jw(dzD);
                }
                i += i2;
            } else {
                fVar.duR();
                fVar.Jw(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mgF.frameSize);
        fVar.s(lVar.data, 0, this.mgF.frameSize);
        int i = (this.mgF.version & 1) != 0 ? this.mgF.channels != 1 ? 36 : 21 : this.mgF.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mgB || c == mgC) {
            d b = d.b(this.mgF, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mgG.duV()) {
                fVar.duR();
                fVar.Jw(i + 141);
                fVar.s(this.mez.data, 0, 3);
                this.mez.setPosition(0);
                this.mgG.JB(this.mez.dzx());
            }
            fVar.Jv(this.mgF.frameSize);
            if (b != null && !b.duQ() && c == mgC) {
                return m(fVar);
            }
            return b;
        } else if (c == mgD) {
            c a2 = c.a(this.mgF, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jv(this.mgF.frameSize);
            return a2;
        } else {
            fVar.duR();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mez.data, 0, 4);
        this.mez.setPosition(0);
        j.a(this.mez.readInt(), this.mgF);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mgF.bitrate, fVar.getLength());
    }

    private static boolean D(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dzu() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mgB || readInt == mgC) {
                return readInt;
            }
        }
        if (lVar.dzu() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mgD) {
                return mgD;
            }
        }
        return 0;
    }
}
