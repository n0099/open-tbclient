package org.brotli.dec;
/* loaded from: classes6.dex */
final class l {
    private static final byte[] qcd = new byte[1024];
    private static final int[] qce = new int[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(qcd, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(qce, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
