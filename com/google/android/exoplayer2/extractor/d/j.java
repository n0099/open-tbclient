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
    private a mnH;
    private int mnI;
    private boolean mnJ;
    private k.d mnK;
    private k.b mnL;

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
            this.mnH = null;
            this.mnK = null;
            this.mnL = null;
        }
        this.mnI = 0;
        this.mnJ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fX(long j) {
        super.fX(j);
        this.mnJ = j != 0;
        this.mnI = this.mnK != null ? this.mnK.mob : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mnH);
        int i = this.mnJ ? (this.mnI + a2) / 4 : 0;
        d(lVar, i);
        this.mnJ = true;
        this.mnI = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mnH != null) {
            return false;
        }
        this.mnH = F(lVar);
        if (this.mnH == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mnH.mnM.data);
        arrayList.add(this.mnH.mnN);
        aVar.mbs = Format.a(null, "audio/vorbis", null, this.mnH.mnM.mnZ, -1, this.mnH.mnM.channels, (int) this.mnH.mnM.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mnK == null) {
            this.mnK = k.G(lVar);
            return null;
        } else if (this.mnL == null) {
            this.mnL = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dzS()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dzS());
            k.c[] i = k.i(lVar, this.mnK.channels);
            return new a(this.mnK, this.mnL, bArr, i, k.Kb(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dzS() + 4);
        lVar.data[lVar.dzS() - 4] = (byte) (j & 255);
        lVar.data[lVar.dzS() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dzS() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dzS() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mnO[a(b, aVar.mnP, 1)].mnU) {
            return aVar.mnM.mob;
        }
        return aVar.mnM.moc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final k.b mnL;
        public final k.d mnM;
        public final byte[] mnN;
        public final k.c[] mnO;
        public final int mnP;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mnM = dVar;
            this.mnL = bVar;
            this.mnN = bArr;
            this.mnO = cVarArr;
            this.mnP = i;
        }
    }
}
