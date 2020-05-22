package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterBoost {
    static FlutterBoost sInstance = null;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private Activity mCurrentActiveActivity;
    private FlutterEngine mEngine;
    private FlutterViewContainerManager mManager;
    private Platform mPlatform;
    private PluginRegistry mRegistry;
    public boolean isReady = false;
    private long FlutterPostFrameCallTime = 0;

    /* loaded from: classes6.dex */
    public interface BoostLifecycleListener {
        void onEngineCreated();

        void onPluginsRegistered();
    }

    /* loaded from: classes6.dex */
    public interface BoostPluginsRegister {
        void registerPlugins(PluginRegistry pluginRegistry);
    }

    public void setFlutterPostFrameCallTime(long j) {
        this.FlutterPostFrameCallTime = j;
    }

    public static FlutterBoost instance() {
        if (sInstance == null) {
            sInstance = new FlutterBoost();
        }
        return sInstance;
    }

    public void init(Platform platform) {
        this.mPlatform = platform;
        this.mManager = new FlutterViewContainerManager();
        this.mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.idlefish.flutterboost.FlutterBoost.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                FlutterBoost.this.mCurrentActiveActivity = activity;
                if (FlutterBoost.this.mPlatform.whenEngineStart() == ConfigBuilder.ANY_ACTIVITY_CREATED) {
                    FlutterBoost.this.doInitialFlutter();
                    FlutterBoost.this.boostPluginRegistry();
                }
                if (FlutterBoost.this.mPlatform.whenEngineStart() == ConfigBuilder.IMMEDIATELY) {
                    FlutterBoost.this.boostPluginRegistry();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (FlutterBoost.this.mCurrentActiveActivity == null) {
                    Debuger.log("Application entry foreground");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.createEngine() != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "foreground");
                        channel.sendEvent("lifecycle", hashMap);
                    }
                }
                FlutterBoost.this.mCurrentActiveActivity = activity;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                FlutterBoost.this.mCurrentActiveActivity = activity;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.createEngine() != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "background");
                        channel.sendEvent("lifecycle", hashMap);
                    }
                    FlutterBoost.this.mCurrentActiveActivity = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.createEngine() != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "background");
                        channel.sendEvent("lifecycle", hashMap);
                    }
                    FlutterBoost.this.mCurrentActiveActivity = null;
                }
            }
        };
        platform.getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
        if (this.mPlatform.whenEngineStart() == ConfigBuilder.IMMEDIATELY) {
            doInitialFlutter();
        }
    }

    public void doInitialFlutter() {
        if (this.mRegistry == null) {
            long currentTimeMillis = System.currentTimeMillis();
            FlutterEngine createEngine = createEngine();
            if (this.mPlatform.lifecycleListener != null) {
                this.mPlatform.lifecycleListener.onEngineCreated();
            }
            if (createEngine != null && !createEngine.getDartExecutor().isExecutingDart()) {
                if (this.mPlatform.initialRoute() != null) {
                    createEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
                }
                createEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "main"));
                this.mRegistry = new BoostPluginRegistry(createEngine());
                HashMap hashMap = new HashMap();
                hashMap.put("seb", String.valueOf(currentTimeMillis));
                hashMap.put("see", String.valueOf(System.currentTimeMillis()));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921451, hashMap));
            }
        }
    }

    public void boostPluginRegistry() {
        if (this.mRegistry != null && !this.mRegistry.hasPlugin("boostPluginRegistry")) {
            this.mPlatform.registerPlugins(this.mRegistry);
            this.mRegistry.registrarFor("boostPluginRegistry");
        }
    }

    /* loaded from: classes6.dex */
    public static class ConfigBuilder {
        private BoostLifecycleListener lifecycleListener;
        private Application mApp;
        private INativeRouter router;
        public static int IMMEDIATELY = 0;
        public static int ANY_ACTIVITY_CREATED = 1;
        public static int FLUTTER_ACTIVITY_CREATED = 2;
        public static int APP_EXit = 0;
        public static int All_FLUTTER_ACTIVITY_DESTROY = 1;
        private String dartEntrypoint = "main";
        private String initialRoute = "/";
        private int whenEngineStart = ANY_ACTIVITY_CREATED;
        private int whenEngineDestory = APP_EXit;
        private boolean isDebug = false;
        private FlutterView.RenderMode renderMode = FlutterView.RenderMode.texture;

        public ConfigBuilder(Application application, INativeRouter iNativeRouter) {
            this.router = null;
            this.router = iNativeRouter;
            this.mApp = application;
        }

        public ConfigBuilder renderMode(FlutterView.RenderMode renderMode) {
            this.renderMode = renderMode;
            return this;
        }

        public ConfigBuilder isDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public ConfigBuilder whenEngineStart(int i) {
            this.whenEngineStart = i;
            return this;
        }

        public ConfigBuilder lifecycleListener(BoostLifecycleListener boostLifecycleListener) {
            this.lifecycleListener = boostLifecycleListener;
            return this;
        }

        public Platform build() {
            Platform platform = new Platform() { // from class: com.idlefish.flutterboost.FlutterBoost.ConfigBuilder.1
                @Override // com.idlefish.flutterboost.Platform
                public Application getApplication() {
                    return ConfigBuilder.this.mApp;
                }

                @Override // com.idlefish.flutterboost.Platform
                public boolean isDebug() {
                    return ConfigBuilder.this.isDebug;
                }

                @Override // com.idlefish.flutterboost.Platform
                public String initialRoute() {
                    return ConfigBuilder.this.initialRoute;
                }

                @Override // com.idlefish.flutterboost.Platform
                public void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2) {
                    ConfigBuilder.this.router.openContainer(context, str, map, i, map2);
                }

                @Override // com.idlefish.flutterboost.Platform
                public int whenEngineStart() {
                    return ConfigBuilder.this.whenEngineStart;
                }

                @Override // com.idlefish.flutterboost.Platform
                public FlutterView.RenderMode renderMode() {
                    return ConfigBuilder.this.renderMode;
                }
            };
            platform.lifecycleListener = this.lifecycleListener;
            return platform;
        }
    }

    public IContainerManager containerManager() {
        return sInstance.mManager;
    }

    public Platform platform() {
        return sInstance.mPlatform;
    }

    public FlutterBoostPlugin channel() {
        return FlutterBoostPlugin.singleton();
    }

    public Activity currentActivity() {
        return sInstance.mCurrentActiveActivity;
    }

    public PluginRegistry getPluginRegistry() {
        return this.mRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlutterEngine createEngine() {
        if (this.mEngine == null) {
            FlutterMain.startInitialization(this.mPlatform.getApplication());
            PluginSetting findPluginSetting = c.oA().findPluginSetting("com.baidu.tieba.pluginFlutter");
            if (findPluginSetting != null && findPluginSetting.apkPath != null) {
                String replace = findPluginSetting.apkPath.replace(".apk", "");
                try {
                    FlutterLoader flutterLoader = FlutterLoader.getInstance();
                    Field declaredField = FlutterLoader.class.getDeclaredField("aotSharedLibraryName");
                    declaredField.setAccessible(true);
                    declaredField.set(flutterLoader, replace + "/lib/libapp.so");
                } catch (Exception e) {
                    BdLog.e("resSetSupplier2 exception");
                    e.printStackTrace();
                }
            } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
                return null;
            }
            FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), new FlutterShellArgs(new String[0]).toArray());
            this.mEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext());
        }
        return this.mEngine;
    }

    public FlutterEngine engineProvider() {
        return this.mEngine;
    }
}
