package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class g {
    private int nJS;
    int[] nJT;
    int[] nJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nJS = i;
        gVar.nJT = new int[i2 * 1080];
        gVar.nJU = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nJU.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nJU[i2] = i;
            d.a(gVar.nJS, gVar.nJT, i, aVar);
            i += 1080;
        }
    }
}
