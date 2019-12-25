package org.brotli.dec;
/* loaded from: classes4.dex */
final class h {
    private byte[] nav;
    private int[] naw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, byte[] bArr, int[] iArr) {
        hVar.nav = bArr;
        hVar.naw = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hVar.naw[i2] = (hVar.nav[i2 * 4] & 255) | ((hVar.nav[(i2 * 4) + 1] & 255) << 8) | ((hVar.nav[(i2 * 4) + 2] & 255) << 16) | ((hVar.nav[(i2 * 4) + 3] & 255) << 24);
        }
    }
}
