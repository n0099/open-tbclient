package io.flutter.embedding.android;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
/* loaded from: classes3.dex */
public class FlutterFragment extends Fragment implements FlutterActivityAndFragmentDelegate.Host, ComponentCallbacks2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    public static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    public static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    public static final String ARG_ENABLE_STATE_RESTORATION = "enable_state_restoration";
    public static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    public static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    public static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    public static final String ARG_HANDLE_DEEPLINKING = "handle_deeplinking";
    public static final String ARG_INITIAL_ROUTE = "initial_route";
    public static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    public static final String ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED = "should_automatically_handle_on_back_pressed";
    public static final String ARG_SHOULD_DELAY_FIRST_ANDROID_VIEW_DRAW = "should_delay_first_android_view_draw";
    public static final int FLUTTER_VIEW_ID;
    public static final String TAG = "FlutterFragment";
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public FlutterActivityAndFragmentDelegate delegate;
    public final OnBackPressedCallback onBackPressedCallback;

    /* loaded from: classes3.dex */
    public @interface ActivityCallThrough {
    }

    /* loaded from: classes3.dex */
    public static class CachedEngineFragmentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean destroyEngineWithFragment;
        public final String engineId;
        public final Class<? extends FlutterFragment> fragmentClass;
        public boolean handleDeeplinking;
        public RenderMode renderMode;
        public boolean shouldAttachEngineToActivity;
        public boolean shouldAutomaticallyHandleOnBackPressed;
        public boolean shouldDelayFirstAndroidViewDraw;
        public TransparencyMode transparencyMode;

        @NonNull
        public <T extends FlutterFragment> T build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    T t = (T) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (t != null) {
                        t.setArguments(createArgs());
                        return t;
                    }
                    throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
                } catch (Exception e2) {
                    throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
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
                bundle.putString("cached_engine_id", this.engineId);
                bundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
                bundle.putBoolean(FlutterFragment.ARG_HANDLE_DEEPLINKING, this.handleDeeplinking);
                RenderMode renderMode = this.renderMode;
                if (renderMode == null) {
                    renderMode = RenderMode.surface;
                }
                bundle.putString("flutterview_render_mode", renderMode.name());
                TransparencyMode transparencyMode = this.transparencyMode;
                if (transparencyMode == null) {
                    transparencyMode = TransparencyMode.transparent;
                }
                bundle.putString("flutterview_transparency_mode", transparencyMode.name());
                bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
                bundle.putBoolean(FlutterFragment.ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, this.shouldAutomaticallyHandleOnBackPressed);
                bundle.putBoolean(FlutterFragment.ARG_SHOULD_DELAY_FIRST_ANDROID_VIEW_DRAW, this.shouldDelayFirstAndroidViewDraw);
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.destroyEngineWithFragment = z;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder handleDeeplinking(@NonNull Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bool)) == null) {
                this.handleDeeplinking = bool.booleanValue();
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, renderMode)) == null) {
                this.renderMode = renderMode;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.shouldAttachEngineToActivity = z;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldAutomaticallyHandleOnBackPressed(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.shouldAutomaticallyHandleOnBackPressed = z;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldDelayFirstAndroidViewDraw(@NonNull boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.shouldDelayFirstAndroidViewDraw = z;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public CachedEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, transparencyMode)) == null) {
                this.transparencyMode = transparencyMode;
                return this;
            }
            return (CachedEngineFragmentBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CachedEngineFragmentBuilder(@NonNull String str) {
            this(FlutterFragment.class, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Class) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public CachedEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.destroyEngineWithFragment = false;
            this.handleDeeplinking = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = cls;
            this.engineId = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(101598519, "Lio/flutter/embedding/android/FlutterFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(101598519, "Lio/flutter/embedding/android/FlutterFragment;");
                return;
            }
        }
        FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);
    }

    public FlutterFragment() {
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
        this.onBackPressedCallback = new OnBackPressedCallback(this, true) { // from class: io.flutter.embedding.android.FlutterFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Boolean) newInitContext2.callArgs[0]).booleanValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.onBackPressed();
                }
            }
        };
        setArguments(new Bundle());
    }

    @NonNull
    public static FlutterFragment createDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new NewEngineFragmentBuilder().build() : (FlutterFragment) invokeV.objValue;
    }

    private boolean stillAttachedForEvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (this.delegate == null) {
                Log.w(TAG, "FlutterFragment " + hashCode() + " " + str + " called after release.");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static CachedEngineFragmentBuilder withCachedEngine(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new CachedEngineFragmentBuilder(str) : (CachedEngineFragmentBuilder) invokeL.objValue;
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new NewEngineFragmentBuilder() : (NewEngineFragmentBuilder) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterEngine) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterEngineConfigurator) {
                ((FlutterEngineConfigurator) activity).cleanUpFlutterEngine(flutterEngine);
            }
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterEngine) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterEngineConfigurator) {
                ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
            }
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void detachFromFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.w(TAG, "FlutterFragment " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
            this.delegate.onDestroyView();
            this.delegate.onDetach();
            this.delegate.release();
            this.delegate = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getAppBundlePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getArguments().getString("app_bundle_path") : (String) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public String getCachedEngineId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getArguments().getString("cached_engine_id", null) : (String) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getDartEntrypointFunctionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getArguments().getString("dart_entrypoint", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT) : (String) invokeV.objValue;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.delegate.getFlutterEngine() : (FlutterEngine) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
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

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public String getInitialRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getArguments().getString("initial_route") : (String) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public RenderMode getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name())) : (RenderMode) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public TransparencyMode getTransparencyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name())) : (TransparencyMode) invokeV.objValue;
    }

    public boolean isFlutterEngineInjected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.delegate.isFlutterEngineFromHost() : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) && stillAttachedForEvent("onActivityResult")) {
            this.delegate.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            super.onAttach(context);
            FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
            this.delegate = flutterActivityAndFragmentDelegate;
            flutterActivityAndFragmentDelegate.onAttach(context);
            if (getArguments().getBoolean(ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, false)) {
                requireActivity().getOnBackPressedDispatcher().addCallback(this, this.onBackPressedCallback);
            }
        }
    }

    @ActivityCallThrough
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && stillAttachedForEvent("onBackPressed")) {
            this.delegate.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            this.delegate.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) ? this.delegate.onCreateView(layoutInflater, viewGroup, bundle, FLUTTER_VIEW_ID, shouldDelayFirstAndroidViewDraw()) : (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroyView();
            if (stillAttachedForEvent("onDestroyView")) {
                this.delegate.onDestroyView();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetach();
            FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
            if (flutterActivityAndFragmentDelegate != null) {
                flutterActivityAndFragmentDelegate.onDetach();
                this.delegate.release();
                this.delegate = null;
                return;
            }
            Log.v(TAG, "FlutterFragment " + this + " onDetach called after release.");
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, flutterSurfaceView) == null) {
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, flutterTextureView) == null) {
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterUiDisplayListener) {
                ((FlutterUiDisplayListener) activity).onFlutterUiDisplayed();
            }
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiNoLongerDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterUiDisplayListener) {
                ((FlutterUiDisplayListener) activity).onFlutterUiNoLongerDisplayed();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onLowMemory();
            if (stillAttachedForEvent("onLowMemory")) {
                this.delegate.onLowMemory();
            }
        }
    }

    @ActivityCallThrough
    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, intent) == null) && stillAttachedForEvent("onNewIntent")) {
            this.delegate.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            if (stillAttachedForEvent(MissionEvent.MESSAGE_PAUSE)) {
                this.delegate.onPause();
            }
        }
    }

    @ActivityCallThrough
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.delegate.onPostResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @ActivityCallThrough
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048604, this, i2, strArr, iArr) == null) && stillAttachedForEvent("onRequestPermissionsResult")) {
            this.delegate.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            if (stillAttachedForEvent("onResume")) {
                this.delegate.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (stillAttachedForEvent("onSaveInstanceState")) {
                this.delegate.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onStart();
            if (stillAttachedForEvent("onStart")) {
                this.delegate.onStart();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onStop();
            if (stillAttachedForEvent(MissionEvent.MESSAGE_STOP)) {
                this.delegate.onStop();
            }
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i2) == null) && stillAttachedForEvent("onTrimMemory")) {
            this.delegate.onTrimMemory(i2);
        }
    }

    @ActivityCallThrough
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && stillAttachedForEvent("onUserLeaveHint")) {
            this.delegate.onUserLeaveHint();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformPlugin.PlatformPluginDelegate
    public boolean popSystemNavigator() {
        InterceptResult invokeV;
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!getArguments().getBoolean(ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, false) || (activity = getActivity()) == null) {
                return false;
            }
            this.onBackPressedCallback.setEnabled(false);
            activity.getOnBackPressedDispatcher().onBackPressed();
            this.onBackPressedCallback.setEnabled(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, context)) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FlutterEngineProvider) {
                Log.v(TAG, "Deferring to attached Activity to provide a FlutterEngine.");
                return ((FlutterEngineProvider) activity).provideFlutterEngine(getContext());
            }
            return null;
        }
        return (FlutterEngine) invokeL.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, activity, flutterEngine)) == null) {
            if (activity != null) {
                return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
            }
            return null;
        }
        return (PlatformPlugin) invokeLL.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof SplashScreenProvider) {
                return ((SplashScreenProvider) activity).provideSplashScreen();
            }
            return null;
        }
        return (SplashScreen) invokeV.objValue;
    }

    @VisibleForTesting
    public void setDelegate(@NonNull FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, flutterActivityAndFragmentDelegate) == null) {
            this.delegate = flutterActivityAndFragmentDelegate;
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? getArguments().getBoolean("should_attach_engine_to_activity") : invokeV.booleanValue;
    }

    @NonNull
    @VisibleForTesting
    public boolean shouldDelayFirstAndroidViewDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? getArguments().getBoolean(ARG_SHOULD_DELAY_FIRST_ANDROID_VIEW_DRAW) : invokeV.booleanValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            boolean z = getArguments().getBoolean("destroy_engine_with_fragment", false);
            return (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) ? z : getArguments().getBoolean("destroy_engine_with_fragment", true);
        }
        return invokeV.booleanValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldHandleDeeplinking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? getArguments().getBoolean(ARG_HANDLE_DEEPLINKING) : invokeV.booleanValue;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldRestoreAndSaveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (getArguments().containsKey("enable_state_restoration")) {
                return getArguments().getBoolean("enable_state_restoration");
            }
            return getCachedEngineId() == null;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static class NewEngineFragmentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appBundlePath;
        public String dartEntrypoint;
        public final Class<? extends FlutterFragment> fragmentClass;
        public boolean handleDeeplinking;
        public String initialRoute;
        public RenderMode renderMode;
        public FlutterShellArgs shellArgs;
        public boolean shouldAttachEngineToActivity;
        public boolean shouldAutomaticallyHandleOnBackPressed;
        public boolean shouldDelayFirstAndroidViewDraw;
        public TransparencyMode transparencyMode;

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
            this.dartEntrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            this.initialRoute = "/";
            this.handleDeeplinking = false;
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = FlutterFragment.class;
        }

        @NonNull
        public NewEngineFragmentBuilder appBundlePath(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.appBundlePath = str;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    T t = (T) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (t != null) {
                        t.setArguments(createArgs());
                        return t;
                    }
                    throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
                } catch (Exception e2) {
                    throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            return (T) invokeV.objValue;
        }

        @NonNull
        public Bundle createArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("initial_route", this.initialRoute);
                bundle.putBoolean(FlutterFragment.ARG_HANDLE_DEEPLINKING, this.handleDeeplinking);
                bundle.putString("app_bundle_path", this.appBundlePath);
                bundle.putString("dart_entrypoint", this.dartEntrypoint);
                FlutterShellArgs flutterShellArgs = this.shellArgs;
                if (flutterShellArgs != null) {
                    bundle.putStringArray("initialization_args", flutterShellArgs.toArray());
                }
                RenderMode renderMode = this.renderMode;
                if (renderMode == null) {
                    renderMode = RenderMode.surface;
                }
                bundle.putString("flutterview_render_mode", renderMode.name());
                TransparencyMode transparencyMode = this.transparencyMode;
                if (transparencyMode == null) {
                    transparencyMode = TransparencyMode.transparent;
                }
                bundle.putString("flutterview_transparency_mode", transparencyMode.name());
                bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
                bundle.putBoolean("destroy_engine_with_fragment", true);
                bundle.putBoolean(FlutterFragment.ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, this.shouldAutomaticallyHandleOnBackPressed);
                bundle.putBoolean(FlutterFragment.ARG_SHOULD_DELAY_FIRST_ANDROID_VIEW_DRAW, this.shouldDelayFirstAndroidViewDraw);
                return bundle;
            }
            return (Bundle) invokeV.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder dartEntrypoint(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.dartEntrypoint = str;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs flutterShellArgs) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, flutterShellArgs)) == null) {
                this.shellArgs = flutterShellArgs;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder handleDeeplinking(@NonNull Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bool)) == null) {
                this.handleDeeplinking = bool.booleanValue();
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder initialRoute(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.initialRoute = str;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, renderMode)) == null) {
                this.renderMode = renderMode;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeL.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.shouldAttachEngineToActivity = z;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldAutomaticallyHandleOnBackPressed(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.shouldAutomaticallyHandleOnBackPressed = z;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldDelayFirstAndroidViewDraw(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.shouldDelayFirstAndroidViewDraw = z;
                return this;
            }
            return (NewEngineFragmentBuilder) invokeZ.objValue;
        }

        @NonNull
        public NewEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, transparencyMode)) == null) {
                this.transparencyMode = transparencyMode;
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
            this.dartEntrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            this.initialRoute = "/";
            this.handleDeeplinking = false;
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.shouldAutomaticallyHandleOnBackPressed = false;
            this.shouldDelayFirstAndroidViewDraw = false;
            this.fragmentClass = cls;
        }
    }
}
