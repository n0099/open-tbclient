package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class i implements h {
    private static final double[] mmU = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private com.google.android.exoplayer2.extractor.m meL;
    private boolean mev;
    private String mmI;
    private long mmT;
    private long mmV;
    private final boolean[] mmW = new boolean[4];
    private final a mmX = new a(128);
    private boolean mmY;
    private long mmZ;
    private long mna;
    private boolean mnb;
    private boolean mnc;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        com.google.android.exoplayer2.util.j.b(this.mmW);
        this.mmX.reset();
        this.totalBytesWritten = 0L;
        this.mmY = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvE();
        this.mmI = dVar.dvG();
        this.meL = gVar.dK(dVar.dvF(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mmZ = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dzu = lVar.dzu();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzt();
        this.meL.a(lVar, lVar.dzt());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzu, this.mmW);
            if (a2 == dzu) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.mev) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.mmX.u(bArr, position, a2);
                }
                if (this.mmX.dM(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.mmX, this.mmI);
                    this.meL.h((Format) a3.first);
                    this.mmV = ((Long) a3.second).longValue();
                    this.mev = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dzu - a2;
                if (this.mmY && this.mnc && this.mev) {
                    this.meL.a(this.mmT, this.mnb ? 1 : 0, ((int) (this.totalBytesWritten - this.mna)) - i3, i3, null);
                }
                if (!this.mmY || this.mnc) {
                    this.mna = this.totalBytesWritten - i3;
                    if (this.mmZ != -9223372036854775807L) {
                        j = this.mmZ;
                    } else {
                        j = this.mmY ? this.mmT + this.mmV : 0L;
                    }
                    this.mmT = j;
                    this.mnb = false;
                    this.mmZ = -9223372036854775807L;
                    this.mmY = true;
                }
                this.mnc = i == 0;
            } else if (i == 184) {
                this.mnb = true;
            }
            position = a2 + 3;
        }
        if (!this.mev) {
            this.mmX.u(bArr, position, dzu);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
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
        if (i5 >= 0 && i5 < mmU.length) {
            double d = mmU[i5];
            int i6 = aVar.mnf;
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
        private static final byte[] mnd = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean mne;
        public int mnf;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.mne = false;
            this.length = 0;
            this.mnf = 0;
        }

        public boolean dM(int i, int i2) {
            if (this.mne) {
                this.length -= i2;
                if (this.mnf == 0 && i == 181) {
                    this.mnf = this.length;
                } else {
                    this.mne = false;
                    return true;
                }
            } else if (i == 179) {
                this.mne = true;
            }
            u(mnd, 0, mnd.length);
            return false;
        }

        public void u(byte[] bArr, int i, int i2) {
            if (this.mne) {
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
