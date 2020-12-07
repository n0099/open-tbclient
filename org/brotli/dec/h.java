package org.brotli.dec;
/* loaded from: classes11.dex */
final class h {
    private byte[] pMg;
    private int[] pMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.pMg = bArr;
        hVar.pMh = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.pMh[i2] = (hVar.pMg[i2 * 4] & 255) | ((hVar.pMg[(i2 * 4) + 1] & 255) << 8) | ((hVar.pMg[(i2 * 4) + 2] & 255) << 16) | ((hVar.pMg[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
