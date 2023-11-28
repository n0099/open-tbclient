package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes10.dex */
public class b1 extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str3 = "";
            try {
                str2 = (String) Class.forName(EmuiUtil.BUILDEX_NAME).getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            } catch (AndroidRuntimeException unused) {
            } catch (ClassNotFoundException unused2) {
            } catch (IllegalAccessException unused3) {
            } catch (IllegalArgumentException unused4) {
            } catch (NoSuchMethodException unused5) {
            } catch (InvocationTargetException unused6) {
            }
            try {
                y.c("hmsSdk", "getUDID success");
                return str2;
            } catch (AndroidRuntimeException unused7) {
                str3 = str2;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                y.f("hmsSdk", str);
                return str3;
            } catch (ClassNotFoundException unused8) {
                str3 = str2;
                str = "getUDID method invoke failed";
                y.f("hmsSdk", str);
                return str3;
            } catch (IllegalAccessException unused9) {
                str3 = str2;
                str = "getUDID method invoke failed : Illegal AccessException";
                y.f("hmsSdk", str);
                return str3;
            } catch (IllegalArgumentException unused10) {
                str3 = str2;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                y.f("hmsSdk", str);
                return str3;
            } catch (NoSuchMethodException unused11) {
                str3 = str2;
                str = "getUDID method invoke failed : NoSuchMethodException";
                y.f("hmsSdk", str);
                return str3;
            } catch (InvocationTargetException unused12) {
                str3 = str2;
                str = "getUDID method invoke failed : InvocationTargetException";
                y.f("hmsSdk", str);
                return str3;
            }
        }
        return (String) invokeV.objValue;
    }

    public static Pair<String, String> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (q0.a(context, com.kuaishou.weapon.p0.g.c)) {
                y.f("hmsSdk", "getMccAndMnc() Pair value is empty");
                return new Pair<>("", "");
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                String networkOperator = telephonyManager.getNetworkOperator();
                return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, StringUtil.NULL_STRING)) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
            }
            return new Pair<>("", "");
        }
        return (Pair) invokeL.objValue;
    }
}
