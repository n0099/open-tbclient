package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int oBn;
    int[] oBo;
    int[] oBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.oBn = i;
        gVar.oBo = new int[i2 * 1080];
        gVar.oBp = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.oBp.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.oBp[i2] = i;
            d.a(gVar.oBn, gVar.oBo, i, aVar);
            i += 1080;
        }
    }
}
