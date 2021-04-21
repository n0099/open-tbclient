package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.tbadk.switchs.FlutterCrashRepairEnableSwitch;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import d.b.c.h.j.g.d;
import d.b.j0.i3.a;
import dalvik.system.PathClassLoader;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
/* loaded from: classes6.dex */
public class FlutterBoost {
    public static boolean sInit;
    public static FlutterBoost sInstance;
    public boolean isReady;
    public Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    public Activity mCurrentActiveActivity;
    public FlutterEngine mEngine;
    public boolean mEnterActivityCreate = false;
    public FlutterViewContainerManager mManager;
    public Platform mPlatform;

    /* loaded from: classes6.dex */
    public interface BoostLifecycleListener {
        void beforeCreateEngine();

        void onEngineCreated();
    }

    /* loaded from: classes6.dex */
    public static class ConfigBuilder {
        public static int ANY_ACTIVITY_CREATED = 1;
        public static int FLUTTER_ACTIVITY_CREATED = 2;
        public static int IMMEDIATELY;
        public BoostLifecycleListener lifecycleListener;
        public Application mApp;
        public INativeRouter router;
        public String dartEntrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        public String initialRoute = "/";
        public int whenEngineStart = ANY_ACTIVITY_CREATED;
        public boolean isDebug = false;
        public FlutterView.RenderMode renderMode = FlutterView.RenderMode.texture;

        public ConfigBuilder(Application application, INativeRouter iNativeRouter) {
            this.router = null;
            this.router = iNativeRouter;
            this.mApp = application;
        }

        public Platform build() {
            Platform platform = new Platform() { // from class: com.idlefish.flutterboost.FlutterBoost.ConfigBuilder.1
                @Override // com.idlefish.flutterboost.Platform
                public String dartEntrypoint() {
                    return ConfigBuilder.this.dartEntrypoint;
                }

                @Override // com.idlefish.flutterboost.Platform
                public Application getApplication() {
                    return ConfigBuilder.this.mApp;
                }

                @Override // com.idlefish.flutterboost.Platform
                public String initialRoute() {
                    return ConfigBuilder.this.initialRoute;
                }

                @Override // com.idlefish.flutterboost.Platform
                public boolean isDebug() {
                    return ConfigBuilder.this.isDebug;
                }

                @Override // com.idlefish.flutterboost.Platform
                public void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2) {
                    ConfigBuilder.this.router.openContainer(context, str, map, i, map2);
                }

                @Override // com.idlefish.flutterboost.Platform
                public FlutterView.RenderMode renderMode() {
                    return ConfigBuilder.this.renderMode;
                }

                @Override // com.idlefish.flutterboost.Platform
                public int whenEngineStart() {
                    return ConfigBuilder.this.whenEngineStart;
                }
            };
            platform.lifecycleListener = this.lifecycleListener;
            return platform;
        }

        public ConfigBuilder isDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public ConfigBuilder lifecycleListener(BoostLifecycleListener boostLifecycleListener) {
            this.lifecycleListener = boostLifecycleListener;
            return this;
        }

        public ConfigBuilder renderMode(FlutterView.RenderMode renderMode) {
            this.renderMode = renderMode;
            return this;
        }

