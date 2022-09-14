package com.yy.gslbsdk.control;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NetworkStatus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IP_V4 = 1;
    public static final int IP_V6 = 2;
    public static final int STATUS_IP_V4_AND_V6 = 3;
    public static final int STATUS_IP_V4_ONLY = 1;
    public static final int STATUS_IP_V6_ONLY = 2;
    public static final int STATUS_IP_V_NONE = 0;
    public static NetworkStatus sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mEnableV6;
    public int mStatus;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1339305767, "Lcom/yy/gslbsdk/control/NetworkStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1339305767, "Lcom/yy/gslbsdk/control/NetworkStatus;");
                return;
            }
        }
        sInstance = new NetworkStatus();
    }

    public NetworkStatus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnableV6 = true;
        this.mStatus = 0;
    }

    public static NetworkStatus getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new NetworkStatus();
            }
            return sInstance;
        }
        return (NetworkStatus) invokeV.objValue;
    }

    public static NetworkStatus getInstanceClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? getInstance().m693clone() : (NetworkStatus) invokeV.objValue;
    }

    public static void updateEnableV6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            getInstance().mEnableV6 = z;
        }
    }

    public static void updateStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            getInstance().mStatus = i;
        }
    }

    public boolean canV4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (this.mStatus == 1) || ((this.mStatus & 1) > 0) || this.mStatus == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean canV6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = (this.mStatus & 2) > 0;
            if (this.mStatus == 2) {
                return true;
            }
            return this.mEnableV6 && z;
        }
        return invokeV.booleanValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public boolean isEnableV6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mEnableV6 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[2];
            objArr[0] = this.mEnableV6 ? "true" : "false";
            objArr[1] = Integer.valueOf(this.mStatus);
            return String.format(locale, "[EnableV6=%s, Status=%d]", objArr);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public NetworkStatus m693clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NetworkStatus networkStatus = new NetworkStatus();
            networkStatus.mEnableV6 = this.mEnableV6;
            networkStatus.mStatus = this.mStatus;
            return networkStatus;
        }
        return (NetworkStatus) invokeV.objValue;
    }
}
