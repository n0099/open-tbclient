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
import androidx.lifecycle.Lifecycle;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class FlutterActivityAndFragmentDelegate {
    private static final String TAG = "FlutterActivityAndFragmentDelegate";
    @Nullable
    private FlutterEngine flutterEngine;
    @Nullable
    private FlutterSplashView flutterSplashView;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.1
        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiDisplayed();
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate.this.host.onFlutterUiNoLongerDisplayed();
        }
    };
    @Nullable
    private FlutterView flutterView;
    @NonNull
    private Host host;
    private boolean isFlutterEngineFromHost;
    @Nullable
    private PlatformPlugin platformPlugin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider {
        @Override // io.flutter.embedding.android.FlutterEngineConfigurator
        void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

        @Override // io.flutter.embedding.android.FlutterEngineConfigurator
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

        @Nullable
        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();
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
    public boolean isFlutterEngineFromHost() {
        return this.isFlutterEngineFromHost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttach(@NonNull Context context) {
        ensureAlive();
        if (this.flutterEngine == null) {
            setupFlutterEngine();
        }
        this.platformPlugin = this.host.providePlatformPlugin(this.host.getActivity(), this.flutterEngine);
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Attaching FlutterEngine to the Activity that owns this Fragment.");
            this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
        }
        this.host.configureFlutterEngine(this.flutterEngine);
    }

    @VisibleForTesting
    void setupFlutterEngine() {
        Log.v(TAG, "Setting up FlutterEngine.");
        String cachedEngineId = this.host.getCachedEngineId();
        if (cachedEngineId != null) {
            this.flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.isFlutterEngineFromHost = true;
            if (this.flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        this.flutterEngine = this.host.provideFlutterEngine(this.host.getContext());
        if (this.flutterEngine != null) {
            this.isFlutterEngineFromHost = true;
            return;
        }
        Log.v(TAG, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false);
        this.isFlutterEngineFromHost = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Log.v(TAG, "Creating FlutterView.");
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
        this.flutterSplashView = new FlutterSplashView(this.host.getContext());
        if (Build.VERSION.SDK_INT >= 17) {
            this.flutterSplashView.setId(View.generateViewId());
        } else {
            this.flutterSplashView.setId(486947586);
        }
        this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
        Log.v(TAG, "Attaching FlutterEngine to FlutterView.");
        this.flutterView.attachToFlutterEngine(this.flutterEngine);
        return this.flutterSplashView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityCreated(@Nullable Bundle bundle) {
        Log.v(TAG, "onActivityCreated. Giving plugins an opportunity to restore state.");
        ensureAlive();
        if (this.host.shouldAttachEngineToActivity()) {
            this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStart() {
        Log.v(TAG, "onStart()");
        ensureAlive();
        doInitialFlutterViewRun();
    }

    private void doInitialFlutterViewRun() {
        if (this.host.getCachedEngineId() == null && !this.flutterEngine.getDartExecutor().isExecutingDart()) {
            Log.v(TAG, "Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", and sending initial route: " + this.host.getInitialRoute());
            if (this.host.getInitialRoute() != null) {
                this.flutterEngine.getNavigationChannel().setInitialRoute(this.host.getInitialRoute());
            }
            this.flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(this.host.getAppBundlePath(), this.host.getDartEntrypointFunctionName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume() {
        Log.v(TAG, "onResume()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPostResume() {
        Log.v(TAG, "onPostResume()");
        ensureAlive();
        if (this.flutterEngine != null) {
            if (this.platformPlugin != null) {
                this.platformPlugin.updateSystemUiOverlays();
                return;
            }
            return;
        }
        Log.w(TAG, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause() {
        Log.v(TAG, "onPause()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsInactive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStop() {
        Log.v(TAG, "onStop()");
        ensureAlive();
        this.flutterEngine.getLifecycleChannel().appIsPaused();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroyView() {
        Log.v(TAG, "onDestroyView()");
        ensureAlive();
        this.flutterView.detachFromFlutterEngine();
        this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSaveInstanceState(@Nullable Bundle bundle) {
        Log.v(TAG, "onSaveInstanceState. Giving plugins an opportunity to save state.");
        ensureAlive();
        if (this.host.shouldAttachEngineToActivity()) {
            this.flutterEngine.getActivityControlSurface().onSaveInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetach() {
        Log.v(TAG, "onDetach()");
        ensureAlive();
        this.host.cleanUpFlutterEngine(this.flutterEngine);
        if (this.host.shouldAttachEngineToActivity()) {
            Log.v(TAG, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.host.getActivity().isChangingConfigurations()) {
                this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.flutterEngine.getActivityControlSurface().detachFromActivity();
            }
        }
        if (this.platformPlugin != null) {
            this.platformPlugin.destroy();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBackPressed() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onBackPressed() to FlutterEngine.");
            this.flutterEngine.getNavigationChannel().popRoute();
            return;
        }
        Log.w(TAG, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.w(TAG, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNewIntent(@NonNull Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onNewIntent() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onNewIntent(intent);
            return;
        }
        Log.w(TAG, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityResult(int i, int i2, Intent intent) {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.flutterEngine.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.w(TAG, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onUserLeaveHint() {
        ensureAlive();
        if (this.flutterEngine != null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.w(TAG, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTrimMemory(int i) {
        ensureAlive();
        if (this.flutterEngine != null) {
            if (i == 10) {
                Log.v(TAG, "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
                this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
                return;
            }
            return;
        }
        Log.w(TAG, "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLowMemory() {
        Log.v(TAG, "Forwarding onLowMemory() to FlutterEngine.");
        ensureAlive();
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }

    private void ensureAlive() {
        if (this.host == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
