package okhttp3.internal.http;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.apache.http.message.BasicHeaderValueFormatter;
/* loaded from: classes9.dex */
public final class HttpHeaders {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteString QUOTED_STRING_DELIMITERS;
    public static final ByteString TOKEN_DELIMITERS;
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
        QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");
    }

    public HttpHeaders() {
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

    public static long contentLength(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, headers)) == null) {
            return stringToLong(headers.get("Content-Length"));
        }
        return invokeL.longValue;
    }

    public static boolean hasVaryAll(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, headers)) == null) {
            return varyFields(headers).contains("*");
        }
        return invokeL.booleanValue;
    }

    public static long stringToLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, response)) == null) {
            return varyFields(response.headers());
        }
        return (Set) invokeL.objValue;
    }

    public static Headers varyHeaders(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, response)) == null) {
            return varyHeaders(response.networkResponse().request().headers(), response.headers());
        }
        return (Headers) invokeL.objValue;
    }

    public static long contentLength(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, response)) == null) {
            return contentLength(response.headers());
        }
        return invokeL.longValue;
    }

    public static boolean hasVaryAll(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, response)) == null) {
            return hasVaryAll(response.headers());
        }
        return invokeL.booleanValue;
    }

    public static boolean hasBody(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, response)) == null) {
            if (response.request().method().equals("HEAD")) {
                return false;
            }
            int code = response.code();
            if (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String readQuotedString(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, buffer)) == null) {
            if (buffer.readByte() == 34) {
                Buffer buffer2 = new Buffer();
                while (true) {
                    long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
                    if (indexOfElement == -1) {
                        return null;
                    }
                    if (buffer.getByte(indexOfElement) == 34) {
                        buffer2.write(buffer, indexOfElement);
                        buffer.readByte();
                        return buffer2.readUtf8();
                    } else if (buffer.size() == indexOfElement + 1) {
                        return null;
                    } else {
                        buffer2.write(buffer, indexOfElement);
                        buffer.readByte();
                        buffer2.write(buffer, 1L);
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static Set<String> varyFields(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, headers)) == null) {
            Set<String> emptySet = Collections.emptySet();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                if ("Vary".equalsIgnoreCase(headers.name(i))) {
                    String value = headers.value(i);
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

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0081, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0081, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void parseChallengeHeader(List<Challenge> list, Buffer buffer) {
        String readToken;
        int skipAll;
        String readToken2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, null, list, buffer) != null) {
            return;
        }
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipWhitespaceAndCommas(buffer);
                    str = readToken(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
                readToken = readToken(buffer);
                if (readToken == null) {
                    if (!buffer.exhausted()) {
                        return;
                    }
                    list.add(new Challenge(str, Collections.emptyMap()));
                    return;
                }
                skipAll = skipAll(buffer, BaseNCodec.PAD_DEFAULT);
                boolean skipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
                if (skipWhitespaceAndCommas || (!skipWhitespaceAndCommas2 && !buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = skipAll + skipAll(buffer, BaseNCodec.PAD_DEFAULT);
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(buffer);
                            if (skipWhitespaceAndCommas(buffer)) {
                                break;
                            }
                            skipAll2 = skipAll(buffer, BaseNCodec.PAD_DEFAULT);
                        }
                        if (skipAll2 == 0) {
                            break;
                        } else if (skipAll2 > 1 || skipWhitespaceAndCommas(buffer)) {
                            return;
                        } else {
                            if (!buffer.exhausted() && buffer.getByte(0L) == 34) {
                                readToken2 = readQuotedString(buffer);
                            } else {
                                readToken2 = readToken(buffer);
                            }
                            if (readToken2 == null || ((String) linkedHashMap.put(readToken, readToken2)) != null) {
                                return;
                            }
                            if (!skipWhitespaceAndCommas(buffer) && !buffer.exhausted()) {
                                return;
                            }
                            readToken = null;
                        }
                    }
                    list.add(new Challenge(str, linkedHashMap));
                    str = readToken;
                }
            }
            list.add(new Challenge(str, Collections.singletonMap(null, readToken + repeat(a.h, skipAll))));
        }
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, headers, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < headers.size(); i++) {
                if (str.equalsIgnoreCase(headers.name(i))) {
                    parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i)));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int skipAll(Buffer buffer, byte b) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{buffer, Byte.valueOf(b)})) == null) {
            int i = 0;
            while (!buffer.exhausted() && buffer.getByte(0L) == b) {
                i++;
                buffer.readByte();
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static int parseSeconds(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
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
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static String repeat(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            char[] cArr = new char[i];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }
        return (String) invokeCommon.objValue;
    }

    public static int skipWhitespace(String str, int i) {
        char charAt;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, str, i)) == null) {
            while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
                i++;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static String readToken(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, buffer)) == null) {
            try {
                long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
                if (indexOfElement == -1) {
                    indexOfElement = buffer.size();
                }
                if (indexOfElement != 0) {
                    return buffer.readUtf8(indexOfElement);
                }
                return null;
            } catch (EOFException unused) {
                throw new AssertionError();
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean skipWhitespaceAndCommas(Buffer buffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, buffer)) == null) {
            boolean z = false;
            while (!buffer.exhausted()) {
                byte b = buffer.getByte(0L);
                if (b == 44) {
                    buffer.readByte();
                    z = true;
                } else if (b != 32 && b != 9) {
                    break;
                } else {
                    buffer.readByte();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65548, null, cookieJar, httpUrl, headers) != null) || cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static int skipUntil(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, str, i, str2)) == null) {
            while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
                i++;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, headers, headers2)) == null) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return new Headers.Builder().build();
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i));
                }
            }
            return builder.build();
        }
        return (Headers) invokeLL.objValue;
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, response, headers, request)) == null) {
            for (String str : varyFields(response)) {
                if (!Util.equal(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
