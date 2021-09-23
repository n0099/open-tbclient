package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f69131a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-752059498, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-752059498, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/h;");
                return;
            }
        }
        f69131a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static void a(InputStream inputStream, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, inputStream, str) == null) {
            if (str != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    try {
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                messageDigest.update(bArr, 0, read);
                            }
                            try {
                                byte[] digest = messageDigest.digest();
                                String a2 = a(digest, 0, digest.length);
                                if (str.equals(a2)) {
                                    return;
                                }
                                throw new RuntimeException("md5 check failed file: local md5:" + a2 + " expect md5:" + str);
                            } catch (Exception e2) {
                                throw new RuntimeException("md5 check failed:" + e2.getMessage(), e2);
                            }
                        } catch (Exception e3) {
                            throw new RuntimeException("md5 check failed:" + e3.getMessage(), e3);
                        }
                    } finally {
                        b.a(inputStream);
                    }
                } catch (Exception e4) {
                    throw new RuntimeException("md5 check failed:" + e4.getMessage(), e4);
                }
            }
            throw new RuntimeException("md5 check failed: md5 == null");
        }
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i2 + i3 <= bArr.length) {
                    int i4 = i3 * 2;
                    char[] cArr = new char[i4];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = bArr[i6 + i2] & 255;
                        int i8 = i5 + 1;
                        char[] cArr2 = f69131a;
                        cArr[i5] = cArr2[i7 >> 4];
                        i5 = i8 + 1;
                        cArr[i8] = cArr2[i7 & 15];
                    }
                    return new String(cArr, 0, i4);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }
}
