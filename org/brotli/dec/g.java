package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g {
    private int pMB;
    int[] pMC;
    int[] pMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.pMB = i;
        gVar.pMC = new int[i2 * 1080];
        gVar.pMD = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.pMD.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.pMD[i2] = i;
            d.a(gVar.pMB, gVar.pMC, i, aVar);
            i += 1080;
        }
    }
}
