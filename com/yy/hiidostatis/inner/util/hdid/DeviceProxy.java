package com.yy.hiidostatis.inner.util.hdid;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes2.dex */
public class DeviceProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? getDevice(context).arid : (String) invokeL.objValue;
    }

    public static long getCreateTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? getDevice(context).crtTime : invokeL.longValue;
    }

    public static Device getDevice(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? DeviceManagerV2.instance.getDevice(context) : (Device) invokeL.objValue;
    }

    public static int getHFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? getDevice(context).hFrom : invokeL.intValue;
    }

    public static String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? getDevice(context).hdid : (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? getDevice(context).imei : (String) invokeL.objValue;
    }

    public static String getMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? getDevice(context).mac : (String) invokeL.objValue;
    }

    public static String getSdPermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? getDevice(context).sdPermission : (String) invokeL.objValue;
    }

    public static String getType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? getDevice(context).type : (String) invokeL.objValue;
    }

    public static void test(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            L.debug("DeviceProxy", "DeviceTest:%d==>%s,%s,%s,%s,%s,%d,%s,%d,%d", Long.valueOf(Thread.currentThread().getId()), getHdid(context), getImei(context), getMac(context), getAndroidId(context), getType(context) + "", Integer.valueOf(getHFrom(context)), getSdPermission(context), Long.valueOf(getCreateTime(context)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
