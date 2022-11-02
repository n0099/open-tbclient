package com.fun.ad.sdk.internal.api.flavor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.Set;
/* loaded from: classes7.dex */
public class DefaultPluginRC implements PluginRC {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PluginRC a;
    public final RCInterceptor b;
    public final RCInterceptor c;

    public DefaultPluginRC() {
        PluginRC pluginRC;
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
        this.b = new RCInterceptor(this) { // from class: com.fun.ad.sdk.internal.api.flavor.DefaultPluginRC.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                    }
                }
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean needRipper() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public void onAdClick(RippedAd rippedAd) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rippedAd) == null) {
                }
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public void onAdShow(RippedAd rippedAd) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) {
                }
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean shouldInterceptLoad() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean shouldInterceptShow(RippedAd rippedAd) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, rippedAd)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        this.c = new RCInterceptor(this) { // from class: com.fun.ad.sdk.internal.api.flavor.DefaultPluginRC.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DefaultPluginRC a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean needRipper() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FunAdSdk.isForBidShowInstalledApp() : invokeV.booleanValue;
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public void onAdClick(RippedAd rippedAd) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rippedAd) == null) {
                }
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public void onAdShow(RippedAd rippedAd) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, rippedAd) == null) {
                }
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean shouldInterceptLoad() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.fun.ad.sdk.internal.api.flavor.RCInterceptor
            public boolean shouldInterceptShow(RippedAd rippedAd) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, rippedAd)) == null) {
                    if (FunAdSdk.isForBidShowInstalledApp()) {
                        return DefaultPluginRC.a(this.a, rippedAd.appPkg);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
        String str = BuildConfig.PLUGIN_RC;
        if (!TextUtils.isEmpty(str)) {
            try {
                pluginRC = (PluginRC) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                LogPrinter.e(e);
            }
            this.a = pluginRC;
        }
        pluginRC = null;
        this.a = pluginRC;
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.PluginRC
    public void init(Context context) {
        PluginRC pluginRC;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (pluginRC = this.a) == null) {
            return;
        }
        pluginRC.init(context);
    }

    public static boolean a(DefaultPluginRC defaultPluginRC, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, defaultPluginRC, str)) == null) {
            defaultPluginRC.getClass();
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (FunAdSdk.getAppContext().getPackageManager().getApplicationInfo(str, 0) == null) {
                    return false;
                }
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                LogPrinter.d("not find app", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.flavor.PluginRC
    public RCInterceptor shouldIntercept(String str, FunAdType funAdType) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, funAdType)) == null) {
            Set<String> forbiddenPlatforms = FunAdSdk.getForbiddenPlatforms();
            if (forbiddenPlatforms != null && forbiddenPlatforms.contains(funAdType.getPlatform())) {
                return this.b;
            }
            String platform = funAdType.getPlatform();
            Set<Pair<String, String>> set = FunAdSdk.getsForbiddenAids();
            if (set != null) {
                for (Pair<String, String> pair : set) {
                    if (pair != null && str.equals(pair.second) && platform.equals(pair.first)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return this.b;
            }
            if (FunAdSdk.isForBidShowInstalledApp()) {
                return this.c;
            }
            PluginRC pluginRC = this.a;
            if (pluginRC != null) {
                return pluginRC.shouldIntercept(str, funAdType);
            }
            return null;
        }
        return (RCInterceptor) invokeLL.objValue;
    }
}
