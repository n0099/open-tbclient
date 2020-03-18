package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class i implements h {
    private static final double[] moM = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private com.google.android.exoplayer2.extractor.m mgC;
    private boolean mgm;
    private String moA;
    private long moL;
    private long moN;
    private final boolean[] moO = new boolean[4];
    private final a moP = new a(128);
    private boolean moQ;
    private long moR;
    private long moS;
    private boolean moT;
    private boolean moU;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        com.google.android.exoplayer2.util.j.b(this.moO);
        this.moP.reset();
        this.totalBytesWritten = 0L;
        this.moQ = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dwc();
        this.moA = dVar.dwe();
        this.mgC = gVar.dL(dVar.dwd(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        this.moR = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dzS = lVar.dzS();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzR();
        this.mgC.a(lVar, lVar.dzR());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzS, this.moO);
            if (a2 == dzS) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.mgm) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.moP.u(bArr, position, a2);
                }
                if (this.moP.dN(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.moP, this.moA);
                    this.mgC.h((Format) a3.first);
                    this.moN = ((Long) a3.second).longValue();
                    this.mgm = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dzS - a2;
                if (this.moQ && this.moU && this.mgm) {
                    this.mgC.a(this.moL, this.moT ? 1 : 0, ((int) (this.totalBytesWritten - this.moS)) - i3, i3, null);
                }
                if (!this.moQ || this.moU) {
                    this.moS = this.totalBytesWritten - i3;
                    if (this.moR != -9223372036854775807L) {
                        j = this.moR;
                    } else {
                        j = this.moQ ? this.moL + this.moN : 0L;
                    }
                    this.moL = j;
                    this.moT = false;
                    this.moR = -9223372036854775807L;
                    this.moQ = true;
                }
                this.moU = i == 0;
            } else if (i == 184) {
                this.moT = true;
            }
            position = a2 + 3;
        }
        if (!this.mgm) {
            this.moP.u(bArr, position, dzS);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
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
        if (i5 >= 0 && i5 < moM.length) {
            double d = moM[i5];
            int i6 = aVar.moX;
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
        private static final byte[] moV = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean moW;
        public int moX;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.moW = false;
            this.length = 0;
            this.moX = 0;
        }

        public boolean dN(int i, int i2) {
            if (this.moW) {
                this.length -= i2;
                if (this.moX == 0 && i == 181) {
                    this.moX = this.length;
                } else {
                    this.moW = false;
                    return true;
                }
            } else if (i == 179) {
                this.moW = true;
            }
            u(moV, 0, moV.length);
            return false;
        }

        public void u(byte[] bArr, int i, int i2) {
            if (this.moW) {
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
