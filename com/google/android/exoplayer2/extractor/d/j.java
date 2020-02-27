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
    private a mlO;
    private int mlP;
    private boolean mlQ;
    private k.d mlR;
    private k.b mlS;

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
            this.mlO = null;
            this.mlR = null;
            this.mlS = null;
        }
        this.mlP = 0;
        this.mlQ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fW(long j) {
        super.fW(j);
        this.mlQ = j != 0;
        this.mlP = this.mlR != null ? this.mlR.mmi : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mlO);
        int i = this.mlQ ? (this.mlP + a2) / 4 : 0;
        d(lVar, i);
        this.mlQ = true;
        this.mlP = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mlO != null) {
            return false;
        }
        this.mlO = F(lVar);
        if (this.mlO == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mlO.mlT.data);
        arrayList.add(this.mlO.mlU);
        aVar.lZw = Format.a(null, "audio/vorbis", null, this.mlO.mlT.mmg, -1, this.mlO.mlT.channels, (int) this.mlO.mlT.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mlR == null) {
            this.mlR = k.G(lVar);
            return null;
        } else if (this.mlS == null) {
            this.mlS = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dzs()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dzs());
            k.c[] i = k.i(lVar, this.mlR.channels);
            return new a(this.mlR, this.mlS, bArr, i, k.JV(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dzs() + 4);
        lVar.data[lVar.dzs() - 4] = (byte) (j & 255);
        lVar.data[lVar.dzs() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dzs() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dzs() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mlV[a(b, aVar.mlW, 1)].mmb) {
            return aVar.mlT.mmi;
        }
        return aVar.mlT.mmj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final k.b mlS;
        public final k.d mlT;
        public final byte[] mlU;
        public final k.c[] mlV;
        public final int mlW;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mlT = dVar;
            this.mlS = bVar;
            this.mlU = bArr;
            this.mlV = cVarArr;
            this.mlW = i;
        }
    }
}
