package com.ta.utdid2.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nanoTime = (int) System.nanoTime();
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] bytes = d.getBytes(currentTimeMillis);
            byte[] bytes2 = d.getBytes(nanoTime);
            byte[] bytes3 = d.getBytes(nextInt);
            byte[] bytes4 = d.getBytes(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(bytes, 0, bArr, 0, 4);
            System.arraycopy(bytes2, 0, bArr, 4, 4);
            System.arraycopy(bytes3, 0, bArr, 8, 4);
            System.arraycopy(bytes4, 0, bArr, 12, 4);
            return b.encodeToString(bArr, 2);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!c.a() && context != null) {
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Exception unused) {
                }
                if (telephonyManager != null) {
                    str = ApiReplaceUtil.getDeviceId(telephonyManager);
                    if (g.m93a(str)) {
                        str = b();
                    }
                    if (g.m93a(str)) {
                        str = b(context);
                    }
                    if (!g.m93a(str)) {
                        return a();
                    }
                    return str;
                }
            }
            str = null;
            if (g.m93a(str)) {
            }
            if (g.m93a(str)) {
            }
            if (!g.m93a(str)) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = h.get("ro.aliyun.clouduuid", "");
            if (TextUtils.isEmpty(str)) {
                str = h.get("ro.sys.aliyun.clouduuid", "");
            }
            if (TextUtils.isEmpty(str)) {
                return c();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = "";
            try {
                string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Throwable unused) {
            }
            try {
                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("a5f5faddde9e9f02") && !string.equalsIgnoreCase("8e17f7422b35fbea")) {
                    if (!string.equalsIgnoreCase("0000000000000000")) {
                        return string;
                    }
                }
                return "";
            } catch (Throwable unused2) {
                str = string;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String subscriberId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context != null) {
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Exception unused) {
                }
                if (telephonyManager != null) {
                    subscriberId = ApiReplaceUtil.getSubscriberId(telephonyManager);
                    if (!g.m93a(subscriberId)) {
                        return a();
                    }
                    return subscriberId;
                }
            }
            subscriberId = null;
            if (!g.m93a(subscriberId)) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
