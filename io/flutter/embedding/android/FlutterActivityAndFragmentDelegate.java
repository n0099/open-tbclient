package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class FlutterActivityAndFragmentDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterActivityAndFragmentDelegate";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public FlutterEngine flutterEngine;
    @Nullable
    public FlutterSplashView flutterSplashView;
    @NonNull
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    public FlutterView flutterView;
    @NonNull
    public Host host;
    public boolean isFlutterEngineFromHost;
    @Nullable
    public PlatformPlugin platformPlugin;

    /* loaded from: classes9.dex */
    public interface Host extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator {
        void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        @Nullable
        Activity getActivity();

        @NonNull
        String getAppBundlePath();

        @Nullable
        String getCachedEngineId();

        @NonNull
        Context getContext();

        @NonNull
        String getDartEntrypointFunctionName();

        @NonNull
        FlutterShellArgs getFlutterShellArgs();

        @Nullable
        String getInitialRoute();

        @NonNull
        Lifecycle getLifecycle();

        @NonNull
        RenderMode getRenderMode();

        @NonNull
        TransparencyMode getTransparencyMode();

        void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView);

        void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView);

        void onFlutterUiDisplayed();

        void onFlutterUiNoLongerDisplayed();

        @Nullable
        FlutterEngine provideFlutterEngine(@NonNull Context context);

        @Nullable
        PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine);

        @Override // io.flutter.embedding.android.SplashScreenProvider
        @Nullable
        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();
    }

    public FlutterActivityAndFragmentDelegate(@NonNull Host host) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {host};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterActivityAndFragmentDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.host.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.host.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.host = host;
    }

    private void doInitialFlutterViewRun() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.host.getCachedEngineId() == null && !this.flutterEngine.getDartExecutor().isExecutingDart()) {
            Log.v("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", and sending initial route: " + this.host.getInitialRoute());
            if (this.host.getInitialRoute() != null) {
                this.flutterEngine.getNavigationChannel().setInitialRoute(this.host.getInitialRoute());
            }
            this.flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(this.host.getAppBundlePath(), this.host.getDartEntrypointFunctionName()));
        }
    }

    private void ensureAlive() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
    }

    public boolean isFlutterEngineFromHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isFlutterEngineFromHost : invokeV.booleanValue;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onActivityCreated. Giving plugins an opportunity to restore state.");
            ensureAlive();
            if (this.host.shouldAttachEngineToActivity()) {
                this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(bundle);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i2 + "\nresultCode: " + i3 + "\ndata: " + intent);
                this.flutterEngine.getActivityControlSurface().onActivityResult(i2, i3, intent);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            ensureAlive();
            if (this.flutterEngine == null) {
                setupFlutterEngine();
            }
            Host host = this.host;
            this.platformPlugin = host.providePlatformPlugin(host.getActivity(), this.flutterEngine);
            if (this.host.shouldAttachEngineToActivity()) {
                Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this Fragment.");
                this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
            }
            this.host.configureFlutterEngine(this.flutterEngine);
        }
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
                this.flutterEngine.getNavigationChannel().popRoute();
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        }
    }

    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
            ensureAlive();
            if (this.host.getRenderMode() == RenderMode.surface) {
                FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(this.host.getActivity(), this.host.getTransparencyMode() == TransparencyMode.transparent);
                this.host.onFlutterSurfaceViewCreated(flutterSurfaceView);
                this.flutterView = new FlutterView(this.host.getActivity(), flutterSurfaceView);
            } else {
                FlutterTextureView flutterTextureView = new FlutterTextureView(this.host.getActivity());
                this.host.onFlutterTextureViewCreated(flutterTextureView);
                this.flutterView = new FlutterView(this.host.getActivity(), flutterTextureView);
            }
            this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            FlutterSplashView flutterSplashView = new FlutterSplashView(this.host.getContext());
            this.flutterSplashView = flutterSplashView;
            if (Build.VERSION.SDK_INT >= 17) {
                flutterSplashView.setId(View.generateViewId());
            } else {
                flutterSplashView.setId(486947586);
            }
            this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
            Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.flutterView.attachToFlutterEngine(this.flutterEngine);
            return this.flutterSplashView;
        }
        return (View) invokeLLL.objValue;
    }

    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
            ensureAlive();
            this.flutterView.detachFromFlutterEngine();
            this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
            ensureAlive();
            this.host.cleanUpFlutterEngine(this.flutterEngine);
            if (this.host.shouldAttachEngineToActivity()) {
                Log.v("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
                if (this.host.getActivity().isChangingConfigurations()) {
                    this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
                } else {
                    this.flutterEngine.getActivityControlSurface().detachFromActivity();
                }
            }
            PlatformPlugin platformPlugin = this.platformPlugin;
            if (platformPlugin != null) {
                platformPlugin.destroy();
                this.platformPlugin = null;
            }
            this.flutterEngine.getLifecycleChannel().appIsDetached();
            if (this.host.shouldDestroyEngineWithHost()) {
                this.flutterEngine.destroy();
                if (this.host.getCachedEngineId() != null) {
                    FlutterEngineCache.getInstance().remove(this.host.getCachedEngineId());
                }
                this.flutterEngine = null;
            }
        }
    }

    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
            ensureAlive();
            this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.");
                this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsInactive();
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
            ensureAlive();
            if (this.flutterEngine != null) {
                PlatformPlugin platformPlugin = this.platformPlugin;
                if (platformPlugin != null) {
                    platformPlugin.updateSystemUiOverlays();
                    return;
                }
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, strArr, iArr) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i2 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
                this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i2, strArr, iArr);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

    public void onSaveInstanceState(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving plugins an opportunity to save state.");
            ensureAlive();
            if (this.host.shouldAttachEngineToActivity()) {
                this.flutterEngine.getActivityControlSurface().onSaveInstanceState(bundle);
            }
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
            ensureAlive();
            doInitialFlutterViewRun();
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsPaused();
        }
    }

    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            ensureAlive();
            if (this.flutterEngine == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
            } else if (i2 == 10) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i2);
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
                this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.host = null;
            this.flutterEngine = null;
            this.flutterView = null;
            this.platformPlugin = null;
        }
    }

    @VisibleForTesting
    public void setupFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
            String cachedEngineId = this.host.getCachedEngineId();
            if (cachedEngineId != null) {
                FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
                this.flutterEngine = flutterEngine;
                this.isFlutterEngineFromHost = true;
                if (flutterEngine != null) {
                    return;
                }
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            Host host = this.host;
            FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
            this.flutterEngine = provideFlutterEngine;
            if (provideFlutterEngine != null) {
                this.isFlutterEngineFromHost = true;
                return;
            }
            Log.v("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
            this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false);
            this.isFlutterEngineFromHost = false;
        }
    }
}
