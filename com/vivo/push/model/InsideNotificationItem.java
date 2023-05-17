package com.vivo.push.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAppType;
    public int mDisplayStyle;
    public int mInnerPriority;
    public boolean mIsShowBigPicOnMobileNet;
    public int mMessageType;
    public int mNotifyDisplayStatus;
    public String mReactPackage;
    public String mSuitReactVersion;

    public InsideNotificationItem() {
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

    private int parsingNotifyStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i = this.mDisplayStyle;
            if ((i & 32) != 0 || (i & 16) == 0) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int getAppType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAppType;
        }
        return invokeV.intValue;
    }

    public int getDisplayStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDisplayStyle;
        }
        return invokeV.intValue;
    }

    public int getInnerPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mInnerPriority;
        }
        return invokeV.intValue;
    }

    public int getMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMessageType;
        }
        return invokeV.intValue;
    }

    public int getNotifyDisplayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mNotifyDisplayStatus;
        }
        return invokeV.intValue;
    }

    public String getReactPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mReactPackage;
        }
        return (String) invokeV.objValue;
    }

    public String getSuitReactVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mSuitReactVersion;
        }
        return (String) invokeV.objValue;
    }

    public boolean isShowBigPicOnMobileNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIsShowBigPicOnMobileNet;
        }
        return invokeV.booleanValue;
    }

    public void setAppType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mAppType = i;
        }
    }

    public void setDisplayStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mDisplayStyle = i;
            this.mNotifyDisplayStatus = parsingNotifyStyle();
        }
    }

    public void setInnerPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mInnerPriority = i;
        }
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsShowBigPicOnMobileNet = z;
        }
    }

    public void setMessageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mMessageType = i;
        }
    }

    public void setReactPackage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mReactPackage = str;
        }
    }

    public void setSuitReactVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mSuitReactVersion = str;
        }
    }
}
