package org.brotli.dec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    private int qvo;
    int[] qvp;
    int[] qvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, int i, int i2) {
        gVar.qvo = i;
        gVar.qvp = new int[i2 * 1080];
        gVar.qvq = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, a aVar) {
        int length = gVar.qvq.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gVar.qvq[i] = i2;
            d.a(gVar.qvo, gVar.qvp, i2, aVar);
            i++;
            i2 += 1080;
        }
    }
}
