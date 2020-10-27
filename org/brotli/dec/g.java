package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    private int pRB;
    int[] pRC;
    int[] pRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.pRB = i;
        gVar.pRC = new int[i2 * 1080];
        gVar.pRD = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.pRD.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.pRD[i2] = i;
            d.a(gVar.pRB, gVar.pRC, i, aVar);
            i += 1080;
        }
    }
}
