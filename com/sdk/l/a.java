package com.sdk.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.g;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.l.a";
    public static final Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592988596, "Lcom/sdk/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592988596, "Lcom/sdk/l/a;");
                return;
            }
        }
        b = Boolean.valueOf(g.b);
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
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
                return null;
            } catch (SocketException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpURLConnection)) == null) {
            if (httpURLConnection != null) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                    if (com.sdk.n.a.b(headerField).booleanValue()) {
                        String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                        if (com.sdk.n.a.b(str).booleanValue()) {
                            return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                        }
                    }
                } catch (Throwable th) {
                    com.sdk.n.a.a(a, th.getMessage(), b);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                for (String str2 : new URL(str).getHost().split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) {
                    for (int i = 0; i < str2.length(); i++) {
                        if (!Character.isDigit(str2.charAt(i))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, httpURLConnection)) == null) {
            if (httpURLConnection == null) {
                return false;
            }
            String headerField = httpURLConnection.getHeaderField(Util.ACCEPT_RANGES);
            if (com.sdk.n.a.b(headerField).booleanValue()) {
                return "bytes".equals(headerField);
            }
            if (com.sdk.n.a.b(httpURLConnection.getHeaderField("Content-Range")).booleanValue()) {
                return headerField.startsWith("bytes");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[Catch: all -> 0x005c, TryCatch #1 {all -> 0x005c, blocks: (B:7:0x0012, B:10:0x0018, B:14:0x0023, B:16:0x0030, B:21:0x003d, B:25:0x0053, B:22:0x0041, B:24:0x004c, B:26:0x0056, B:13:0x001f), top: B:40:0x0012 }] */
    @SuppressLint({"DefaultLocale", "NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String defaultUserAgent;
        int length;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = SDKManager.userAgent;
            if (com.sdk.n.a.a(str).booleanValue()) {
                if (context != null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 17) {
                            try {
                                defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                            } catch (Exception unused) {
                            }
                            StringBuilder sb = new StringBuilder();
                            length = defaultUserAgent.length();
                            for (i = 0; i < length; i++) {
                                char charAt = defaultUserAgent.charAt(i);
                                if (charAt > 31 && charAt < 127) {
                                    sb.append(charAt);
                                }
                                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            }
                            str = sb.toString();
                        }
                        defaultUserAgent = System.getProperty("http.agent");
                        StringBuilder sb2 = new StringBuilder();
                        length = defaultUserAgent.length();
                        while (i < length) {
                        }
                        str = sb2.toString();
                    } catch (Throwable unused2) {
                    }
                }
                if (com.sdk.n.a.a(str).booleanValue()) {
                    return "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1";
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
