package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    private int qvO;
    int[] qvP;
    int[] qvQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qvO = i;
        gVar.qvP = new int[i2 * 1080];
        gVar.qvQ = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qvQ.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qvQ[i] = i2;
            d.a(gVar.qvO, gVar.qvP, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
