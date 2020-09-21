package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class g {
    private int oKS;
    int[] oKT;
    int[] oKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.oKS = i;
        gVar.oKT = new int[i2 * 1080];
        gVar.oKU = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.oKU.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.oKU[i2] = i;
            d.a(gVar.oKS, gVar.oKT, i, aVar);
            i += 1080;
        }
    }
}
