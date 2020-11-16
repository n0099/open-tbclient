package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class g {
    int[] qcA;
    private int qcy;
    int[] qcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qcy = i;
        gVar.qcz = new int[i2 * 1080];
        gVar.qcA = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qcA.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.qcA[i2] = i;
            d.a(gVar.qcy, gVar.qcz, i, aVar);
            i += 1080;
        }
    }
}
