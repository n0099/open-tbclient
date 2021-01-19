package org.brotli.dec;
/* loaded from: classes4.dex */
final class h {
    private byte[] qkS;
    private int[] qkT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.qkS = bArr;
        hVar.qkT = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.qkT[i2] = (hVar.qkS[i2 * 4] & 255) | ((hVar.qkS[(i2 * 4) + 1] & 255) << 8) | ((hVar.qkS[(i2 * 4) + 2] & 255) << 16) | ((hVar.qkS[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
