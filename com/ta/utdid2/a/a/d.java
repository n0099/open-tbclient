package com.ta.utdid2.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str = g.get("ro.aliyun.clouduuid", "");
            if (TextUtils.isEmpty(str)) {
                str = g.get("ro.sys.aliyun.clouduuid", "");
            }
            return TextUtils.isEmpty(str) ? b() : str;
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getDeviceId();
                    }
                } catch (Exception unused) {
                }
            }
            if (f.isEmpty(str)) {
                str = a();
            }
            return f.isEmpty(str) ? getUniqueID() : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getSubscriberId();
                    }
                } catch (Exception unused) {
                }
            }
            return f.isEmpty(str) ? getUniqueID() : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nanoTime = (int) System.nanoTime();
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] bytes = c.getBytes(currentTimeMillis);
            byte[] bytes2 = c.getBytes(nanoTime);
            byte[] bytes3 = c.getBytes(nextInt);
            byte[] bytes4 = c.getBytes(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(bytes, 0, bArr, 0, 4);
            System.arraycopy(bytes2, 0, bArr, 4, 4);
            System.arraycopy(bytes3, 0, bArr, 8, 4);
            System.arraycopy(bytes4, 0, bArr, 12, 4);
            return b.encodeToString(bArr, 2);
        }
        return (String) invokeV.objValue;
    }
}
