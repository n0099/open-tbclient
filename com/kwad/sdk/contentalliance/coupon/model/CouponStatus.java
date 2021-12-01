package com.kwad.sdk.contentalliance.coupon.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CouponStatus extends a implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_COUPON_VIDEO_SECONDS = 5;
    public static final long serialVersionUID = 8301131859564901468L;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile SdkConfigData.CouponActiveConfig couponActiveConfig;
    public volatile CouponStatusInfo couponStatusInfo;
    public int currentWatchVideoCount;
    public int winningTimes;

    public CouponStatus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.couponActiveConfig = null;
        this.currentWatchVideoCount = 0;
        this.winningTimes = 0;
    }

    public int getCouponVideoSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.couponActiveConfig != null) {
                return this.couponActiveConfig.videoSeconds;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public int getCouponVideoThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.couponActiveConfig != null) {
                return this.couponActiveConfig.videoThreshold;
            }
            return Integer.MAX_VALUE;
        }
        return invokeV.intValue;
    }

    public double getCurrTotalAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.couponStatusInfo != null) {
                return this.couponStatusInfo.currTotalAmount;
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.couponStatusInfo != null) {
                return this.couponStatusInfo.statusCode;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean isAccumulating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !isNewUser() && getStatusCode() == 0 && this.currentWatchVideoCount < this.couponActiveConfig.videoThreshold : invokeV.booleanValue;
    }

    public boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.couponActiveConfig != null && this.couponActiveConfig.videoThreshold > 0 && this.couponActiveConfig.videoSeconds > 0 : invokeV.booleanValue;
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.couponStatusInfo != null && this.couponStatusInfo.isNewUser : invokeV.booleanValue;
    }

    public boolean isWaitingOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isNewUser() || (getStatusCode() == 0 && this.currentWatchVideoCount == this.couponActiveConfig.videoThreshold) : invokeV.booleanValue;
    }

    public void setStatusCode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.couponStatusInfo == null) {
            return;
        }
        this.couponStatusInfo.statusCode = i2;
    }
}
