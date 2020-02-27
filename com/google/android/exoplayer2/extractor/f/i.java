package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class i implements h {
    private static final double[] mmS = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private com.google.android.exoplayer2.extractor.m meJ;
    private boolean met;
    private String mmG;
    private long mmR;
    private long mmT;
    private final boolean[] mmU = new boolean[4];
    private final a mmV = new a(128);
    private boolean mmW;
    private long mmX;
    private long mmY;
    private boolean mmZ;
    private boolean mna;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        com.google.android.exoplayer2.util.j.b(this.mmU);
        this.mmV.reset();
        this.totalBytesWritten = 0L;
        this.mmW = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvC();
        this.mmG = dVar.dvE();
        this.meJ = gVar.dK(dVar.dvD(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmX = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dzs = lVar.dzs();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzr();
        this.meJ.a(lVar, lVar.dzr());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzs, this.mmU);
            if (a2 == dzs) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.met) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.mmV.u(bArr, position, a2);
                }
                if (this.mmV.dM(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.mmV, this.mmG);
                    this.meJ.h((Format) a3.first);
                    this.mmT = ((Long) a3.second).longValue();
                    this.met = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dzs - a2;
                if (this.mmW && this.mna && this.met) {
                    this.meJ.a(this.mmR, this.mmZ ? 1 : 0, ((int) (this.totalBytesWritten - this.mmY)) - i3, i3, null);
                }
                if (!this.mmW || this.mna) {
                    this.mmY = this.totalBytesWritten - i3;
                    if (this.mmX != -9223372036854775807L) {
                        j = this.mmX;
                    } else {
                        j = this.mmW ? this.mmR + this.mmT : 0L;
                    }
                    this.mmR = j;
                    this.mmZ = false;
                    this.mmX = -9223372036854775807L;
                    this.mmW = true;
                }
                this.mna = i == 0;
            } else if (i == 184) {
                this.mmZ = true;
            }
            position = a2 + 3;
        }
        if (!this.met) {
            this.mmV.u(bArr, position, dzs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
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
        if (i5 >= 0 && i5 < mmS.length) {
            double d = mmS[i5];
            int i6 = aVar.mnd;
            int i7 = (copyOf[i6 + 9] & 96) >> 5;
            if (i7 != (copyOf[i6 + 9] & 31)) {
                d *= (i7 + 1.0d) / (i + 1);
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a2, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private static final byte[] mnb = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean mnc;
        public int mnd;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.mnc = false;
            this.length = 0;
            this.mnd = 0;
        }

        public boolean dM(int i, int i2) {
            if (this.mnc) {
                this.length -= i2;
                if (this.mnd == 0 && i == 181) {
                    this.mnd = this.length;
                } else {
                    this.mnc = false;
                    return true;
                }
            } else if (i == 179) {
                this.mnc = true;
            }
            u(mnb, 0, mnb.length);
            return false;
        }

        public void u(byte[] bArr, int i, int i2) {
            if (this.mnc) {
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
