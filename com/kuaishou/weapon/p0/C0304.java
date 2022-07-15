package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* renamed from: com.kuaishou.weapon.p0.ʻˏ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public final class C0304 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String[] f40;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335181283, "Lcom/kuaishou/weapon/p0/ʻˏ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335181283, "Lcom/kuaishou/weapon/p0/ʻˏ;");
                return;
            }
        }
        f40 = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    public C0304() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m172(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) {
            if (b < 0) {
                b += 256;
            }
            return f40[b / 16] + f40[b % 16];
        }
        return (String) invokeB.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m173(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file != null && file.exists()) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        String m176 = m176(messageDigest.digest());
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return m176;
                    } catch (Throwable unused2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        return null;
                    }
                } catch (Throwable unused4) {
                    fileInputStream = null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m174(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String str2 = new String(str);
                try {
                    return m175(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
                } catch (Throwable unused) {
                    return str2;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m175(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                stringBuffer.append(m172(b));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m176(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                int i2 = i * 2;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                cArr2[i2 + 1] = cArr[b & 15];
            }
            return new String(cArr2);
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m177(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return m175(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
