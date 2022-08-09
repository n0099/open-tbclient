package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes8.dex */
public class gy {
    public static /* synthetic */ Interceptable $ic;
    public static Random a;

    /* renamed from: a  reason: collision with other field name */
    public static final char[] f450a;
    public static final char[] b;
    public static final char[] c;
    public static final char[] d;
    public static final char[] e;
    public static char[] f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373362, "Lcom/xiaomi/push/gy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373362, "Lcom/xiaomi/push/gy;");
                return;
            }
        }
        f450a = "&quot;".toCharArray();
        b = "&apos;".toCharArray();
        c = "&amp;".toCharArray();
        d = "&lt;".toCharArray();
        e = "&gt;".toCharArray();
        a = new Random();
        f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i < 1) {
                return null;
            }
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = f[a.nextInt(71)];
            }
            return new String(cArr);
        }
        return (String) invokeI.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            StringBuilder sb = new StringBuilder((int) (length * 1.3d));
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char c2 = charArray[i];
                if (c2 <= '>') {
                    if (c2 == '<') {
                        if (i > i2) {
                            sb.append(charArray, i2, i - i2);
                        }
                        i2 = i + 1;
                        sb.append(d);
                    } else if (c2 == '>') {
                        if (i > i2) {
                            sb.append(charArray, i2, i - i2);
                        }
                        i2 = i + 1;
                        sb.append(e);
                    } else if (c2 == '&') {
                        if (i > i2) {
                            sb.append(charArray, i2, i - i2);
                        }
                        int i3 = i + 5;
                        if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                            i2 = i + 1;
                            sb.append(c);
                        }
                    } else if (c2 == '\"') {
                        if (i > i2) {
                            sb.append(charArray, i2, i - i2);
                        }
                        i2 = i + 1;
                        sb.append(f450a);
                    } else if (c2 == '\'') {
                        if (i > i2) {
                            sb.append(charArray, i2, i - i2);
                        }
                        i2 = i + 1;
                        sb.append(b);
                    }
                }
                i++;
            }
            if (i2 == 0) {
                return str;
            }
            if (i > i2) {
                sb.append(charArray, i2, i - i2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) != null) {
            return (String) invokeLLL.objValue;
        }
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf);
        sb.append(charArray2);
        int i = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i);
            if (indexOf2 <= 0) {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
            sb.append(charArray, i, indexOf2 - i);
            sb.append(charArray2);
            i = indexOf2 + length;
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? String.valueOf(bm.a(bArr)) : (String) invokeL.objValue;
    }

    public static final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&") : (String) invokeL.objValue;
    }
}
