package org.brotli.dec;
/* loaded from: classes7.dex */
final class h {
    private byte[] nCh;
    private int[] nCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nCh = bArr;
        hVar.nCi = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.nCi[i2] = (hVar.nCh[i2 * 4] & 255) | ((hVar.nCh[(i2 * 4) + 1] & 255) << 8) | ((hVar.nCh[(i2 * 4) + 2] & 255) << 16) | ((hVar.nCh[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
