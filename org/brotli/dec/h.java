package org.brotli.dec;
/* loaded from: classes3.dex */
final class h {
    private byte[] qnL;
    private int[] qnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.qnL = bArr;
        hVar.qnM = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.qnM[i2] = (hVar.qnL[i2 * 4] & 255) | ((hVar.qnL[(i2 * 4) + 1] & 255) << 8) | ((hVar.qnL[(i2 * 4) + 2] & 255) << 16) | ((hVar.qnL[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
