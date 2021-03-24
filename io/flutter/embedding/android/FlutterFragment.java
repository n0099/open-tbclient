package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
/* loaded from: classes7.dex */
public class FlutterFragment extends Fragment implements FlutterActivityAndFragmentDelegate.Host {
    public static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    public static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    public static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    public static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    public static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    public static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    public static final String ARG_INITIAL_ROUTE = "initial_route";
    public static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    public static final String TAG = "FlutterFragment";
    @VisibleForTesting
    public FlutterActivityAndFragmentDelegate delegate;

    /* loaded from: classes7.dex */
    public @interface ActivityCallThrough {
    }

    /* loaded from: classes7.dex */
    public static class CachedEngineFragmentBuilder {
        public boolean destroyEngineWithFragment;
        public final String engineId;
        public final Class<? extends FlutterFragment> fragmentClass;
        public RenderMode renderMode;
        public boolean shouldAttachEngineToActivity;
        public TransparencyMode transparencyMode;

        @NonNull
        public <T extends FlutterFragment> T build() {
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

        @NonNull
        public Bundle createArgs() {
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_id", this.engineId);
            bundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
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
            return bundle;
        }

        @NonNull
        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean z) {
            this.destroyEngineWithFragment = z;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode) {
            this.renderMode = renderMode;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean z) {
            this.shouldAttachEngineToActivity = z;
            return this;
        }

        @NonNull
        public CachedEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode) {
            this.transparencyMode = transparencyMode;
            return this;
        }

        public CachedEngineFragmentBuilder(@NonNull String str) {
            this(FlutterFragment.class, str);
        }

        public CachedEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls, @NonNull String str) {
            this.destroyEngineWithFragment = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = cls;
            this.engineId = str;
        }
    }

    public FlutterFragment() {
        setArguments(new Bundle());
    }

    @NonNull
    public static FlutterFragment createDefault() {
        return new NewEngineFragmentBuilder().build();
    }

    @NonNull
    public static CachedEngineFragmentBuilder withCachedEngine(@NonNull String str) {
        return new CachedEngineFragmentBuilder(str);
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        return new NewEngineFragmentBuilder();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).cleanUpFlutterEngine(flutterEngine);
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.wallet.lightapp.multipage.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getAppBundlePath() {
        return getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public String getCachedEngineId() {
        return getArguments().getString("cached_engine_id", null);
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getDartEntrypointFunctionName() {
        return getArguments().getString("dart_entrypoint", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        String[] stringArray = getArguments().getStringArray("initialization_args");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        return new FlutterShellArgs(stringArray);
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public String getInitialRoute() {
        return getArguments().getString("initial_route");
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public RenderMode getRenderMode() {
        return RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name()));
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.delegate.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        this.delegate.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(context);
    }

    @ActivityCallThrough
    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.delegate.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.delegate.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.delegate.onDetach();
        this.delegate.release();
        this.delegate = null;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView) {
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView) {
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiDisplayed() {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) activity).onFlutterUiDisplayed();
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiNoLongerDisplayed() {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterUiDisplayListener) {
            ((FlutterUiDisplayListener) activity).onFlutterUiNoLongerDisplayed();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.delegate.onLowMemory();
    }

    @ActivityCallThrough
    public void onNewIntent(@NonNull Intent intent) {
        this.delegate.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.delegate.onPause();
    }

    @ActivityCallThrough
    public void onPostResume() {
        this.delegate.onPostResume();
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    @ActivityCallThrough
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.delegate.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.delegate.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.delegate.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.delegate.onStop();
    }

    @ActivityCallThrough
    public void onTrimMemory(int i) {
        this.delegate.onTrimMemory(i);
    }

    @ActivityCallThrough
    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineProvider) {
            Log.v(TAG, "Deferring to attached Activity to provide a FlutterEngine.");
            return ((FlutterEngineProvider) activity).provideFlutterEngine(getContext());
        }
        return null;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
        }
        return null;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        FragmentActivity activity = getActivity();
        if (activity instanceof SplashScreenProvider) {
            return ((SplashScreenProvider) activity).provideSplashScreen();
        }
        return null;
    }

    @VisibleForTesting
    public void setDelegate(@NonNull FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate) {
        this.delegate = flutterActivityAndFragmentDelegate;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        return getArguments().getBoolean("should_attach_engine_to_activity");
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        boolean z = getArguments().getBoolean("destroy_engine_with_fragment", false);
        return (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) ? z : getArguments().getBoolean("destroy_engine_with_fragment", true);
    }

    /* loaded from: classes7.dex */
    public static class NewEngineFragmentBuilder {
        public String appBundlePath;
        public String dartEntrypoint;
        public final Class<? extends FlutterFragment> fragmentClass;
        public String initialRoute;
        public RenderMode renderMode;
        public FlutterShellArgs shellArgs;
        public boolean shouldAttachEngineToActivity;
        public TransparencyMode transparencyMode;

        public NewEngineFragmentBuilder() {
            this.dartEntrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            this.initialRoute = "/";
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = FlutterFragment.class;
        }

        @NonNull
        public NewEngineFragmentBuilder appBundlePath(@NonNull String str) {
            this.appBundlePath = str;
            return this;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
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

        @NonNull
        public Bundle createArgs() {
            Bundle bundle = new Bundle();
            bundle.putString("initial_route", this.initialRoute);
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
            return bundle;
        }

        @NonNull
        public NewEngineFragmentBuilder dartEntrypoint(@NonNull String str) {
            this.dartEntrypoint = str;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs flutterShellArgs) {
            this.shellArgs = flutterShellArgs;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder initialRoute(@NonNull String str) {
            this.initialRoute = str;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder renderMode(@NonNull RenderMode renderMode) {
            this.renderMode = renderMode;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean z) {
            this.shouldAttachEngineToActivity = z;
            return this;
        }

        @NonNull
        public NewEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode transparencyMode) {
            this.transparencyMode = transparencyMode;
            return this;
        }

        public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls) {
            this.dartEntrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            this.initialRoute = "/";
            this.appBundlePath = null;
            this.shellArgs = null;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.fragmentClass = cls;
        }
    }
}
