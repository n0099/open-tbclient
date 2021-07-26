package d.a.s.g.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f67908a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f67909b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f67910c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(356517085, "Ld/a/s/g/c/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(356517085, "Ld/a/s/g/c/a/a;");
                return;
            }
        }
        f67908a = "0123456789ABCDEF".toCharArray();
        f67909b = "0123456789abcdef".toCharArray();
        f67910c = new byte[128];
        for (int i2 = 0; i2 < 10; i2++) {
            byte[] bArr = f67910c;
            bArr[i2 + 48] = (byte) i2;
            byte b2 = (byte) (i2 + 10);
            bArr[i2 + 65] = b2;
            bArr[i2 + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, bArr, z)) == null) {
            char[] cArr = z ? f67908a : f67909b;
            char[] cArr2 = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 & 240) >>> 4];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return cArr2;
        }
        return (char[]) invokeLZ.objValue;
    }

    public static String b(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) ? new String(a(bArr, z)) : (String) invokeLZ.objValue;
    }
}
