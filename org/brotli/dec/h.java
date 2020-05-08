package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nfW;
    private int[] nfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nfW = bArr;
        hVar.nfX = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nfX[i2] = (hVar.nfW[i2 * 4] & 255) | ((hVar.nfW[(i2 * 4) + 1] & 255) << 8) | ((hVar.nfW[(i2 * 4) + 2] & 255) << 16) | ((hVar.nfW[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
