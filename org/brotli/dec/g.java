package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nKJ;
    int[] nKK;
    int[] nKL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nKJ = i;
        gVar.nKK = new int[i2 * 1080];
        gVar.nKL = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nKL.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nKL[i2] = i;
            d.a(gVar.nKJ, gVar.nKK, i, aVar);
            i += 1080;
        }
    }
}
