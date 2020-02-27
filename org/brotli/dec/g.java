package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nKH;
    int[] nKI;
    int[] nKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nKH = i;
        gVar.nKI = new int[i2 * 1080];
        gVar.nKJ = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nKJ.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nKJ[i2] = i;
            d.a(gVar.nKH, gVar.nKI, i, aVar);
            i += 1080;
        }
    }
}
