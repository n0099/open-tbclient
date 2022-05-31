package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
/* loaded from: classes7.dex */
public class xn0 implements CookieJar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yn0 a;

    public xn0(yn0 yn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yn0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yn0Var;
    }

    public static int a(@NonNull String str, int i, int i2, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)})) == null) {
            while (i < i2) {
                if (str.charAt(i) == c) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int d(@NonNull String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i, i2)) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static int e(@NonNull String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, str, i, i2)) == null) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }
        return invokeLII.intValue;
    }

    public static String f(@NonNull String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2)) == null) {
            int d = d(str, i, i2);
            return str.substring(d, e(str, d, i2));
        }
        return (String) invokeLII.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final List<Cookie> c(@NonNull HttpUrl httpUrl, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int a = a(str, i, length, WebvttCueParser.CHAR_SEMI_COLON);
                int a2 = a(str, i, a, '=');
                String f = f(str, i, a2);
                String f2 = a2 < a ? f(str, a2 + 1, a) : "";
                if (f2.startsWith("\"") && f2.endsWith("\"")) {
                    f2 = f2.substring(1, f2.length() - 1);
                }
                String b = b(f);
                String b2 = b(f2);
                if (!TextUtils.isEmpty(b) && this.a.shouldSendCookie(httpUrl.toString(), b)) {
                    arrayList.add(new Cookie.Builder().name(b).value(b2).domain(httpUrl.host()).build());
                }
                i = a + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        InterceptResult invokeL;
        yn0 yn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpUrl)) == null) {
            ArrayList arrayList = new ArrayList();
            if (httpUrl != null && (yn0Var = this.a) != null) {
                String cookie = yn0Var.getCookie(httpUrl.toString());
                if (!TextUtils.isEmpty(cookie)) {
                    arrayList.addAll(c(httpUrl, cookie));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, httpUrl, list) == null) || httpUrl == null || gx0.g(list) || this.a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String httpUrl2 = httpUrl.toString();
        for (Cookie cookie : list) {
            if (cookie != null) {
                String cookie2 = cookie.toString();
                if (!TextUtils.isEmpty(cookie2) && this.a.shouldAcceptCookie(httpUrl2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
        }
        this.a.storeCookie(httpUrl.toString(), arrayList);
    }
}
