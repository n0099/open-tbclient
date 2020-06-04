package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    int[] nCA;
    int[] nCB;
    private int nCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nCz = i;
        gVar.nCA = new int[i2 * 1080];
        gVar.nCB = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nCB.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nCB[i2] = i;
            d.a(gVar.nCz, gVar.nCA, i, aVar);
            i += 1080;
        }
    }
}
