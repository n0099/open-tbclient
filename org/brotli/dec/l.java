package org.brotli.dec;
/* loaded from: classes7.dex */
final class l {
    private static final byte[] oCv = new byte[1024];
    private static final int[] oCw = new int[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(oCv, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(oCw, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
