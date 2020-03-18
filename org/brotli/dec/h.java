package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nMp;
    private int[] nMq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nMp = bArr;
        hVar.nMq = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nMq[i2] = (hVar.nMp[i2 * 4] & 255) | ((hVar.nMp[(i2 * 4) + 1] & 255) << 8) | ((hVar.nMp[(i2 * 4) + 2] & 255) << 16) | ((hVar.nMp[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
