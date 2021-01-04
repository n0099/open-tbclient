package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g {
    private int qoe;
    int[] qof;
    int[] qog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qoe = i;
        gVar.qof = new int[i2 * 1080];
        gVar.qog = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qog.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qog[i] = i2;
            d.a(gVar.qoe, gVar.qof, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
