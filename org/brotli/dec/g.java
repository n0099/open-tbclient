package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g {
    private int oAV;
    int[] oAW;
    int[] oAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.oAV = i;
        gVar.oAW = new int[i2 * 1080];
        gVar.oAX = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.oAX.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.oAX[i2] = i;
            d.a(gVar.oAV, gVar.oAW, i, aVar);
            i += 1080;
        }
    }
}
