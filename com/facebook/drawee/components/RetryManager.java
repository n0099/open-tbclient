package com.facebook.drawee.components;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RetryManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_TAP_TO_RETRY_ATTEMPTS = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaxTapToRetryAttempts;
    public int mTapToRetryAttempts;
    public boolean mTapToRetryEnabled;

    public RetryManager() {
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
        init();
    }

    public static RetryManager newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new RetryManager();
        }
        return (RetryManager) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTapToRetryEnabled = false;
            this.mMaxTapToRetryAttempts = 4;
            reset();
        }
    }

    public boolean isTapToRetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTapToRetryEnabled;
        }
        return invokeV.booleanValue;
    }

    public void notifyTapToRetry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTapToRetryAttempts++;
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mTapToRetryAttempts = 0;
        }
    }

    public boolean shouldRetryOnTap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mTapToRetryEnabled && this.mTapToRetryAttempts < this.mMaxTapToRetryAttempts) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setMaxTapToRetryAttemps(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mMaxTapToRetryAttempts = i;
        }
    }

    public void setTapToRetryEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mTapToRetryEnabled = z;
        }
    }
}
