package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.az;
/* loaded from: classes8.dex */
public final class d implements IEnvironment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KsAdSDKImpl.get().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsAdSDKImpl.get().getContext() : (Context) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? az.getDeviceId() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getProcessName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? SystemUtil.getProcessName(context) : (String) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BuildConfig.VERSION_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? o.getUserAgent() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isArm64(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? AbiUtil.isArm64(context) : invokeL.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDevelopEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.components.core.a.aw.booleanValue() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isInMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? SystemUtil.isInMainProcess(context) : invokeL.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String localIpAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "10.244.50.216" : (String) invokeV.objValue;
    }
}
