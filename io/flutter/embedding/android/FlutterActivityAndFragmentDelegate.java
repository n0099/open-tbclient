package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class FlutterActivityAndFragmentDelegate implements ExclusiveAppComponent<Activity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLUTTER_SPLASH_VIEW_FALLBACK_ID = 486947586;
    public static final String FRAMEWORK_RESTORATION_BUNDLE_KEY = "framework";
    public static final String PLUGINS_RESTORATION_BUNDLE_KEY = "plugins";
    public static final String TAG = "FlutterActivityAndFragmentDelegate";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @VisibleForTesting
    public ViewTreeObserver.OnPreDrawListener activePreDrawListener;
    @Nullable
    public FlutterEngine flutterEngine;
    @NonNull
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    public FlutterView flutterView;
    @NonNull
    public Host host;
    public boolean isFlutterEngineFromHost;
    public boolean isFlutterUiDisplayed;
    @Nullable
    public PlatformPlugin platformPlugin;

    /* loaded from: classes3.dex */
    public interface Host extends SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator, PlatformPlugin.PlatformPluginDelegate {
        void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);

        void detachFromFlutterEngine();

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

        @Nullable
        boolean shouldHandleDeeplinking();

        boolean shouldRestoreAndSaveState();
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
                    this.this$0.isFlutterUiDisplayed = true;
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.host.onFlutterUiNoLongerDisplayed();
                    this.this$0.isFlutterUiDisplayed = false;
                }
            }
        };
        this.host = host;
    }

    private void delayFirstAndroidViewDraw(FlutterView flutterView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, flutterView) == null) {
            if (this.host.getRenderMode() == RenderMode.surface) {
                if (this.activePreDrawListener != null) {
                    flutterView.getViewTreeObserver().removeOnPreDrawListener(this.activePreDrawListener);
                }
                this.activePreDrawListener = new ViewTreeObserver.OnPreDrawListener(this, flutterView) { // from class: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterActivityAndFragmentDelegate this$0;
                    public final /* synthetic */ FlutterView val$flutterView;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, flutterView};
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
                        this.val$flutterView = flutterView;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (this.this$0.isFlutterUiDisplayed && this.this$0.activePreDrawListener != null) {
                                this.val$flutterView.getViewTreeObserver().removeOnPreDrawListener(this);
                                this.this$0.activePreDrawListener = null;
                            }
                            return this.this$0.isFlutterUiDisplayed;
                        }
                        return invokeV.booleanValue;
                    }
                };
                flutterView.getViewTreeObserver().addOnPreDrawListener(this.activePreDrawListener);
                return;
            }
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
    }

    private void doInitialFlutterViewRun() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.host.getCachedEngineId() == null && !this.flutterEngine.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.host.getInitialRoute();
            if (initialRoute == null && (initialRoute = maybeGetInitialRouteFromIntent(this.host.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.v("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.host.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.host.getDartEntrypointFunctionName()));
        }
    }

    private void ensureAlive() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String maybeGetInitialRouteFromIntent(Intent intent) {
        InterceptResult invokeL;
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, intent)) == null) {
            if (!this.host.shouldHandleDeeplinking() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
                return null;
            }
            String path = data.getPath();
            if (data.getQuery() != null && !data.getQuery().isEmpty()) {
                path = path + "?" + data.getQuery();
            }
            if (data.getFragment() == null || data.getFragment().isEmpty()) {
                return path;
            }
            return path + "#" + data.getFragment();
        }
        return (String) invokeL.objValue;
    }

    @Override // io.flutter.embedding.android.ExclusiveAppComponent
    public void detachFromFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.host.shouldDestroyEngineWithHost()) {
                this.host.detachFromFlutterEngine();
                return;
            }
            throw new AssertionError("The internal FlutterEngine created by " + this.host + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
        }
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.flutterEngine : (FlutterEngine) invokeV.objValue;
    }

    public boolean isFlutterEngineFromHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isFlutterEngineFromHost : invokeV.booleanValue;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            ensureAlive();
            if (this.flutterEngine == null) {
                setupFlutterEngine();
            }
            if (this.host.shouldAttachEngineToActivity()) {
                Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
                this.flutterEngine.getActivityControlSurface().attachToActivity(this, this.host.getLifecycle());
            }
            Host host = this.host;
            this.platformPlugin = host.providePlatformPlugin(host.getActivity(), this.flutterEngine);
            this.host.configureFlutterEngine(this.flutterEngine);
        }
    }

    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{layoutInflater, viewGroup, bundle, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
            ensureAlive();
            if (this.host.getRenderMode() == RenderMode.surface) {
                FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(this.host.getContext(), this.host.getTransparencyMode() == TransparencyMode.transparent);
                this.host.onFlutterSurfaceViewCreated(flutterSurfaceView);
                this.flutterView = new FlutterView(this.host.getContext(), flutterSurfaceView);
            } else {
                FlutterTextureView flutterTextureView = new FlutterTextureView(this.host.getContext());
                flutterTextureView.setOpaque(this.host.getTransparencyMode() == TransparencyMode.opaque);
                this.host.onFlutterTextureViewCreated(flutterTextureView);
                this.flutterView = new FlutterView(this.host.getContext(), flutterTextureView);
            }
            this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.flutterView.attachToFlutterEngine(this.flutterEngine);
            this.flutterView.setId(i2);
            SplashScreen provideSplashScreen = this.host.provideSplashScreen();
            if (provideSplashScreen != null) {
                Log.w("FlutterActivityAndFragmentDelegate", "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
                FlutterSplashView flutterSplashView = new FlutterSplashView(this.host.getContext());
                flutterSplashView.setId(ViewUtils.generateViewId(FLUTTER_SPLASH_VIEW_FALLBACK_ID));
                flutterSplashView.displayFlutterViewWithSplash(this.flutterView, provideSplashScreen);
                return flutterSplashView;
            }
            if (z) {
                delayFirstAndroidViewDraw(this.flutterView);
            }
            return this.flutterView;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
            ensureAlive();
            if (this.activePreDrawListener != null) {
                this.flutterView.getViewTreeObserver().removeOnPreDrawListener(this.activePreDrawListener);
                this.activePreDrawListener = null;
            }
            this.flutterView.detachFromFlutterEngine();
            this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
            ensureAlive();
            this.flutterEngine.getDartExecutor().notifyLowMemoryWarning();
            this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
                this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
                String maybeGetInitialRouteFromIntent = maybeGetInitialRouteFromIntent(intent);
                if (maybeGetInitialRouteFromIntent == null || maybeGetInitialRouteFromIntent.isEmpty()) {
                    return;
                }
                this.flutterEngine.getNavigationChannel().pushRoute(maybeGetInitialRouteFromIntent);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsInactive();
        }
    }

    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, strArr, iArr) == null) {
            ensureAlive();
            if (this.flutterEngine != null) {
                Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i2 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
                this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i2, strArr, iArr);
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
            ensureAlive();
            byte[] bArr = null;
            if (bundle != null) {
                Bundle bundle3 = bundle.getBundle(PLUGINS_RESTORATION_BUNDLE_KEY);
                bArr = bundle.getByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY);
                bundle2 = bundle3;
            } else {
                bundle2 = null;
            }
            if (this.host.shouldRestoreAndSaveState()) {
                this.flutterEngine.getRestorationChannel().setRestorationData(bArr);
            }
            if (this.host.shouldAttachEngineToActivity()) {
                this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(bundle2);
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

    public void onSaveInstanceState(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
            ensureAlive();
            if (this.host.shouldRestoreAndSaveState()) {
                bundle.putByteArray(FRAMEWORK_RESTORATION_BUNDLE_KEY, this.flutterEngine.getRestorationChannel().getRestorationData());
            }
            if (this.host.shouldAttachEngineToActivity()) {
                Bundle bundle2 = new Bundle();
                this.flutterEngine.getActivityControlSurface().onSaveInstanceState(bundle2);
                bundle.putBundle(PLUGINS_RESTORATION_BUNDLE_KEY, bundle2);
            }
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
            ensureAlive();
            doInitialFlutterViewRun();
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
            ensureAlive();
            this.flutterEngine.getLifecycleChannel().appIsPaused();
        }
    }

    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            ensureAlive();
            FlutterEngine flutterEngine = this.flutterEngine;
            if (flutterEngine != null) {
                flutterEngine.getDartExecutor().notifyLowMemoryWarning();
                if (i2 == 10) {
                    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i2);
                    this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
                    return;
                }
                return;
            }
            Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.host = null;
            this.flutterEngine = null;
            this.flutterView = null;
            this.platformPlugin = null;
        }
    }

    @VisibleForTesting
    public void setupFlutterEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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
            this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false, this.host.shouldRestoreAndSaveState());
            this.isFlutterEngineFromHost = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.embedding.android.ExclusiveAppComponent
    @NonNull
    public Activity getAppComponent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Activity activity = this.host.getActivity();
            if (activity != null) {
                return activity;
            }
            throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
        }
        return (Activity) invokeV.objValue;
    }
}
