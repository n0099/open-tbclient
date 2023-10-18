package com.fun.ad.sdk.channel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ModuleAdConfig;
/* loaded from: classes9.dex */
public class ModuleConfigBaidu extends ModuleAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean bdCanReadAppList;
    public final boolean bdCanReadDeviceId;
    public final boolean bdCanUseLocation;
    public final boolean bdCanUseStorage;

    /* renamed from: com.fun.ad.sdk.channel.ModuleConfigBaidu$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean canReadAppList;
        public boolean canReadDeviceId;
        public boolean canUseLocation;
        public boolean canUseStorage;

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
            this.canReadDeviceId = true;
            this.canUseLocation = true;
            this.canUseStorage = true;
            this.canReadAppList = true;
        }

        public ModuleConfigBaidu build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ModuleConfigBaidu(this, null) : (ModuleConfigBaidu) invokeV.objValue;
        }

        public Builder setIsCanReadAppList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.canReadAppList = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsCanReadDeviceId(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.canReadDeviceId = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsCanUseLocation(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.canUseLocation = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsCanUseStorage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.canUseStorage = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public ModuleConfigBaidu(Builder builder) {
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
        this.bdCanReadAppList = builder.canReadAppList;
        this.bdCanUseLocation = builder.canUseLocation;
        this.bdCanUseStorage = builder.canUseStorage;
        this.bdCanReadDeviceId = builder.canReadDeviceId;
    }

    public /* synthetic */ ModuleConfigBaidu(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
