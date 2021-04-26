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
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import d.a.c.a.a;
import io.flutter.Log;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class BoostFlutterActivity extends Activity implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner {
    public static final String DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    public static final String EXTRA_ANIMATED = "animated";
    public static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_SHOW_LOADING = "showloading";
    public static final String EXTRA_SWIPEBACK = "swipeback";
    public static final String EXTRA_URL = "url";
    public static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
    public static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
    public static final String TAG = "NewBoostFlutterActivity";
    public static XPlatformPlugin sXPlatformPlugin;
    public FlutterActivityAndFragmentDelegate delegate;
    @NonNull
    public LifecycleRegistry lifecycle = new LifecycleRegistry(this);

    /* loaded from: classes6.dex */
    public enum BackgroundMode {
        opaque,
        transparent
    }

    /* loaded from: classes6.dex */
    public static class NewEngineIntentBuilder {
        public final Class<? extends BoostFlutterActivity> activityClass;
        public String backgroundMode = BoostFlutterActivity.DEFAULT_BACKGROUND_MODE;
        public String url = "";
        public Map<String, Object> params = new HashMap();

        public NewEngineIntentBuilder(@NonNull Class<? extends BoostFlutterActivity> cls) {
            this.activityClass = cls;
        }

        public Intent build(@NonNull Context context) {
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(this.params);
            return new Intent(context, this.activityClass).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", false).putExtra("url", this.url).putExtra("params", serializableMap);
        }
    }

    /* loaded from: classes6.dex */
    public static class SerializableMap implements Serializable {
        public Map<String, Object> map;

        public Map<String, Object> getMap() {
            return this.map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setFlags(512, 512);
        }
    }

    public static Intent createDefaultIntent(@NonNull Context context) {
        return withNewEngine().build(context);
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable")) : null;
            if (valueOf != null) {
                if (Build.VERSION.SDK_INT > 21) {
                    return getResources().getDrawable(valueOf.intValue(), getTheme());
                }
                return getResources().getDrawable(valueOf.intValue());
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i2 = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i2 != -1) {
                    setTheme(i2);
                }
            } else {
                Log.d(TAG, "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(BoostFlutterActivity.class);
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @NonNull
    public View createFlutterView() {
        return this.delegate.onCreateView(null, null, null);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Activity getActivity() {
        return this;
    }

    @NonNull
    public BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return BackgroundMode.opaque;
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

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Context getContext() {
        return this;
    }

    public FlutterActivityAndFragmentDelegate getFlutterDelegate() {
        return this.delegate;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public XFlutterView getFlutterView() {
        return this.delegate.getFlutterView();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
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

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.delegate.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        switchLaunchThemeForNormalTheme();
        a.b(this);
        super.onCreate(bundle);
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(this);
        configureWindowForTransparency();
        setContentView(createFlutterView());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.delegate.onDestroyView();
        this.delegate.onDetach();
    }

    @Override // android.app.Activity
    public void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        this.delegate.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.delegate.onPause();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.delegate.onPostResume();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.delegate.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.delegate.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.delegate.onStop();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        this.delegate.onTrimMemory(i2);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return FlutterBoost.instance().engineProvider();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine) {
        return BoostViewUtils.getPlatformPlugin(flutterEngine.getPlatformChannel());
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest, ImageView.ScaleType.CENTER, 500L);
        }
        return null;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (a.d(this) && a.a(i2)) {
            return;
        }
        super.setRequestedOrientation(i2);
    }

    public void setSwipeBackEnable(boolean z) {
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public void swipeBackControl(double d2) {
    }
}
