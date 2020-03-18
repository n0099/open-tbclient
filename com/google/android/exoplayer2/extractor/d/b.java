package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes6.dex */
final class b extends h {
    private com.google.android.exoplayer2.util.f mmZ;
    private a mna;

    public static boolean A(l lVar) {
        return lVar.dzR() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mmZ = null;
            this.mna = null;
        }
    }

    private static boolean aw(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if (aw(lVar.data)) {
            return C(lVar);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        byte[] bArr = lVar.data;
        if (this.mmZ == null) {
            this.mmZ = new com.google.android.exoplayer2.util.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.dzS());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.mbs = Format.a(null, "audio/flac", null, -1, this.mmZ.dzK(), this.mmZ.channels, this.mmZ.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.mna = new a();
            this.mna.D(lVar);
        } else if (aw(bArr)) {
            if (this.mna != null) {
                this.mna.fU(j);
                aVar.mnz = this.mna;
                return false;
            }
            return false;
        }
        return true;
    }

    private int C(l lVar) {
        int i = (lVar.data[2] & 255) >> 4;
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                lVar.skipBytes(4);
                lVar.dAg();
                int readUnsignedByte = i == 6 ? lVar.readUnsignedByte() : lVar.readUnsignedShort();
                lVar.setPosition(0);
                return readUnsignedByte + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    /* loaded from: classes6.dex */
    private class a implements f, com.google.android.exoplayer2.extractor.l {
        private long[] mnb;
        private long[] mnc;
        private long mnd = -1;
        private long mne = -1;

        public a() {
        }

        public void fU(long j) {
            this.mnd = j;
        }

        public void D(l lVar) {
            lVar.skipBytes(1);
            int dzV = lVar.dzV() / 18;
            this.mnb = new long[dzV];
            this.mnc = new long[dzV];
            for (int i = 0; i < dzV; i++) {
                this.mnb[i] = lVar.readLong();
                this.mnc[i] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            if (this.mne >= 0) {
                long j = -(this.mne + 2);
                this.mne = -1L;
                return j;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fT(long j) {
            long fW = b.this.fW(j);
            this.mne = this.mnb[v.a(this.mnb, fW, true, true)];
            return fW;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dvH() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dvo() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fM(long j) {
            int a = v.a(this.mnb, b.this.fW(j), true, true);
            return this.mnc[a] + this.mnd;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return b.this.mmZ.dzL();
        }
    }
}
