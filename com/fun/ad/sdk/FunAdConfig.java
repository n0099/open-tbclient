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
/* loaded from: classes11.dex */
public final class FunAdConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;
    public final String appId;
    public final String appName;
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
    public final int titleBarTheme;
    public final TTCustomController ttCustomCtr;
    public final String userId;

    /* renamed from: com.fun.ad.sdk.FunAdConfig$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f62715a;

        /* renamed from: b  reason: collision with root package name */
        public String f62716b;

        /* renamed from: c  reason: collision with root package name */
        public String f62717c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62718d;

        /* renamed from: e  reason: collision with root package name */
        public int f62719e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f62720f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62721g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f62722h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f62723i;
        public boolean j;
        public TTCustomController k;
        public KsCustomController l;
        public String m;
        public Set<String> n;
        public boolean o;
        public boolean p;
        public boolean q;

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
            this.f62718d = false;
            this.f62719e = -1;
            this.f62720f = false;
            this.f62721g = false;
            this.f62722h = false;
            this.f62723i = true;
            this.j = false;
            this.k = null;
            this.l = null;
            this.n = new HashSet();
            this.o = true;
            this.p = true;
            this.q = true;
            this.f62715a = context.getApplicationContext();
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
                this.n.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f62717c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f62716b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFilterDeepLinkAd(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadICCID(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadMacAddress(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.q = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCanReadNearbyWifiList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.p = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setKsCustomController(KsCustomController ksCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksCustomController)) == null) {
                this.l = ksCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLogEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f62722h = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setTTCustomController(TTCustomController tTCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tTCustomController)) == null) {
                this.k = tTCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitleBarTheme(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f62719e = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUseCloudAdConfiguration(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.f62723i = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUseTextureView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.f62718d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setUserId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoDataFlowAutoStart(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.f62721g = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoSoundEnable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.f62720f = z;
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
        this.appContext = builder.f62715a;
        this.appName = builder.f62716b;
        this.appId = builder.f62717c;
        this.isUseTextureView = builder.f62718d;
        this.titleBarTheme = builder.f62719e;
        this.isVideoSoundEnable = builder.f62720f;
        this.isVideoDataFlowAutoStart = builder.f62721g;
        this.logEnabled = builder.f62722h;
        this.isUseCloudAdConfiguration = builder.f62723i;
        this.isFilterDeepLinkAd = builder.j;
        this.userId = builder.m;
        this.forbiddenPlatforms = Collections.unmodifiableSet(builder.n);
        this.ttCustomCtr = builder.k;
        this.ksCustomCtr = builder.l;
        this.ksCanReadICCID = builder.o;
        this.ksCanReadNearbyWifiList = builder.p;
        this.ksCanReadMacAddress = builder.q;
    }
}
