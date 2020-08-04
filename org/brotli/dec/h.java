package org.brotli.dec;
/* loaded from: classes4.dex */
final class h {
    private byte[] ogH;
    private int[] ogI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.ogH = bArr;
        hVar.ogI = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.ogI[i2] = (hVar.ogH[i2 * 4] & 255) | ((hVar.ogH[(i2 * 4) + 1] & 255) << 8) | ((hVar.ogH[(i2 * 4) + 2] & 255) << 16) | ((hVar.ogH[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
