package com.kwai.video.player;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.getkeepsafe.relinker.ReLinker;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class KsMediaPlayerInitConfig {
    public static /* synthetic */ Interceptable $ic;
    public static String packageName;
    public static String packageVersion;
    public static volatile KsSoLoader sInjectedSoLoader;
    public static AtomicBoolean sSoLibInited;
    public static OnceReadyBarrier sSoLibReadyBarrirer;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1068180421, "Lcom/kwai/video/player/KsMediaPlayerInitConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1068180421, "Lcom/kwai/video/player/KsMediaPlayerInitConfig;");
                return;
            }
        }
        sSoLibInited = new AtomicBoolean(false);
        sSoLibReadyBarrirer = new OnceReadyBarrier();
    }

    public KsMediaPlayerInitConfig() {
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

    public static int getPlayerAliveCnt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (isSoLibInited()) {
                return KwaiMediaPlayer._getPlayerAliveCnt();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            KsSoLoader ksSoLoader = new KsSoLoader(sInjectedSoLoader, context.getApplicationContext()) { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$appContext;
                public final /* synthetic */ KsSoLoader val$injectLoader;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$injectLoader = r6;
                    this.val$appContext = r7;
                }

                @Override // com.kwai.video.player.KsSoLoader
                public void loadLibrary(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        KsSoLoader ksSoLoader2 = this.val$injectLoader;
                        if (ksSoLoader2 != null) {
                            ksSoLoader2.loadLibrary(str);
                        } else if (this.val$appContext != null) {
                            ReLinker.recursively().loadLibrary(this.val$appContext, str);
                        } else {
                            System.loadLibrary(str);
                        }
                    }
                }
            };
            ksSoLoader.loadLibrary("c++_shared");
            ksSoLoader.loadLibrary("kwaiplayer");
            sSoLibInited.set(true);
            sSoLibReadyBarrirer.setReady();
            Timber.v("[KsMediaPlayerInitConfig.init] to KwaiMediaPlayer.native_init", new Object[0]);
            KwaiMediaPlayer.native_init();
            Timber.v("[KsMediaPlayerInitConfig.init] to initPackageName", new Object[0]);
            initPackageName(context);
            Timber.v("[KsMediaPlayerInitConfig.init] all finish", new Object[0]);
        }
    }

    public static void initAsync(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, context) == null) {
            new Thread(context) { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsMediaPlayerInitConfig.init(this.val$context);
                    }
                }
            }.start();
        }
    }

    public static void initPackageName(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    packageName = packageInfo.packageName;
                    packageVersion = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean isSoLibInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sSoLibInited.get() : invokeV.booleanValue;
    }

    public static void setReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            sSoLibReadyBarrirer.setReady();
        }
    }

    public static void setSoLoader(KsSoLoader ksSoLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ksSoLoader) == null) {
            sInjectedSoLoader = ksSoLoader;
        }
    }

    public static void waitSoLibReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            AwesomeCacheInitConfig.waitSoLibReady();
            sSoLibReadyBarrirer.waitReady();
        }
    }
}
