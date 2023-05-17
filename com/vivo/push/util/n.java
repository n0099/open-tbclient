package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static Method f;
    public static String g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178542, "Lcom/vivo/push/util/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178542, "Lcom/vivo/push/util/n;");
                return;
            }
        }
        a = ag.b("ro.vivo.product.overseas", "no").equals("yes");
        b = b("rom_1.0");
        c = b("rom_2.0");
        d = b("rom_2.5");
        e = b("rom_3.0");
        g = null;
        h = null;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                u.d("Device", "Build.MANUFACTURER is null");
                return false;
            }
            u.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
            if (!Build.MANUFACTURER.toLowerCase().contains("bbk") && !Build.MANUFACTURER.toLowerCase().startsWith("vivo")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (n.class) {
                if (g == null && h == null) {
                    try {
                        Method declaredMethod = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class);
                        f = declaredMethod;
                        declaredMethod.setAccessible(true);
                        g = (String) f.invoke(null, "ro.vivo.rom", "@><@");
                        h = (String) f.invoke(null, "ro.vivo.rom.version", "@><@");
                    } catch (Exception unused) {
                        u.b("Device", "getRomCode error");
                    }
                }
                u.d("Device", "sRomProperty1 : " + g + " ; sRomProperty2 : " + h);
                String a2 = a(g);
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
                String a3 = a(h);
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                return a3;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
            if (!matcher.find()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            if (TextUtils.isEmpty(matcher.group(2))) {
                substring = "0";
            } else {
                substring = matcher.group(2).substring(0, 1);
            }
            sb.append(substring);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String b2 = ag.b("ro.vivo.rom", "");
            String b3 = ag.b("ro.vivo.rom.version", "");
            u.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
            if (b2 == null || !b2.contains(str)) {
                if (b3 != null && b3.contains(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String a(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                str3 = (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(null, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = str2;
            }
            if (str3 != null && str3.length() != 0) {
                return str3;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
