package javassist.bytecode;
/* loaded from: classes.dex */
public class g {
    public static int a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i] << 8) | (bArr[i + 1] & 255);
    }

    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    public static void b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, int i, byte[] bArr2, int i2) {
        bArr2[i2] = bArr[i];
        bArr2[i2 + 1] = bArr[i + 1];
        bArr2[i2 + 2] = bArr[i + 2];
        bArr2[i2 + 3] = bArr[i + 3];
    }
}
