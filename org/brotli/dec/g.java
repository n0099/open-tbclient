package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g {
    private int qwq;
    int[] qwr;
    int[] qws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qwq = i;
        gVar.qwr = new int[i2 * 1080];
        gVar.qws = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qws.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qws[i] = i2;
            d.a(gVar.qwq, gVar.qwr, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
