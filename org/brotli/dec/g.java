package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class g {
    private int qpM;
    int[] qpN;
    int[] qpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qpM = i;
        gVar.qpN = new int[i2 * 1080];
        gVar.qpO = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qpO.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qpO[i] = i2;
            d.a(gVar.qpM, gVar.qpN, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
