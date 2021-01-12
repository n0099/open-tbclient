package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class g {
    private int qlk;
    int[] qll;
    int[] qlm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qlk = i;
        gVar.qll = new int[i2 * 1080];
        gVar.qlm = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qlm.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qlm[i] = i2;
            d.a(gVar.qlk, gVar.qll, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
