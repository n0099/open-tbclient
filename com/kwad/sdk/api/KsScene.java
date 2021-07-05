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
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public KsScene scene;

        @KsAdSdkApi
        @Keep
        public Builder(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
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
            ksScene.setPosId(j);
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
        public Builder adNum(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.scene.setAdNum(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder adStyle(int i2) {
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
        public Builder posId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.scene.setPosId(j);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
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
    int getHeight();

    @KsAdSdkApi
    @Keep
    long getPosId();

    @KsAdSdkApi
    @Keep
    int getWidth();

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
    void setHeight(int i2);

    @KsAdSdkApi
    @Keep
    void setPosId(long j);

    @KsAdSdkApi
    @Keep
    void setWidth(int i2);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
