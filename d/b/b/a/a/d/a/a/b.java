package d.b.b.a.a.d.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f42098b = k(new byte[]{Constants.SHORT_PING_CMD_TYPE, 120, 112, 97, 110, 100, 32, 51, 50, UtilsBlink.VER_TYPE_SEPARATOR, 98, 121, 116, Constants.SHORT_PING_CMD_TYPE, 32, 107});

    /* renamed from: a  reason: collision with root package name */
    public final int f42099a;

    public b(int i) {
        this.f42099a = i;
    }

    public static int b(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static void e(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            f(iArr, 0, 4, 8, 12);
            f(iArr, 1, 5, 9, 13);
            f(iArr, 2, 6, 10, 14);
            f(iArr, 3, 7, 11, 15);
            f(iArr, 0, 5, 10, 15);
            f(iArr, 1, 6, 11, 12);
            f(iArr, 2, 7, 8, 13);
            f(iArr, 3, 4, 9, 14);
        }
    }

    public static void f(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = b(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = b(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = b(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = b(iArr[i2] ^ iArr[i3], 7);
    }

    public static void g(int[] iArr, int[] iArr2) {
        int[] iArr3 = f42098b;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, f42098b.length, 8);
    }

    public static int[] k(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public int a() {
        return 12;
    }

    public ByteBuffer c(byte[] bArr, byte[] bArr2, int i) {
        int[] i2 = i(k(bArr), k(bArr2), i);
        int[] iArr = (int[]) i2.clone();
        e(iArr);
        for (int i3 = 0; i3 < i2.length; i3++) {
            i2[i3] = i2[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(i2, 0, 16);
        return order;
    }

    public final void d(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer2.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer c2 = c(bArr, bArr2, this.f42099a + i2);
            if (i2 == i - 1) {
                a.a(byteBuffer, byteBuffer2, c2, remaining % 64);
            } else {
                a.a(byteBuffer, byteBuffer2, c2, 64);
            }
        }
    }

    public byte[] h(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= a()) {
            byte[] bArr = new byte[a()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            d(bArr, d.a(), allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("data too short");
    }

    public int[] i(int[] iArr, int[] iArr2, int i) {
        if (iArr.length == a() / 4) {
            int[] iArr3 = new int[16];
            g(iArr3, iArr2);
            iArr3[12] = i;
            System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
            return iArr3;
        }
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
    }

    public byte[] j(byte[] bArr) {
        return h(ByteBuffer.wrap(bArr));
    }
}
