package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsAdVideoPlayConfig {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean dataFlowAutoStart;
        public boolean videoSoundEnable;

        public Builder() {
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

        @KsAdSdkApi
        @Keep
        public KsAdVideoPlayConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                KsAdVideoPlayConfig ksAdVideoPlayConfig = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);
                ksAdVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
                ksAdVideoPlayConfig.setDataFlowAutoStart(this.dataFlowAutoStart);
                return ksAdVideoPlayConfig;
            }
            return (KsAdVideoPlayConfig) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder dataFlowAutoStart(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.dataFlowAutoStart = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.videoSoundEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @KsAdSdkApi
    @Keep
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setDataFlowAutoStart(boolean z);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z);
}
