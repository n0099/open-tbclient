package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class g {
    private int nJN;
    int[] nJO;
    int[] nJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nJN = i;
        gVar.nJO = new int[i2 * 1080];
        gVar.nJP = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nJP.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nJP[i2] = i;
            d.a(gVar.nJN, gVar.nJO, i, aVar);
            i += 1080;
        }
    }
}
