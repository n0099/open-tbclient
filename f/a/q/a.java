package f.a.q;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static char[] a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f61845b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-962710181, "Lf/a/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-962710181, "Lf/a/q/a;");
                return;
            }
        }
        a = new char[64];
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        f61845b = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f61845b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f61845b[a[i4]] = (byte) i4;
        }
    }

    public static char[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? b(bArr, bArr.length) : (char[]) invokeL.objValue;
    }

    public static char[] b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) {
            int i6 = ((i2 * 4) + 2) / 3;
            char[] cArr = new char[((i2 + 2) / 3) * 4];
            int i7 = 0;
            int i8 = 0;
            while (i7 < i2) {
                int i9 = i7 + 1;
                int i10 = bArr[i7] & 255;
                if (i9 < i2) {
                    i3 = i9 + 1;
                    i4 = bArr[i9] & 255;
                } else {
                    i3 = i9;
                    i4 = 0;
                }
                if (i3 < i2) {
                    i5 = bArr[i3] & 255;
                    i3++;
                } else {
                    i5 = 0;
                }
                int i11 = i10 >>> 2;
                int i12 = ((i10 & 3) << 4) | (i4 >>> 4);
                int i13 = ((i4 & 15) << 2) | (i5 >>> 6);
                int i14 = i5 & 63;
                int i15 = i8 + 1;
                char[] cArr2 = a;
                cArr[i8] = cArr2[i11];
                int i16 = i15 + 1;
                cArr[i15] = cArr2[i12];
                char c2 = com.alipay.sdk.encrypt.a.f31099h;
                cArr[i16] = i16 < i6 ? cArr2[i13] : com.alipay.sdk.encrypt.a.f31099h;
                int i17 = i16 + 1;
                if (i17 < i6) {
                    c2 = a[i14];
                }
                cArr[i17] = c2;
                i8 = i17 + 1;
                i7 = i3;
            }
            return cArr;
        }
        return (char[]) invokeLI.objValue;
    }
}
