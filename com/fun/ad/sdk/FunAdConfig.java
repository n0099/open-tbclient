package com.fun.ad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public final class FunAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;
    public final String appId;
    public final String appName;
    public final Set<String> forbiddenPlatforms;
    public final boolean isUseCloudAdConfiguration;
    public final boolean isUseTextureView;
    public final boolean isVideoDataFlowAutoStart;
    public final boolean isVideoSoundEnable;
    public final boolean logEnabled;
    public final Map<String, ModuleAdConfig> moduleConfigMap;
    public final FunModuleInitManager moduleInitManager;
    public final FunRuntimeAdConfig runtimeAdConfig;
    public final String userId;

    /* renamed from: com.fun.ad.sdk.FunAdConfig$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public FunAdConfig(Builder builder) {
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
        this.appContext = builder.a;
        this.appName = builder.b;
        this.appId = builder.c;
        this.isUseTextureView = builder.d;
        this.isVideoSoundEnable = builder.e;
        this.isVideoDataFlowAutoStart = builder.f;
        this.logEnabled = builder.g;
        this.isUseCloudAdConfiguration = builder.h;
        this.userId = builder.i;
        this.forbiddenPlatforms = Collections.unmodifiableSet(builder.j);
        this.moduleConfigMap = builder.moduleConfigMap;
        this.runtimeAdConfig = new FunRuntimeAdConfig();
        this.moduleInitManager = new FunModuleInitManager();
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public String i;
        public final Set<String> j;
        public final Map<String, ModuleAdConfig> moduleConfigMap;

        public Builder(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = true;
            this.j = new HashSet();
            this.moduleConfigMap = new HashMap();
            this.a = context.getApplicationContext();
        }

        public Builder forbiddenPlatform(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.j.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAmAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_AM, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBzAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_BZ, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCsjAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_CSJ, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setGdtAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_GDT, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIsAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put("is", moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setKsAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_KS, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLogEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMaxAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_MAX, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMmAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_MM, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPgAdConfig(ModuleAdConfig moduleAdConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, moduleAdConfig)) == null) {
                this.moduleConfigMap.put(FunAdSdk.PLATFORM_PG, moduleAdConfig);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUseCloudAdConfiguration(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseTextureView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.i = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoDataFlowAutoStart(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.f = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                this.e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public FunAdConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new FunAdConfig(this);
            }
            return (FunAdConfig) invokeV.objValue;
        }
    }
}
