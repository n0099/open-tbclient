package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.extractor.d.k;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
final class j extends h {
    private a mhm;
    private int mhn;
    private boolean mho;
    private k.d mhp;
    private k.b mhq;

    public static boolean A(l lVar) {
        try {
            return k.a(1, lVar, true);
        } catch (ParserException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.mhm = null;
            this.mhp = null;
            this.mhq = null;
        }
        this.mhn = 0;
        this.mho = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fT(long j) {
        super.fT(j);
        this.mho = j != 0;
        this.mhn = this.mhp != null ? this.mhp.mhH : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mhm);
        int i = this.mho ? (this.mhn + a2) / 4 : 0;
        d(lVar, i);
        this.mho = true;
        this.mhn = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mhm != null) {
            return false;
        }
        this.mhm = F(lVar);
        if (this.mhm == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mhm.mhr.data);
        arrayList.add(this.mhm.mhs);
        aVar.lUU = Format.a(null, "audio/vorbis", null, this.mhm.mhr.mhF, -1, this.mhm.mhr.channels, (int) this.mhm.mhr.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mhp == null) {
            this.mhp = k.G(lVar);
            return null;
        } else if (this.mhq == null) {
            this.mhq = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dwW()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dwW());
            k.c[] i = k.i(lVar, this.mhp.channels);
            return new a(this.mhp, this.mhq, bArr, i, k.JH(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dwW() + 4);
        lVar.data[lVar.dwW() - 4] = (byte) (j & 255);
        lVar.data[lVar.dwW() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dwW() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dwW() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mht[a(b, aVar.mhu, 1)].mhA) {
            return aVar.mhr.mhH;
        }
        return aVar.mhr.mhI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final k.b mhq;
        public final k.d mhr;
        public final byte[] mhs;
        public final k.c[] mht;
        public final int mhu;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mhr = dVar;
            this.mhq = bVar;
            this.mhs = bArr;
            this.mht = cVarArr;
            this.mhu = i;
        }
    }
}
