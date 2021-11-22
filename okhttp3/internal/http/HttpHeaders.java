package okhttp3.internal.http;

import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
/* loaded from: classes3.dex */
public final class HttpHeaders {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern PARAMETER;
    public static final String QUOTED_STRING = "\"([^\"]*)\"";
    public static final String TOKEN = "([^ \"=]*)";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2058225506, "Lokhttp3/internal/http/HttpHeaders;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2058225506, "Lokhttp3/internal/http/HttpHeaders;");
                return;
            }
        }
        PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public HttpHeaders() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long contentLength(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, response)) == null) ? contentLength(response.headers()) : invokeL.longValue;
    }

    public static boolean hasBody(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, response)) == null) {
            if (response.request().method().equals("HEAD")) {
                return false;
            }
            int code = response.code();
            return (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasVaryAll(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, response)) == null) ? hasVaryAll(response.headers()) : invokeL.booleanValue;
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, headers, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : headers.values(str)) {
                int indexOf = str2.indexOf(32);
                if (indexOf != -1) {
                    String substring = str2.substring(0, indexOf);
                    Matcher matcher = PARAMETER.matcher(str2);
                    String str3 = null;
                    String str4 = null;
                    while (matcher.find(indexOf)) {
                        if (str2.regionMatches(true, matcher.start(1), "realm", 0, 5)) {
                            str3 = matcher.group(3);
                        } else if (str2.regionMatches(true, matcher.start(1), "charset", 0, 7)) {
                            str4 = matcher.group(3);
                        }
                        if (str3 != null && str4 != null) {
                            break;
                        }
                        indexOf = matcher.end();
                    }
                    if (str3 != null) {
                        Challenge challenge = new Challenge(substring, str3);
                        if (str4 != null) {
                            if (str4.equalsIgnoreCase("UTF-8")) {
                                challenge = challenge.withCharset(Util.UTF_8);
                            }
                        }
                        arrayList.add(challenge);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int parseSeconds(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, cookieJar, httpUrl, headers) == null) || cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static int skipUntil(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65546, null, str, i2, str2)) == null) {
            while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
                i2++;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    public static int skipWhitespace(String str, int i2) {
        char charAt;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i2)) == null) {
            while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static long stringToLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static Set<String> varyFields(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, response)) == null) ? varyFields(response.headers()) : (Set) invokeL.objValue;
    }

    public static Headers varyHeaders(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, response)) == null) ? varyHeaders(response.networkResponse().request().headers(), response.headers()) : (Headers) invokeL.objValue;
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, response, headers, request)) == null) {
            for (String str : varyFields(response)) {
                if (!Util.equal(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static long contentLength(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, headers)) == null) ? stringToLong(headers.get("Content-Length")) : invokeL.longValue;
    }

    public static boolean hasVaryAll(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, headers)) == null) ? varyFields(headers).contains(ProxyConfig.MATCH_ALL_SCHEMES) : invokeL.booleanValue;
    }

    public static Set<String> varyFields(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, headers)) == null) {
            Set<String> emptySet = Collections.emptySet();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                if ("Vary".equalsIgnoreCase(headers.name(i2))) {
                    String value = headers.value(i2);
                    if (emptySet.isEmpty()) {
                        emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                    }
                    for (String str : value.split(",")) {
                        emptySet.add(str.trim());
                    }
                }
            }
            return emptySet;
        }
        return (Set) invokeL.objValue;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, headers, headers2)) == null) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return new Headers.Builder().build();
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = headers.name(i2);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i2));
                }
            }
            return builder.build();
        }
        return (Headers) invokeLL.objValue;
    }
}
