package org.brotli.dec;
/* loaded from: classes4.dex */
final class l {
    private static final byte[] oif = new byte[1024];
    private static final int[] oig = new int[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(oif, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(oig, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
