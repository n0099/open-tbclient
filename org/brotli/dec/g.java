package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class g {
    private int ogZ;
    int[] oha;
    int[] ohb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.ogZ = i;
        gVar.oha = new int[i2 * 1080];
        gVar.ohb = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.ohb.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.ohb[i2] = i;
            d.a(gVar.ogZ, gVar.oha, i, aVar);
            i += 1080;
        }
    }
}
