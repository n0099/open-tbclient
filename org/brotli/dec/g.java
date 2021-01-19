package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class g {
    private int qll;
    int[] qlm;
    int[] qln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qll = i;
        gVar.qlm = new int[i2 * 1080];
        gVar.qln = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qln.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qln[i] = i2;
            d.a(gVar.qll, gVar.qlm, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
