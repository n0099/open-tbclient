package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class i implements h {
    private static final double[] mmh = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean mdI;
    private com.google.android.exoplayer2.extractor.m mdY;
    private String mlV;
    private long mmg;
    private long mmi;
    private final boolean[] mmj = new boolean[4];
    private final a mmk = new a(128);
    private boolean mml;
    private long mmm;
    private long mmn;
    private boolean mmo;
    private boolean mmp;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        com.google.android.exoplayer2.util.j.b(this.mmj);
        this.mmk.reset();
        this.totalBytesWritten = 0L;
        this.mml = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dup();
        this.mlV = dVar.dur();
        this.mdY = gVar.dH(dVar.duq(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.mmm = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dyg = lVar.dyg();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dyf();
        this.mdY.a(lVar, lVar.dyf());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dyg, this.mmj);
            if (a2 == dyg) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.mdI) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.mmk.q(bArr, position, a2);
                }
                if (this.mmk.dJ(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.mmk, this.mlV);
                    this.mdY.h((Format) a3.first);
                    this.mmi = ((Long) a3.second).longValue();
                    this.mdI = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dyg - a2;
                if (this.mml && this.mmp && this.mdI) {
                    this.mdY.a(this.mmg, this.mmo ? 1 : 0, ((int) (this.totalBytesWritten - this.mmn)) - i3, i3, null);
                }
                if (!this.mml || this.mmp) {
                    this.mmn = this.totalBytesWritten - i3;
                    if (this.mmm != -9223372036854775807L) {
                        j = this.mmm;
                    } else {
                        j = this.mml ? this.mmg + this.mmi : 0L;
                    }
                    this.mmg = j;
                    this.mmo = false;
                    this.mmm = -9223372036854775807L;
                    this.mml = true;
                }
                this.mmp = i == 0;
            } else if (i == 184) {
                this.mmo = true;
            }
            position = a2 + 3;
        }
        if (!this.mdI) {
            this.mmk.q(bArr, position, dyg);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
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
        if (i5 >= 0 && i5 < mmh.length) {
            double d = mmh[i5];
            int i6 = aVar.mms;
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
        private static final byte[] mmq = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean mmr;
        public int mms;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.mmr = false;
            this.length = 0;
            this.mms = 0;
        }

        public boolean dJ(int i, int i2) {
            if (this.mmr) {
                this.length -= i2;
                if (this.mms == 0 && i == 181) {
                    this.mms = this.length;
                } else {
                    this.mmr = false;
                    return true;
                }
            } else if (i == 179) {
                this.mmr = true;
            }
            q(mmq, 0, mmq.length);
            return false;
        }

        public void q(byte[] bArr, int i, int i2) {
            if (this.mmr) {
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
