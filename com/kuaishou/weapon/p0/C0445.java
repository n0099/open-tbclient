package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
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
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ⁱ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0445 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String[] f628;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f629;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651520562, "Lcom/kuaishou/weapon/p0/ⁱ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651520562, "Lcom/kuaishou/weapon/p0/ⁱ;");
                return;
            }
        }
        f628 = new String[]{"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    }

    public C0445(Context context) {
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
        this.f629 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m956(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            PackageManager packageManager = this.f629.getPackageManager();
            for (String str : list) {
                try {
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private String[] m957(String[] strArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            try {
                str = System.getenv("PATH");
            } catch (Exception unused) {
            }
            if (str == null || "".equals(str)) {
                return (String[]) arrayList.toArray(new String[0]);
            }
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
        return (String[]) invokeL.objValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m958() {
        InterceptResult invokeV;
        String m854;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                m854 = C0433.m854(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(m854)) {
                return false;
            }
            if (m854.contains("flyme")) {
                return true;
            }
            return m854.toLowerCase().contains("flyme");
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m959() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                for (String str : m957(C0453.f725)) {
                    if (new File(str, C0453.f723).exists()) {
                        return 1;
                    }
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m960(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return C0428.m824().m826(str).replace("\n", "");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m961() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (String str : f628) {
                if (new File(str, "magisk").exists()) {
                    return str + "magisk";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m962() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (String str : f628) {
                if (new File(str, C0453.f723).exists()) {
                    return str + C0453.f723;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public int m963() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new File("/system/app/Superuser.apk").exists() ? 1 : 0 : invokeV.intValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public boolean m964() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(C0453.f724));
            if (arrayList.size() > 0) {
                return m956(arrayList);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public String m965() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                if (!m958() || Build.VERSION.SDK_INT <= 29) {
                    return C0428.m824().m826("su -v").replace("\n", "");
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public String m966() {
        InterceptResult invokeV;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

    /* renamed from: ˉ  reason: contains not printable characters */
    public int m967() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String m827 = C0428.m824().m827("ro.adb.secure");
            return (m827 != null && "0".equals(m827)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m968() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String m827 = C0428.m824().m827("ro.debuggable");
            return (m827 != null && "0".equals(m827)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m969() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String m827 = C0428.m824().m827("ro.secure");
            return (m827 != null && "0".equals(m827)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m970() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String m960 = m960(" which su ");
                if (TextUtils.isEmpty(m960) || m960.length() <= 2) {
                    jSONObject.put("0", 0);
                } else {
                    jSONObject.put("0", 1);
                    jSONObject.put("0-p", m960);
                }
                String m9602 = m960(" id ");
                if (!TextUtils.isEmpty(m9602)) {
                    if (m9602.toLowerCase().contains("uid=0")) {
                        jSONObject.put("1", 1);
                    } else {
                        jSONObject.put("1", 0);
                    }
                }
                String m9603 = m960(" busybox df ");
                if (!TextUtils.isEmpty(m9603) && !m9603.contains("not found")) {
                    if (m9603.length() > 30) {
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
}
