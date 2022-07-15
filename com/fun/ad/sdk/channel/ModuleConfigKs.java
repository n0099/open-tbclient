package com.fun.ad.sdk.channel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ModuleAdConfig;
import com.kwad.sdk.api.KsCustomController;
/* loaded from: classes4.dex */
public class ModuleConfigKs extends ModuleAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean ksCanReadICCID;
    public final boolean ksCanReadMacAddress;
    public final boolean ksCanReadNearbyWifiList;
    public final KsCustomController ksCustomCtr;
    public final boolean ksVideoSoundEnable;

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean ksCanReadICCID;
        public boolean ksCanReadMacAddress;
        public boolean ksCanReadNearbyWifiList;
        public boolean ksVideoSoundEnable;
        public KsCustomController mKsCustomCtr;

        public Builder() {
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
            this.ksCanReadICCID = true;
            this.ksCanReadNearbyWifiList = true;
            this.ksCanReadMacAddress = true;
            this.mKsCustomCtr = null;
            this.ksVideoSoundEnable = true;
        }

        public ModuleConfigKs build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ModuleConfigKs(this) : (ModuleConfigKs) invokeV.objValue;
        }

        public Builder setKsCanReadICCID(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.ksCanReadICCID = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadMacAddress(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.ksCanReadMacAddress = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadNearbyWifiList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.ksCanReadNearbyWifiList = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCustomController(KsCustomController ksCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ksCustomController)) == null) {
                this.mKsCustomCtr = ksCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.ksVideoSoundEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public ModuleConfigKs(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ksCustomCtr = builder.mKsCustomCtr;
        this.ksCanReadICCID = builder.ksCanReadICCID;
        this.ksCanReadNearbyWifiList = builder.ksCanReadNearbyWifiList;
        this.ksCanReadMacAddress = builder.ksCanReadMacAddress;
        this.ksVideoSoundEnable = builder.ksVideoSoundEnable;
    }
}
