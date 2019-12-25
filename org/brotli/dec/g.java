package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class g {
    private int naN;
    int[] naO;
    int[] naP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.naN = i;
        gVar.naO = new int[i2 * 1080];
        gVar.naP = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.naP.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.naP[i2] = i;
            d.a(gVar.naN, gVar.naO, i, aVar);
            i += 1080;
        }
    }
}
