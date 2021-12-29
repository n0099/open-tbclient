package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
/* loaded from: classes4.dex */
public class FlutterFragmentActivity extends FragmentActivity implements SplashScreenProvider, FlutterEngineProvider, FlutterEngineConfigurator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAGMENT_CONTAINER_ID = 609893468;
    public static final String TAG = "FlutterFragmentActivity";
    public static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public FlutterFragment flutterFragment;

    /* loaded from: classes4.dex */
    public static class CachedEngineIntentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends FlutterFragmentActivity> activityClass;
        public String backgroundMode;
        public final String cachedEngineId;
        public boolean destroyEngineWithActivity;

        public CachedEngineIntentBuilder(@NonNull Class<? extends FlutterFragmentActivity> cls, @NonNull String str) {
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
            this.destroyEngineWithActivity = false;
            this.backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        @NonNull
        public CachedEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, backgroundMode)) == null) {
                this.backgroundMode = backgroundMode.name();
                return this;
            }
            return (CachedEngineIntentBuilder) invokeL.objValue;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode) : (Intent) invokeL.objValue;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.destroyEngineWithActivity = z;
                return this;
            }
            return (CachedEngineIntentBuilder) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class NewEngineIntentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends FlutterFragmentActivity> activityClass;
        public String backgroundMode;
        public String initialRoute;

        public NewEngineIntentBuilder(@NonNull Class<? extends FlutterFragmentActivity> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.initialRoute = "/";
            this.backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
            this.activityClass = cls;
        }

        @NonNull
        public NewEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, backgroundMode)) == null) {
                this.backgroundMode = backgroundMode.name();
                return this;
            }
            return (NewEngineIntentBuilder) invokeL.objValue;
        }

        @NonNull
        public Intent build(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new Intent(context, this.activityClass).putExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true) : (Intent) invokeL.objValue;
        }

        @NonNull
        public NewEngineIntentBuilder initialRoute(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.initialRoute = str;
                return this;
            }
            return (NewEngineIntentBuilder) invokeL.objValue;
        }
    }

    public FlutterFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void configureWindowForTransparency() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NonNull
    public static Intent createDefaultIntent(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? withNewEngine().build(context) : (Intent) invokeL.objValue;
    }

    @NonNull
    private View createFragmentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            FrameLayout provideRootLayout = provideRootLayout(this);
            provideRootLayout.setId(FRAGMENT_CONTAINER_ID);
            provideRootLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return provideRootLayout;
        }
        return (View) invokeV.objValue;
    }

    private void ensureFlutterFragmentCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.flutterFragment == null) {
                this.flutterFragment = retrieveExistingFlutterFragmentIfPossible();
            }
            if (this.flutterFragment == null) {
                this.flutterFragment = createFlutterFragment();
                getSupportFragmentManager().beginTransaction().add(FRAGMENT_CONTAINER_ID, this.flutterFragment, TAG_FLUTTER_FRAGMENT).commit();
            }
        }
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                Bundle metaData = getMetaData();
                int i2 = metaData != null ? metaData.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
                if (i2 != 0) {
                    return ResourcesCompat.getDrawable(getResources(), i2, getTheme());
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            } catch (Resources.NotFoundException e2) {
                Log.e(TAG, "Splash screen not found. Ensure the drawable exists and that it's valid.");
                throw e2;
            }
        }
        return (Drawable) invokeV.objValue;
    }

    private boolean isDebuggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (getApplicationInfo().flags & 2) != 0 : invokeV.booleanValue;
    }

    private void switchLaunchThemeForNormalTheme() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                Bundle metaData = getMetaData();
                if (metaData != null) {
                    int i2 = metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                    if (i2 != -1) {
                        setTheme(i2);
                    }
                } else {
                    Log.v(TAG, "Using the launch theme as normal theme.");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e(TAG, "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
            }
        }
    }

    @NonNull
    public static CachedEngineIntentBuilder withCachedEngine(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? new CachedEngineIntentBuilder(FlutterFragmentActivity.class, str) : (CachedEngineIntentBuilder) invokeL.objValue;
    }

    @NonNull
    public static NewEngineIntentBuilder withNewEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new NewEngineIntentBuilder(FlutterFragmentActivity.class) : (NewEngineIntentBuilder) invokeV.objValue;
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterEngine) == null) {
        }
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterEngine) == null) {
            FlutterFragment flutterFragment = this.flutterFragment;
            if (flutterFragment == null || !flutterFragment.isFlutterEngineInjected()) {
                GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
            }
        }
    }

    @NonNull
    public FlutterFragment createFlutterFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FlutterActivityLaunchConfigs.BackgroundMode backgroundMode = getBackgroundMode();
            RenderMode renderMode = getRenderMode();
            TransparencyMode transparencyMode = backgroundMode == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? TransparencyMode.opaque : TransparencyMode.transparent;
            boolean z = renderMode == RenderMode.surface;
            if (getCachedEngineId() != null) {
                Log.v(TAG, "Creating FlutterFragment with cached engine:\nCached engine ID: " + getCachedEngineId() + "\nWill destroy engine when Activity is destroyed: " + shouldDestroyEngineWithHost() + "\nBackground transparency mode: " + backgroundMode + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
                return FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(renderMode).transparencyMode(transparencyMode).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).shouldDelayFirstAndroidViewDraw(z).build();
            }
            Log.v(TAG, "Creating FlutterFragment with new engine:\nBackground transparency mode: " + backgroundMode + "\nDart entrypoint: " + getDartEntrypointFunctionName() + "\nInitial route: " + getInitialRoute() + "\nApp bundle path: " + getAppBundlePath() + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
            return FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).renderMode(renderMode).transparencyMode(transparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).shouldDelayFirstAndroidViewDraw(z).build();
        }
        return (FlutterFragment) invokeV.objValue;
    }

    @NonNull
    public String getAppBundlePath() {
        InterceptResult invokeV;
        String dataString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (isDebuggable() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
                return dataString;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getIntent().hasExtra("background_mode")) {
                return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
            }
            return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
        }
        return (FlutterActivityLaunchConfigs.BackgroundMode) invokeV.objValue;
    }

    @Nullable
    public String getCachedEngineId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getIntent().getStringExtra("cached_engine_id") : (String) invokeV.objValue;
    }

    @NonNull
    public String getDartEntrypointFunctionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Bundle metaData = getMetaData();
                String string = metaData != null ? metaData.getString(FlutterActivityLaunchConfigs.DART_ENTRYPOINT_META_DATA_KEY) : null;
                return string != null ? string : "main";
            } catch (PackageManager.NameNotFoundException unused) {
                return "main";
            }
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.flutterFragment.getFlutterEngine() : (FlutterEngine) invokeV.objValue;
    }

    public String getInitialRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
                return getIntent().getStringExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            }
            try {
                Bundle metaData = getMetaData();
                if (metaData != null) {
                    return metaData.getString(FlutterActivityLaunchConfigs.INITIAL_ROUTE_META_DATA_KEY);
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getPackageManager().getActivityInfo(getComponentName(), 128).metaData : (Bundle) invokeV.objValue;
    }

    @NonNull
    public RenderMode getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture : (RenderMode) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.flutterFragment.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.flutterFragment.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            switchLaunchThemeForNormalTheme();
            this.flutterFragment = retrieveExistingFlutterFragmentIfPossible();
            super.onCreate(bundle);
            configureWindowForTransparency();
            setContentView(createFragmentContainer());
            configureStatusBarForFullscreenFlutterExperience();
            ensureFlutterFragmentCreated();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            this.flutterFragment.onNewIntent(intent);
            super.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPostResume();
            this.flutterFragment.onPostResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.flutterFragment.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onTrimMemory(i2);
            this.flutterFragment.onTrimMemory(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.flutterFragment.onUserLeaveHint();
        }
    }

    @Override // io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            return null;
        }
        return (FlutterEngine) invokeL.objValue;
    }

    @NonNull
    public FrameLayout provideRootLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new FrameLayout(context) : (FrameLayout) invokeL.objValue;
    }

    @Override // io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Drawable splashScreenFromManifest = getSplashScreenFromManifest();
            if (splashScreenFromManifest != null) {
                return new DrawableSplashScreen(splashScreenFromManifest);
            }
            return null;
        }
        return (SplashScreen) invokeV.objValue;
    }

    @VisibleForTesting
    public FlutterFragment retrieveExistingFlutterFragmentIfPossible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (FlutterFragment) getSupportFragmentManager().findFragmentByTag(TAG_FLUTTER_FRAGMENT) : (FlutterFragment) invokeV.objValue;
    }

    public boolean shouldAttachEngineToActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldDestroyEngineWithHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getIntent().getBooleanExtra("destroy_engine_with_activity", false) : invokeV.booleanValue;
    }

    @VisibleForTesting
    public boolean shouldHandleDeeplinking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            try {
                Bundle metaData = getMetaData();
                if (metaData != null) {
                    return metaData.getBoolean(FlutterActivityLaunchConfigs.HANDLE_DEEPLINKING_META_DATA_KEY);
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
