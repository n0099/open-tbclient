package com.kwad.components.core.internal.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.config.d;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -154151744722615768L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean dataFlowAutoStart;
    public int dataFlowAutoStartValue;
    public boolean hasNoCache;
    public int videoAutoPlayType;
    public boolean videoSoundEnable;
    public int videoSoundValue;

    public KSAdVideoPlayConfigImpl() {
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
        this.videoSoundValue = 0;
        this.dataFlowAutoStartValue = 0;
        this.dataFlowAutoStart = d.K();
    }

    public int getDataFlowAutoStartValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataFlowAutoStartValue : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public int getVideoAutoPlayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.videoAutoPlayType : invokeV.intValue;
    }

    public int getVideoSoundValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.videoSoundValue : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dataFlowAutoStart : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isNoCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hasNoCache : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.videoSoundEnable : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.dataFlowAutoStart = z;
            this.dataFlowAutoStartValue = 1;
            this.videoAutoPlayType = 0;
        }
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setNoCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.hasNoCache = true;
        }
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoAutoPlayType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.videoAutoPlayType = i;
            this.dataFlowAutoStartValue = 0;
        }
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.videoSoundEnable = z;
            this.videoSoundValue = 1;
        }
    }
}
