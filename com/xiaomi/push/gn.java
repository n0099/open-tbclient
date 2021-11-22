package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes2.dex */
public class gn {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Random f71957a;

    /* renamed from: a  reason: collision with other field name */
    public static final char[] f444a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f71958b;

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f71959c;

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f71960d;

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f71961e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f71962f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373703, "Lcom/xiaomi/push/gn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373703, "Lcom/xiaomi/push/gn;");
                return;
            }
        }
        f444a = "&quot;".toCharArray();
        f71958b = "&apos;".toCharArray();
        f71959c = "&amp;".toCharArray();
        f71960d = "&lt;".toCharArray();
        f71961e = "&gt;".toCharArray();
        f71957a = new Random();
        f71962f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 < 1) {
                return null;
            }
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = f71962f[f71957a.nextInt(71)];
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
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char c2 = charArray[i2];
                if (c2 <= '>') {
                    if (c2 == '<') {
                        if (i2 > i3) {
                            sb.append(charArray, i3, i2 - i3);
                        }
                        i3 = i2 + 1;
                        sb.append(f71960d);
                    } else if (c2 == '>') {
                        if (i2 > i3) {
                            sb.append(charArray, i3, i2 - i3);
                        }
                        i3 = i2 + 1;
                        sb.append(f71961e);
                    } else if (c2 == '&') {
                        if (i2 > i3) {
                            sb.append(charArray, i3, i2 - i3);
                        }
                        int i4 = i2 + 5;
                        if (length <= i4 || charArray[i2 + 1] != '#' || !Character.isDigit(charArray[i2 + 2]) || !Character.isDigit(charArray[i2 + 3]) || !Character.isDigit(charArray[i2 + 4]) || charArray[i4] != ';') {
                            i3 = i2 + 1;
                            sb.append(f71959c);
                        }
                    } else if (c2 == '\"') {
                        if (i2 > i3) {
                            sb.append(charArray, i3, i2 - i3);
                        }
                        i3 = i2 + 1;
                        sb.append(f444a);
                    } else if (c2 == '\'') {
                        if (i2 > i3) {
                            sb.append(charArray, i3, i2 - i3);
                        }
                        i3 = i2 + 1;
                        sb.append(f71958b);
                    }
                }
                i2++;
            }
            if (i3 == 0) {
                return str;
            }
            if (i2 > i3) {
                sb.append(charArray, i3, i2 - i3);
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
        int i2 = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i2);
            if (indexOf2 <= 0) {
                sb.append(charArray, i2, charArray.length - i2);
                return sb.toString();
            }
            sb.append(charArray, i2, indexOf2 - i2);
            sb.append(charArray2);
            i2 = indexOf2 + length;
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? String.valueOf(bj.a(bArr)) : (String) invokeL.objValue;
    }

    public static final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&") : (String) invokeL.objValue;
    }
}
