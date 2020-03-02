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
    private com.google.android.exoplayer2.util.f mli;
    private a mlj;

    public static boolean A(l lVar) {
        return lVar.dzt() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mli = null;
            this.mlj = null;
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
        if (this.mli == null) {
            this.mli = new com.google.android.exoplayer2.util.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.dzu());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.lZy = Format.a(null, "audio/flac", null, -1, this.mli.dzm(), this.mli.channels, this.mli.sampleRate, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.mlj = new a();
            this.mlj.D(lVar);
        } else if (aw(bArr)) {
            if (this.mlj != null) {
                this.mlj.fT(j);
                aVar.mlI = this.mlj;
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
                lVar.dzI();
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
        private long[] mlk;
        private long[] mll;
        private long mlm = -1;
        private long mln = -1;

        public a() {
        }

        public void fT(long j) {
            this.mlm = j;
        }

        public void D(l lVar) {
            lVar.skipBytes(1);
            int dzx = lVar.dzx() / 18;
            this.mlk = new long[dzx];
            this.mll = new long[dzx];
            for (int i = 0; i < dzx; i++) {
                this.mlk[i] = lVar.readLong();
                this.mll[i] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long u(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
            if (this.mln >= 0) {
                long j = -(this.mln + 2);
                this.mln = -1L;
                return j;
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public long fS(long j) {
            long fV = b.this.fV(j);
            this.mln = this.mlk[v.a(this.mlk, fV, true, true)];
            return fV;
        }

        @Override // com.google.android.exoplayer2.extractor.d.f
        public com.google.android.exoplayer2.extractor.l dvj() {
            return this;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duQ() {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            int a = v.a(this.mlk, b.this.fV(j), true, true);
            return this.mll[a] + this.mlm;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return b.this.mli.dzn();
        }
    }
}
