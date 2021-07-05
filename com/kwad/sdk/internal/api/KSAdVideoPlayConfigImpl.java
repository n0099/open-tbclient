package com.kwad.sdk.internal.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -154151744722615768L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean dataFlowAutoStart;
    public boolean videoSoundEnable;

    public KSAdVideoPlayConfigImpl() {
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

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataFlowAutoStart : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.videoSoundEnable : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.dataFlowAutoStart = z;
        }
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.videoSoundEnable = z;
        }
    }
}
