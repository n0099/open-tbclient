package com.kwai.video.cache;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.getkeepsafe.relinker.ReLinker;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.Hodor;
import com.kwai.video.hodor.HodorConfig;
import com.kwai.video.hodor.NetworkMonitor;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes7.dex */
public class AwesomeCacheInitConfig {
    public static /* synthetic */ Interceptable $ic;
    public static boolean mInited;
    public static volatile AwesomeCacheSoLoader sAwesomeCacheSoLoader;
    public static OnceReadyBarrier sSoLibReadyBarrirer;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1135482504, "Lcom/kwai/video/cache/AwesomeCacheInitConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1135482504, "Lcom/kwai/video/cache/AwesomeCacheInitConfig;");
                return;
            }
        }
        sSoLibReadyBarrirer = new OnceReadyBarrier();
    }

    public AwesomeCacheInitConfig() {
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

    public static synchronized void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (AwesomeCacheInitConfig.class) {
                if (mInited) {
                    return;
                }
                Context applicationContext = context == null ? null : context.getApplicationContext();
                AwesomeCacheSoLoader awesomeCacheSoLoader = new AwesomeCacheSoLoader(sAwesomeCacheSoLoader, applicationContext) { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ AwesomeCacheSoLoader val$injectSoLoader;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r6, applicationContext};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$injectSoLoader = r6;
                        this.val$appContext = applicationContext;
                    }

                    @Override // com.kwai.video.cache.AwesomeCacheSoLoader
                    public void loadLibrary(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            AwesomeCacheSoLoader awesomeCacheSoLoader2 = this.val$injectSoLoader;
                            if (awesomeCacheSoLoader2 != null) {
                                awesomeCacheSoLoader2.loadLibrary(str);
                            } else if (this.val$appContext != null) {
                                ReLinker.recursively().loadLibrary(this.val$appContext, str);
                            } else {
                                Timber.w("WARNING! AwesomeCacheSoLoader is using System.loadLibrary", new Object[0]);
                                System.loadLibrary(str);
                            }
                        }
                    }
                };
                awesomeCacheSoLoader.loadLibrary("c++_shared");
                awesomeCacheSoLoader.loadLibrary("aegon");
                awesomeCacheSoLoader.loadLibrary("hodor");
                sSoLibReadyBarrirer.setReady();
                Hodor.loadJavaClass();
                HodorConfig.init(context);
                AwesomeCache.VodAdaptive.init(context);
                NetworkMonitor.initNetworkChangeReceiver(applicationContext);
                mInited = true;
            }
        }
    }

    public static void initAsync(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            new Thread(context) { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.2
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
                        AwesomeCacheInitConfig.init(this.val$context);
                    }
                }
            }.start();
        }
    }

    public static void setReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            sSoLibReadyBarrirer.setReady();
        }
    }

    public static void setSoLoader(AwesomeCacheSoLoader awesomeCacheSoLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, awesomeCacheSoLoader) == null) {
            sAwesomeCacheSoLoader = awesomeCacheSoLoader;
        }
    }

    public static void waitSoLibReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            sSoLibReadyBarrirer.waitReady();
        }
    }
}
