package com.google.android.exoplayer2.extractor.d;

import com.baidu.down.manage.DownloadConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes4.dex */
final class b extends h {
    private com.google.android.exoplayer2.util.f mgE;
    private a mgF;

    public static boolean A(l lVar) {
        return lVar.dwV() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mgE = null;
            this.mgF = null;
        }
    }

    private static boolean as(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if (as(lVar.data)) {
            return C(lVar);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        byte[] bArr = lVar.data;
        if (this.mgE == null) {
            this.mgE = new com.google.android.exoplayer2.util.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.dwW());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.lUU = Format.a(null, "audio/flac", null, -1, this.mgE.dwO(), this.mgE.channels, this.mgE.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.mgF = new a();
            this.mgF.D(lVar);
        } else if (as(bArr)) {
            if (this.mgF != null) {
                this.mgF.fQ(j);
                aVar.mhe = this.mgF;
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
                lVar.dxk();
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

    /* loaded from: classes4.dex */
    private class a implements f, com.google.android.exoplayer2.extractor.l {
        private long[] mgG;
        private long[] mgH;
        private long mgI = -1;
        private long mgJ = -1;

        public a() {
        }

        public void fQ(long j) {
            this.mgI = j;
        }

        public void D(l lVar) {
            lVar.skipBytes(1);
            int dwZ = lVar.dwZ() / 18;
            this.mgG = new long[dwZ];
            this.mgH = new long[dwZ];
            for (int i = 0; i < dwZ; i++) {
                this.mgG[i] = lVar.readLong();
                this.mgH[i] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            if (this.mgJ >= 0) {
                long j = -(this.mgJ + 2);
                this.mgJ = -1L;
                return j;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fP(long j) {
            long fS = b.this.fS(j);
            this.mgJ = this.mgG[v.a(this.mgG, fS, true, true)];
            return fS;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dsI() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dsp() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fI(long j) {
            int a = v.a(this.mgG, b.this.fS(j), true, true);
            return this.mgH[a] + this.mgI;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long drc() {
            return b.this.mgE.dwP();
        }
    }
}
