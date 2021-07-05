package d.a.q0.a.l2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.net.WebAddress;
import com.facebook.common.internal.Sets;
import d.a.q0.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49331a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f49332b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f49333c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f49334d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f49335e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(120688584, "Ld/a/q0/a/l2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(120688584, "Ld/a/q0/a/l2/c;");
                return;
            }
        }
        f49331a = k.f49133a;
        f49332b = 6;
        f49333c = 8;
        f49334d = Sets.newHashSet("https", "http", "wss");
        String[] strArr = {"ac", "co", "com", Config.EVENT_PATH_MAPPING, "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f49335e = strArr;
        Arrays.sort(strArr);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : f49334d) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(Collection<a> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, str)) == null) {
            if (collection == null || collection.isEmpty()) {
                return str;
            }
            String trim = str == null ? "" : str.trim();
            int length = trim.length();
            if (!TextUtils.isEmpty(trim)) {
                int i2 = length - 1;
                if (trim.charAt(i2) == ';') {
                    trim = trim.substring(0, i2);
                }
            }
            StringBuilder sb = new StringBuilder(trim);
            for (a aVar : collection) {
                if (aVar != null) {
                    if (sb.length() > 0) {
                        sb.append(';');
                        sb.append(' ');
                    }
                    sb.append(aVar.f49315c);
                    if (aVar.f49316d != null) {
                        sb.append(com.alipay.sdk.encrypt.a.f1889h);
                        sb.append(aVar.f49316d);
                    }
                }
            }
            return TextUtils.isEmpty(sb) ? str : sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static int c(@NonNull String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, str, i2, i3)) == null) {
            int indexOf = str.indexOf(59, i2);
            int indexOf2 = str.indexOf(44, i2);
            return (indexOf == -1 && indexOf2 == -1) ? i3 : indexOf == -1 ? indexOf2 : indexOf2 == -1 ? indexOf : Math.min(indexOf, indexOf2);
        }
        return invokeLII.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int i2 = 0;
            int indexOf = str.indexOf(46);
            int lastIndexOf = str.lastIndexOf(46);
            while (indexOf < lastIndexOf) {
                i2 = indexOf + 1;
                indexOf = str.indexOf(46, i2);
            }
            return i2 > 0 ? str.substring(i2) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String[] e(WebAddress webAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, webAddress)) == null) {
            if (webAddress == null || TextUtils.isEmpty(webAddress.getHost()) || TextUtils.isEmpty(webAddress.getPath()) || d.a.q0.a.l2.f.b.b(webAddress.getHost())) {
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

    public static int f(a aVar, String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{aVar, str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            if (aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return i3;
            }
            while (i2 >= 0 && i2 < i3) {
                if (str.charAt(i2) == ' ' || str.charAt(i2) == ';') {
                    i2++;
                } else if (str.charAt(i2) == ',') {
                    return i2 + 1;
                } else {
                    int i4 = i3 - i2;
                    int i5 = f49332b;
                    if (i4 >= i5 && str.substring(i2, i5 + i2).equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        int i6 = f49332b + i2;
                        if (i6 == i3) {
                            aVar.f49318f = true;
                            return i6;
                        } else if (str.charAt(i6) == ';' || str.charAt(i6) == '=' || str.charAt(i6) == ',') {
                            aVar.f49318f = true;
                            i2 = c(str, i6, i3);
                        }
                    }
                    int i7 = f49333c;
                    if (i4 >= i7 && str.substring(i2, i7 + i2).equalsIgnoreCase("httponly")) {
                        int i8 = f49333c + i2;
                        if (i8 == i3) {
                            return i8;
                        }
                        if (str.charAt(i8) == ';' || str.charAt(i8) == '=' || str.charAt(i8) == ',') {
                            i2 = c(str, i8, i3);
                        }
                    }
                    int indexOf2 = str.indexOf(61, i2);
                    if (indexOf2 <= 0) {
                        return i3;
                    }
                    String lowerCase = str.substring(i2, indexOf2).toLowerCase();
                    i2 = c(str, n(str, lowerCase, i2, indexOf2), i3);
                    if (i2 >= indexOf2) {
                        String substring = str.substring(indexOf2 + 1, i2);
                        if (substring.length() > 2 && substring.charAt(0) == '\"' && (indexOf = substring.indexOf(34, 1)) > 0) {
                            substring = substring.substring(1, indexOf);
                        }
                        i(aVar, lowerCase, substring, str2);
                    }
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static ArrayList<a> g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            if (f49331a) {
                Log.d("SwanCookieParser", "parseCookie: host=" + str + "; path=" + str2 + "; cookieString=" + str3);
            }
            ArrayList<a> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                int i2 = 0;
                int length = str3.length();
                while (i2 >= 0 && i2 < length) {
                    if (str3.charAt(i2) == ' ') {
                        i2++;
                    } else {
                        a aVar = new a(str, str2);
                        i2 = f(aVar, str3, h(aVar, str3, i2, length), length, str);
                        if (!TextUtils.isEmpty(aVar.f49313a) && !TextUtils.isEmpty(aVar.f49315c) && aVar.f49316d != null) {
                            arrayList.add(aVar);
                            if (f49331a) {
                                Log.d("SwanCookieParser", "parseCookies result: " + aVar.toString());
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static int h(a aVar, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, aVar, str, i2, i3)) == null) {
            if (aVar != null && !TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf(59, i2);
                int indexOf2 = str.indexOf(61, i2);
                if (indexOf > indexOf2 && indexOf2 != -1) {
                    aVar.f49315c = str.substring(i2, indexOf2);
                    int i4 = indexOf2 + 1;
                    if (str.charAt(i4) == '\"' && (i2 = str.indexOf(34, indexOf2 + 2)) == -1) {
                        aVar.f49313a = null;
                        return i3;
                    }
                    int indexOf3 = str.indexOf(59, i2);
                    if (indexOf3 != -1) {
                        i3 = indexOf3;
                    }
                    if (i4 != i3 && i3 >= indexOf2) {
                        aVar.f49316d = str.substring(i4, i3);
                    } else {
                        aVar.f49316d = "";
                    }
                    return i3;
                }
                if (indexOf != -1) {
                    i3 = indexOf;
                }
                aVar.f49315c = str.substring(i2, i3);
                aVar.f49316d = null;
            }
            return i3;
        }
        return invokeLLII.intValue;
    }

    public static void i(a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65545, null, aVar, str, str2, str3) == null) || aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
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
            k(aVar, str2);
        } else if (c2 == 1) {
            l(aVar, str2);
        } else if (c2 == 2) {
            m(aVar, str2);
        } else if (c2 != 3) {
        } else {
            j(aVar, str2, str3);
        }
    }

    public static void j(@NonNull a aVar, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, aVar, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0) {
            aVar.f49313a = null;
            return;
        }
        if (d.a.q0.a.l2.f.b.b(str.startsWith(".") ? str.substring(1) : str)) {
            aVar.f49313a = null;
            return;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.charAt(0) != '.') {
            lowerCase = IStringUtil.EXTENSION_SEPARATOR + lowerCase;
            lastIndexOf++;
        }
        if (!str2.endsWith(lowerCase.substring(1))) {
            aVar.f49313a = null;
            return;
        }
        int length = lowerCase.length();
        int length2 = str2.length();
        if (length2 > length - 1 && str2.charAt(length2 - length) != '.') {
            aVar.f49313a = null;
            return;
        }
        if (length == lastIndexOf + 3 && length >= 6 && length <= 8) {
            if (Arrays.binarySearch(f49335e, lowerCase.substring(1, lastIndexOf)) >= 0) {
                aVar.f49313a = null;
                return;
            }
        }
        aVar.f49313a = lowerCase;
    }

    public static void k(@NonNull a aVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, aVar, str) == null) {
            if (f49331a) {
                Log.d("SwanCookieParser", "setExpires value: " + str);
            }
            if (aVar.f49317e != -1) {
                return;
            }
            long e2 = d.a.q0.a.l2.f.a.e(str);
            if (f49331a) {
                Log.d("SwanCookieParser", "setExpires result: " + e2);
            }
            if (e2 != -1) {
                aVar.f49317e = e2;
            }
        }
    }

    public static void l(@NonNull a aVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, aVar, str) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                long parseLong = Long.parseLong(str);
                Long.signum(parseLong);
                aVar.f49317e = currentTimeMillis + (parseLong * 1000);
            } catch (NumberFormatException unused) {
                if (f49331a) {
                    Log.e("SwanCookieParser", "illegal max-age: " + str);
                }
            }
        }
    }

    public static void m(@NonNull a aVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, aVar, str) == null) && !TextUtils.isEmpty(str) && str.charAt(0) == '/') {
            aVar.f49314b = str;
        }
    }

    public static int n(@NonNull String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i2, i3)) == null) ? (TextUtils.equals("expires", str2) && (indexOf = str.indexOf(44, i3)) != -1 && indexOf - i3 <= 10) ? indexOf + 1 : i2 : invokeLLII.intValue;
    }
}
