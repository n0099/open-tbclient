package com.bytedance.sdk.openadsdk.q;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68686a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f68687b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f68688c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f68689d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f68690e = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(98109665, "Lcom/bytedance/sdk/openadsdk/q/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(98109665, "Lcom/bytedance/sdk/openadsdk/q/m;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if (!f68686a) {
                    c();
                }
                Configuration configuration = com.bytedance.sdk.openadsdk.core.o.a().getResources().getConfiguration();
                String valueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : f68688c;
                com.bytedance.sdk.component.utils.k.f("MCC", "config=" + configuration.mcc + ",sMCC=" + f68688c);
                if (f68690e) {
                    return valueOf;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("getMCC");
                sb.append(f68690e ? "有SIM卡" : "无SIM卡,MCC返回null");
                com.bytedance.sdk.component.utils.k.f("MCC", sb.toString());
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f68686a) {
                c();
            }
            return f68689d;
        }
        return (String) invokeV.objValue;
    }

    public static void c() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || com.bytedance.sdk.openadsdk.core.o.a() == null || f68686a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("phone");
            int simState = telephonyManager.getSimState();
            if (simState == 0) {
                f68690e = false;
            } else if (simState == 1) {
                f68690e = false;
            }
            com.bytedance.sdk.component.utils.k.f("MCC", f68690e ? "有SIM卡" : "无SIM卡");
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                str4 = str2.substring(0, 3);
                str3 = str2.substring(3);
            }
            if (!TextUtils.isEmpty(str)) {
                f68687b = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                f68688c = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                f68689d = str3;
            }
        } catch (Throwable unused4) {
        }
        f68686a = true;
    }
}
