package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.searchbox.taskmanager.IdleLaunchTaskManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.switchs.FlutterFragmentSpeedSwitch;
import com.baidu.tbadk.switchs.FlutterLifeCycleBugEnableSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FlutterFragment extends BaseFragment implements FlutterActivityAndFragmentDelegate.Host {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    public static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    public static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    public static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    public static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    public static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    public static final String ARG_INITIAL_ROUTE = "initial_route";
    public static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_URL = "url";
    public static final String TAG = "NewFlutterFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public FlutterActivityAndFragmentDelegate delegate;
    public View flutterView;
    public boolean isAddFlutterView;
    public boolean isAttach;
    public boolean isResumedOrVisibleToUser;
    public LinearLayout linearLayout;
    public boolean sendReumeToDart;

    public FlutterFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sendReumeToDart = false;
        this.isAttach = false;
        this.isAddFlutterView = false;
        setArguments(new Bundle());
    }

    @NonNull
    public static FlutterFragment createDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new NewEngineFragmentBuilder().build() : (FlutterFragment) invokeV.objValue;
    }

    @NonNull
    private Context getContextCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return getContext();
            }
            return getActivity();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new NewEngineFragmentBuilder() : (NewEngineFragmentBuilder) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterEngine) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterEngine) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterEngineConfigurator) {
                ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
            }
        }
    }

    public void doSpeedLoad() {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (flutterActivityAndFragmentDelegate = this.delegate) == null) {
            return;
        }
        if (!this.isAttach) {
            this.isAttach = true;
            flutterActivityAndFragmentDelegate.onAttach(getContext());
            this.flutterView = this.delegate.onCreateView(null, null, null);
        }
        if (this.isAddFlutterView || (linearLayout = this.linearLayout) == null) {
            return;
        }
        this.isAddFlutterView = true;
        linearLayout.addView(this.flutterView);
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.wallet.lightapp.multipage.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getArguments().getString("url") : (String) invokeV.objValue;
    }

    public Map<String, Object> getContainerUrlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap() : (Map) invokeV.objValue;
    }

    public FlutterActivityAndFragmentDelegate getFlutterDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate : (FlutterActivityAndFragmentDelegate) invokeV.objValue;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.delegate.getFlutterEngine() : (FlutterEngine) invokeV.objValue;
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] stringArray = getArguments().getStringArray("initialization_args");
            if (stringArray == null) {
                stringArray = new String[0];
            }
            return new FlutterShellArgs(stringArray);
        }
        return (FlutterShellArgs) invokeV.objValue;
    }

    public XFlutterView getFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.delegate.getFlutterView() : (XFlutterView) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.RenderMode getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? FlutterView.RenderMode.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.RenderMode.surface.name())) : (FlutterView.RenderMode) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name())) : (FlutterView.TransparencyMode) invokeV.objValue;
    }

    public boolean isFlutterFragmentLazySwitchClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !FlutterFragmentSpeedSwitch.getIsOn() : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            if (isFlutterFragmentLazySwitchClosed()) {
                FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
                if (flutterActivityAndFragmentDelegate != null) {
                    flutterActivityAndFragmentDelegate.onActivityResult(i2, i3, intent);
                    return;
                }
                return;
            }
            FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate2 = this.delegate;
            if (flutterActivityAndFragmentDelegate2 != null && this.isAttach && this.isAddFlutterView) {
                flutterActivityAndFragmentDelegate2.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            super.onAttach(context);
            this.delegate = new FlutterActivityAndFragmentDelegate(this);
            if (isFlutterFragmentLazySwitchClosed()) {
                this.delegate.onAttach(context);
            }
        }
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.delegate.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            if (isFlutterFragmentLazySwitchClosed()) {
                return this.delegate.onCreateView(layoutInflater, viewGroup, bundle);
            }
            this.linearLayout = new LinearLayout(getActivity());
            IdleLaunchTaskManager.registerIdleTask(new IdleLaunchTask(this) { // from class: com.idlefish.flutterboost.containers.FlutterFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterFragment this$0;

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

                @Override // com.baidu.searchbox.launch.SmartLaunchTask
                public void execute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doSpeedLoad();
                    }
                }
            });
            return this.linearLayout;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            if (this.delegate != null) {
                if (isFlutterFragmentLazySwitchClosed()) {
                    this.delegate.onDestroyView();
                } else if (this.isAttach && this.isAddFlutterView) {
                    this.delegate.onDestroyView();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDetach();
            if (isFlutterFragmentLazySwitchClosed()) {
                this.delegate.onDetach();
            } else if (this.isAttach) {
                this.delegate.onDetach();
            }
            this.delegate.release();
            this.linearLayout = null;
            this.flutterView = null;
            this.delegate = null;
            this.isAttach = false;
            this.isAddFlutterView = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.onHiddenChanged(z);
            if (z) {
                this.delegate.onPause();
            } else {
                this.delegate.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLowMemory();
            if (this.delegate != null) {
                if (isFlutterFragmentLazySwitchClosed()) {
                    this.delegate.onLowMemory();
                } else if (this.isAttach && this.isAddFlutterView) {
                    this.delegate.onLowMemory();
                }
            }
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            this.delegate.onNewIntent(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            if (!isHidden() && this.sendReumeToDart && this.isResumedOrVisibleToUser) {
                this.isResumedOrVisibleToUser = false;
                this.delegate.onPause();
            }
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.delegate.onPostResume();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i2, strArr, iArr) == null) {
            this.delegate.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            if (isHidden() || !this.sendReumeToDart || this.isResumedOrVisibleToUser) {
                return;
            }
            this.isResumedOrVisibleToUser = true;
            if (!isFlutterFragmentLazySwitchClosed()) {
                doSpeedLoad();
            }
            this.delegate.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStart();
            if (isHidden()) {
                return;
            }
            this.delegate.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStop();
            if (isHidden()) {
                return;
            }
            this.delegate.onStop();
        }
    }

    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || this.delegate == null) {
            return;
        }
        if (isFlutterFragmentLazySwitchClosed()) {
            this.delegate.onTrimMemory(i2);
        } else if (this.isAttach && this.isAddFlutterView) {
            this.delegate.onTrimMemory(i2);
        }
    }

    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.delegate.onUserLeaveHint();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) ? FlutterBoost.instance().engineProvider() : (FlutterEngine) invokeL.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, flutterEngine)) == null) ? BoostViewUtils.getPlatformPlugin(flutterEngine.getPlatformChannel()) : (XPlatformPlugin) invokeL.objValue;
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof SplashScreenProvider) {
                return ((SplashScreenProvider) activity).provideSplashScreen();
            }
            return null;
        }
        return (SplashScreen) invokeV.objValue;
    }

    public void sendReumeToDart(@NonNull boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.sendReumeToDart = z;
        }
    }

    public void setSwipeBackEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (flutterActivityAndFragmentDelegate = this.delegate) == null) {
            return;
        }
        if (z) {
            if (!this.isResumedOrVisibleToUser) {
                this.sendReumeToDart = true;
                this.isResumedOrVisibleToUser = true;
                if (!isFlutterFragmentLazySwitchClosed()) {
                    doSpeedLoad();
                }
                this.delegate.onResume();
            }
        } else if (this.isResumedOrVisibleToUser) {
            this.sendReumeToDart = false;
            this.isResumedOrVisibleToUser = false;
            flutterActivityAndFragmentDelegate.onPause();
        }
        if (FlutterLifeCycleBugEnableSwitch.isOn()) {
            this.sendReumeToDart = z;
            this.isResumedOrVisibleToUser = z;
        }
    }

    public boolean shouldAttachEngineToActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Double.valueOf(d2)}) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class NewEngineFragmentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends FlutterFragment> fragmentClass;
        public boolean isUseTabHost;
        public Map params;
        public FlutterView.RenderMode renderMode;
        public FlutterShellArgs shellArgs;
        public FlutterView.TransparencyMode transparencyMode;
        public String url;

        public NewEngineFragmentBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.texture;
            this.transparencyMode = FlutterView.TransparencyMode.opaque;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = FlutterFragment.class;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    T t = (T) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (t != null) {
                        t.setArguments(createArgs());
                        t.sendReumeToDart(this.isUseTabHost ? false : true);
                        return t;
                    }
                    throw new RuntimeException("The NewFlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
                } catch (Exception e2) {
                    throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.fragmentClass.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            return (T) invokeV.objValue;
        }

        @NonNull
        public Bundle createArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Bundle bundle = new Bundle();
                FlutterShellArgs flutterShellArgs = this.shellArgs;
                if (flutterShellArgs != null) {
                    bundle.putStringArray("initialization_args", flutterShellArgs.toArray());
                }
                BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
                serializableMap.setMap(this.params);
                bundle.putString("url", this.url);
                bundle.putSerializable("params", serializableMap);
                FlutterView.RenderMode renderMode = this.renderMode;
                if (renderMode == null) {
                    renderMode = FlutterView.RenderMode.surface;
                }
                bundle.putString("flutterview_render_mode", renderMode.name());
                FlutterView.TransparencyMode transparencyMode = this.transparencyMode;
                if (transparencyMode == null) {
                    transparencyMode = FlutterView.TransparencyMode.transparent;
                }
                bundle.putString("flutterview_transparency_mode", transparencyMode.name());
                bundle.putBoolean("destroy_engine_with_fragment", true);
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        public NewEngineFragmentBuilder isTabHost(@NonNull boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.isUseTabHost = z;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeZ.objValue;
        }

        public NewEngineFragmentBuilder params(@NonNull Map map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                this.params = map;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        public NewEngineFragmentBuilder url(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.url = str;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.texture;
            this.transparencyMode = FlutterView.TransparencyMode.opaque;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = cls;
        }
    }
}
