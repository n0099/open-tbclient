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
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.tieba.t.a;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class FlutterActivityAndFragmentDelegate implements IFlutterViewContainer {
    private static int ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = 0;
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
    private XPlatformPlugin platformPlugin;

    /* loaded from: classes12.dex */
    public interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider {
        @Override // io.flutter.embedding.android.FlutterEngineConfigurator
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

        @Nullable
        FlutterEngine provideFlutterEngine(@NonNull Context context);

        @Nullable
        XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine);

        @Nullable
        SplashScreen provideSplashScreen();

        void setSwipeBackEnable(boolean z);

        void swipeBackControl(double d);
    }

    public FlutterActivityAndFragmentDelegate(@NonNull Host host) {
        this.host = host;
    }

    public void release() {
        this.host = null;
        this.flutterEngine = null;
        this.flutterView = null;
        this.platformPlugin = null;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.flutterEngine;
    }

    public XFlutterView getFlutterView() {
        return this.flutterView;
    }

    public void onAttach(@NonNull Context context) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onAttach1" + getContainerUrl());
        }
        ensureAlive();
        if (FlutterBoost.instance().platform().whenEngineStart() == FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED) {
            FlutterBoost.instance().doInitialFlutter();
        }
        if (this.flutterEngine == null) {
            setupFlutterEngine();
        }
        this.platformPlugin = this.host.providePlatformPlugin(this.flutterEngine);
        this.host.configureFlutterEngine(this.flutterEngine);
        this.host.getActivity().getWindow().setFormat(-3);
        setDisplayMode();
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onAttach2" + getContainerUrl());
        }
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

    @NonNull
    @SuppressLint({"ResourceType"})
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setLastFlutterPage(getContainerUrl());
            Log.v(TAG, "Creating FlutterView.");
            a.getInstance().setFlutterPath("onCreateView1" + getContainerUrl());
        }
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
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onCreateView2");
        }
        return this.flutterSplashView;
    }

    public void onStart() {
        Log.v(TAG, "onStart()");
        ensureAlive();
    }

    public void onResume() {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onResume1" + getContainerUrl());
        }
        a.getInstance().setLastFlutterPage(getContainerUrl());
        this.mSyncer.onAppear();
        Log.v(TAG, "onResume()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsResumed();
        if (ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE == 0 || ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE != this.host.hashCode()) {
            this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), new androidx.lifecycle.a(this.host.getLifecycle()));
            ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = this.host.hashCode();
        }
        if (this.platformPlugin != null) {
            this.platformPlugin.attachToActivity(this.host.getActivity());
        }
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onResume2" + getContainerUrl());
        }
    }

    public void onPostResume() {
        Log.v(TAG, "onPostResume()");
        ensureAlive();
    }

    public void onPause() {
        Log.v(TAG, "onPause()");
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onPause1" + getContainerUrl());
        }
        ensureAlive();
        this.mSyncer.onDisappear();
        this.flutterEngine.getLifecycleChannel().appIsInactive();
    }

    public void onStop() {
        Log.v(TAG, "onStop()");
        ensureAlive();
    }

    public void onDestroyView() {
        Log.v(TAG, "onDestroyView()");
        this.mSyncer.onDestroy();
        ensureAlive();
        this.flutterView.release();
    }

    public void onDetach() {
        Log.v(TAG, "onDetach()");
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onDetach1" + getContainerUrl());
        }
        ensureAlive();
        if (this.platformPlugin != null) {
            this.platformPlugin.detachActivity(getContextActivity());
            this.platformPlugin = null;
        }
        if (ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE != 0 && ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE == this.host.hashCode()) {
            this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
        }
        Utils.fixInputMethodManagerLeak(this.host.getActivity());
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onDetach2" + getContainerUrl());
        }
    }

    public void onBackPressed() {
        this.mSyncer.onBackPressed();
        ensureAlive();
    }

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

    public void onNewIntent(@NonNull Intent intent) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onNewIntent" + getContainerUrl());
        }
        this.mSyncer.onNewIntent(intent);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onNewIntent() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            return;
        }
        Log.w(TAG, "onNewIntent() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onActivityResult" + getContainerUrl());
        }
        this.mSyncer.onActivityResult(i, i2, intent);
        HashMap hashMap = new HashMap();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("_flutter_result_");
            if (serializableExtra instanceof Map) {
                hashMap.putAll((Map) serializableExtra);
            }
            try {
                Bundle extras = intent.getExtras();
                if (extras != null && extras.size() > 0) {
                    for (String str : extras.keySet()) {
                        hashMap.put(str, extras.get(str));
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        this.mSyncer.onContainerResult(i, i2, hashMap);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.flutterEngine.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.w(TAG, "onActivityResult() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void onUserLeaveHint() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w(TAG, "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
    }

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
    public void finishContainer(Map<String, Object> map) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("finishContainer" + getContainerUrl());
        }
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
        return this.host == null ? "" : this.host.getContainerUrl();
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
    public void setSwipeBackEnable(boolean z) {
        this.host.setSwipeBackEnable(z);
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void swipeBackControl(double d) {
        this.host.swipeBackControl(d);
    }
}
