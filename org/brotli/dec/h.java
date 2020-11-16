package org.brotli.dec;
/* loaded from: classes8.dex */
final class h {
    private byte[] qcg;
    private int[] qch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.qcg = bArr;
        hVar.qch = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.qch[i2] = (hVar.qcg[i2 * 4] & 255) | ((hVar.qcg[(i2 * 4) + 1] & 255) << 8) | ((hVar.qcg[(i2 * 4) + 2] & 255) << 16) | ((hVar.qcg[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
