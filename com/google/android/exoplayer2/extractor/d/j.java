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
    private a mlQ;
    private int mlR;
    private boolean mlS;
    private k.d mlT;
    private k.b mlU;

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
            this.mlQ = null;
            this.mlT = null;
            this.mlU = null;
        }
        this.mlR = 0;
        this.mlS = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fW(long j) {
        super.fW(j);
        this.mlS = j != 0;
        this.mlR = this.mlT != null ? this.mlT.mmk : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mlQ);
        int i = this.mlS ? (this.mlR + a2) / 4 : 0;
        d(lVar, i);
        this.mlS = true;
        this.mlR = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mlQ != null) {
            return false;
        }
        this.mlQ = F(lVar);
        if (this.mlQ == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mlQ.mlV.data);
        arrayList.add(this.mlQ.mlW);
        aVar.lZy = Format.a(null, "audio/vorbis", null, this.mlQ.mlV.mmi, -1, this.mlQ.mlV.channels, (int) this.mlQ.mlV.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mlT == null) {
            this.mlT = k.G(lVar);
            return null;
        } else if (this.mlU == null) {
            this.mlU = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dzu()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dzu());
            k.c[] i = k.i(lVar, this.mlT.channels);
            return new a(this.mlT, this.mlU, bArr, i, k.JV(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dzu() + 4);
        lVar.data[lVar.dzu() - 4] = (byte) (j & 255);
        lVar.data[lVar.dzu() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dzu() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dzu() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mlX[a(b, aVar.mlY, 1)].mmd) {
            return aVar.mlV.mmk;
        }
        return aVar.mlV.mml;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final k.b mlU;
        public final k.d mlV;
        public final byte[] mlW;
        public final k.c[] mlX;
        public final int mlY;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mlV = dVar;
            this.mlU = bVar;
            this.mlW = bArr;
            this.mlX = cVarArr;
            this.mlY = i;
        }
    }
}
