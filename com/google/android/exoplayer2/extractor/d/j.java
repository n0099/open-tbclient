package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.extractor.d.k;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
final class j extends h {
    private a mmb;
    private int mmc;
    private boolean mmd;
    private k.d mme;
    private k.b mmf;

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
            this.mmb = null;
            this.mme = null;
            this.mmf = null;
        }
        this.mmc = 0;
        this.mmd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fW(long j) {
        super.fW(j);
        this.mmd = j != 0;
        this.mmc = this.mme != null ? this.mme.mmv : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mmb);
        int i = this.mmd ? (this.mmc + a2) / 4 : 0;
        d(lVar, i);
        this.mmd = true;
        this.mmc = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mmb != null) {
            return false;
        }
        this.mmb = F(lVar);
        if (this.mmb == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mmb.mmg.data);
        arrayList.add(this.mmb.mmh);
        aVar.lZJ = Format.a(null, "audio/vorbis", null, this.mmb.mmg.mmt, -1, this.mmb.mmg.channels, (int) this.mmb.mmg.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mme == null) {
            this.mme = k.G(lVar);
            return null;
        } else if (this.mmf == null) {
            this.mmf = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dzv()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dzv());
            k.c[] i = k.i(lVar, this.mme.channels);
            return new a(this.mme, this.mmf, bArr, i, k.JV(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dzv() + 4);
        lVar.data[lVar.dzv() - 4] = (byte) (j & 255);
        lVar.data[lVar.dzv() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dzv() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dzv() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mmi[a(b, aVar.mmj, 1)].mmo) {
            return aVar.mmg.mmv;
        }
        return aVar.mmg.mmw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final k.b mmf;
        public final k.d mmg;
        public final byte[] mmh;
        public final k.c[] mmi;
        public final int mmj;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mmg = dVar;
            this.mmf = bVar;
            this.mmh = bArr;
            this.mmi = cVarArr;
            this.mmj = i;
        }
    }
}
