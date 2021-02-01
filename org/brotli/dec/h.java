package org.brotli.dec;
/* loaded from: classes6.dex */
final class h {
    private byte[] quV;
    private int[] quW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.quV = bArr;
        hVar.quW = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.quW[i2] = (hVar.quV[i2 * 4] & 255) | ((hVar.quV[(i2 * 4) + 1] & 255) << 8) | ((hVar.quV[(i2 * 4) + 2] & 255) << 16) | ((hVar.quV[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
