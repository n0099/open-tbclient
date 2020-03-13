package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nKU;
    int[] nKV;
    int[] nKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nKU = i;
        gVar.nKV = new int[i2 * 1080];
        gVar.nKW = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nKW.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nKW[i2] = i;
            d.a(gVar.nKU, gVar.nKV, i, aVar);
            i += 1080;
        }
    }
}
