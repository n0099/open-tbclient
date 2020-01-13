package com.google.android.exoplayer2.extractor.d;

import com.baidu.down.manage.DownloadConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes5.dex */
final class b extends h {
    private com.google.android.exoplayer2.util.f mkv;
    private a mkw;

    public static boolean A(l lVar) {
        return lVar.dyf() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mkv = null;
            this.mkw = null;
        }
    }

    private static boolean ar(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if (ar(lVar.data)) {
            return C(lVar);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        byte[] bArr = lVar.data;
        if (this.mkv == null) {
            this.mkv = new com.google.android.exoplayer2.util.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.dyg());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.lYL = Format.a(null, "audio/flac", null, -1, this.mkv.dxY(), this.mkv.channels, this.mkv.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.mkw = new a();
            this.mkw.D(lVar);
        } else if (ar(bArr)) {
            if (this.mkw != null) {
                this.mkw.fV(j);
                aVar.mkV = this.mkw;
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
                return DownloadConstants.STATUS_RUNNING;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                lVar.skipBytes(4);
                lVar.dyu();
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

    /* loaded from: classes5.dex */
    private class a implements f, com.google.android.exoplayer2.extractor.l {
        private long[] mkx;
        private long[] mky;
        private long mkz = -1;
        private long mkA = -1;

        public a() {
        }

        public void fV(long j) {
            this.mkz = j;
        }

        public void D(l lVar) {
            lVar.skipBytes(1);
            int dyj = lVar.dyj() / 18;
            this.mkx = new long[dyj];
            this.mky = new long[dyj];
            for (int i = 0; i < dyj; i++) {
                this.mkx[i] = lVar.readLong();
                this.mky[i] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            if (this.mkA >= 0) {
                long j = -(this.mkA + 2);
                this.mkA = -1L;
                return j;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fU(long j) {
            long fX = b.this.fX(j);
            this.mkA = this.mkx[v.a(this.mkx, fX, true, true)];
            return fX;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dtU() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dtB() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fN(long j) {
            int a = v.a(this.mkx, b.this.fX(j), true, true);
            return this.mky[a] + this.mkz;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long dso() {
            return b.this.mkv.dxZ();
        }
    }
}
