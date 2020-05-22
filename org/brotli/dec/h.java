package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nAX;
    private int[] nAY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nAX = bArr;
        hVar.nAY = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nAY[i2] = (hVar.nAX[i2 * 4] & 255) | ((hVar.nAX[(i2 * 4) + 1] & 255) << 8) | ((hVar.nAX[(i2 * 4) + 2] & 255) << 16) | ((hVar.nAX[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
