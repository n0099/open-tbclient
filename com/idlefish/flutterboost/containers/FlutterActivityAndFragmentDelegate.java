package com.idlefish.flutterboost.containers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import d.b.i0.i3.a;
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
/* loaded from: classes6.dex */
public class FlutterActivityAndFragmentDelegate implements IFlutterViewContainer {
    public static int ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = 0;
    public static final String TAG = "FlutterActivityAndFragmentDelegate";
    @Nullable
    public FlutterEngine flutterEngine;
    @Nullable
    public FlutterSplashView flutterSplashView;
    @Nullable
    public XFlutterView flutterView;
    @NonNull
    public Host host;
    public boolean isFlutterEngineFromHost;
    public IOperateSyncer mSyncer;
    @Nullable
    public XPlatformPlugin platformPlugin;

    /* loaded from: classes6.dex */
    public interface Host extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator {
        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        @Nullable
        Activity getActivity();

        String getContainerUrl();

        Map<String, Object> getContainerUrlParams();

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

        @Override // io.flutter.embedding.android.SplashScreenProvider
        @Nullable
        SplashScreen provideSplashScreen();

        void setSwipeBackEnable(boolean z);

        void swipeBackControl(double d2);
    }

    public FlutterActivityAndFragmentDelegate(@NonNull Host host) {
        this.host = host;
    }

    private void ensureAlive() {
        if (this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private void setDisplayMode() {
        try {
            WindowManager windowManager = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            float refreshRate = windowManager.getDefaultDisplay().getRefreshRate();
            if (refreshRate <= 61.0f || this.host.getActivity() == null || Build.VERSION.SDK_INT < 23) {
                return;
            }
            Window window = this.host.getActivity().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i = attributes.preferredDisplayModeId;
            Display.Mode[] supportedModes = windowManager.getDefaultDisplay().getSupportedModes();
            int i2 = 0;
            while (true) {
                if (i2 >= supportedModes.length) {
                    break;
                } else if (supportedModes[i2].getRefreshRate() == refreshRate) {
                    i = supportedModes[i2].getModeId();
                    break;
                } else {
                    i2++;
                }
            }
            attributes.preferredDisplayModeId = i;
            window.setAttributes(attributes);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void setupFlutterEngine() {
        Log.d("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        Host host = this.host;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.flutterEngine = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.isFlutterEngineFromHost = true;
            return;
        }
        Log.d("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this NewFlutterFragment.");
        this.isFlutterEngineFromHost = false;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("finishContainer" + getContainerUrl());
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

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public FlutterSplashView getBoostFlutterView() {
        return this.flutterSplashView;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public String getContainerUrl() {
        Host host = this.host;
        return host == null ? "" : host.getContainerUrl();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Map<String, Object> getContainerUrlParams() {
        return this.host.getContainerUrlParams();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Activity getContextActivity() {
        return this.host.getActivity();
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.flutterEngine;
    }

    public XFlutterView getFlutterView() {
        return this.flutterView;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onActivityResult" + getContainerUrl());
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
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.flutterEngine.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void onAttach(@NonNull Context context) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onAttach1" + getContainerUrl());
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
        if (this.host.getActivity() != null) {
            this.host.getActivity().getWindow().setFormat(-3);
        }
        setDisplayMode();
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar2 = a.getInstance();
            aVar2.setFlutterPath("onAttach2" + getContainerUrl());
        }
    }

    public void onBackPressed() {
        this.mSyncer.onBackPressed();
        ensureAlive();
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerHidden() {
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerShown() {
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setLastFlutterPage(getContainerUrl());
            Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
            a aVar = a.getInstance();
            aVar.setFlutterPath("onCreateView1" + getContainerUrl());
        }
        this.mSyncer = FlutterBoost.instance().containerManager().generateSyncer(this);
        ensureAlive();
        this.flutterView = new XFlutterView(this.host.getActivity(), FlutterBoost.instance().platform().renderMode(), this.host.getTransparencyMode());
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.host.getContext());
        this.flutterSplashView = flutterSplashView;
        if (Build.VERSION.SDK_INT >= 17) {
            flutterSplashView.setId(View.generateViewId());
        } else {
            flutterSplashView.setId(486947586);
        }
        this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
        this.mSyncer.onCreate();
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a.getInstance().setFlutterPath("onCreateView2");
        }
        return this.flutterSplashView;
    }

    public void onDestroyView() {
        Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        this.mSyncer.onDestroy();
        ensureAlive();
        this.flutterView.release();
    }

    public void onDetach() {
        Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onDetach1" + getContainerUrl());
        }
        ensureAlive();
        XPlatformPlugin xPlatformPlugin = this.platformPlugin;
        if (xPlatformPlugin != null) {
            xPlatformPlugin.detachActivity(getContextActivity());
            this.platformPlugin = null;
        }
        int i = ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE;
        if (i != 0 && i == this.host.hashCode()) {
            this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
        }
        Utils.fixInputMethodManagerLeak(this.host.getActivity());
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar2 = a.getInstance();
            aVar2.setFlutterPath("onDetach2" + getContainerUrl());
        }
    }

    public void onLowMemory() {
        Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
        this.mSyncer.onLowMemory();
        ensureAlive();
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }

    public void onNewIntent(@NonNull Intent intent) {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onNewIntent" + getContainerUrl());
        }
        this.mSyncer.onNewIntent(intent);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            return;
        }
        Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void onPause() {
        Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onPause1" + getContainerUrl());
        }
        ensureAlive();
        this.mSyncer.onDisappear();
        this.flutterEngine.getLifecycleChannel().appIsInactive();
    }

    public void onPostResume() {
        Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
        ensureAlive();
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mSyncer.onRequestPermissionsResult(i, strArr, iArr);
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void onResume() {
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar = a.getInstance();
            aVar.setFlutterPath("onResume1" + getContainerUrl());
        }
        a.getInstance().setLastFlutterPage(getContainerUrl());
        this.mSyncer.onAppear();
        Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsResumed();
        int i = ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE;
        if (i == 0 || i != this.host.hashCode()) {
            this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
            ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = this.host.hashCode();
        }
        XPlatformPlugin xPlatformPlugin = this.platformPlugin;
        if (xPlatformPlugin != null) {
            xPlatformPlugin.attachToActivity(this.host.getActivity());
        }
        if (FlutterCrabReportEnableSwitch.isOn()) {
            a aVar2 = a.getInstance();
            aVar2.setFlutterPath("onResume2" + getContainerUrl());
        }
    }

    public void onStart() {
        Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
        ensureAlive();
    }

    public void onStop() {
        Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
        ensureAlive();
    }

    public void onTrimMemory(int i) {
        this.mSyncer.onTrimMemory(i);
        ensureAlive();
        if (this.flutterEngine == null) {
            Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before NewFlutterFragment was attached to an Activity.");
        } else if (i == 10) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
            this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        }
    }

    public void onUserLeaveHint() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
    }

    public void release() {
        this.host = null;
        this.flutterEngine = null;
        this.flutterView = null;
        this.platformPlugin = null;
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
    public void setSwipeBackEnable(boolean z) {
        this.host.setSwipeBackEnable(z);
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void swipeBackControl(double d2) {
        this.host.swipeBackControl(d2);
    }
}