        public ConfigBuilder whenEngineStart(int i) {
            this.whenEngineStart = i;
            return this;
        }
    }

    public static FlutterBoost instance() {
        if (sInstance == null) {
            sInstance = new FlutterBoost();
        }
        return sInstance;
    }

    public FlutterBoostPlugin channel() {
        return FlutterBoostPlugin.singleton();
    }

    public IContainerManager containerManager() {
        return sInstance.mManager;
    }

    public final FlutterEngine createEngine() {
        boolean z;
        List list;
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("createEngine1");
        }
        if (this.mEngine == null) {
            synchronized (d.b.c.h.k.a.f43048a) {
                PluginSetting h2 = d.k().h("com.baidu.tieba.pluginFlutter");
                try {
                    if (FlutterCrashRepairEnableSwitch.isOn() && h2 != null && h2.apkPath != null) {
                        Object i = d.b.c.h.k.a.i((PathClassLoader) TbadkCoreApplication.getInst().getClassLoader());
                        Object h3 = d.b.c.h.k.a.h(i);
                        if (h3 instanceof File[]) {
                            File[] fileArr = (File[]) h3;
                            z = false;
                            for (int i2 = 0; i2 < fileArr.length; i2++) {
                                if (fileArr[i2] != null && fileArr[i2].getPath().contains("pluginFlutter")) {
                                    z = true;
                                }
                            }
                        } else if (h3 instanceof List) {
                            List list2 = (List) h3;
                            z = false;
                            for (int i3 = 0; i3 < list2.size(); i3++) {
                                if (list2.get(i3) != null && ((File) list2.get(i3)).getPath().contains("pluginFlutter")) {
                                    z = true;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            String replace = h2.apkPath.replace(".apk", "/lib");
                            if (h3 instanceof File[]) {
                                list = d.b.c.h.k.a.c(h3, new File(replace));
                            } else {
                                boolean z2 = h3 instanceof List;
                                list = h3;
                                if (z2) {
                                    List list3 = (List) h3;
                                    list3.add(0, new File(replace));
                                    list = list3;
                                }
                            }
                            d.b.c.h.k.a.p(i, i.getClass(), "nativeLibraryDirectories", list);
                            if (Build.VERSION.SDK_INT <= 25 && (Build.VERSION.SDK_INT != 25 || !Util.t())) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    Method declaredMethod = i.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                                    declaredMethod.setAccessible(true);
                                    d.b.c.h.k.a.p(i, i.getClass(), "nativeLibraryPathElements", declaredMethod.invoke(i.getClass(), (List) list, null, new ArrayList()));
                                } else {
                                    d.b.c.h.k.a.p(i, i.getClass(), "nativeLibraryDirectories", list);
                                }
                            }
                            Method declaredMethod2 = i.getClass().getDeclaredMethod("makePathElements", List.class);
                            declaredMethod2.setAccessible(true);
                            d.b.c.h.k.a.p(i, i.getClass(), "nativeLibraryPathElements", declaredMethod2.invoke(i.getClass(), (List) list));
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e("add flutter.so path err");
                    e2.printStackTrace();
                }
                FlutterMain.startInitialization(this.mPlatform.getApplication());
                if (FlutterCrabReportEnableSwitch.isOn()) {
                    a.getInstance().setFlutterPath("createEngine2");
                }
                String[] strArr = new String[0];
                if (h2 != null && h2.apkPath != null) {
                    String replace2 = h2.apkPath.replace(".apk", "");
                    strArr = new String[]{"--aot-shared-library-name=" + replace2 + "/lib/libapp.so"};
                }
                FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), new FlutterShellArgs(strArr).toArray());
                FlutterEngine flutterEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext(), FlutterLoader.getInstance(), new FlutterJNI(), null, false);
                this.mEngine = flutterEngine;
                registerPlugins(flutterEngine);
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

    public Activity currentActivity() {
        return sInstance.mCurrentActiveActivity;
    }

    public void doInitialFlutter() {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("doInitialFlutter");
        }
        if (this.mEngine != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        BoostLifecycleListener boostLifecycleListener = this.mPlatform.lifecycleListener;
        if (boostLifecycleListener != null) {
            boostLifecycleListener.beforeCreateEngine();
        }
        FlutterEngine createEngine = createEngine();
        BoostLifecycleListener boostLifecycleListener2 = this.mPlatform.lifecycleListener;
        if (boostLifecycleListener2 != null) {
            boostLifecycleListener2.onEngineCreated();
        }
        if (createEngine.getDartExecutor().isExecutingDart()) {
            return;
        }
        if (this.mPlatform.initialRoute() != null) {
            createEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
        }
        createEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), this.mPlatform.dartEntrypoint()));
        HashMap hashMap = new HashMap();
        hashMap.put("seb", String.valueOf(currentTimeMillis));
        hashMap.put("see", String.valueOf(System.currentTimeMillis()));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921451, hashMap));
    }

    public FlutterEngine engineProvider() {
        return this.mEngine;
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
            public void onActivityDestroyed(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate && FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.mEngine != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", NotificationCompat.WearableExtender.KEY_BACKGROUND);
                        channel.sendEvent("lifecycle", hashMap);
                    }
                    FlutterBoost.this.mCurrentActiveActivity = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (!FlutterBoost.this.mEnterActivityCreate) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate) {
                    FlutterBoost.this.mCurrentActiveActivity = activity;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                if (!FlutterBoost.this.mEnterActivityCreate) {
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
                            hashMap.put("type", Constant.FOREGROUND);
                            channel.sendEvent("lifecycle", hashMap);
                        }
                    }
                    FlutterBoost.this.mCurrentActiveActivity = activity;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (FlutterBoost.this.mEnterActivityCreate && FlutterBoost.this.mCurrentActiveActivity == activity) {
                    Debuger.log("Application entry background");
                    FlutterBoostPlugin channel = FlutterBoost.this.channel();
                    if (FlutterBoost.this.mEngine != null && channel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", NotificationCompat.WearableExtender.KEY_BACKGROUND);
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

    public Platform platform() {
        return sInstance.mPlatform;
    }

    public final void registerPlugins(FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
        } catch (Exception e2) {
            Debuger.exception(e2);
        }
    }

    public void setFlutterPostFrameCallTime(long j) {
    }
}
