package org.brotli.dec;
/* loaded from: classes5.dex */
final class h {
    private byte[] nJA;
    private int[] nJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nJA = bArr;
        hVar.nJB = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nJB[i2] = (hVar.nJA[i2 * 4] & 255) | ((hVar.nJA[(i2 * 4) + 1] & 255) << 8) | ((hVar.nJA[(i2 * 4) + 2] & 255) << 16) | ((hVar.nJA[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
