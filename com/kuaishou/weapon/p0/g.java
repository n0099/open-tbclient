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
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774824, "Lcom/kuaishou/weapon/p0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774824, "Lcom/kuaishou/weapon/p0/g;");
                return;
            }
        }
        a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    public g() {
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
    public static String a(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) {
            if (b < 0) {
                b += 256;
            }
            return a[b / 16] + a[b % 16];
        }
        return (String) invokeB.objValue;
    }

    public static String a(File file) {
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
                        String b = b(messageDigest.digest());
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return b;
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String str2 = new String(str);
                try {
                    return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
                } catch (Throwable unused) {
                    return str2;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                stringBuffer.append(a(b));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
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

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return a(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return MessageDigest.getInstance("MD5").digest(bArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
