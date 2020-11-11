package org.brotli.dec;
/* loaded from: classes6.dex */
final class h {
    private byte[] qaD;
    private int[] qaE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.qaD = bArr;
        hVar.qaE = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.qaE[i2] = (hVar.qaD[i2 * 4] & 255) | ((hVar.qaD[(i2 * 4) + 1] & 255) << 8) | ((hVar.qaD[(i2 * 4) + 2] & 255) << 16) | ((hVar.qaD[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
