package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class i implements h {
    private static final double[] mmm = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean mdN;
    private com.google.android.exoplayer2.extractor.m med;
    private String mma;
    private long mml;
    private long mmn;
    private final boolean[] mmo = new boolean[4];
    private final a mmp = new a(128);
    private boolean mmq;
    private long mmr;
    private long mms;
    private boolean mmt;
    private boolean mmu;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        com.google.android.exoplayer2.util.j.b(this.mmo);
        this.mmp.reset();
        this.totalBytesWritten = 0L;
        this.mmq = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dur();
        this.mma = dVar.dut();
        this.med = gVar.dH(dVar.dus(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmr = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dyi = lVar.dyi();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dyh();
        this.med.a(lVar, lVar.dyh());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyi, this.mmo);
            if (a2 == dyi) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.mdN) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.mmp.q(bArr, position, a2);
                }
                if (this.mmp.dJ(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.mmp, this.mma);
                    this.med.h((Format) a3.first);
                    this.mmn = ((Long) a3.second).longValue();
                    this.mdN = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dyi - a2;
                if (this.mmq && this.mmu && this.mdN) {
                    this.med.a(this.mml, this.mmt ? 1 : 0, ((int) (this.totalBytesWritten - this.mms)) - i3, i3, null);
                }
                if (!this.mmq || this.mmu) {
                    this.mms = this.totalBytesWritten - i3;
                    if (this.mmr != -9223372036854775807L) {
                        j = this.mmr;
                    } else {
                        j = this.mmq ? this.mml + this.mmn : 0L;
                    }
                    this.mml = j;
                    this.mmt = false;
                    this.mmr = -9223372036854775807L;
                    this.mmq = true;
                }
                this.mmu = i == 0;
            } else if (i == 184) {
                this.mmt = true;
            }
            position = a2 + 3;
        }
        if (!this.mdN) {
            this.mmp.q(bArr, position, dyi);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
    }

    private static Pair<Format, Long> a(a aVar, String str) {
        int i;
        byte[] copyOf = Arrays.copyOf(aVar.data, aVar.length);
        int i2 = copyOf[5] & 255;
        int i3 = (i2 >> 4) | ((copyOf[4] & 255) << 4);
        int i4 = ((i2 & 15) << 8) | (copyOf[6] & 255);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = (i4 * 4) / (i3 * 3);
                break;
            case 3:
                f = (i4 * 16) / (i3 * 9);
                break;
            case 4:
                f = (i4 * 121) / (i3 * 100);
                break;
        }
        Format a2 = Format.a(str, "video/mpeg2", (String) null, -1, -1, i3, i4, -1.0f, Collections.singletonList(copyOf), -1, f, (DrmInitData) null);
        long j = 0;
        int i5 = (copyOf[7] & 15) - 1;
        if (i5 >= 0 && i5 < mmm.length) {
            double d = mmm[i5];
            int i6 = aVar.mmx;
            int i7 = (copyOf[i6 + 9] & 96) >> 5;
            if (i7 != (copyOf[i6 + 9] & 31)) {
                d *= (i7 + 1.0d) / (i + 1);
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a2, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        private static final byte[] mmv = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean mmw;
        public int mmx;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.mmw = false;
            this.length = 0;
            this.mmx = 0;
        }

        public boolean dJ(int i, int i2) {
            if (this.mmw) {
                this.length -= i2;
                if (this.mmx == 0 && i == 181) {
                    this.mmx = this.length;
                } else {
                    this.mmw = false;
                    return true;
                }
            } else if (i == 179) {
                this.mmw = true;
            }
            q(mmv, 0, mmv.length);
            return false;
        }

        public void q(byte[] bArr, int i, int i2) {
            if (this.mmw) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length = i3 + this.length;
            }
        }
    }
}
