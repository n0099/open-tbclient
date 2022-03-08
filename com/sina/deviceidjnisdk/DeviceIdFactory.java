package com.sina.deviceidjnisdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DeviceIdFactory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IDeviceId sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1802189409, "Lcom/sina/deviceidjnisdk/DeviceIdFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1802189409, "Lcom/sina/deviceidjnisdk/DeviceIdFactory;");
                return;
            }
        }
        System.loadLibrary("weibosdkcore");
    }

    public DeviceIdFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native String calculateM(Context context, String str, String str2);

    public static synchronized String getIValue(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (DeviceIdFactory.class) {
                try {
                    String deviceId = DeviceInfo.getDeviceId(context);
                    if (TextUtils.isEmpty(deviceId)) {
                        deviceId = DeviceInfo.getMacAddress(context);
                    }
                    if (TextUtils.isEmpty(deviceId)) {
                        deviceId = "000000000000000";
                    }
                    if (!TextUtils.isEmpty(deviceId)) {
                        return getIValueNative(context, deviceId);
                    }
                } catch (Exception unused) {
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static native String getIValueNative(Context context, String str);

    public static synchronized IDeviceId getInstance(Context context) {
        InterceptResult invokeL;
        IDeviceId iDeviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (DeviceIdFactory.class) {
                if (sInstance == null) {
                    sInstance = new DeviceId(context);
                }
                iDeviceId = sInstance;
            }
            return iDeviceId;
        }
        return (IDeviceId) invokeL.objValue;
    }

    public static native IDeviceId getInstanceNative(Context context, int i2);
}
