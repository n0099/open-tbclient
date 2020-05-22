package com.idlefish.flutterboost.containers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t.a;
import com.idlefish.flutterboost.BoostPluginRegistry;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterActivityAndFragmentDelegate implements IFlutterViewContainer {
    private static final String TAG = "FlutterActivityAndFragmentDelegate";
    @Nullable
    private FlutterEngine flutterEngine;
    @Nullable
    private FlutterSplashView flutterSplashView;
    @Nullable
    private XFlutterView flutterView;
    @NonNull
    private Host host;
    private boolean isFlutterEngineFromHost;
    protected IOperateSyncer mSyncer;
    @Nullable
    private PlatformPlugin platformPlugin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider {
        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        @Nullable
        Activity getActivity();

        String getContainerUrl();

        Map getContainerUrlParams();

        @NonNull
        Context getContext();

        @NonNull
        Lifecycle getLifecycle();

        @NonNull
        FlutterView.TransparencyMode getTransparencyMode();

        void onFlutterContainerClose();

        void onFlutterContainerOpen();

        @Nullable
        FlutterEngine provideFlutterEngine(@NonNull Context context);

        @Nullable
        PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine);

        @Nullable
        SplashScreen provideSplashScreen();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterActivityAndFragmentDelegate(@NonNull Host host) {
        this.host = host;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.host = null;
        this.flutterEngine = null;
        this.flutterView = null;
        this.platformPlugin = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.flutterEngine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XFlutterView getFlutterView() {
        return this.flutterView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttach(@NonNull Context context) {
        ensureAlive();
        if (FlutterBoost.instance().platform().whenEngineStart() == FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED) {
            FlutterBoost.instance().doInitialFlutter();
            FlutterBoost.instance().boostPluginRegistry();
        }
        if (this.flutterEngine == null) {
            setupFlutterEngine();
        }
        this.platformPlugin = this.host.providePlatformPlugin(this.host.getActivity(), this.flutterEngine);
        this.host.configureFlutterEngine(this.flutterEngine);
        this.host.getActivity().getWindow().setFormat(-3);
        setDisplayMode();
    }

    private void setDisplayMode() {
        int i;
        try {
            WindowManager windowManager = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            float refreshRate = windowManager.getDefaultDisplay().getRefreshRate();
            if (refreshRate > 61.0f && this.host.getActivity() != null && Build.VERSION.SDK_INT >= 23) {
                Window window = this.host.getActivity().getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int i2 = attributes.preferredDisplayModeId;
                Display.Mode[] supportedModes = windowManager.getDefaultDisplay().getSupportedModes();
                int i3 = 0;
                while (true) {
                    if (i3 >= supportedModes.length) {
                        i = i2;
                        break;
                    } else if (supportedModes[i3].getRefreshRate() != refreshRate) {
                        i3++;
                    } else {
                        i = supportedModes[i3].getModeId();
                        break;
                    }
                }
                attributes.preferredDisplayModeId = i;
                window.setAttributes(attributes);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void setupFlutterEngine() {
        Log.d(TAG, "Setting up FlutterEngine.");
        this.flutterEngine = this.host.provideFlutterEngine(this.host.getContext());
        if (this.flutterEngine != null) {
            this.isFlutterEngineFromHost = true;
            return;
        }
        Log.d(TAG, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this NewFlutterFragment.");
        this.isFlutterEngineFromHost = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @SuppressLint({"ResourceType"})
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Log.v(TAG, "Creating FlutterView.");
        this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
        this.mSyncer = FlutterBoost.instance().containerManager().generateSyncer(this);
        ensureAlive();
        this.flutterView = new XFlutterView(this.host.getActivity(), FlutterBoost.instance().platform().renderMode(), this.host.getTransparencyMode());
        this.flutterSplashView = new FlutterSplashView(this.host.getContext());
        if (Build.VERSION.SDK_INT >= 17) {
            this.flutterSplashView.setId(View.generateViewId());
        } else {
            this.flutterSplashView.setId(486947586);
        }
        this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
        this.mSyncer.onCreate();
        return this.flutterSplashView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStart() {
        Log.v(TAG, "onStart()");
        ensureAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        a.getInstance().setLastFlutterPage(getContainerUrl());
        this.mSyncer.onAppear();
        Log.v(TAG, "onResume()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsResumed();
        ActivityPluginBinding activityPluginBinding = ((BoostPluginRegistry) FlutterBoost.instance().getPluginRegistry()).getRegistrarAggregate().getActivityPluginBinding();
        if (activityPluginBinding != null && activityPluginBinding.getActivity() != this.host.getActivity()) {
            this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPostResume() {
        Log.v(TAG, "onPostResume()");
        ensureAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        Log.v(TAG, "onPause()");
        ensureAlive();
        this.mSyncer.onDisappear();
        this.flutterEngine.getLifecycleChannel().appIsInactive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStop() {
        Log.v(TAG, "onStop()");
        ensureAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroyView() {
        ActivityPluginBinding activityPluginBinding;
        Log.v(TAG, "onDestroyView()");
        this.mSyncer.onDestroy();
        ensureAlive();
        BoostPluginRegistry boostPluginRegistry = (BoostPluginRegistry) FlutterBoost.instance().getPluginRegistry();
        if (boostPluginRegistry != null && (activityPluginBinding = boostPluginRegistry.getRegistrarAggregate().getActivityPluginBinding()) != null && activityPluginBinding.getActivity() == this.host.getActivity()) {
            boostPluginRegistry.getRegistrarAggregate().onDetachedFromActivityForConfigChanges();
            this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
        }
        this.flutterView.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetach() {
        Log.v(TAG, "onDetach()");
        ensureAlive();
        if (this.platformPlugin != null) {
            this.platformPlugin.destroy();
            this.platformPlugin = null;
        }
        Utils.fixInputMethodManagerLeak(this.host.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackPressed() {
        this.mSyncer.onBackPressed();
        ensureAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mSyncer.onRequestPermissionsResult(i, strArr, iArr);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.w(TAG, "onRequestPermissionResult() invoked before NewFlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNewIntent(@NonNull Intent intent) {
        this.mSyncer.onNewIntent(intent);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onNewIntent() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            return;
        }
        Log.w(TAG, "onNewIntent() invoked before NewFlutterFragment was attached to an Activity.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.idlefish.flutterboost.interfaces.IOperateSyncer */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i, int i2, Intent intent) {
        Map map;
        this.mSyncer.onActivityResult(i, i2, intent);
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("_flutter_result_");
            if (serializableExtra instanceof Map) {
                map = (Map) serializableExtra;
                this.mSyncer.onContainerResult(i, i2, map);
                ensureAlive();
                if (this.flutterEngine == null) {
                    Log.v(TAG, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
                    this.flutterEngine.getActivityControlSurface().onActivityResult(i, i2, intent);
                    return;
                }
                Log.w(TAG, "onActivityResult() invoked before NewFlutterFragment was attached to an Activity.");
                return;
            }
        }
        map = null;
        this.mSyncer.onContainerResult(i, i2, map);
        ensureAlive();
        if (this.flutterEngine == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onUserLeaveHint() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w(TAG, "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTrimMemory(int i) {
        this.mSyncer.onTrimMemory(i);
        ensureAlive();
        if (this.flutterEngine != null) {
            if (i == 10) {
                Log.v(TAG, "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
                return;
            }
            return;
        }
        Log.w(TAG, "onTrimMemory() invoked before NewFlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLowMemory() {
        Log.v(TAG, "Forwarding onLowMemory() to FlutterEngine.");
        this.mSyncer.onLowMemory();
        ensureAlive();
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }

    private void ensureAlive() {
        if (this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Activity getContextActivity() {
        return this.host.getActivity();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public FlutterSplashView getBoostFlutterView() {
        return this.flutterSplashView;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    @RequiresApi(api = 5)
    public void finishContainer(Map<String, Object> map) {
        if (map != null) {
            setBoostResult(this.host.getActivity(), new HashMap(map));
            this.host.getActivity().finish();
            this.host.getActivity().overridePendingTransition(0, 0);
            return;
        }
        this.host.getActivity().finish();
        this.host.getActivity().overridePendingTransition(0, 0);
    }

    public void setBoostResult(Activity activity, HashMap hashMap) {
        Intent intent = new Intent();
        if (hashMap != null) {
            intent.putExtra("_flutter_result_", hashMap);
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                    intent.putExtra((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        activity.setResult(-1, intent);
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public String getContainerUrl() {
        return this.host.getContainerUrl();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Map getContainerUrlParams() {
        return this.host.getContainerUrlParams();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerShown() {
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerHidden() {
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onFlutterContainerOpen() {
        this.host.onFlutterContainerOpen();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onFlutterContainerClose() {
        this.host.onFlutterContainerClose();
    }
}
