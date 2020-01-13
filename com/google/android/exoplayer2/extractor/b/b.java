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
/* loaded from: classes5.dex */
public final class b implements e {
    public static final h mdK = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtE() {
            return new e[]{new b()};
        }
    };
    private static final int mfO = v.Qr("Xing");
    private static final int mfP = v.Qr("Info");
    private static final int mfQ = v.Qr("VBRI");
    private final int flags;
    private final l mdM;
    private g mdQ;
    private Metadata metadata;
    private final long mfR;
    private final j mfS;
    private final i mfT;
    private m mfU;
    private int mfV;
    private a mfW;
    private long mfX;
    private long mfY;
    private int mfZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a extends com.google.android.exoplayer2.extractor.l {
        long fP(long j);
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = i;
        this.mfR = j;
        this.mdM = new l(10);
        this.mfS = new j();
        this.mfT = new i();
        this.mfX = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdQ = gVar;
        this.mfU = this.mdQ.dH(0, 1);
        this.mdQ.dtF();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mfV = 0;
        this.mfX = -9223372036854775807L;
        this.mfY = 0L;
        this.mfZ = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mfV == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mfW == null) {
            this.mfW = l(fVar);
            if (this.mfW == null || (!this.mfW.dtB() && (this.flags & 1) != 0)) {
                this.mfW = m(fVar);
            }
            this.mdQ.a(this.mfW);
            this.mfU.h(Format.a((String) null, this.mfS.mimeType, (String) null, -1, 4096, this.mfS.channels, this.mfS.sampleRate, -1, this.mfT.encoderDelay, this.mfT.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mfZ == 0) {
            fVar.dtC();
            if (!fVar.e(this.mdM.data, 0, 4, true)) {
                return -1;
            }
            this.mdM.setPosition(0);
            int readInt = this.mdM.readInt();
            if (!E(readInt, this.mfV) || j.Jx(readInt) == -1) {
                fVar.Jq(1);
                this.mfV = 0;
                return 0;
            }
            j.a(readInt, this.mfS);
            if (this.mfX == -9223372036854775807L) {
                this.mfX = this.mfW.fP(fVar.getPosition());
                if (this.mfR != -9223372036854775807L) {
                    this.mfX = (this.mfR - this.mfW.fP(0L)) + this.mfX;
                }
            }
            this.mfZ = this.mfS.frameSize;
        }
        int a2 = this.mfU.a(fVar, this.mfZ, true);
        if (a2 == -1) {
            return -1;
        }
        this.mfZ -= a2;
        if (this.mfZ <= 0) {
            this.mfU.a(((this.mfY * TimeUtils.NANOS_PER_MS) / this.mfS.sampleRate) + this.mfX, 1, this.mfS.frameSize, 0, null);
            this.mfY += this.mfS.samplesPerFrame;
            this.mfZ = 0;
            return 0;
        }
        return 0;
    }

    private boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        int i;
        int i2;
        int i3;
        int i4;
        int Jx;
        int i5 = z ? 16384 : 131072;
        fVar.dtC();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int dtD = (int) fVar.dtD();
            if (!z) {
                fVar.Jq(dtD);
            }
            i2 = dtD;
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
            if (!fVar.e(this.mdM.data, 0, 4, i4 > 0)) {
                break;
            }
            this.mdM.setPosition(0);
            int readInt = this.mdM.readInt();
            if ((i3 != 0 && !E(readInt, i3)) || (Jx = j.Jx(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.dtC();
                    fVar.Jr(i2 + i6);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                } else {
                    fVar.Jq(1);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                }
            } else {
                i4++;
                if (i4 == 1) {
                    j.a(readInt, this.mfS);
                    i3 = readInt;
                } else if (i4 == 4) {
                    break;
                }
                fVar.Jr(Jx - 4);
            }
        }
        if (z) {
            fVar.Jq(i2 + i);
        } else {
            fVar.dtC();
        }
        this.mfV = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.o(this.mdM.data, 0, 10);
            this.mdM.setPosition(0);
            if (this.mdM.dyj() == com.google.android.exoplayer2.metadata.id3.a.mlE) {
                this.mdM.skipBytes(3);
                int dyp = this.mdM.dyp();
                int i2 = dyp + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.mdM.data, 0, bArr, 0, 10);
                    fVar.o(bArr, 10, dyp);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.mdv : null).x(bArr, i2);
                    if (this.metadata != null) {
                        this.mfT.c(this.metadata);
                    }
                } else {
                    fVar.Jr(dyp);
                }
                i += i2;
            } else {
                fVar.dtC();
                fVar.Jr(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mfS.frameSize);
        fVar.o(lVar.data, 0, this.mfS.frameSize);
        int i = (this.mfS.version & 1) != 0 ? this.mfS.channels != 1 ? 36 : 21 : this.mfS.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mfO || c == mfP) {
            d b = d.b(this.mfS, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mfT.dtG()) {
                fVar.dtC();
                fVar.Jr(i + 141);
                fVar.o(this.mdM.data, 0, 3);
                this.mdM.setPosition(0);
                this.mfT.Jw(this.mdM.dyj());
            }
            fVar.Jq(this.mfS.frameSize);
            if (b != null && !b.dtB() && c == mfP) {
                return m(fVar);
            }
            return b;
        } else if (c == mfQ) {
            c a2 = c.a(this.mfS, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jq(this.mfS.frameSize);
            return a2;
        } else {
            fVar.dtC();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.o(this.mdM.data, 0, 4);
        this.mdM.setPosition(0);
        j.a(this.mdM.readInt(), this.mfS);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mfS.bitrate, fVar.getLength());
    }

    private static boolean E(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dyg() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mfO || readInt == mfP) {
                return readInt;
            }
        }
        if (lVar.dyg() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mfQ) {
                return mfQ;
            }
        }
        return 0;
    }
}
