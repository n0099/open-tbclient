package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nfT;
    private int[] nfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nfT = bArr;
        hVar.nfU = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nfU[i2] = (hVar.nfT[i2 * 4] & 255) | ((hVar.nfT[(i2 * 4) + 1] & 255) << 8) | ((hVar.nfT[(i2 * 4) + 2] & 255) << 16) | ((hVar.nfT[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
