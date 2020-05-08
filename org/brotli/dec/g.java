package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int ngo;
    int[] ngp;
    int[] ngq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.ngo = i;
        gVar.ngp = new int[i2 * 1080];
        gVar.ngq = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.ngq.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.ngq[i2] = i;
            d.a(gVar.ngo, gVar.ngp, i, aVar);
            i += 1080;
        }
    }
}
