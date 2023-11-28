package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aj {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334583758, "Lcom/kuaishou/weapon/p0/aj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334583758, "Lcom/kuaishou/weapon/p0/aj;");
                return;
            }
        }
        b = new String[]{"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    }

    public static boolean b() {
        InterceptResult invokeV;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                a = bh.a(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            if (!a.contains("flyme")) {
                if (!a.toLowerCase().contains("flyme")) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String[] a = a(bi.z);
                int length = a.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (new File(a[i], bi.y).exists()) {
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        z = false;
                        break;
                    }
                }
            } catch (Exception unused) {
            }
            if (!z) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (String str : b) {
                if (new File(str, "magisk").exists()) {
                    return str + "magisk";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (String str : b) {
                if (new File(str, bi.y).exists()) {
                    return str + bi.y;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public aj(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return aa.a().b(str).replace("\n", "");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private String[] a(String[] strArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            try {
                str = System.getenv("PATH");
            } catch (Exception unused) {
            }
            if (str != null && !"".equals(str)) {
                String[] split = str.split(":");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    String str2 = split[i];
                    if (!str2.endsWith("/")) {
                        str2 = str2 + WebvttCueParser.CHAR_SLASH;
                    }
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 29) {
                    return null;
                }
                return aa.a().b("su -v").replace("\n", "");
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String a = aa.a().a("ro.secure");
            if (a != null && "0".equals(a)) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String a = aa.a().a("ro.debuggable");
            if (a != null && "0".equals(a)) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String a = aa.a().a("ro.adb.secure");
            if (a != null && "0".equals(a)) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (new File("/system/app/Superuser.apk").exists()) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String a = a(" which su ");
                if (!TextUtils.isEmpty(a) && a.length() > 2) {
                    jSONObject.put("0", 1);
                    jSONObject.put("0-p", a);
                } else {
                    jSONObject.put("0", 0);
                }
                String a2 = a(" id ");
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.toLowerCase().contains("uid=0")) {
                        jSONObject.put("1", 1);
                    } else {
                        jSONObject.put("1", 0);
                    }
                }
                String a3 = a(" busybox df ");
                if (!TextUtils.isEmpty(a3) && !a3.contains("not found")) {
                    if (a3.length() > 30) {
                        jSONObject.put("2", 1);
                    } else {
                        jSONObject.put("2", 0);
                    }
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                throw new Exception("");
            } catch (Exception e) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                        return stackTraceElement.getClassName();
                    }
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
