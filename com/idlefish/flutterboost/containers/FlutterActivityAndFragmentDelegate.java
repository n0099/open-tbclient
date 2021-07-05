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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import d.a.s0.m3.a;
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
/* loaded from: classes7.dex */
public class FlutterActivityAndFragmentDelegate implements IFlutterViewContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE = 0;
    public static final String TAG = "FlutterActivityAndFragmentDelegate";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-418685732, "Lcom/idlefish/flutterboost/containers/FlutterActivityAndFragmentDelegate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-418685732, "Lcom/idlefish/flutterboost/containers/FlutterActivityAndFragmentDelegate;");
        }
    }

    public FlutterActivityAndFragmentDelegate(@NonNull Host host) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {host};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.host = host;
    }

    private void ensureAlive() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private void setDisplayMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                WindowManager windowManager = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
                float refreshRate = windowManager.getDefaultDisplay().getRefreshRate();
                if (refreshRate <= 61.0f || this.host.getActivity() == null || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                Window window = this.host.getActivity().getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int i2 = attributes.preferredDisplayModeId;
                Display.Mode[] supportedModes = windowManager.getDefaultDisplay().getSupportedModes();
                int i3 = 0;
                while (true) {
                    if (i3 >= supportedModes.length) {
                        break;
                    } else if (supportedModes[i3].getRefreshRate() == refreshRate) {
                        i2 = supportedModes[i3].getModeId();
                        break;
                    } else {
                        i3++;
                    }
                }
                attributes.preferredDisplayModeId = i2;
                window.setAttributes(attributes);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    private void setupFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
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
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
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
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public FlutterSplashView getBoostFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.flutterSplashView : (FlutterSplashView) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public String getContainerUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Host host = this.host;
            return host == null ? "" : host.getContainerUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Map<String, Object> getContainerUrlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.host.getContainerUrlParams() : (Map) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public Activity getContextActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.host.getActivity() : (Activity) invokeV.objValue;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
    }

    public XFlutterView getFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.flutterView : (XFlutterView) invokeV.objValue;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            if (FlutterCrabReportEnableSwitch.isOn()) {
                a aVar = a.getInstance();
                aVar.setFlutterPath("onActivityResult" + getContainerUrl());
            }
            this.mSyncer.onActivityResult(i2, i3, intent);
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
            this.mSyncer.onContainerResult(i2, i3, hashMap);
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i2 + "\nresultCode: " + i3 + "\ndata: " + intent);
                this.flutterEngine.getActivityControlSurface().onActivityResult(i2, i3, intent);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before NewFlutterFragment was attached to an Activity.");
        }
    }

    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
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
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mSyncer.onBackPressed();
            ensureAlive();
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerHidden() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void onContainerShown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
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
        return (View) invokeLLL.objValue;
    }

    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
            this.mSyncer.onDestroy();
            ensureAlive();
            this.flutterView.release();
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
            int i2 = ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE;
            if (i2 != 0 && i2 == this.host.hashCode()) {
                this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            }
            Utils.fixInputMethodManagerLeak(this.host.getActivity());
            if (FlutterCrabReportEnableSwitch.isOn()) {
                a aVar2 = a.getInstance();
                aVar2.setFlutterPath("onDetach2" + getContainerUrl());
            }
        }
    }

    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
            this.mSyncer.onLowMemory();
            ensureAlive();
            this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
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
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
            if (FlutterCrabReportEnableSwitch.isOn()) {
                a aVar = a.getInstance();
                aVar.setFlutterPath("onPause1" + getContainerUrl());
            }
            ensureAlive();
            this.mSyncer.onDisappear();
            this.flutterEngine.getLifecycleChannel().appIsInactive();
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
            ensureAlive();
        }
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, strArr, iArr) == null) {
            this.mSyncer.onRequestPermissionsResult(i2, strArr, iArr);
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i2 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
                this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i2, strArr, iArr);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before NewFlutterFragment was attached to an Activity.");
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (FlutterCrabReportEnableSwitch.isOn()) {
                a aVar = a.getInstance();
                aVar.setFlutterPath("onResume1" + getContainerUrl());
            }
            a.getInstance().setLastFlutterPage(getContainerUrl());
            this.mSyncer.onAppear();
            Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsResumed();
            int i2 = ACTIVITY_CONTROL_SURFACE_ATTACH_TO_ACTVITY_HASH_CODE;
            if (i2 == 0 || i2 != this.host.hashCode()) {
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
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
            ensureAlive();
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
            ensureAlive();
        }
    }

    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mSyncer.onTrimMemory(i2);
            ensureAlive();
            if (this.flutterEngine == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before NewFlutterFragment was attached to an Activity.");
            } else if (i2 == 10) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i2);
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
                this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.host = null;
            this.flutterEngine = null;
            this.flutterView = null;
            this.platformPlugin = null;
        }
    }

    public void setBoostResult(Activity activity, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, activity, hashMap) == null) {
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
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void setSwipeBackEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.host.setSwipeBackEnable(z);
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IFlutterViewContainer
    public void swipeBackControl(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.host.swipeBackControl(d2);
        }
    }
}
