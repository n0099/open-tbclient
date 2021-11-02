package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f66730a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835043, "Lcom/kwad/sdk/utils/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835043, "Lcom/kwad/sdk/utils/w;");
                return;
            }
        }
        f66730a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @NonNull
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a(str.getBytes()) : (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                int length = digest.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = digest[i2];
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    if (i3 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i3));
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 < 0 || i2 + i3 > bArr.length) {
                    throw new IndexOutOfBoundsException();
                }
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = f66730a;
                    cArr[i5] = cArr2[i7 >> 4];
                    i5 = i8 + 1;
                    cArr[i8] = cArr2[i7 & 15];
                }
                return new String(cArr, 0, i4);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                return a(digest, 0, digest.length);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
