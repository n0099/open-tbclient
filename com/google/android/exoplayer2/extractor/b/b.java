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
    public static final h mdP = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dtG() {
            return new e[]{new b()};
        }
    };
    private static final int mfT = v.Qr("Xing");
    private static final int mfU = v.Qr("Info");
    private static final int mfV = v.Qr("VBRI");
    private final int flags;
    private final l mdR;
    private g mdV;
    private Metadata metadata;
    private final long mfW;
    private final j mfX;
    private final i mfY;
    private m mfZ;
    private int mga;
    private a mgb;
    private long mgc;
    private long mgd;
    private int mge;

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
        this.mfW = j;
        this.mdR = new l(10);
        this.mfX = new j();
        this.mfY = new i();
        this.mgc = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mdV = gVar;
        this.mfZ = this.mdV.dH(0, 1);
        this.mdV.dtH();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mga = 0;
        this.mgc = -9223372036854775807L;
        this.mgd = 0L;
        this.mge = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mga == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mgb == null) {
            this.mgb = l(fVar);
            if (this.mgb == null || (!this.mgb.dtD() && (this.flags & 1) != 0)) {
                this.mgb = m(fVar);
            }
            this.mdV.a(this.mgb);
            this.mfZ.h(Format.a((String) null, this.mfX.mimeType, (String) null, -1, 4096, this.mfX.channels, this.mfX.sampleRate, -1, this.mfY.encoderDelay, this.mfY.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mge == 0) {
            fVar.dtE();
            if (!fVar.e(this.mdR.data, 0, 4, true)) {
                return -1;
            }
            this.mdR.setPosition(0);
            int readInt = this.mdR.readInt();
            if (!E(readInt, this.mga) || j.Jx(readInt) == -1) {
                fVar.Jq(1);
                this.mga = 0;
                return 0;
            }
            j.a(readInt, this.mfX);
            if (this.mgc == -9223372036854775807L) {
                this.mgc = this.mgb.fP(fVar.getPosition());
                if (this.mfW != -9223372036854775807L) {
                    this.mgc = (this.mfW - this.mgb.fP(0L)) + this.mgc;
                }
            }
            this.mge = this.mfX.frameSize;
        }
        int a2 = this.mfZ.a(fVar, this.mge, true);
        if (a2 == -1) {
            return -1;
        }
        this.mge -= a2;
        if (this.mge <= 0) {
            this.mfZ.a(((this.mgd * TimeUtils.NANOS_PER_MS) / this.mfX.sampleRate) + this.mgc, 1, this.mfX.frameSize, 0, null);
            this.mgd += this.mfX.samplesPerFrame;
            this.mge = 0;
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
        fVar.dtE();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int dtF = (int) fVar.dtF();
            if (!z) {
                fVar.Jq(dtF);
            }
            i2 = dtF;
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
            if (!fVar.e(this.mdR.data, 0, 4, i4 > 0)) {
                break;
            }
            this.mdR.setPosition(0);
            int readInt = this.mdR.readInt();
            if ((i3 != 0 && !E(readInt, i3)) || (Jx = j.Jx(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.dtE();
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
                    j.a(readInt, this.mfX);
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
            fVar.dtE();
        }
        this.mga = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.o(this.mdR.data, 0, 10);
            this.mdR.setPosition(0);
            if (this.mdR.dyl() == com.google.android.exoplayer2.metadata.id3.a.mlJ) {
                this.mdR.skipBytes(3);
                int dyr = this.mdR.dyr();
                int i2 = dyr + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.mdR.data, 0, bArr, 0, 10);
                    fVar.o(bArr, 10, dyr);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.mdA : null).x(bArr, i2);
                    if (this.metadata != null) {
                        this.mfY.c(this.metadata);
                    }
                } else {
                    fVar.Jr(dyr);
                }
                i += i2;
            } else {
                fVar.dtE();
                fVar.Jr(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mfX.frameSize);
        fVar.o(lVar.data, 0, this.mfX.frameSize);
        int i = (this.mfX.version & 1) != 0 ? this.mfX.channels != 1 ? 36 : 21 : this.mfX.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mfT || c == mfU) {
            d b = d.b(this.mfX, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mfY.dtI()) {
                fVar.dtE();
                fVar.Jr(i + 141);
                fVar.o(this.mdR.data, 0, 3);
                this.mdR.setPosition(0);
                this.mfY.Jw(this.mdR.dyl());
            }
            fVar.Jq(this.mfX.frameSize);
            if (b != null && !b.dtD() && c == mfU) {
                return m(fVar);
            }
            return b;
        } else if (c == mfV) {
            c a2 = c.a(this.mfX, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jq(this.mfX.frameSize);
            return a2;
        } else {
            fVar.dtE();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.o(this.mdR.data, 0, 4);
        this.mdR.setPosition(0);
        j.a(this.mdR.readInt(), this.mfX);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mfX.bitrate, fVar.getLength());
    }

    private static boolean E(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dyi() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mfT || readInt == mfU) {
                return readInt;
            }
        }
        if (lVar.dyi() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mfV) {
                return mfV;
            }
        }
        return 0;
    }
}
