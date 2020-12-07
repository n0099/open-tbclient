package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g {
    int[] pMA;
    int[] pMB;
    private int pMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.pMz = i;
        gVar.pMA = new int[i2 * 1080];
        gVar.pMB = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.pMB.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.pMB[i2] = i;
            d.a(gVar.pMz, gVar.pMA, i, aVar);
            i += 1080;
        }
    }
}
