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
    public static final h mgo = new h() { // from class: com.google.android.exoplayer2.extractor.b.b.1
        @Override // com.google.android.exoplayer2.extractor.h
        public e[] dvr() {
            return new e[]{new b()};
        }
    };
    private static final int miu = v.QE("Xing");
    private static final int miv = v.QE("Info");
    private static final int miw = v.QE("VBRI");
    private final int flags;
    private Metadata metadata;
    private final l mgq;
    private g mgu;
    private m miA;
    private int miB;
    private a miC;
    private long miD;
    private long miE;
    private int miF;
    private final long mix;
    private final j miy;
    private final i miz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a extends com.google.android.exoplayer2.extractor.l {
        long fO(long j);
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = i;
        this.mix = j;
        this.mgq = new l(10);
        this.miy = new j();
        this.miz = new i();
        this.miD = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(g gVar) {
        this.mgu = gVar;
        this.miA = this.mgu.dL(0, 1);
        this.mgu.dvs();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        this.miB = 0;
        this.miD = -9223372036854775807L;
        this.miE = 0L;
        this.miF = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.miB == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.miC == null) {
            this.miC = l(fVar);
            if (this.miC == null || (!this.miC.dvo() && (this.flags & 1) != 0)) {
                this.miC = m(fVar);
            }
            this.mgu.a(this.miC);
            this.miA.h(Format.a((String) null, this.miy.mimeType, (String) null, -1, 4096, this.miy.channels, this.miy.sampleRate, -1, this.miz.encoderDelay, this.miz.encoderPadding, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return j(fVar);
    }

    private int j(f fVar) throws IOException, InterruptedException {
        if (this.miF == 0) {
            fVar.dvp();
            if (!fVar.e(this.mgq.data, 0, 4, true)) {
                return -1;
            }
            this.mgq.setPosition(0);
            int readInt = this.mgq.readInt();
            if (!D(readInt, this.miB) || j.JI(readInt) == -1) {
                fVar.JB(1);
                this.miB = 0;
                return 0;
            }
            j.a(readInt, this.miy);
            if (this.miD == -9223372036854775807L) {
                this.miD = this.miC.fO(fVar.getPosition());
                if (this.mix != -9223372036854775807L) {
                    this.miD = (this.mix - this.miC.fO(0L)) + this.miD;
                }
            }
            this.miF = this.miy.frameSize;
        }
        int a2 = this.miA.a(fVar, this.miF, true);
        if (a2 == -1) {
            return -1;
        }
        this.miF -= a2;
        if (this.miF <= 0) {
            this.miA.a(((this.miE * TimeUtils.NANOS_PER_MS) / this.miy.sampleRate) + this.miD, 1, this.miy.frameSize, 0, null);
            this.miE += this.miy.samplesPerFrame;
            this.miF = 0;
            return 0;
        }
        return 0;
    }

    private boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        int i;
        int i2;
        int i3;
        int i4;
        int JI;
        int i5 = z ? 16384 : 131072;
        fVar.dvp();
        if (fVar.getPosition() == 0) {
            k(fVar);
            int dvq = (int) fVar.dvq();
            if (!z) {
                fVar.JB(dvq);
            }
            i2 = dvq;
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
            if (!fVar.e(this.mgq.data, 0, 4, i4 > 0)) {
                break;
            }
            this.mgq.setPosition(0);
            int readInt = this.mgq.readInt();
            if ((i3 != 0 && !D(readInt, i3)) || (JI = j.JI(readInt)) == -1) {
                int i6 = i + 1;
                if (i == i5) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                } else if (z) {
                    fVar.dvp();
                    fVar.JC(i2 + i6);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                } else {
                    fVar.JB(1);
                    i = i6;
                    i4 = 0;
                    i3 = 0;
                }
            } else {
                i4++;
                if (i4 == 1) {
                    j.a(readInt, this.miy);
                    i3 = readInt;
                } else if (i4 == 4) {
                    break;
                }
                fVar.JC(JI - 4);
            }
        }
        if (z) {
            fVar.JB(i2 + i);
        } else {
            fVar.dvp();
        }
        this.miB = i3;
        return true;
    }

    private void k(f fVar) throws IOException, InterruptedException {
        int i = 0;
        while (true) {
            fVar.s(this.mgq.data, 0, 10);
            this.mgq.setPosition(0);
            if (this.mgq.dzV() == com.google.android.exoplayer2.metadata.id3.a.moi) {
                this.mgq.skipBytes(3);
                int dAb = this.mgq.dAb();
                int i2 = dAb + 10;
                if (this.metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.mgq.data, 0, bArr, 0, 10);
                    fVar.s(bArr, 10, dAb);
                    this.metadata = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.mfZ : null).z(bArr, i2);
                    if (this.metadata != null) {
                        this.miz.c(this.metadata);
                    }
                } else {
                    fVar.JC(dAb);
                }
                i += i2;
            } else {
                fVar.dvp();
                fVar.JC(i);
                return;
            }
        }
    }

    private a l(f fVar) throws IOException, InterruptedException {
        l lVar = new l(this.miy.frameSize);
        fVar.s(lVar.data, 0, this.miy.frameSize);
        int i = (this.miy.version & 1) != 0 ? this.miy.channels != 1 ? 36 : 21 : this.miy.channels != 1 ? 21 : 13;
        int c = c(lVar, i);
        if (c == miu || c == miv) {
            d b = d.b(this.miy, lVar, fVar.getPosition(), fVar.getLength());
            if (b != null && !this.miz.dvt()) {
                fVar.dvp();
                fVar.JC(i + 141);
                fVar.s(this.mgq.data, 0, 3);
                this.mgq.setPosition(0);
                this.miz.JH(this.mgq.dzV());
            }
            fVar.JB(this.miy.frameSize);
            if (b != null && !b.dvo() && c == miv) {
                return m(fVar);
            }
            return b;
        } else if (c == miw) {
            c a2 = c.a(this.miy, lVar, fVar.getPosition(), fVar.getLength());
            fVar.JB(this.miy.frameSize);
            return a2;
        } else {
            fVar.dvp();
            return null;
        }
    }

    private a m(f fVar) throws IOException, InterruptedException {
        fVar.s(this.mgq.data, 0, 4);
        this.mgq.setPosition(0);
        j.a(this.mgq.readInt(), this.miy);
        return new com.google.android.exoplayer2.extractor.b.a(fVar.getPosition(), this.miy.bitrate, fVar.getLength());
    }

    private static boolean D(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    private static int c(l lVar, int i) {
        if (lVar.dzS() >= i + 4) {
            lVar.setPosition(i);
            int readInt = lVar.readInt();
            if (readInt == miu || readInt == miv) {
                return readInt;
            }
        }
        if (lVar.dzS() >= 40) {
            lVar.setPosition(36);
            if (lVar.readInt() == miw) {
                return miw;
            }
        }
        return 0;
    }
}
