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
import java.io.Serializable;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public interface KsVideoPlayConfig extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean showLandscape;
        public String showScene;
        public boolean skipLongTime;
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
                    return;
                }
            }
            this.videoSoundEnable = true;
        }

        @KsAdSdkApi
        @Keep
        public KsVideoPlayConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
                ksVideoPlayConfig.setShowScene(this.showScene);
                ksVideoPlayConfig.setShowLandscape(this.showLandscape);
                ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
                ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
                return ksVideoPlayConfig;
            }
            return (KsVideoPlayConfig) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder showLandscape(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.showLandscape = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder showScene(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.showScene = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder skipThirtySecond(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.skipLongTime = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.videoSoundEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @KsAdSdkApi
    @Keep
    String getShowScene();

    @KsAdSdkApi
    @Keep
    boolean isShowLandscape();

    @KsAdSdkApi
    @Keep
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setShowLandscape(boolean z);

    @KsAdSdkApi
    @Keep
    void setShowScene(String str);

    @KsAdSdkApi
    @Keep
    void setSkipThirtySecond(boolean z);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z);
}
