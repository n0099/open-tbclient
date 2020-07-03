package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nYk;
    int[] nYl;
    int[] nYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nYk = i;
        gVar.nYl = new int[i2 * 1080];
        gVar.nYm = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nYm.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nYm[i2] = i;
            d.a(gVar.nYk, gVar.nYl, i, aVar);
            i += 1080;
        }
    }
}
