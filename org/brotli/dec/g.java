package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int ngl;
    int[] ngm;
    int[] ngn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.ngl = i;
        gVar.ngm = new int[i2 * 1080];
        gVar.ngn = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.ngn.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.ngn[i2] = i;
            d.a(gVar.ngl, gVar.ngm, i, aVar);
            i += 1080;
        }
    }
}
