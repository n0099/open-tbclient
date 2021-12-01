package com.sdk.base.framework.f.d;

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
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.base.framework.f.d.a";

    /* renamed from: b  reason: collision with root package name */
    public static final Boolean f61008b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065803342, "Lcom/sdk/base/framework/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065803342, "Lcom/sdk/base/framework/f/d/a;");
                return;
            }
        }
        f61008b = Boolean.valueOf(f.f60988b);
    }

    public a() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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

    @SuppressLint({"DefaultLocale", "NewApi"})
    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String userAgent = SDKManager.getUserAgent();
            if (c.a(userAgent).booleanValue()) {
                if (context != null) {
                    try {
                        userAgent = b(context);
                    } catch (Throwable unused) {
                    }
                }
                return c.a(userAgent).booleanValue() ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : userAgent;
            }
            return userAgent;
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
                    for (int i2 = 0; i2 < str2.length(); i2++) {
                        if (!Character.isDigit(str2.charAt(i2))) {
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

    public static boolean a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, httpURLConnection)) == null) {
            if (httpURLConnection == null) {
                return false;
            }
            String headerField = httpURLConnection.getHeaderField(Util.ACCEPT_RANGES);
            if (c.b(headerField).booleanValue()) {
                return "bytes".equals(headerField);
            }
            if (c.b(httpURLConnection.getHeaderField("Content-Range")).booleanValue()) {
                return headerField.startsWith("bytes");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        String defaultUserAgent;
        int length;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Exception unused) {
                }
                StringBuilder sb = new StringBuilder();
                length = defaultUserAgent.length();
                for (i2 = 0; i2 < length; i2++) {
                    char charAt = defaultUserAgent.charAt(i2);
                    if (charAt <= 31 || charAt >= 127) {
                        sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb.append(charAt);
                    }
                }
                return sb.toString();
            }
            defaultUserAgent = System.getProperty("http.agent");
            StringBuilder sb2 = new StringBuilder();
            length = defaultUserAgent.length();
            while (i2 < length) {
            }
            return sb2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, httpURLConnection)) == null) {
            if (httpURLConnection != null) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                    if (c.b(headerField).booleanValue()) {
                        String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                        if (c.b(str).booleanValue()) {
                            return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                        }
                    }
                } catch (Throwable th) {
                    c.b(a, th.getMessage(), f61008b);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
