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
import com.kwad.sdk.api.KsCustomController;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class FunAdConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_TYPE_NO_POPUP = 0;
    public static final int DOWNLOAD_TYPE_POPUP = 1;
    public static final int SPLASH_BUTTON_TYPE_DOWNLOADER_BAR = 2;
    public static final int SPLASH_BUTTON_TYPE_FULL_SCREEN = 1;
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;
    public final String appId;
    public final String appName;
    public final int downLoadType;
    public final Set<String> forbiddenPlatforms;
    public final boolean isFilterDeepLinkAd;
    public final boolean isUseCloudAdConfiguration;
    public final boolean isUseTextureView;
    public final boolean isVideoDataFlowAutoStart;
    public final boolean isVideoSoundEnable;
    public final boolean ksCanReadICCID;
    public final boolean ksCanReadMacAddress;
    public final boolean ksCanReadNearbyWifiList;
    public final KsCustomController ksCustomCtr;
    public final boolean logEnabled;
    public final int splashButtonType;
    public final int titleBarTheme;
    public final TTCustomController ttCustomCtr;
    public final String userId;

    /* renamed from: com.fun.ad.sdk.FunAdConfig$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public String f56189b;

        /* renamed from: c  reason: collision with root package name */
        public String f56190c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56191d;

        /* renamed from: e  reason: collision with root package name */
        public int f56192e;

        /* renamed from: f  reason: collision with root package name */
        public int f56193f;

        /* renamed from: g  reason: collision with root package name */
        public int f56194g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f56195h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f56196i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f56197j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f56198k;
        public boolean l;
        public TTCustomController m;
        public KsCustomController n;
        public String o;
        public Set<String> p;
        public boolean q;
        public boolean r;
        public boolean s;

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
            this.f56191d = false;
            this.f56192e = -1;
            this.f56193f = 1;
            this.f56194g = 0;
            this.f56195h = false;
            this.f56196i = false;
            this.f56197j = false;
            this.f56198k = true;
            this.l = false;
            this.m = null;
            this.n = null;
            this.p = new HashSet();
            this.q = true;
            this.r = true;
            this.s = true;
            this.a = context.getApplicationContext();
        }

        public FunAdConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new FunAdConfig(this) : (FunAdConfig) invokeV.objValue;
        }

        public Builder forbiddenPlatform(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.p.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f56190c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f56189b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDownLoadType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f56194g = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFilterDeepLinkAd(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.l = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadICCID(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadMacAddress(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.s = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadNearbyWifiList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.r = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCustomController(KsCustomController ksCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ksCustomController)) == null) {
                this.n = ksCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLogEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f56197j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSplashButtonType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f56193f = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTTCustomController(TTCustomController tTCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tTCustomController)) == null) {
                this.m = tTCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitleBarTheme(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.f56192e = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUseCloudAdConfiguration(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.f56198k = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseTextureView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.f56191d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.o = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoDataFlowAutoStart(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.f56196i = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                this.f56195h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
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
        this.appContext = builder.a;
        this.appName = builder.f56189b;
        this.appId = builder.f56190c;
        this.isUseTextureView = builder.f56191d;
        this.titleBarTheme = builder.f56192e;
        this.splashButtonType = builder.f56193f;
        this.downLoadType = builder.f56194g;
        this.isVideoSoundEnable = builder.f56195h;
        this.isVideoDataFlowAutoStart = builder.f56196i;
        this.logEnabled = builder.f56197j;
        this.isUseCloudAdConfiguration = builder.f56198k;
        this.isFilterDeepLinkAd = builder.l;
        this.userId = builder.o;
        this.forbiddenPlatforms = Collections.unmodifiableSet(builder.p);
        this.ttCustomCtr = builder.m;
        this.ksCustomCtr = builder.n;
        this.ksCanReadICCID = builder.q;
        this.ksCanReadNearbyWifiList = builder.r;
        this.ksCanReadMacAddress = builder.s;
    }
}
