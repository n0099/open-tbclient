package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nKC;
    private int[] nKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nKC = bArr;
        hVar.nKD = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nKD[i2] = (hVar.nKC[i2 * 4] & 255) | ((hVar.nKC[(i2 * 4) + 1] & 255) << 8) | ((hVar.nKC[(i2 * 4) + 2] & 255) << 16) | ((hVar.nKC[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
