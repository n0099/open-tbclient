package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes4.dex */
public final class i implements h {
    private static final double[] mit = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean lZQ;
    private com.google.android.exoplayer2.extractor.m mah;
    private boolean miA;
    private boolean miB;
    private String mig;
    private long mis;
    private long miu;
    private final boolean[] miv = new boolean[4];
    private final a miw = new a(128);
    private boolean mix;
    private long miy;
    private long miz;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        com.google.android.exoplayer2.util.j.b(this.miv);
        this.miw.reset();
        this.totalBytesWritten = 0L;
        this.mix = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dte();
        this.mig = dVar.dtg();
        this.mah = gVar.dJ(dVar.dtf(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        this.miy = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dwW = lVar.dwW();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dwV();
        this.mah.a(lVar, lVar.dwV());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dwW, this.miv);
            if (a2 == dwW) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.lZQ) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.miw.r(bArr, position, a2);
                }
                if (this.miw.dL(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.miw, this.mig);
                    this.mah.h((Format) a3.first);
                    this.miu = ((Long) a3.second).longValue();
                    this.lZQ = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dwW - a2;
                if (this.mix && this.miB && this.lZQ) {
                    this.mah.a(this.mis, this.miA ? 1 : 0, ((int) (this.totalBytesWritten - this.miz)) - i3, i3, null);
                }
                if (!this.mix || this.miB) {
                    this.miz = this.totalBytesWritten - i3;
                    if (this.miy != -9223372036854775807L) {
                        j = this.miy;
                    } else {
                        j = this.mix ? this.mis + this.miu : 0L;
                    }
                    this.mis = j;
                    this.miA = false;
                    this.miy = -9223372036854775807L;
                    this.mix = true;
                }
                this.miB = i == 0;
            } else if (i == 184) {
                this.miA = true;
            }
            position = a2 + 3;
        }
        if (!this.lZQ) {
            this.miw.r(bArr, position, dwW);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
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
        if (i5 >= 0 && i5 < mit.length) {
            double d = mit[i5];
            int i6 = aVar.miE;
            int i7 = (copyOf[i6 + 9] & 96) >> 5;
            if (i7 != (copyOf[i6 + 9] & 31)) {
                d *= (i7 + 1.0d) / (i + 1);
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a2, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        private static final byte[] miC = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean miD;
        public int miE;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.miD = false;
            this.length = 0;
            this.miE = 0;
        }

        public boolean dL(int i, int i2) {
            if (this.miD) {
                this.length -= i2;
                if (this.miE == 0 && i == 181) {
                    this.miE = this.length;
                } else {
                    this.miD = false;
                    return true;
                }
            } else if (i == 179) {
                this.miD = true;
            }
            r(miC, 0, miC.length);
            return false;
        }

        public void r(byte[] bArr, int i, int i2) {
            if (this.miD) {
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
