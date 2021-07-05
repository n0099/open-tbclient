package com.kuaishou.aegon;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.CronetEngine$Builder$LibraryLoader;
import aegon.chrome.net.impl.CronetLibraryLoader;
import aegon.chrome.net.impl.CronetUrlRequestContext;
import aegon.chrome.net.impl.NativeCronetEngineBuilderWithLibraryLoaderImpl;
import aegon.chrome.net.impl.VersionSafeCallbacks$LibraryLoader;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class Aegon {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CREATE_CRONET_CONTEXT_DELAY_MS = 3000;
    public static String LIBRARY_NAME = "aegon";
    public static final String TAG = "Aegon";
    public static Context sApplicationContext;
    public static volatile CronetUrlRequestContext sCronetContext;
    public static final Object sCronetContextMutex;
    public static AtomicBoolean sInitialized;
    public static SignalStrengthListener sSignalStrengthListener;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static abstract class LibraryLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LibraryLoader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void loadLibrary(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-882355090, "Lcom/kuaishou/aegon/Aegon;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-882355090, "Lcom/kuaishou/aegon/Aegon;");
                return;
            }
        }
        sCronetContextMutex = new Object();
        sInitialized = new AtomicBoolean();
    }

    public Aegon() {
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

    public static void addExtraRequestHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$15.$ic);
        }
    }

    public static void addLogger(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            AegonLoggerDispatcher.a(aVar);
        }
    }

    public static void clearHttpCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, null) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$7.$ic);
        }
    }

    @Nullable
    public static CronetEngine getCronetEngine() {
        InterceptResult invokeV;
        CronetUrlRequestContext cronetUrlRequestContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            CronetUrlRequestContext cronetUrlRequestContext2 = sCronetContext;
            if (cronetUrlRequestContext2 != null) {
                return cronetUrlRequestContext2;
            }
            if (sInitialized.get()) {
                synchronized (sCronetContextMutex) {
                    if (sCronetContext == null && sApplicationContext != null) {
                        long nanoTime = System.nanoTime();
                        NativeCronetEngineBuilderWithLibraryLoaderImpl nativeCronetEngineBuilderWithLibraryLoaderImpl = new NativeCronetEngineBuilderWithLibraryLoaderImpl(sApplicationContext);
                        nativeCronetEngineBuilderWithLibraryLoaderImpl.mLibraryLoader = new VersionSafeCallbacks$LibraryLoader(new CronetEngine$Builder$LibraryLoader() { // from class: com.kuaishou.aegon.Aegon.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // aegon.chrome.net.CronetEngine$Builder$LibraryLoader
                            public void loadLibrary(String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                }
                            }
                        });
                        sCronetContext = new CronetUrlRequestContext(nativeCronetEngineBuilderWithLibraryLoaderImpl);
                        CronetLibraryLoader.postToInitThread(Aegon$$Lambda$10.$ic);
                        com.kuaishou.aegon.a.a.a(Aegon$$Lambda$11.$ic);
                        long nanoTime2 = System.nanoTime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Create cronet engine finished, cost = ");
                        sb.append(nanoTime2 - nanoTime);
                        Log.i(TAG, sb.toString());
                    }
                    cronetUrlRequestContext = sCronetContext;
                }
                return cronetUrlRequestContext;
            }
            return null;
        }
        return (CronetEngine) invokeV.objValue;
    }

    public static String getEffectiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? !sInitialized.get() ? "" : (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$3.$ic) : (String) invokeV.objValue;
    }

    public static long getHttpCacheUsedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (sInitialized.get()) {
                return ((Long) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$6.$ic)).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static String getPublicIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? !sInitialized.get() ? "" : (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$17.$ic) : (String) invokeV.objValue;
    }

    @Nullable
    public static String getVersionString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (sInitialized.get()) {
                return (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$12.$ic);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static void initialize(Context context, @Nullable String str, @Nullable String str2, @Nullable LibraryLoader libraryLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, context, str, str2, libraryLoader) == null) {
            Log.i(TAG, "Initializing, jsonConfig=" + str + ", storagePath=" + str2);
            long nanoTime = System.nanoTime();
            if (libraryLoader != null) {
                libraryLoader.loadLibrary(LIBRARY_NAME);
            } else {
                System.loadLibrary(LIBRARY_NAME);
            }
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$1.$ic);
            long nanoTime2 = System.nanoTime();
            Log.i(TAG, "Initialize finished, cost = " + (nanoTime2 - nanoTime));
            sApplicationContext = context;
            sInitialized.set(true);
            new Handler(context.getMainLooper()).postDelayed(Aegon$$Lambda$2.$ic, 3000L);
        }
    }

    public static boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? sInitialized.get() : invokeV.booleanValue;
    }

    public static native void nativeAddExtraRequestHeader(String str, String str2);

    public static native void nativeClearHttpCache();

    public static native String nativeGetEffectiveConfig();

    public static native long nativeGetHttpCacheUsedBytes();

    public static native String nativeGetPublicIP();

    public static native String nativeGetRequestExtraInfo(String str);

    public static native String nativeGetVersionString();

    public static native void nativeOnBackground();

    public static native void nativeOnForeground();

    public static native void nativeSetAutonomousNetworkAccessAllowed(boolean z);

    public static native void nativeSetDebug(boolean z);

    public static native void nativeSetInitialized(boolean z);

    public static native void nativeSetLoggingCallback(long j, boolean z);

    public static native void nativeSetPreconnectUrls(String str, String[] strArr);

    public static native void nativeUpdateConfig(String str, String str2);

    public static void onBackground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65573, null) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$8.$ic);
        }
    }

    public static void onForeground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, null) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$9.$ic);
        }
    }

    public static void removeLogger(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, aVar) == null) {
            AegonLoggerDispatcher.b(aVar);
        }
    }

    public static void setAutonomousNetworkAccessAllowed(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65576, null, z) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$16.$ic);
        }
    }

    public static void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65577, null, z) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$4.$ic);
        }
    }

    public static void setLoggingCallback(d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65578, null, dVar, z) == null) {
            AegonLoggingDispatcher.f34010a = dVar;
            if (sInitialized.get()) {
                com.kuaishou.aegon.a.a.b(Aegon$$Lambda$14.$ic);
            }
        }
    }

    public static void setNativeLoggingCallbackFunction(long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$13.$ic);
        }
    }

    public static void setPreconnectUrls(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65580, null, str, strArr) == null) && sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$5.$ic);
        }
    }

    public static void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, null) == null) {
            synchronized (sCronetContextMutex) {
                if (sCronetContext == null) {
                    return;
                }
                sCronetContext.shutdown();
                sCronetContext = null;
            }
        }
    }
}
