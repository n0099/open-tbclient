package okhttp3.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
/* loaded from: classes3.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final Charset ISO_8859_1;
    public static final Comparator<String> NATURAL_ORDER;
    public static final TimeZone UTC;
    public static final Charset UTF_16_BE;
    public static final ByteString UTF_16_BE_BOM;
    public static final Charset UTF_16_LE;
    public static final ByteString UTF_16_LE_BOM;
    public static final Charset UTF_32_BE;
    public static final ByteString UTF_32_BE_BOM;
    public static final Charset UTF_32_LE;
    public static final ByteString UTF_32_LE_BOM;
    public static final Charset UTF_8;
    public static final ByteString UTF_8_BOM;
    public static final Pattern VERIFY_AS_IP_ADDRESS;
    public static final Method addSuppressedExceptionMethod;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1862295661, "Lokhttp3/internal/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1862295661, "Lokhttp3/internal/Util;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_STRING_ARRAY = new String[0];
        Method method = null;
        EMPTY_RESPONSE = ResponseBody.create((MediaType) null, bArr);
        EMPTY_REQUEST = RequestBody.create((MediaType) null, EMPTY_BYTE_ARRAY);
        UTF_8_BOM = ByteString.decodeHex("efbbbf");
        UTF_16_BE_BOM = ByteString.decodeHex("feff");
        UTF_16_LE_BOM = ByteString.decodeHex("fffe");
        UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
        UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        UTF_16_BE = Charset.forName("UTF-16BE");
        UTF_16_LE = Charset.forName("UTF-16LE");
        UTF_32_BE = Charset.forName("UTF-32BE");
        UTF_32_LE = Charset.forName("UTF-32LE");
        UTC = TimeZone.getTimeZone("GMT");
        NATURAL_ORDER = new Comparator<String>() { // from class: okhttp3.internal.Util.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
            }
        };
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        addSuppressedExceptionMethod = method;
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public Util() {
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

    public static void addSuppressedIfPossible(Throwable th, Throwable th2) {
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, th, th2) == null) || (method = addSuppressedExceptionMethod) == null) {
            return;
        }
        try {
            method.invoke(th, th2);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public static AssertionError assertionError(String str, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, exc)) == null) {
            AssertionError assertionError = new AssertionError(str);
            try {
                assertionError.initCause(exc);
            } catch (IllegalStateException unused) {
            }
            return assertionError;
        }
        return (AssertionError) invokeLL.objValue;
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedSource, charset)) == null) {
            if (bufferedSource.rangeEquals(0L, UTF_8_BOM)) {
                bufferedSource.skip(UTF_8_BOM.size());
                return UTF_8;
            } else if (bufferedSource.rangeEquals(0L, UTF_16_BE_BOM)) {
                bufferedSource.skip(UTF_16_BE_BOM.size());
                return UTF_16_BE;
            } else if (bufferedSource.rangeEquals(0L, UTF_16_LE_BOM)) {
                bufferedSource.skip(UTF_16_LE_BOM.size());
                return UTF_16_LE;
            } else if (bufferedSource.rangeEquals(0L, UTF_32_BE_BOM)) {
                bufferedSource.skip(UTF_32_BE_BOM.size());
                return UTF_32_BE;
            } else if (bufferedSource.rangeEquals(0L, UTF_32_LE_BOM)) {
                bufferedSource.skip(UTF_32_LE_BOM.size());
                return UTF_32_LE;
            } else {
                return charset;
            }
        }
        return (Charset) invokeLL.objValue;
    }

    public static String canonicalizeHost(String str) {
        InterceptResult invokeL;
        InetAddress decodeIpv6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str.contains(":")) {
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
                } else {
                    decodeIpv6 = decodeIpv6(str, 0, str.length());
                }
                if (decodeIpv6 == null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, Long.valueOf(j), timeUnit})) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }
        return invokeCommon.intValue;
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static String[] concat(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, strArr, str)) == null) {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = str;
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int decodeHexDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)})) == null) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            return i5 == i4 + 4;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress decodeIpv6(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, str, i2, i3)) == null) {
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i2 < i3) {
                    if (i5 != 16) {
                        int i8 = i2 + 2;
                        if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                            if (i6 == -1) {
                                i5 += 2;
                                i6 = i5;
                                if (i8 != i3) {
                                    i7 = i8;
                                    i2 = i7;
                                    int i9 = 0;
                                    while (i2 < i3) {
                                    }
                                    i4 = i2 - i7;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i5 != 0) {
                            if (str.regionMatches(i2, ":", 0, 1)) {
                                i2++;
                            } else if (!str.regionMatches(i2, ".", 0, 1) || !decodeIpv4Suffix(str, i7, i3, bArr, i5 - 2)) {
                                return null;
                            } else {
                                i5 += 2;
                            }
                        }
                        i7 = i2;
                        i2 = i7;
                        int i92 = 0;
                        while (i2 < i3) {
                            int decodeHexDigit = decodeHexDigit(str.charAt(i2));
                            if (decodeHexDigit == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + decodeHexDigit;
                            i2++;
                        }
                        i4 = i2 - i7;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i5 + 1;
                        bArr[i5] = (byte) ((i92 >>> 8) & 255);
                        i5 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i5 != 16) {
                if (i6 == -1) {
                    return null;
                }
                int i11 = i5 - i6;
                System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
                Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeLII.objValue;
    }

    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            while (i2 < i3) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static boolean discard(Source source, int i2, TimeUnit timeUnit) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, source, i2, timeUnit)) == null) {
            try {
                return skipAll(source, i2, timeUnit);
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, objArr)) == null) ? String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        InterceptResult invokeLZ;
        String host;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, null, httpUrl, z)) == null) {
            if (httpUrl.host().contains(":")) {
                host = PreferencesUtil.LEFT_MOUNT + httpUrl.host() + PreferencesUtil.RIGHT_MOUNT;
            } else {
                host = httpUrl.host();
            }
            if (z || httpUrl.port() != HttpUrl.defaultPort(httpUrl.scheme())) {
                return host + ":" + httpUrl.port();
            }
            return host;
        }
        return (String) invokeLZ.objValue;
    }

    public static <T> List<T> immutableList(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, list)) == null) ? Collections.unmodifiableList(new ArrayList(list)) : (List) invokeL.objValue;
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, map)) == null) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        return (Map) invokeL.objValue;
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, comparator, strArr, str)) == null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (comparator.compare(strArr[i2], str) == 0) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static int indexOfControlOrNonAscii(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String inet6AddressToAscii(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) {
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                int i6 = i4;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5 && i7 >= 4) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            Buffer buffer = new Buffer();
            while (i2 < bArr.length) {
                if (i2 == i3) {
                    buffer.writeByte(58);
                    i2 += i5;
                    if (i2 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return buffer.readUtf8();
        }
        return (String) invokeL.objValue;
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, comparator, strArr, strArr2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (comparator.compare(str, strArr2[i2]) == 0) {
                        arrayList.add(str);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, assertionError)) == null) ? (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true : invokeL.booleanValue;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, comparator, strArr, strArr2)) == null) {
            if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static X509TrustManager platformTrustManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                    return (X509TrustManager) trustManagers[0];
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw assertionError("No System TLS", e2);
            }
        }
        return (X509TrustManager) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CMP_L]}, finally: {[CMP_L, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, IF] complete} */
    public static boolean skipAll(Source source, int i2, TimeUnit timeUnit) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65568, null, source, i2, timeUnit)) == null) {
            long nanoTime = System.nanoTime();
            long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
            source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i2)) + nanoTime);
            try {
                Buffer buffer = new Buffer();
                while (source.read(buffer, 8192L) != -1) {
                    buffer.clear();
                }
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                return true;
            } catch (InterruptedIOException unused) {
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                return false;
            } catch (Throwable th) {
                if (deadlineNanoTime == Long.MAX_VALUE) {
                    source.timeout().clearDeadline();
                } else {
                    source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
                }
                throw th;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65569, null, str, i2, i3)) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65570, null, str, i2, i3)) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65571, null, str, z)) == null) ? new ThreadFactory(str, z) { // from class: okhttp3.internal.Util.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean val$daemon;
            public final /* synthetic */ String val$name;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$name = str;
                this.val$daemon = z;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable, this.val$name);
                    thread.setDaemon(this.val$daemon);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        } : (ThreadFactory) invokeLZ.objValue;
    }

    public static String trimSubstring(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65572, null, str, i2, i3)) == null) {
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i2, i3);
            return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i3));
        }
        return (String) invokeLII.objValue;
    }

    public static boolean verifyAsIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) ? VERIFY_AS_IP_ADDRESS.matcher(str).matches() : invokeL.booleanValue;
    }

    public static int delimiterOffset(String str, int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            while (i2 < i3) {
                if (str.charAt(i2) == c2) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static <T> List<T> immutableList(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, tArr)) == null) ? Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone())) : (List) invokeL.objValue;
    }

    public static void closeQuietly(Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, socket) == null) || socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!isAndroidGetsocknameError(e2)) {
                throw e2;
            }
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, serverSocket) == null) || serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }
}
