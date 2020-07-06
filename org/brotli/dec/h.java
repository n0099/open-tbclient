package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nXV;
    private int[] nXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nXV = bArr;
        hVar.nXW = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nXW[i2] = (hVar.nXV[i2 * 4] & 255) | ((hVar.nXV[(i2 * 4) + 1] & 255) << 8) | ((hVar.nXV[(i2 * 4) + 2] & 255) << 16) | ((hVar.nXV[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
