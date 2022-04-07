package com.vivo.push.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SubscribeAppInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SUBSCIRBE = 1;
    public static final int SUBSCIRBE_CANCLE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActualStatus;
    public String mName;
    public int mTargetStatus;

    public SubscribeAppInfo(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mName = str;
        this.mTargetStatus = i;
        this.mActualStatus = i2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SubscribeAppInfo.class == obj.getClass()) {
                SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) obj;
                String str = this.mName;
                if (str == null) {
                    if (subscribeAppInfo.mName != null) {
                        return false;
                    }
                } else if (!str.equals(subscribeAppInfo.mName)) {
                    return false;
                }
                return this.mTargetStatus == subscribeAppInfo.mTargetStatus;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getActualStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActualStatus : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    public int getTargetStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTargetStatus : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.mName;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.mTargetStatus;
        }
        return invokeV.intValue;
    }

    public void setActualStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.mActualStatus = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mName = str;
        }
    }

    public void setTargetStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mTargetStatus = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
