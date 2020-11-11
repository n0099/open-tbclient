package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    private int qaV;
    int[] qaW;
    int[] qaX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qaV = i;
        gVar.qaW = new int[i2 * 1080];
        gVar.qaX = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qaX.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.qaX[i2] = i;
            d.a(gVar.qaV, gVar.qaW, i, aVar);
            i += 1080;
        }
    }
}
