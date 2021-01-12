package com.idlefish.flutterboost.containers;

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
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.adp.base.a;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import io.flutter.Log;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class BoostFlutterActivity extends Activity implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host {
    protected static final String DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    protected static final String EXTRA_ANIMATED = "animated";
    protected static final String EXTRA_BACKGROUND_MODE = "background_mode";
    protected static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
    protected static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    protected static final String EXTRA_PARAMS = "params";
    protected static final String EXTRA_SHOW_LOADING = "showloading";
    protected static final String EXTRA_SWIPEBACK = "swipeback";
    protected static final String EXTRA_URL = "url";
    protected static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
    protected static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
    private static final String TAG = "NewBoostFlutterActivity";
    private static XPlatformPlugin sXPlatformPlugin;
    private FlutterActivityAndFragmentDelegate delegate;
    @NonNull
    private LifecycleRegistry lifecycle = new LifecycleRegistry(this);

    /* loaded from: classes14.dex */
    public enum BackgroundMode {
        opaque,
        transparent
    }

    public static Intent createDefaultIntent(@NonNull Context context) {
        return withNewEngine().build(context);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(BoostFlutterActivity.class);
    }

    /* loaded from: classes14.dex */
    public static class NewEngineIntentBuilder {
        private final Class<? extends BoostFlutterActivity> activityClass;
        private String backgroundMode = BoostFlutterActivity.DEFAULT_BACKGROUND_MODE;
        private String url = "";
        private Map<String, Object> params = new HashMap();

        public NewEngineIntentBuilder(@NonNull Class<? extends BoostFlutterActivity> cls) {
            this.activityClass = cls;
        }

        public Intent build(@NonNull Context context) {
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(this.params);
            return new Intent(context, this.activityClass).putExtra(BoostFlutterActivity.EXTRA_BACKGROUND_MODE, this.backgroundMode).putExtra(BoostFlutterActivity.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, false).putExtra("url", this.url).putExtra("params", serializableMap);
        }
    }

    /* loaded from: classes14.dex */
    public static class SerializableMap implements Serializable {
        private Map<String, Object> map;

        public Map<String, Object> getMap() {
            return this.map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }
    }

    public FlutterActivityAndFragmentDelegate getFlutterDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        switchLaunchThemeForNormalTheme();
        a.j(this);
        super.onCreate(bundle);
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.delegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate.onAttach(this);
        configureWindowForTransparency();
        setContentView(createFlutterView());
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (!a.k(this) || !a.Z(i)) {
            super.setRequestedOrientation(i);
        }
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i = activityInfo.metaData.getInt(NORMAL_THEME_META_DATA_KEY, -1);
                if (i != -1) {
                    setTheme(i);
                }
            } else {
                Log.d(TAG, "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest, ImageView.ScaleType.CENTER, 500L);
        }
        return null;
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt(SPLASH_SCREEN_META_DATA_KEY)) : null;
            if (valueOf != null) {
                if (Build.VERSION.SDK_INT > 21) {
                    return getResources().getDrawable(valueOf.intValue(), getTheme());
                }
                return getResources().getDrawable(valueOf.intValue());
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setFlags(512, 512);
        }
    }

    @NonNull
    protected View createFlutterView() {
        return this.delegate.onCreateView(null, null, null);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        }
    }

    protected XFlutterView getFlutterView() {
        return this.delegate.getFlutterView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.delegate.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.delegate.onResume();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.delegate.onPostResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.delegate.onPause();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.delegate.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.delegate.onDestroyView();
        this.delegate.onDetach();
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

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Context getContext() {
        return this;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Activity getActivity() {
        return this;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    @NonNull
    public FlutterView.RenderMode getRenderMode() {
        return getBackgroundMode() == BackgroundMode.opaque ? FlutterView.RenderMode.surface : FlutterView.RenderMode.texture;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        return getBackgroundMode() == BackgroundMode.opaque ? FlutterView.TransparencyMode.opaque : FlutterView.TransparencyMode.transparent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public BackgroundMode getBackgroundMode() {
        return getIntent().hasExtra(EXTRA_BACKGROUND_MODE) ? BackgroundMode.valueOf(getIntent().getStringExtra(EXTRA_BACKGROUND_MODE)) : BackgroundMode.opaque;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return FlutterBoost.instance().engineProvider();
    }

    @Nullable
    protected FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine) {
        return BoostViewUtils.getPlatformPlugin(flutterEngine.getPlatformChannel());
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        return getIntent().hasExtra("url") ? getIntent().getStringExtra("url") : "";
    }

    public Map<String, Object> getContainerUrlParams() {
        if (getIntent().hasExtra("params")) {
            return ((SerializableMap) getIntent().getSerializableExtra("params")).getMap();
        }
        return new HashMap();
    }

    public void setSwipeBackEnable(boolean z) {
    }

    public void swipeBackControl(double d) {
    }
}
