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
/* loaded from: classes4.dex */
public final class b implements e {
    public static final h lZS = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dss() {
            return new e[]{new b()};
        }
    };
    private static final int mbZ = v.Qg("Xing");
    private static final int mca = v.Qg("Info");
    private static final int mcb = v.Qg("VBRI");
    private final int flags;
    private final l lZU;
    private g lZY;
    private final long mcc;
    private final j mcd;
    private final i mce;
    private m mcf;
    private int mcg;
    private a mch;
    private long mci;
    private long mcj;
    private int mck;
    private Metadata metadata;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a extends com.google.android.exoplayer2.extractor.l {
        long fK(long j);
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = i;
        this.mcc = j;
        this.lZU = new l(10);
        this.mcd = new j();
        this.mce = new i();
        this.mci = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.lZY = gVar;
        this.mcf = this.lZY.dJ(0, 1);
        this.lZY.dst();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        this.mcg = 0;
        this.mci = -9223372036854775807L;
        this.mcj = 0L;
        this.mck = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.mcg == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.mch == null) {
            this.mch = l(fVar);
            if (this.mch == null || (!this.mch.dsp() && (this.flags & 1) != 0)) {
                this.mch = m(fVar);
            }
            this.lZY.a(this.mch);
            this.mcf.h(Format.a((String) null, this.mcd.mimeType, (String) null, -1, 4096, this.mcd.channels, this.mcd.sampleRate, -1, this.mce.encoderDelay, this.mce.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.mck == 0) {
            fVar.dsq();
            if (!fVar.e(this.lZU.data, 0, 4, true)) {
                return -1;
            }
            this.lZU.setPosition(0);
            int readInt = this.lZU.readInt();
            if (!E(readInt, this.mcg) || j.Jo(readInt) == -1) {
                fVar.Jh(1);
                this.mcg = 0;
                return 0;
            }
            j.a(readInt, this.mcd);
            if (this.mci == -9223372036854775807L) {
                this.mci = this.mch.fK(fVar.getPosition());
                if (this.mcc != -9223372036854775807L) {
                    this.mci = (this.mcc - this.mch.fK(0L)) + this.mci;
                }
            }
            this.mck = this.mcd.frameSize;
        }
        int a2 = this.mcf.a(fVar, this.mck, true);
        if (a2 == -1) {
            return -1;
        }
        this.mck -= a2;
        if (this.mck <= 0) {
            this.mcf.a(((this.mcj * TimeUtils.NANOS_PER_MS) / this.mcd.sampleRate) + this.mci, 1, this.mcd.frameSize, 0, null);
            this.mcj += this.mcd.samplesPerFrame;
            this.mck = 0;
            return 0;
        }
        return 0;
    }

    private boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        int i;
        int i2;
        int i3;
        int i4;
        int Jo;
        int i5 = z ? 16384 : 131072;
        fVar.dsq();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int dsr = (int) fVar.dsr();
            if (!z) {
                fVar.Jh(dsr);
            }
            i2 = dsr;
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
            if (!fVar.e(this.lZU.data, 0, 4, i4 > 0)) {
                break;
            }
            this.lZU.setPosition(0);
            int readInt = this.lZU.readInt();
            if ((i3 != 0 && !E(readInt, i3)) || (Jo = j.Jo(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.dsq();
                    fVar.Ji(i2 + i6);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                } else {
                    fVar.Jh(1);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                }
            } else {
                i4++;
                if (i4 == 1) {
                    j.a(readInt, this.mcd);
                    i3 = readInt;
                } else if (i4 == 4) {
                    break;
                }
                fVar.Ji(Jo - 4);
            }
        }
        if (z) {
            fVar.Jh(i2 + i);
        } else {
            fVar.dsq();
        }
        this.mcg = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.p(this.lZU.data, 0, 10);
            this.lZU.setPosition(0);
            if (this.lZU.dwZ() == com.google.android.exoplayer2.metadata.id3.a.mhO) {
                this.lZU.skipBytes(3);
                int dxf = this.lZU.dxf();
                int i2 = dxf + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.lZU.data, 0, bArr, 0, 10);
                    fVar.p(bArr, 10, dxf);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.lZD : null).x(bArr, i2);
                    if (this.metadata != null) {
                        this.mce.c(this.metadata);
                    }
                } else {
                    fVar.Ji(dxf);
                }
                i += i2;
            } else {
                fVar.dsq();
                fVar.Ji(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.mcd.frameSize);
        fVar.p(lVar.data, 0, this.mcd.frameSize);
        int i = (this.mcd.version & 1) != 0 ? this.mcd.channels != 1 ? 36 : 21 : this.mcd.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == mbZ || c == mca) {
            d b = d.b(this.mcd, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.mce.dsu()) {
                fVar.dsq();
                fVar.Ji(i + 141);
                fVar.p(this.lZU.data, 0, 3);
                this.lZU.setPosition(0);
                this.mce.Jn(this.lZU.dwZ());
            }
            fVar.Jh(this.mcd.frameSize);
            if (b != null && !b.dsp() && c == mca) {
                return m(fVar);
            }
            return b;
        } else if (c == mcb) {
            c a2 = c.a(this.mcd, lVar, fVar.getPosition(), fVar.getLength());
            fVar.Jh(this.mcd.frameSize);
            return a2;
        } else {
            fVar.dsq();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.p(this.lZU.data, 0, 4);
        this.lZU.setPosition(0);
        j.a(this.lZU.readInt(), this.mcd);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.mcd.bitrate, fVar.getLength());
    }

    private static boolean E(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dwW() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == mbZ || readInt == mca) {
                return readInt;
            }
        }
        if (lVar.dwW() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == mcb) {
                return mcb;
            }
        }
        return 0;
    }
}
