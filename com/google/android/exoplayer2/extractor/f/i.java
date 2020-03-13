package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class i implements h {
    private static final double[] mnf = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean meG;
    private com.google.android.exoplayer2.extractor.m meW;
    private String mmT;
    private long mne;
    private long mng;
    private final boolean[] mnh = new boolean[4];
    private final a mni = new a(128);
    private boolean mnj;
    private long mnk;
    private long mnl;
    private boolean mnm;
    private boolean mnn;
    private long totalBytesWritten;

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        com.google.android.exoplayer2.util.j.b(this.mnh);
        this.mni.reset();
        this.totalBytesWritten = 0L;
        this.mnj = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        dVar.dvF();
        this.mmT = dVar.dvH();
        this.meW = gVar.dK(dVar.dvG(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        this.mnk = j;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        long j;
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        byte[] bArr = lVar.data;
        this.totalBytesWritten += lVar.dzu();
        this.meW.a(lVar, lVar.dzu());
        while (true) {
            int a2 = com.google.android.exoplayer2.util.j.a(bArr, position, dzv, this.mnh);
            if (a2 == dzv) {
                break;
            }
            int i = lVar.data[a2 + 3] & 255;
            if (!this.meG) {
                int i2 = a2 - position;
                if (i2 > 0) {
                    this.mni.u(bArr, position, a2);
                }
                if (this.mni.dM(i, i2 < 0 ? -i2 : 0)) {
                    Pair<Format, Long> a3 = a(this.mni, this.mmT);
                    this.meW.h((Format) a3.first);
                    this.mng = ((Long) a3.second).longValue();
                    this.meG = true;
                }
            }
            if (i == 0 || i == 179) {
                int i3 = dzv - a2;
                if (this.mnj && this.mnn && this.meG) {
                    this.meW.a(this.mne, this.mnm ? 1 : 0, ((int) (this.totalBytesWritten - this.mnl)) - i3, i3, null);
                }
                if (!this.mnj || this.mnn) {
                    this.mnl = this.totalBytesWritten - i3;
                    if (this.mnk != -9223372036854775807L) {
                        j = this.mnk;
                    } else {
                        j = this.mnj ? this.mne + this.mng : 0L;
                    }
                    this.mne = j;
                    this.mnm = false;
                    this.mnk = -9223372036854775807L;
                    this.mnj = true;
                }
                this.mnn = i == 0;
            } else if (i == 184) {
                this.mnm = true;
            }
            position = a2 + 3;
        }
        if (!this.meG) {
            this.mni.u(bArr, position, dzv);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
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
        if (i5 >= 0 && i5 < mnf.length) {
            double d = mnf[i5];
            int i6 = aVar.mnq;
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
        private static final byte[] mno = {0, 0, 1};
        public byte[] data;
        public int length;
        private boolean mnp;
        public int mnq;

        public a(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.mnp = false;
            this.length = 0;
            this.mnq = 0;
        }

        public boolean dM(int i, int i2) {
            if (this.mnp) {
                this.length -= i2;
                if (this.mnq == 0 && i == 181) {
                    this.mnq = this.length;
                } else {
                    this.mnp = false;
                    return true;
                }
            } else if (i == 179) {
                this.mnp = true;
            }
            u(mno, 0, mno.length);
            return false;
        }

        public void u(byte[] bArr, int i, int i2) {
            if (this.mnp) {
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
