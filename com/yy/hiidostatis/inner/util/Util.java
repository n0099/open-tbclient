package com.yy.hiidostatis.inner.util;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class Util {
    public static /* synthetic */ Interceptable $ic;
    public static ThreadLocal<Map<String, SimpleDateFormat>> dateFormatThreadLocal;
    public static volatile Locale locale;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-967178856, "Lcom/yy/hiidostatis/inner/util/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-967178856, "Lcom/yy/hiidostatis/inner/util/Util;");
                return;
            }
        }
        try {
            if (!"1234567890".equals(String.format("%d", 1234567890))) {
                locale = Locale.ENGLISH;
                PrintStream printStream = System.out;
                printStream.println("locale=" + locale);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dateFormatThreadLocal = new ThreadLocal<Map<String, SimpleDateFormat>>() { // from class: com.yy.hiidostatis.inner.util.Util.1
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
            @Override // java.lang.ThreadLocal
            public Map<String, SimpleDateFormat> initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new HashMap() : (Map) invokeV.objValue;
            }
        };
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

    public static String asEmptyOnNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public static long cpuMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SystemClock.elapsedRealtime() : invokeV.longValue;
    }

    public static long cpuSec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? millisToSec(cpuMillis()) : invokeV.longValue;
    }

    public static int daysBetween(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j3 - j2;
            long j5 = j4 / 86400000;
            if (j4 % 86400000 != 0) {
                j5++;
            }
            return Integer.parseInt(String.valueOf(j5));
        }
        return invokeCommon.intValue;
    }

    public static boolean empty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static String formatDate(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, str, j2)) == null) ? getSimpleDateFormat(str).format(Long.valueOf(j2)) : (String) invokeLJ.objValue;
    }

    public static String formatStr(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return str;
            }
            if (locale == null) {
                return String.format(str, objArr);
            }
            return String.format(locale, str, objArr);
        }
        return (String) invokeLL.objValue;
    }

    public static String getInnerIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                L.debug(com.baidu.android.common.util.Util.f31541b, "getInnerIP ex=%s", th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getOutNetIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://city.ip138.com/ip2city.asp").openConnection();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(StringUtils.LF);
                    }
                    inputStream.close();
                    Matcher matcher = Pattern.compile("[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}").matcher(sb.toString());
                    String str = "";
                    while (matcher.find()) {
                        str = matcher.group();
                    }
                    return str;
                }
            } catch (Throwable th) {
                L.debug(com.baidu.android.common.util.Util.f31541b, "getOutNetIp ex=%s", th);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String getRandStringEx(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
            byte[] bArr2 = new byte[i2];
            Random random = new Random();
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = bArr[random.nextInt(61)];
            }
            return new String(bArr2);
        }
        return (String) invokeI.objValue;
    }

    public static SimpleDateFormat getSimpleDateFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            Map<String, SimpleDateFormat> map = dateFormatThreadLocal.get();
            SimpleDateFormat simpleDateFormat = map.get(str);
            if (simpleDateFormat == null) {
                if (locale == null) {
                    simpleDateFormat = new SimpleDateFormat(str);
                } else {
                    simpleDateFormat = new SimpleDateFormat(str, locale);
                }
                map.put(str, simpleDateFormat);
            }
            return simpleDateFormat;
        }
        return (SimpleDateFormat) invokeL.objValue;
    }

    public static boolean hasData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? !empty(str) : invokeL.booleanValue;
    }

    public static boolean isExistClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            try {
                if (empty(str)) {
                    return false;
                }
                return Class.forName(str) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int longToInt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65557, null, j2)) == null) {
            if (j2 >= 2147483647L) {
                L.debug(com.baidu.android.common.util.Util.f31541b, "Failed to convert long %d to int.", Long.valueOf(j2));
            }
            return (int) j2;
        }
        return invokeJ.intValue;
    }

    public static long millisToSec(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65558, null, j2)) == null) ? j2 / 1000 : invokeJ.longValue;
    }

    public static long millisToSec1(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65559, null, j2)) == null) ? (j2 % 1000 == 0 || j2 <= 0) ? j2 / 1000 : (j2 / 1000) + 1 : invokeJ.longValue;
    }

    public static Date parseDate(String str, String str2) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) ? getSimpleDateFormat(str).parse(str2) : (Date) invokeLL.objValue;
    }

    public static String parseParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            try {
                for (String str3 : str.split("&")) {
                    String[] split = str3.split("=");
                    if (str2.equals(split[0])) {
                        return split[1];
                    }
                }
                return "";
            } catch (Throwable th) {
                L.debug(com.baidu.android.common.util.Util.f31541b, th.getMessage(), new Object[0]);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Map<String, String> parseParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            HashMap hashMap = new HashMap();
            try {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=", -1);
                    hashMap.put(split[0], split[1]);
                }
            } catch (Throwable th) {
                L.debug(com.baidu.android.common.util.Util.f31541b, th.getMessage(), new Object[0]);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65563, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr = new byte[5120];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String replaceEncode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, str2)) == null) {
            if (empty(str)) {
                return str;
            }
            try {
                return str.replace(str2, URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static long wallTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    public static long wallTimeSec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? millisToSec(wallTimeMillis()) : invokeV.longValue;
    }

    public static boolean empty(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, collection)) == null) ? collection == null || collection.size() == 0 : invokeL.booleanValue;
    }

    public static boolean hasData(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, collection)) == null) ? !empty(collection) : invokeL.booleanValue;
    }

    public static boolean empty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) ? bArr == null || bArr.length == 0 : invokeL.booleanValue;
    }

    public static <T> boolean hasData(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, tArr)) == null) ? !empty(tArr) : invokeL.booleanValue;
    }

    public static <T> boolean empty(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tArr)) == null) ? tArr == null || tArr.length == 0 : invokeL.booleanValue;
    }

    public static boolean empty(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iArr)) == null) ? iArr == null || iArr.length == 0 : invokeL.booleanValue;
    }
}
