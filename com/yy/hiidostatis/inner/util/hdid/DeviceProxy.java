package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes8.dex */
public class DeviceProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return getDevice(context).arid;
        }
        return (String) invokeL.objValue;
    }

    public static long getCreateTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return getDevice(context).crtTime;
        }
        return invokeL.longValue;
    }

    public static Device getDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return DeviceManagerV2.instance.getDevice(context);
        }
        return (Device) invokeL.objValue;
    }

    public static int getHFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return getDevice(context).hFrom;
        }
        return invokeL.intValue;
    }

    public static String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return getDevice(context).hdid;
        }
        return (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return getDevice(context).imei;
        }
        return (String) invokeL.objValue;
    }

    public static String getMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return getDevice(context).mac;
        }
        return (String) invokeL.objValue;
    }

    public static String getSdPermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return getDevice(context).sdPermission;
        }
        return (String) invokeL.objValue;
    }

    public static String getType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            return getDevice(context).type;
        }
        return (String) invokeL.objValue;
    }

    public static void test(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            L.debug("DeviceProxy", "DeviceTest:%d==>%s,%s,%s,%s,%s,%d,%s,%d,%d", Long.valueOf(Thread.currentThread().getId()), getHdid(context), getImei(context), getMac(context), getAndroidId(context), getType(context) + "", Integer.valueOf(getHFrom(context)), getSdPermission(context), Long.valueOf(getCreateTime(context)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
