package org.brotli.dec;
/* loaded from: classes5.dex */
final class l {
    private static final byte[] qqU = new byte[1024];
    private static final int[] qqV = new int[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(qqU, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(qqV, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
