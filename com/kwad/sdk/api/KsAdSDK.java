package com.kwad.sdk.api;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.c;
import com.kwad.sdk.api.loader.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public class KsAdSDK {
    public static /* synthetic */ Interceptable $ic;
    public static String sAppTag;
    public static final AtomicBoolean sInited;
    @Keep
    public static IKsAdSDK sSdk;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1869761628, "Lcom/kwad/sdk/api/KsAdSDK;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1869761628, "Lcom/kwad/sdk/api/KsAdSDK;");
                return;
            }
        }
        sInited = new AtomicBoolean(false);
    }

    public KsAdSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (iKsAdSDK = sSdk) == null) {
            return;
        }
        iKsAdSDK.deleteCache();
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.getAppId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.getAppName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.getDid();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @KsAdSdkApi
    @Keep
    public static KsLoadManager getLoadManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.getAdManager();
            }
            return null;
        }
        return (KsLoadManager) invokeV.objValue;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "3.3.11" : (String) invokeV.objValue;
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, sdkConfig)) == null) {
            synchronized (KsAdSDK.class) {
                try {
                    Context a2 = c.a(context);
                    Loader.get().init(a2);
                    IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                    sSdk = ksAdSDKImpl;
                    if (ksAdSDKImpl != null) {
                        ksAdSDKImpl.setApiVersion("3.3.11");
                        sSdk.setApiVersionCode(3031100);
                        sSdk.setAppTag(sAppTag);
                        sSdk.init(Wrapper.wrapContextIfNeed(a2), sdkConfig);
                    }
                    sInited.set(sSdk != null);
                    if (sdkConfig != null) {
                        q.a(a2, "sdkconfig", sdkConfig.toJson());
                    }
                    if (b.f71380a.booleanValue()) {
                        Loader.get().checkUpdate();
                    }
                    z = sInited.get();
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                return iKsAdSDK.isDebugLogEnable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (iKsAdSDK = sSdk) == null) {
            return;
        }
        iKsAdSDK.pauseCurrentPlayer();
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, null) == null) || (iKsAdSDK = sSdk) == null) {
            return;
        }
        iKsAdSDK.resumeCurrentPlayer();
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                iKsAdSDK.setAppTag(str);
            } else {
                sAppTag = str;
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z) {
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65550, null, z) == null) || (iKsAdSDK = sSdk) == null) {
            return;
        }
        iKsAdSDK.setPersonalRecommend(z);
    }

    public static void setThemeMode(int i2) {
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65551, null, i2) == null) || (iKsAdSDK = sSdk) == null) {
            return;
        }
        iKsAdSDK.setThemeMode(i2);
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            IKsAdSDK iKsAdSDK = sSdk;
            if (iKsAdSDK != null) {
                iKsAdSDK.unInit();
            }
            sSdk = null;
        }
    }
}
