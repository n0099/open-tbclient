package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.b;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes2.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public KsScene scene;

        @KsAdSdkApi
        @Keep
        public Builder(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j2);
        }

        @KsAdSdkApi
        @Keep
        public Builder action(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.scene.setAction(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder adLabel(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.scene.setKsAdLabel(bVar);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder adNum(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.scene.setAdNum(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public KsScene build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.scene : (KsScene) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder height(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.scene.setHeight(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder needShowMiniWindow(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.scene.needShowMiniWindow(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder posId(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                this.scene.setPosId(j2);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder promoteId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.scene.setPromoteId(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map)) == null) {
                this.scene.setRewardCallbackExtraData(map);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder screenOrientation(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.scene.setScreenOrientation(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBackUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.scene.setBackUrl(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setComment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.scene.setComment(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateBuying(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.scene.setUserCommRateBuying(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateSharing(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.scene.setUserCommRateSharing(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.scene.setWidth(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    @KsAdSdkApi
    @Keep
    int getAction();

    @KsAdSdkApi
    @Keep
    int getAdNum();

    @KsAdSdkApi
    @Keep
    int getAdStyle();

    @KsAdSdkApi
    @Keep
    String getBackUrl();

    @KsAdSdkApi
    @Keep
    String getComment();

    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    long getPosId();

    @KsAdSdkApi
    @Keep
    String getPromoteId();

    @KsAdSdkApi
    @Keep
    Map<String, String> getRewardCallbackExtraData();

    @KsAdSdkApi
    @Keep
    int getScreenOrientation();

    @KsAdSdkApi
    @Keep
    long getUserCommRateBuying();

    @KsAdSdkApi
    @Keep
    long getUserCommRateSharing();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    void needShowMiniWindow(boolean z);

    @KsAdSdkApi
    @Keep
    void setAction(int i2);

    @KsAdSdkApi
    @Keep
    void setAdNum(int i2);

    @KsAdSdkApi
    @Keep
    void setAdStyle(int i2);

    @KsAdSdkApi
    @Keep
    void setBackUrl(String str);

    @KsAdSdkApi
    @Keep
    void setComment(String str);

    @KsAdSdkApi
    @Keep
    void setHeight(int i2);

    @KsAdSdkApi
    @Keep
    void setKsAdLabel(com.kwad.sdk.api.model.a aVar);

    @KsAdSdkApi
    @Keep
    void setPosId(long j2);

    @KsAdSdkApi
    @Keep
    void setPromoteId(String str);

    @KsAdSdkApi
    @Keep
    void setRewardCallbackExtraData(Map<String, String> map);

    @KsAdSdkApi
    @Keep
    void setScreenOrientation(int i2);

    @KsAdSdkApi
    @Keep
    void setUserCommRateBuying(int i2);

    @KsAdSdkApi
    @Keep
    void setUserCommRateSharing(int i2);

    @KsAdSdkApi
    @Keep
    void setWidth(int i2);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
