package org.brotli.dec;
/* loaded from: classes4.dex */
final class h {
    private byte[] ogF;
    private int[] ogG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.ogF = bArr;
        hVar.ogG = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.ogG[i2] = (hVar.ogF[i2 * 4] & 255) | ((hVar.ogF[(i2 * 4) + 1] & 255) << 8) | ((hVar.ogF[(i2 * 4) + 2] & 255) << 16) | ((hVar.ogF[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
