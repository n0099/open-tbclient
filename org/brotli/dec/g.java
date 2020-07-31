package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class g {
    private int ogX;
    int[] ogY;
    int[] ogZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.ogX = i;
        gVar.ogY = new int[i2 * 1080];
        gVar.ogZ = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.ogZ.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.ogZ[i2] = i;
            d.a(gVar.ogX, gVar.ogY, i, aVar);
            i += 1080;
        }
    }
}
