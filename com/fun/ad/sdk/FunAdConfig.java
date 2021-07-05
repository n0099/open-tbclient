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
import com.bytedance.sdk.openadsdk.TTCustomController;
/* loaded from: classes6.dex */
public final class FunAdConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;
    public final String appId;
    public final String appName;
    public final boolean isFilterDeepLinkAd;
    public final boolean isUseCloudAdConfiguration;
    public final boolean isUseTextureView;
    public final boolean isVideoDataFlowAutoStart;
    public final boolean isVideoSoundEnable;
    public final boolean ksCanReadICCID;
    public final boolean ksCanReadMacAddress;
    public final boolean ksCanReadNearbyWifiList;
    public final boolean logEnabled;
    public final int titleBarTheme;
    public final TTCustomController ttCustomCtr;
    public final String userId;

    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context appContext;
        public String appId;
        public String appName;
        public boolean filterDeepLinkAd;
        public boolean ksCanReadICCID;
        public boolean ksCanReadMacAddress;
        public boolean ksCanReadNearbyWifiList;
        public boolean logEnabled;
        public TTCustomController mTTCustomCtr;
        public int titleBarTheme;
        public boolean useCloudAdConfiguration;
        public boolean useTextureView;
        public String userId;
        public boolean videoDataFlowAutoStart;
        public boolean videoSoundEnable;

        public Builder(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.useTextureView = false;
            this.titleBarTheme = -1;
            this.videoSoundEnable = false;
            this.videoDataFlowAutoStart = false;
            this.logEnabled = false;
            this.useCloudAdConfiguration = true;
            this.filterDeepLinkAd = false;
            this.mTTCustomCtr = null;
            this.ksCanReadICCID = true;
            this.ksCanReadNearbyWifiList = true;
            this.ksCanReadMacAddress = true;
            this.appContext = context.getApplicationContext();
        }

        public FunAdConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new FunAdConfig(this, null) : (FunAdConfig) invokeV.objValue;
        }

        public Builder setAppId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.appId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.appName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFilterDeepLinkAd(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.filterDeepLinkAd = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadICCID(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.ksCanReadICCID = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadMacAddress(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.ksCanReadMacAddress = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadNearbyWifiList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.ksCanReadNearbyWifiList = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLogEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.logEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setTTCustomController(TTCustomController tTCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tTCustomController)) == null) {
                this.mTTCustomCtr = tTCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitleBarTheme(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.titleBarTheme = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUseCloudAdConfiguration(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.useCloudAdConfiguration = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseTextureView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.useTextureView = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.userId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoDataFlowAutoStart(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.videoDataFlowAutoStart = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.videoSoundEnable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.appContext = builder.appContext;
        this.appName = builder.appName;
        this.appId = builder.appId;
        this.isUseTextureView = builder.useTextureView;
        this.titleBarTheme = builder.titleBarTheme;
        this.isVideoSoundEnable = builder.videoSoundEnable;
        this.isVideoDataFlowAutoStart = builder.videoDataFlowAutoStart;
        this.logEnabled = builder.logEnabled;
        this.isUseCloudAdConfiguration = builder.useCloudAdConfiguration;
        this.isFilterDeepLinkAd = builder.filterDeepLinkAd;
        this.userId = builder.userId;
        this.ttCustomCtr = builder.mTTCustomCtr;
        this.ksCanReadICCID = builder.ksCanReadICCID;
        this.ksCanReadNearbyWifiList = builder.ksCanReadNearbyWifiList;
        this.ksCanReadMacAddress = builder.ksCanReadMacAddress;
    }

    public /* synthetic */ FunAdConfig(Builder builder, a aVar) {
        this(builder);
    }
}
