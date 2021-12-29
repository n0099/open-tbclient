package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.view.FlutterMain;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FlutterBoost {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sInit;
    public static FlutterBoost sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity coveredTransparentActivity;
    public boolean isCoverWithTransparentActivity;
    public boolean isCustomDartInitFinish;
    public Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    public Activity mCurrentActiveActivity;
    public FlutterEngine mEngine;
    public boolean mEnterActivityCreate;
    public FlutterViewContainerManager mManager;
    public Platform mPlatform;

    /* loaded from: classes3.dex */
    public interface BoostLifecycleListener {
        void beforeCreateEngine();

        void onEngineCreated();
    }

    /* loaded from: classes3.dex */
    public static class ConfigBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static int ANY_ACTIVITY_CREATED = 1;
        public static int FLUTTER_ACTIVITY_CREATED = 2;
        public static int IMMEDIATELY;
        public transient /* synthetic */ FieldHolder $fh;
        public String dartEntrypoint;
        public FlutterEngineProvider flutterEngineProvider;
        public Class<? extends FlutterView> flutterViewClass;
        public String initialRoute;
        public boolean isDebug;
        public BoostLifecycleListener lifecycleListener;
        public Application mApp;
        public FlutterView.RenderMode renderMode;
        public INativeRouter router;
        public List<String> shellArgs;
        public int whenEngineStart;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(34446944, "Lcom/idlefish/flutterboost/FlutterBoost$ConfigBuilder;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(34446944, "Lcom/idlefish/flutterboost/FlutterBoost$ConfigBuilder;");
            }
        }

        public ConfigBuilder(Application application, INativeRouter iNativeRouter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application, iNativeRouter};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.dartEntrypoint = "main";
            this.initialRoute = "/";
            this.whenEngineStart = ANY_ACTIVITY_CREATED;
            this.isDebug = false;
            this.renderMode = FlutterView.RenderMode.texture;
            this.router = null;
            this.flutterEngineProvider = null;
            this.flutterViewClass = null;
            this.router = iNativeRouter;
            this.mApp = application;
        }

        public Platform build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Platform platform = new Platform(this) { // from class: com.idlefish.flutterboost.FlutterBoost.ConfigBuilder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConfigBuilder this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public String dartEntrypoint() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.dartEntrypoint : (String) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public FlutterEngineProvider flutterEngineProvider() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.flutterEngineProvider : (FlutterEngineProvider) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public Application getApplication() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.mApp : (Application) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public Class<? extends FlutterView> getFlutterViewClass() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.flutterViewClass : (Class) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public String initialRoute() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) ? this.this$0.initialRoute : (String) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public boolean isDebug() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048581, this)) == null) ? this.this$0.isDebug : invokeV2.booleanValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public void openContainer(Context context, String str, Map<String, Object> map, int i2, Map<String, Object> map2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{context, str, map, Integer.valueOf(i2), map2}) == null) {
                            this.this$0.router.openContainer(context, str, map, i2, map2);
                        }
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public FlutterView.RenderMode renderMode() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048583, this)) == null) ? this.this$0.renderMode : (FlutterView.RenderMode) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public List<String> shellArgs() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.this$0.shellArgs : (List) invokeV2.objValue;
                    }

                    @Override // com.idlefish.flutterboost.Platform
                    public int whenEngineStart() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048585, this)) == null) ? this.this$0.whenEngineStart : invokeV2.intValue;
                    }
                };
                platform.lifecycleListener = this.lifecycleListener;
                return platform;
            }
            return (Platform) invokeV.objValue;
        }

        public ConfigBuilder isDebug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.isDebug = z;
                return this;
            }
            return (ConfigBuilder) invokeZ.objValue;
        }

        public ConfigBuilder lifecycleListener(BoostLifecycleListener boostLifecycleListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boostLifecycleListener)) == null) {
                this.lifecycleListener = boostLifecycleListener;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder renderMode(FlutterView.RenderMode renderMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, renderMode)) == null) {
                this.renderMode = renderMode;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder setFlutterViewClass(@NonNull Class<? extends FlutterView> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
                this.flutterViewClass = cls;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder whenEngineStart(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.whenEngineStart = i2;
                return this;
            }
            return (ConfigBuilder) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(530384245, "Lcom/idlefish/flutterboost/FlutterBoost;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(530384245, "Lcom/idlefish/flutterboost/FlutterBoost;");
        }
    }

    public FlutterBoost() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnterActivityCreate = false;
        this.isCoverWithTransparentActivity = false;
    }

    public static FlutterBoost instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (sInstance == null) {
                sInstance = new FlutterBoost();
            }
            return sInstance;
        }
        return (FlutterBoost) invokeV.objValue;
    }

    public FlutterBoostPlugin channel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FlutterBoostPlugin.singleton() : (FlutterBoostPlugin) invokeV.objValue;
    }

    public IContainerManager containerManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? sInstance.mManager : (IContainerManager) invokeV.objValue;
    }

    public final FlutterEngine createEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mEngine == null) {
                FlutterMain.startInitialization(this.mPlatform.getApplication());
                FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), new FlutterShellArgs(this.mPlatform.shellArgs() != null ? this.mPlatform.shellArgs() : Arrays.asList(new String[0])).toArray());
                if (this.mPlatform.flutterEngineProvider() != null) {
                    this.mEngine = this.mPlatform.flutterEngineProvider().provideFlutterEngine(this.mPlatform.getApplication().getApplicationContext());
                }
                if (this.mEngine == null) {
                    this.mEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext(), FlutterLoader.getInstance(), new FlutterJNI(), null, false);
                }
                registerPlugins(this.mEngine);
            }
            return this.mEngine;
        }
        return (FlutterEngine) invokeV.objValue;
    }

    public Activity currentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? sInstance.mCurrentActiveActivity : (Activity) invokeV.objValue;
    }

    public void doInitialFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.mEngine != null) {
                    return;
                }
                if (this.mPlatform.lifecycleListener != null) {
                    this.mPlatform.lifecycleListener.beforeCreateEngine();
                }
                FlutterEngine createEngine = createEngine();
                if (this.mPlatform.lifecycleListener != null) {
                    this.mPlatform.lifecycleListener.onEngineCreated();
                }
                if (createEngine.getDartExecutor().isExecutingDart()) {
                    return;
                }
                if (this.mPlatform.initialRoute() != null) {
                    createEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
                }
                createEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), this.mPlatform.dartEntrypoint()));
            } finally {
                TTIStats.record("FlutterBoost.doInitialFlutter", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public FlutterEngine engineProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mEngine : (FlutterEngine) invokeV.objValue;
    }

    public void init(Platform platform) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, platform) == null) {
            if (sInit) {
                Debuger.log("FlutterBoost is alread inited. Do not init twice");
                return;
            }
            this.mPlatform = platform;
            this.mManager = new FlutterViewContainerManager();
            this.mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(this) { // from class: com.idlefish.flutterboost.FlutterBoost.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterBoost this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                        this.this$0.mEnterActivityCreate = true;
                        this.this$0.mCurrentActiveActivity = activity;
                        if (this.this$0.mPlatform.whenEngineStart() == ConfigBuilder.ANY_ACTIVITY_CREATED) {
                            this.this$0.doInitialFlutter();
                        }
                        FlutterBoost flutterBoost = this.this$0;
                        if (flutterBoost.isCoverWithTransparentActivity && flutterBoost.coveredTransparentActivity == null) {
                            this.this$0.coveredTransparentActivity = activity;
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                        if (this.this$0.coveredTransparentActivity == activity) {
                            this.this$0.coveredTransparentActivity = null;
                            this.this$0.isCoverWithTransparentActivity = false;
                        }
                        if (this.this$0.mEnterActivityCreate && this.this$0.mCurrentActiveActivity == activity) {
                            Debuger.log("Application entry background");
                            if (this.this$0.mEngine != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", NotificationCompat.WearableExtender.KEY_BACKGROUND);
                                this.this$0.channel().sendEvent("lifecycle", hashMap);
                            }
                            this.this$0.mCurrentActiveActivity = null;
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || !this.this$0.mEnterActivityCreate) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) && this.this$0.mEnterActivityCreate) {
                        this.this$0.mCurrentActiveActivity = activity;
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeLL(1048580, this, activity, bundle) != null) || !this.this$0.mEnterActivityCreate) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) && this.this$0.mEnterActivityCreate) {
                        if (this.this$0.mCurrentActiveActivity == null) {
                            Debuger.log("Application entry foreground");
                            if (this.this$0.mEngine != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", Constant.FOREGROUND);
                                this.this$0.channel().sendEvent("lifecycle", hashMap);
                            }
                        }
                        this.this$0.mCurrentActiveActivity = activity;
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) && this.this$0.mEnterActivityCreate && this.this$0.mCurrentActiveActivity == activity) {
                        Debuger.log("Application entry background");
                        if (this.this$0.mEngine != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", NotificationCompat.WearableExtender.KEY_BACKGROUND);
                            this.this$0.channel().sendEvent("lifecycle", hashMap);
                        }
                        this.this$0.mCurrentActiveActivity = null;
                    }
                }
            };
            platform.getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            if (this.mPlatform.whenEngineStart() == ConfigBuilder.IMMEDIATELY) {
                doInitialFlutter();
            }
            sInit = true;
        }
    }

    public Platform platform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? sInstance.mPlatform : (Platform) invokeV.objValue;
    }

    public final void registerPlugins(FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, flutterEngine) == null) {
            try {
                Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
            } catch (Exception e2) {
                Debuger.exception(e2);
            }
        }
    }

    public void setFlutterPostFrameCallTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
        }
    }
}
