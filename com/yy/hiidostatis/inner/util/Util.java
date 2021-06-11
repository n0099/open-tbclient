package com.yy.hiidostatis.inner.util;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
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
/* loaded from: classes7.dex */
public class Util {
    public static ThreadLocal<Map<String, SimpleDateFormat>> dateFormatThreadLocal;
    public static volatile Locale locale;

    static {
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
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public Map<String, SimpleDateFormat> initialValue() {
                return new HashMap();
            }
        };
    }

    public static String asEmptyOnNull(String str) {
        return str == null ? "" : str;
    }

    public static long cpuMillis() {
        return SystemClock.elapsedRealtime();
    }

    public static long cpuSec() {
        return millisToSec(cpuMillis());
    }

    public static int daysBetween(long j, long j2) {
        long j3 = j2 - j;
        long j4 = j3 / 86400000;
        if (j3 % 86400000 != 0) {
            j4++;
        }
        return Integer.parseInt(String.valueOf(j4));
    }

    public static boolean empty(String str) {
        return str == null || str.length() == 0;
    }

    public static String formatDate(String str, long j) {
        return getSimpleDateFormat(str).format(Long.valueOf(j));
    }

    public static String formatStr(String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        if (locale == null) {
            return String.format(str, objArr);
        }
        return String.format(locale, str, objArr);
    }

    public static String getInnerIP() {
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
            L.debug(com.baidu.android.common.util.Util.f2584b, "getInnerIP ex=%s", th);
            return "";
        }
    }

    public static String getOutNetIp() {
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
                    sb.append("\n");
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
            L.debug(com.baidu.android.common.util.Util.f2584b, "getOutNetIp ex=%s", th);
        }
        return "";
    }

    public static String getRandStringEx(int i2) {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        byte[] bArr2 = new byte[i2];
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[random.nextInt(61)];
        }
        return new String(bArr2);
    }

    public static SimpleDateFormat getSimpleDateFormat(String str) {
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

    public static boolean hasData(String str) {
        return !empty(str);
    }

    public static boolean isExistClass(String str) {
        try {
            if (empty(str)) {
                return false;
            }
            return Class.forName(str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int longToInt(long j) {
        if (j >= 2147483647L) {
            L.debug(com.baidu.android.common.util.Util.f2584b, "Failed to convert long %d to int.", Long.valueOf(j));
        }
        return (int) j;
    }

    public static long millisToSec(long j) {
        return j / 1000;
    }

    public static long millisToSec1(long j) {
        return (j % 1000 == 0 || j <= 0) ? j / 1000 : (j / 1000) + 1;
    }

    public static Date parseDate(String str, String str2) throws ParseException {
        return getSimpleDateFormat(str).parse(str2);
    }

    public static String parseParam(String str, String str2) {
        try {
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                if (str2.equals(split[0])) {
                    return split[1];
                }
            }
            return "";
        } catch (Throwable th) {
            L.debug(com.baidu.android.common.util.Util.f2584b, th.getMessage(), new Object[0]);
            return "";
        }
    }

    public static Map<String, String> parseParams(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=", -1);
                hashMap.put(split[0], split[1]);
            }
        } catch (Throwable th) {
            L.debug(com.baidu.android.common.util.Util.f2584b, th.getMessage(), new Object[0]);
        }
        return hashMap;
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
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
        if (empty(str)) {
            return str;
        }
        try {
            return str.replace(str2, URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static long wallTimeMillis() {
        return System.currentTimeMillis();
    }

    public static long wallTimeSec() {
        return millisToSec(wallTimeMillis());
    }

    public static boolean empty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean hasData(Collection<?> collection) {
        return !empty(collection);
    }

    public static boolean empty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static <T> boolean hasData(T... tArr) {
        return !empty(tArr);
    }

    public static <T> boolean empty(T... tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean empty(int... iArr) {
        return iArr == null || iArr.length == 0;
    }
}
