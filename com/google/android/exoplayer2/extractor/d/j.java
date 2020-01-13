package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.d.h;
import com.google.android.exoplayer2.extractor.d.k;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
final class j extends h {
    private a mld;
    private int mle;
    private boolean mlf;
    private k.d mlg;
    private k.b mlh;

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
            this.mld = null;
            this.mlg = null;
            this.mlh = null;
        }
        this.mle = 0;
        this.mlf = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fY(long j) {
        super.fY(j);
        this.mlf = j != 0;
        this.mle = this.mlg != null ? this.mlg.mlx : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mld);
        int i = this.mlf ? (this.mle + a2) / 4 : 0;
        d(lVar, i);
        this.mlf = true;
        this.mle = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mld != null) {
            return false;
        }
        this.mld = F(lVar);
        if (this.mld == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mld.mli.data);
        arrayList.add(this.mld.mlj);
        aVar.lYL = Format.a(null, "audio/vorbis", null, this.mld.mli.mlv, -1, this.mld.mli.channels, (int) this.mld.mli.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mlg == null) {
            this.mlg = k.G(lVar);
            return null;
        } else if (this.mlh == null) {
            this.mlh = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dyg()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dyg());
            k.c[] i = k.i(lVar, this.mlg.channels);
            return new a(this.mlg, this.mlh, bArr, i, k.JQ(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dyg() + 4);
        lVar.data[lVar.dyg() - 4] = (byte) (j & 255);
        lVar.data[lVar.dyg() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dyg() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dyg() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mlk[a(b, aVar.mll, 1)].mlq) {
            return aVar.mli.mlx;
        }
        return aVar.mli.mly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final k.b mlh;
        public final k.d mli;
        public final byte[] mlj;
        public final k.c[] mlk;
        public final int mll;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mli = dVar;
            this.mlh = bVar;
            this.mlj = bArr;
            this.mlk = cVarArr;
            this.mll = i;
        }
    }
}
