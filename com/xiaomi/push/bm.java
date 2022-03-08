package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class bm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < i2; i3++) {
                stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
            }
            return stringBuffer.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(m245a(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            if (i2 <= 0 || length < i2) {
                i2 = length / 3;
                if (i2 <= 1) {
                    i2 = 1;
                }
                if (i2 > 3) {
                    i2 = 3;
                }
            }
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 % i2 == 0) {
                    sb.append("*");
                } else {
                    sb.append(str.charAt(i3));
                }
                i3 = i4;
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static String a(Collection<?> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, collection, str)) == null) {
            if (collection == null) {
                return null;
            }
            return a(collection.iterator(), str);
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:23:0x003b -> B:17:0x0029 */
    public static String a(Iterator<?> it, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, it, str)) == null) {
            if (it == null) {
                return null;
            }
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    StringBuffer stringBuffer = new StringBuffer(256);
                    if (next != null) {
                        stringBuffer.append(next);
                    }
                    while (it.hasNext()) {
                        if (str != null) {
                            stringBuffer.append(str);
                        }
                        Object next2 = it.next();
                        if (next2 != null) {
                            stringBuffer.append(next2);
                        }
                    }
                    return stringBuffer.toString();
                }
                return next.toString();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Object[] objArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, objArr, str)) == null) {
            if (objArr == null) {
                return null;
            }
            return a(objArr, str, 0, objArr.length);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Object[] objArr, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, objArr, str, i2, i3)) == null) {
            if (objArr == null) {
                return null;
            }
            if (str == null) {
                str = "";
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(i4 * ((objArr[i2] == null ? 16 : objArr[i2].toString().length()) + str.length()));
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    stringBuffer.append(str);
                }
                if (objArr[i5] != null) {
                    stringBuffer.append(objArr[i5]);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeLLII.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m244a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str != null) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt < 0 || charAt > 127) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m245a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str.getBytes();
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(m245a(str));
                    return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
                } catch (NoSuchAlgorithmException unused) {
                    return str;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m246b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char charAt = str.charAt(0);
            for (int i2 = 1; i2 < str.length(); i2++) {
                if (str.charAt(i2) != charAt) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
