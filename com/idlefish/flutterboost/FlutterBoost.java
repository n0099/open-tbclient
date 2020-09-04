package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.tbadk.switchs.FlutterCrashRepairEnableSwitch;
import com.baidu.tieba.t.a;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import dalvik.system.PathClassLoader;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.view.FlutterMain;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class FlutterBoost {
    private static boolean sInit;
    static FlutterBoost sInstance = null;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private Activity mCurrentActiveActivity;
    private FlutterEngine mEngine;
    private FlutterViewContainerManager mManager;
    private Platform mPlatform;
    public boolean isReady = false;
    private boolean mEnterActivityCreate = false;
    private long FlutterPostFrameCallTime = 0;

    /* loaded from: classes10.dex */
    public interface BoostLifecycleListener {
        void beforeCreateEngine();

        void onEngineCreated();
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
        if (sInit) {
            Debuger.log("FlutterBoost is alread inited. Do not init twice");
            return;
        }
        this.mPlatform = platform;
        this.mManager = new FlutterViewContainerManager();
        this.mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.idlefish.flutterboost.FlutterBoost.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                FlutterBoost.this.mEnterActivityCreate = true;
                FlutterBoost.this.mCurrentActiveActivity = activity;
                if (FlutterBoost.this.mPlatform.whenEngineStart() == ConfigBuilder.ANY_ACTIVITY_CREATED) {
                    FlutterBoost.this.doInitialFlutter();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate) {
                    if (FlutterBoost.this.mCurrentActiveActivity == null) {
                        Debuger.log("Application entry foreground");
                        FlutterBoostPlugin channel = FlutterBoost.this.channel();
                        if (FlutterBoost.this.mEngine != null && channel != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", "foreground");
                            channel.sendEvent("lifecycle", hashMap);
                        }
                    }
                    FlutterBoost.this.mCurrentActiveActivity = activity;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate) {
                    FlutterBoost.this.mCurrentActiveActivity = activity;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (!FlutterBoost.this.mEnterActivityCreate) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate && FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.mEngine != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "background");
                        channel.sendEvent("lifecycle", hashMap);
                    }
                    FlutterBoost.this.mCurrentActiveActivity = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                if (!FlutterBoost.this.mEnterActivityCreate) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate && FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.mEngine != null && channel != null) {
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
        sInit = true;
    }

    public void doInitialFlutter() {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("doInitialFlutter");
        }
        if (this.mEngine == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mPlatform.lifecycleListener != null) {
                this.mPlatform.lifecycleListener.beforeCreateEngine();
            }
            FlutterEngine createEngine = createEngine();
            if (this.mPlatform.lifecycleListener != null) {
                this.mPlatform.lifecycleListener.onEngineCreated();
            }
            if (!createEngine.getDartExecutor().isExecutingDart()) {
                if (this.mPlatform.initialRoute() != null) {
                    createEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
                }
                createEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), this.mPlatform.dartEntrypoint()));
                HashMap hashMap = new HashMap();
                hashMap.put("seb", String.valueOf(currentTimeMillis));
                hashMap.put("see", String.valueOf(System.currentTimeMillis()));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921451, hashMap));
            }
        }
    }

    /* loaded from: classes10.dex */
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
                public String dartEntrypoint() {
                    return ConfigBuilder.this.dartEntrypoint;
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

    private FlutterEngine createEngine() {
        List list;
        boolean z = false;
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("createEngine1");
        }
        if (this.mEngine == null) {
            synchronized (com.baidu.adp.plugin.util.a.mLock) {
                PluginSetting findPluginSetting = c.qq().findPluginSetting("com.baidu.tieba.pluginFlutter");
                try {
                    if (FlutterCrashRepairEnableSwitch.isOn() && findPluginSetting != null && findPluginSetting.apkPath != null) {
                        Object pathList = com.baidu.adp.plugin.util.a.getPathList((PathClassLoader) TbadkCoreApplication.getInst().getClassLoader());
                        Object D = com.baidu.adp.plugin.util.a.D(pathList);
                        if (D instanceof File[]) {
                            File[] fileArr = (File[]) D;
                            for (int i = 0; i < fileArr.length; i++) {
                                if (fileArr[i] != null && fileArr[i].getPath().contains("pluginFlutter")) {
                                    z = true;
                                }
                            }
                        } else if (D instanceof List) {
                            List list2 = (List) D;
                            int i2 = 0;
                            boolean z2 = false;
                            while (i2 < list2.size()) {
                                boolean z3 = (list2.get(i2) == null || !((File) list2.get(i2)).getPath().contains("pluginFlutter")) ? z2 : true;
                                i2++;
                                z2 = z3;
                            }
                            z = z2;
                        }
                        if (!z) {
                            String replace = findPluginSetting.apkPath.replace(".apk", "/lib");
                            if (D instanceof File[]) {
                                list = com.baidu.adp.plugin.util.a.f(D, new File(replace));
                            } else if (D instanceof List) {
                                List list3 = (List) D;
                                list3.add(0, new File(replace));
                                list = list3;
                            } else {
                                list = D;
                            }
                            com.baidu.adp.plugin.util.a.setField(pathList, pathList.getClass(), "nativeLibraryDirectories", list);
                            if (Build.VERSION.SDK_INT > 25 || (Build.VERSION.SDK_INT == 25 && Util.isPreview())) {
                                Method declaredMethod = pathList.getClass().getDeclaredMethod("makePathElements", List.class);
                                declaredMethod.setAccessible(true);
                                com.baidu.adp.plugin.util.a.setField(pathList, pathList.getClass(), "nativeLibraryPathElements", declaredMethod.invoke(pathList.getClass(), (List) list));
                            } else if (Build.VERSION.SDK_INT >= 23) {
                                Method declaredMethod2 = pathList.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                                declaredMethod2.setAccessible(true);
                                com.baidu.adp.plugin.util.a.setField(pathList, pathList.getClass(), "nativeLibraryPathElements", declaredMethod2.invoke(pathList.getClass(), (List) list, null, new ArrayList()));
                            } else {
                                com.baidu.adp.plugin.util.a.setField(pathList, pathList.getClass(), "nativeLibraryDirectories", list);
                            }
                        }
                    }
                } catch (Exception e) {
                    BdLog.e("add flutter.so path err");
                    e.printStackTrace();
                }
                FlutterMain.startInitialization(this.mPlatform.getApplication());
                if (FlutterCrabReportEnableSwitch.isOn()) {
                    a.getInstance().setFlutterPath("createEngine2");
                }
                String[] strArr = new String[0];
                if (findPluginSetting != null && findPluginSetting.apkPath != null) {
                    strArr = new String[]{"--aot-shared-library-name=" + findPluginSetting.apkPath.replace(".apk", "") + "/lib/libapp.so"};
                }
                FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), new FlutterShellArgs(strArr).toArray());
                this.mEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext(), FlutterLoader.getInstance(), new FlutterJNI(), null, false);
                registerPlugins(this.mEngine);
                if (FlutterCrabReportEnableSwitch.isOn()) {
                    a.getInstance().setFlutterPath("createEngine3");
                }
            }
        }
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("createEngine4");
        }
        return this.mEngine;
    }

    private void registerPlugins(FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
        } catch (Exception e) {
            Debuger.exception(e);
        }
    }

    public FlutterEngine engineProvider() {
        return this.mEngine;
    }
}
