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
    private a mli;
    private int mlj;
    private boolean mlk;
    private k.d mll;
    private k.b mlm;

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
            this.mli = null;
            this.mll = null;
            this.mlm = null;
        }
        this.mlj = 0;
        this.mlk = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.d.h
    public void fY(long j) {
        super.fY(j);
        this.mlk = j != 0;
        this.mlj = this.mll != null ? this.mll.mlC : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected long B(l lVar) {
        if ((lVar.data[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(lVar.data[0], this.mli);
        int i = this.mlk ? (this.mlj + a2) / 4 : 0;
        d(lVar, i);
        this.mlk = true;
        this.mlj = a2;
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.d.h
    protected boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.mli != null) {
            return false;
        }
        this.mli = F(lVar);
        if (this.mli == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mli.mln.data);
        arrayList.add(this.mli.mlo);
        aVar.lYQ = Format.a(null, "audio/vorbis", null, this.mli.mln.mlA, -1, this.mli.mln.channels, (int) this.mli.mln.sampleRate, arrayList, null, 0, null);
        return true;
    }

    a F(l lVar) throws IOException {
        if (this.mll == null) {
            this.mll = k.G(lVar);
            return null;
        } else if (this.mlm == null) {
            this.mlm = k.H(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.dyi()];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.dyi());
            k.c[] i = k.i(lVar, this.mll.channels);
            return new a(this.mll, this.mlm, bArr, i, k.JQ(i.length - 1));
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    static void d(l lVar, long j) {
        lVar.setLimit(lVar.dyi() + 4);
        lVar.data[lVar.dyi() - 4] = (byte) (j & 255);
        lVar.data[lVar.dyi() - 3] = (byte) ((j >>> 8) & 255);
        lVar.data[lVar.dyi() - 2] = (byte) ((j >>> 16) & 255);
        lVar.data[lVar.dyi() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b, a aVar) {
        if (!aVar.mlp[a(b, aVar.mlq, 1)].mlv) {
            return aVar.mln.mlC;
        }
        return aVar.mln.mlD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final k.b mlm;
        public final k.d mln;
        public final byte[] mlo;
        public final k.c[] mlp;
        public final int mlq;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.mln = dVar;
            this.mlm = bVar;
            this.mlo = bArr;
            this.mlp = cVarArr;
            this.mlq = i;
        }
    }
}
