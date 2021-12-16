package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.as;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f58099b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-13782810, "Lcom/kwad/sdk/core/network/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-13782810, "Lcom/kwad/sdk/core/network/k;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                String property = System.getProperty("http.agent");
                a = property;
                if (TextUtils.isEmpty(property)) {
                    return a;
                }
                StringBuffer stringBuffer = new StringBuffer();
                int length = a.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = a.charAt(i2);
                    if (charAt <= 31 || charAt >= 127) {
                        stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        stringBuffer.append(charAt);
                    }
                }
                String stringBuffer2 = stringBuffer.toString();
                a = stringBuffer2;
                return stringBuffer2;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a() + "-ksad-android-3.3.17.4";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? com.kwad.sdk.core.config.b.an() : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(f58099b)) {
                Context context = KsAdSDKImpl.get().getContext();
                if (context == null) {
                    return "";
                }
                try {
                    f2 = as.f(context);
                    f58099b = f2;
                } catch (Exception unused) {
                }
                if (TextUtils.isEmpty(f2)) {
                    f58099b = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : System.getProperty("http.agent");
                    String encode = URLEncoder.encode(f58099b, "UTF-8");
                    f58099b = encode;
                    as.j(context, encode);
                    return f58099b;
                }
                return f58099b;
            }
            return f58099b;
        }
        return (String) invokeV.objValue;
    }
}
