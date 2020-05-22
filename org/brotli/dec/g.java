package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nBp;
    int[] nBq;
    int[] nBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nBp = i;
        gVar.nBq = new int[i2 * 1080];
        gVar.nBr = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nBr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nBr[i2] = i;
            d.a(gVar.nBp, gVar.nBq, i, aVar);
            i += 1080;
        }
    }
}
