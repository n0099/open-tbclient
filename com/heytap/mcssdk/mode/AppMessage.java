package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AppMessage extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBalanceTime;
    public String mContent;
    public int mDistinctBycontent;
    public long mEndDate;
    public int mForcedDelivery;
    public String mRule;
    public long mStartDate;
    public String mTimeRanges;
    public String mTitle;

    public AppMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTimeRanges = "08:00-22:00";
        this.mForcedDelivery = 0;
        this.mDistinctBycontent = 0;
    }

    public int getBalanceTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBalanceTime : invokeV.intValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContent : (String) invokeV.objValue;
    }

    public int getDistinctBycontent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDistinctBycontent : invokeV.intValue;
    }

    public long getEndDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEndDate : invokeV.longValue;
    }

    public int getForcedDelivery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mForcedDelivery : invokeV.intValue;
    }

    public String getRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRule : (String) invokeV.objValue;
    }

    public long getStartDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStartDate : invokeV.longValue;
    }

    public String getTimeRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTimeRanges : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    @Override // com.heytap.mcssdk.mode.Message
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 4098;
        }
        return invokeV.intValue;
    }

    public void setBalanceTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mBalanceTime = i;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mContent = str;
        }
    }

    public void setDistinctBycontent(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mDistinctBycontent = i;
        }
    }

    public void setEndDate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mEndDate = j;
        }
    }

    public void setForcedDelivery(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mForcedDelivery = i;
        }
    }

    public void setRule(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mRule = str;
        }
    }

    public void setStartDate(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.mStartDate = j;
        }
    }

    public void setTimeRanges(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mTimeRanges = str;
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mTitle = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "AppMessage{mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mStartDate=" + this.mStartDate + ", mEndDate=" + this.mEndDate + ", mBalanceTime=" + this.mBalanceTime + ", mTimeRanges='" + this.mTimeRanges + "', mRule='" + this.mRule + "', mForcedDelivery=" + this.mForcedDelivery + ", mDistinctBycontent=" + this.mDistinctBycontent + '}';
        }
        return (String) invokeV.objValue;
    }
}
