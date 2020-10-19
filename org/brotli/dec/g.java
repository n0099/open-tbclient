package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    private int pah;
    int[] pai;
    int[] paj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.pah = i;
        gVar.pai = new int[i2 * 1080];
        gVar.paj = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.paj.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.paj[i2] = i;
            d.a(gVar.pah, gVar.pai, i, aVar);
            i += 1080;
        }
    }
}
