package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
/* loaded from: classes6.dex */
public class FlutterActivity extends Activity implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host {
    private static final String TAG = "FlutterActivity";
    @VisibleForTesting
    protected FlutterActivityAndFragmentDelegate delegate;
    @NonNull
    private LifecycleRegistry lifecycle = new LifecycleRegistry(this);

    @NonNull
    public static Intent createDefaultIntent(@NonNull Context context) {
        return withNewEngine().build(context);
    }

    @NonNull
    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivity.class);
    }

    /* loaded from: classes6.dex */
    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String initialRoute = "/";
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;

        protected NewEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> cls) {
            this.activityClass = cls;
        }

        @NonNull
        public NewEngineIntentBuilder initialRoute(@NonNull String str) {
            this.initialRoute = str;
            return this;
        }

        @NonNull
        public NewEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            this.backgroundMode = backgroundMode.name();
            return this;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            return new Intent(context, this.activityClass).putExtra("route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(@NonNull String str) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, str);
    }

    /* loaded from: classes6.dex */
    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;

        protected CachedEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> cls, @NonNull String str) {
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z) {
            this.destroyEngineWithActivity = z;
            return this;
        }

        @NonNull
        public CachedEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            this.backgroundMode = backgroundMode.name();
            return this;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
        }
    }

    @VisibleForTesting
    void setDelegate(@NonNull FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate) {
        this.delegate = flutterActivityAndFragmentDelegate;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        switchLaunchThemeForNormalTheme();
        super.onCreate(bundle);
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.delegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate.onAttach(this);
        this.delegate.onActivityCreated(bundle);
        configureWindowForTransparency();
        setContentView(createFlutterView());
        configureStatusBarForFullscreenFlutterExperience();
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                }
            } else {
                Log.v(TAG, "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest);
        }
        return null;
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                if (Build.VERSION.SDK_INT > 21) {
                    return getResources().getDrawable(i, getTheme());
                }
                return getResources().getDrawable(i);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NonNull
    private View createFlutterView() {
        return this.delegate.onCreateView(null, null, null);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.delegate.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.delegate.onResume();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.delegate.onPostResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.delegate.onPause();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.delegate.onStop();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.delegate.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.delegate.onDestroyView();
        this.delegate.onDetach();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.delegate.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        this.delegate.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.delegate.onTrimMemory(i);
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Activity getActivity() {
        return this;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getDartEntrypointFunctionName() {
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string == null) {
                return "main";
            }
            return string;
        } catch (PackageManager.NameNotFoundException e) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getInitialRoute() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            return string == null ? "/" : string;
        } catch (PackageManager.NameNotFoundException e) {
            return "/";
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public String getAppBundlePath() {
        String dataString;
        return (isDebuggable() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) ? dataString : FlutterMain.findAppBundlePath();
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public TransparencyMode getTransparencyMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? TransparencyMode.opaque : TransparencyMode.transparent;
    }

    @NonNull
    protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        return getIntent().hasExtra("background_mode") ? FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode")) : FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return null;
    }

    @Nullable
    protected FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
        }
        return null;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        registerPlugins(flutterEngine);
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView flutterSurfaceView) {
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(@NonNull FlutterTextureView flutterTextureView) {
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 21) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterUiNoLongerDisplayed() {
    }

    private static void registerPlugins(@NonNull FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
        } catch (Exception e) {
            Log.w(TAG, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }
}
