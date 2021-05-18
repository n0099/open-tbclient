package d.a.q.g.b.d.a;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f64333a = new SecureRandom();

    public static int a(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) >> 3;
    }

    public static BigInteger b(byte[] bArr, BigInteger bigInteger) {
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bigInteger2.compareTo(bigInteger) < 0) {
            return bigInteger2;
        }
        throw new BadPaddingException("Message is larger than modulus");
    }

    public static byte[] c(BigInteger bigInteger, int i2) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (length == i2) {
            return byteArray;
        }
        if (length == i2 + 1 && byteArray[0] == 0) {
            byte[] bArr = new byte[i2];
            System.arraycopy(byteArray, 1, bArr, 0, i2);
            return bArr;
        } else if (length >= i2) {
            return null;
        } else {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(byteArray, 0, bArr2, i2 - length, length);
            return bArr2;
        }
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        if (i2 == 0 && i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static byte[] e(byte[] bArr, d.a.q.g.b.e.a aVar) {
        return f(bArr, aVar.b(), aVar.a());
    }

    public static byte[] f(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        return c(b(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger));
    }
}
