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
    private com.google.android.exoplayer2.util.f mlt;
    private a mlu;

    public static boolean A(l lVar) {
        return lVar.dzu() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mlt = null;
            this.mlu = null;
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
        if (this.mlt == null) {
            this.mlt = new com.google.android.exoplayer2.util.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.dzv());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.lZJ = Format.a(null, "audio/flac", null, -1, this.mlt.dzn(), this.mlt.channels, this.mlt.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.mlu = new a();
            this.mlu.D(lVar);
        } else if (aw(bArr)) {
            if (this.mlu != null) {
                this.mlu.fT(j);
                aVar.mlT = this.mlu;
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
                lVar.dzJ();
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
        private long[] mlv;
        private long[] mlw;
        private long mlx = -1;
        private long mly = -1;

        public a() {
        }

        public void fT(long j) {
            this.mlx = j;
        }

        public void D(l lVar) {
            lVar.skipBytes(1);
            int dzy = lVar.dzy() / 18;
            this.mlv = new long[dzy];
            this.mlw = new long[dzy];
            for (int i = 0; i < dzy; i++) {
                this.mlv[i] = lVar.readLong();
                this.mlw[i] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            if (this.mly >= 0) {
                long j = -(this.mly + 2);
                this.mly = -1L;
                return j;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fS(long j) {
            long fV = b.this.fV(j);
            this.mly = this.mlv[v.a(this.mlv, fV, true, true)];
            return fV;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dvk() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duR() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            int a = v.a(this.mlv, b.this.fV(j), true, true);
            return this.mlw[a] + this.mlx;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return b.this.mlt.dzo();
        }
    }
}
