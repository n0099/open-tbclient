package org.brotli.dec;
/* loaded from: classes6.dex */
final class h {
    private byte[] pRj;
    private int[] pRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.pRj = bArr;
        hVar.pRk = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.pRk[i2] = (hVar.pRj[i2 * 4] & 255) | ((hVar.pRj[(i2 * 4) + 1] & 255) << 8) | ((hVar.pRj[(i2 * 4) + 2] & 255) << 16) | ((hVar.pRj[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
