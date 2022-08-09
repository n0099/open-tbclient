package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.net.WebAddress;
import com.facebook.common.internal.Sets;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes7.dex */
public class w93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public static final int c;
    public static final Set<String> d;
    public static final String[] e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755246592, "Lcom/repackage/w93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755246592, "Lcom/repackage/w93;");
                return;
            }
        }
        a = jh1.a;
        b = 6;
        c = 8;
        d = Sets.newHashSet("https", "http", "wss");
        String[] strArr = {"ac", "co", "com", Config.EVENT_PATH_MAPPING, "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        e = strArr;
        Arrays.sort(strArr);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : d) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(Collection<u93> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, str)) == null) {
            if (collection == null || collection.isEmpty()) {
                return str;
            }
            String trim = str == null ? "" : str.trim();
            int length = trim.length();
            if (!TextUtils.isEmpty(trim)) {
                int i = length - 1;
                if (trim.charAt(i) == ';') {
                    trim = trim.substring(0, i);
                }
            }
            StringBuilder sb = new StringBuilder(trim);
            for (u93 u93Var : collection) {
                if (u93Var != null) {
                    if (sb.length() > 0) {
                        sb.append(WebvttCueParser.CHAR_SEMI_COLON);
                        sb.append(WebvttCueParser.CHAR_SPACE);
                    }
                    sb.append(u93Var.c);
                    if (u93Var.d != null) {
                        sb.append('=');
                        sb.append(u93Var.d);
                    }
                }
            }
            return TextUtils.isEmpty(sb) ? str : sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static int c(@NonNull String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, str, i, i2)) == null) {
            int indexOf = str.indexOf(59, i);
            int indexOf2 = str.indexOf(44, i);
            return (indexOf == -1 && indexOf2 == -1) ? i2 : indexOf == -1 ? indexOf2 : indexOf2 == -1 ? indexOf : Math.min(indexOf, indexOf2);
        }
        return invokeLII.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int i = 0;
            int indexOf = str.indexOf(46);
            int lastIndexOf = str.lastIndexOf(46);
            while (indexOf < lastIndexOf) {
                i = indexOf + 1;
                indexOf = str.indexOf(46, i);
            }
            return i > 0 ? str.substring(i) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String[] e(WebAddress webAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, webAddress)) == null) {
            if (webAddress == null || TextUtils.isEmpty(webAddress.getHost()) || TextUtils.isEmpty(webAddress.getPath()) || ca3.b(webAddress.getHost())) {
                return null;
            }
            String[] strArr = {webAddress.getHost().toLowerCase(), webAddress.getPath()};
            int indexOf = strArr[0].indexOf(46);
            if (indexOf == -1) {
                return null;
            }
            if (indexOf == strArr[0].lastIndexOf(46)) {
                strArr[0] = IStringUtil.EXTENSION_SEPARATOR + strArr[0];
            }
            if (strArr[1].charAt(0) != '/') {
                return null;
            }
            int indexOf2 = strArr[1].indexOf(63);
            if (indexOf2 != -1) {
                strArr[1] = strArr[1].substring(0, indexOf2);
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public static int f(u93 u93Var, String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{u93Var, str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            if (u93Var == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return i2;
            }
            while (i >= 0 && i < i2) {
                if (str.charAt(i) == ' ' || str.charAt(i) == ';') {
                    i++;
                } else if (str.charAt(i) == ',') {
                    return i + 1;
                } else {
                    int i3 = i2 - i;
                    int i4 = b;
                    if (i3 >= i4 && str.substring(i, i4 + i).equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        int i5 = b + i;
                        if (i5 == i2) {
                            u93Var.f = true;
                            return i5;
                        } else if (str.charAt(i5) == ';' || str.charAt(i5) == '=' || str.charAt(i5) == ',') {
                            u93Var.f = true;
                            i = c(str, i5, i2);
                        }
                    }
                    int i6 = c;
                    if (i3 >= i6 && str.substring(i, i6 + i).equalsIgnoreCase("httponly")) {
                        int i7 = c + i;
                        if (i7 == i2) {
                            return i7;
                        }
                        if (str.charAt(i7) == ';' || str.charAt(i7) == '=' || str.charAt(i7) == ',') {
                            i = c(str, i7, i2);
                        }
                    }
                    int indexOf2 = str.indexOf(61, i);
                    if (indexOf2 <= 0) {
                        return i2;
                    }
                    String lowerCase = str.substring(i, indexOf2).toLowerCase();
                    i = c(str, n(str, lowerCase, i, indexOf2), i2);
                    if (i >= indexOf2) {
                        String substring = str.substring(indexOf2 + 1, i);
                        if (substring.length() > 2 && substring.charAt(0) == '\"' && (indexOf = substring.indexOf(34, 1)) > 0) {
                            substring = substring.substring(1, indexOf);
                        }
                        i(u93Var, lowerCase, substring, str2);
                    }
                }
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static ArrayList<u93> g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            if (a) {
                Log.d("SwanCookieParser", "parseCookie: host=" + str + "; path=" + str2 + "; cookieString=" + str3);
            }
            ArrayList<u93> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                int i = 0;
                int length = str3.length();
                while (i >= 0 && i < length) {
                    if (str3.charAt(i) == ' ') {
                        i++;
                    } else {
                        u93 u93Var = new u93(str, str2);
                        i = f(u93Var, str3, h(u93Var, str3, i, length), length, str);
                        if (!TextUtils.isEmpty(u93Var.a) && !TextUtils.isEmpty(u93Var.c) && u93Var.d != null) {
                            arrayList.add(u93Var);
                            if (a) {
                                Log.d("SwanCookieParser", "parseCookies result: " + u93Var.toString());
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static int h(u93 u93Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, u93Var, str, i, i2)) == null) {
            if (u93Var != null && !TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf(59, i);
                int indexOf2 = str.indexOf(61, i);
                if (indexOf > indexOf2 && indexOf2 != -1) {
                    u93Var.c = str.substring(i, indexOf2);
                    int i3 = indexOf2 + 1;
                    if (str.charAt(i3) == '\"' && (i = str.indexOf(34, indexOf2 + 2)) == -1) {
                        u93Var.a = null;
                        return i2;
                    }
                    int indexOf3 = str.indexOf(59, i);
                    if (indexOf3 != -1) {
                        i2 = indexOf3;
                    }
                    if (i3 != i2 && i2 >= indexOf2) {
                        u93Var.d = str.substring(i3, i2);
                    } else {
                        u93Var.d = "";
                    }
                    return i2;
                }
                if (indexOf != -1) {
                    i2 = indexOf;
                }
                u93Var.c = str.substring(i, i2);
                u93Var.d = null;
            }
            return i2;
        }
        return invokeLLII.intValue;
    }

    public static void i(u93 u93Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65545, null, u93Var, str, str2, str3) == null) || u93Var == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1326197564:
                if (str.equals("domain")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1309235404:
                if (str.equals("expires")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3433509:
                if (str.equals("path")) {
                    c2 = 2;
                    break;
                }
                break;
            case 842940694:
                if (str.equals(ClientCookie.MAX_AGE_ATTR)) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            k(u93Var, str2);
        } else if (c2 == 1) {
            l(u93Var, str2);
        } else if (c2 == 2) {
            m(u93Var, str2);
        } else if (c2 != 3) {
        } else {
            j(u93Var, str2, str3);
        }
    }

    public static void j(@NonNull u93 u93Var, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, u93Var, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0) {
            u93Var.a = null;
            return;
        }
        if (ca3.b(str.startsWith(".") ? str.substring(1) : str)) {
            u93Var.a = null;
            return;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.charAt(0) != '.') {
            lowerCase = IStringUtil.EXTENSION_SEPARATOR + lowerCase;
            lastIndexOf++;
        }
        if (!str2.endsWith(lowerCase.substring(1))) {
            u93Var.a = null;
            return;
        }
        int length = lowerCase.length();
        int length2 = str2.length();
        if (length2 > length - 1 && str2.charAt(length2 - length) != '.') {
            u93Var.a = null;
            return;
        }
        if (length == lastIndexOf + 3 && length >= 6 && length <= 8) {
            if (Arrays.binarySearch(e, lowerCase.substring(1, lastIndexOf)) >= 0) {
                u93Var.a = null;
                return;
            }
        }
        u93Var.a = lowerCase;
    }

    public static void k(@NonNull u93 u93Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, u93Var, str) == null) {
            if (a) {
                Log.d("SwanCookieParser", "setExpires value: " + str);
            }
            if (u93Var.e != -1) {
                return;
            }
            long e2 = ba3.e(str);
            if (a) {
                Log.d("SwanCookieParser", "setExpires result: " + e2);
            }
            if (e2 != -1) {
                u93Var.e = e2;
            }
        }
    }

    public static void l(@NonNull u93 u93Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, u93Var, str) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                long parseLong = Long.parseLong(str);
                Long.signum(parseLong);
                u93Var.e = currentTimeMillis + (parseLong * 1000);
            } catch (NumberFormatException unused) {
                if (a) {
                    Log.e("SwanCookieParser", "illegal max-age: " + str);
                }
            }
        }
    }

    public static void m(@NonNull u93 u93Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, u93Var, str) == null) && !TextUtils.isEmpty(str) && str.charAt(0) == '/') {
            u93Var.b = str;
        }
    }

    public static int n(@NonNull String str, String str2, int i, int i2) {
        InterceptResult invokeLLII;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i, i2)) == null) ? (TextUtils.equals("expires", str2) && (indexOf = str.indexOf(44, i2)) != -1 && indexOf - i2 <= 10) ? indexOf + 1 : i : invokeLLII.intValue;
    }
}
