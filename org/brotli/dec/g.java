package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int nYn;
    int[] nYo;
    int[] nYp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.nYn = i;
        gVar.nYo = new int[i2 * 1080];
        gVar.nYp = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.nYp.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.nYp[i2] = i;
            d.a(gVar.nYn, gVar.nYo, i, aVar);
            i += 1080;
        }
    }
}
