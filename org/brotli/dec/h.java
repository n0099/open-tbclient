package org.brotli.dec;
/* loaded from: classes6.dex */
final class h {
    private byte[] qvv;
    private int[] qvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.qvv = bArr;
        hVar.qvw = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.qvw[i2] = (hVar.qvv[i2 * 4] & 255) | ((hVar.qvv[(i2 * 4) + 1] & 255) << 8) | ((hVar.qvv[(i2 * 4) + 2] & 255) << 16) | ((hVar.qvv[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
