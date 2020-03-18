package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nMH;
    int[] nMI;
    int[] nMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nMH = i;
        gVar.nMI = new int[i2 * 1080];
        gVar.nMJ = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nMJ.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nMJ[i2] = i;
            d.a(gVar.nMH, gVar.nMI, i, aVar);
            i += 1080;
        }
    }
}
