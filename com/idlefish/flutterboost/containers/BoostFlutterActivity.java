package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.app.Application;
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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
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
/* loaded from: classes3.dex */
public class BoostFlutterActivity extends Activity implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BACKGROUND_MODE;
    public static final String EXTRA_BACKGROUND_MODE = "background_mode";
    public static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_URL = "url";
    public static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
    public static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
    public static final String TAG = "NewBoostFlutterActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity coveredTransparentActivity;
    public FlutterActivityAndFragmentDelegate delegate;
    public boolean isCoverWithTransparentActivity;
    @NonNull
    public LifecycleRegistry lifecycle;
    public Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class BackgroundMode {
        public static final /* synthetic */ BackgroundMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BackgroundMode opaque;
        public static final BackgroundMode transparent;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461706732, "Lcom/idlefish/flutterboost/containers/BoostFlutterActivity$BackgroundMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1461706732, "Lcom/idlefish/flutterboost/containers/BoostFlutterActivity$BackgroundMode;");
                    return;
                }
            }
            opaque = new BackgroundMode("opaque", 0);
            BackgroundMode backgroundMode = new BackgroundMode(OpenFlutter.EXTRA_TRANSPARANT, 1);
            transparent = backgroundMode;
            $VALUES = new BackgroundMode[]{opaque, backgroundMode};
        }

        public BackgroundMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BackgroundMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BackgroundMode) Enum.valueOf(BackgroundMode.class, str) : (BackgroundMode) invokeL.objValue;
        }

        public static BackgroundMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BackgroundMode[]) $VALUES.clone() : (BackgroundMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class NewEngineIntentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends BoostFlutterActivity> activityClass;
        public String backgroundMode;
        public Map params;
        public String url;

        public NewEngineIntentBuilder(@NonNull Class<? extends BoostFlutterActivity> cls) {
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
            this.backgroundMode = BoostFlutterActivity.DEFAULT_BACKGROUND_MODE;
            this.url = "";
            this.params = new HashMap();
            this.activityClass = cls;
        }

        public Intent build(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                SerializableMap serializableMap = new SerializableMap();
                serializableMap.setMap(this.params);
                return new Intent(context, this.activityClass).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", false).putExtra("url", this.url).putExtra("params", serializableMap);
            }
            return (Intent) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class SerializableMap implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Object> map;

        public SerializableMap() {
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

        public Map<String, Object> getMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.map : (Map) invokeV.objValue;
        }

        public void setMap(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                this.map = map;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(583092917, "Lcom/idlefish/flutterboost/containers/BoostFlutterActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(583092917, "Lcom/idlefish/flutterboost/containers/BoostFlutterActivity;");
                return;
            }
        }
        DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    }

    public BoostFlutterActivity() {
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
        this.isCoverWithTransparentActivity = false;
        this.mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(this) { // from class: com.idlefish.flutterboost.containers.BoostFlutterActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BoostFlutterActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) && this.this$0.isCoverWithTransparentActivity) {
                    if (this.this$0.coveredTransparentActivity == null) {
                        this.this$0.coveredTransparentActivity = activity;
                    }
                    if (activity instanceof BoostFlutterActivity) {
                        this.this$0.delegate.onPause();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && this.this$0.coveredTransparentActivity == activity) {
                    this.this$0.coveredTransparentActivity = null;
                    this.this$0.isCoverWithTransparentActivity = false;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                }
            }
        };
        this.lifecycle = new LifecycleRegistry(this);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void configureWindowForTransparency() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && getBackgroundMode() == BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setFlags(512, 512);
        }
    }

    public static Intent createDefaultIntent(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? withNewEngine().build(context) : (Intent) invokeL.objValue;
    }

    @Nullable
    private Drawable getSplashScreenFromManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), SplashNativePolicy.SPLASH_CMD_SHOW_PLG).metaData;
                Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable")) : null;
                if (valueOf == null || valueOf.intValue() <= 0) {
                    return null;
                }
                if (Build.VERSION.SDK_INT > 21) {
                    return getResources().getDrawable(valueOf.intValue(), getTheme());
                }
                return getResources().getDrawable(valueOf.intValue());
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (Drawable) invokeV.objValue;
    }

    private boolean isDebuggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (getApplicationInfo().flags & 2) != 0 : invokeV.booleanValue;
    }

    private void switchLaunchThemeForNormalTheme() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
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
    }

    public static NewEngineIntentBuilder withNewEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? new NewEngineIntentBuilder(BoostFlutterActivity.class) : (NewEngineIntentBuilder) invokeV.objValue;
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
        }
    }

    @NonNull
    public View createFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delegate.onCreateView(null, null, null) : (View) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @NonNull
    public BackgroundMode getBackgroundMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getIntent().hasExtra("background_mode")) {
                return BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
            }
            return BackgroundMode.opaque;
        }
        return (BackgroundMode) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getIntent().hasExtra("url") ? getIntent().getStringExtra("url") : "" : (String) invokeV.objValue;
    }

    public Map getContainerUrlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getIntent().hasExtra("params")) {
                Map<String, Object> map = ((SerializableMap) getIntent().getSerializableExtra("params")).getMap();
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (entry != null && (entry.getValue() instanceof Boolean)) {
                            map.put(entry.getKey(), Boolean.valueOf(((Boolean) entry.getValue()).booleanValue()));
                        }
                    }
                }
                return map;
            }
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.delegate.getFlutterEngine() : (FlutterEngine) invokeV.objValue;
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? FlutterShellArgs.fromIntent(getIntent()) : (FlutterShellArgs) invokeV.objValue;
    }

    public FlutterView getFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.delegate.getFlutterView() : (FlutterView) invokeV.objValue;
    }

    public IFlutterViewContainer getIFlutterViewContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.delegate : (IFlutterViewContainer) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lifecycle : (Lifecycle) invokeV.objValue;
    }

    @NonNull
    public FlutterView.RenderMode getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getBackgroundMode() == BackgroundMode.opaque ? FlutterView.RenderMode.surface : FlutterView.RenderMode.texture : (FlutterView.RenderMode) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getBackgroundMode() == BackgroundMode.opaque ? FlutterView.TransparencyMode.opaque : FlutterView.TransparencyMode.transparent : (FlutterView.TransparencyMode) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, intent) == null) {
            this.delegate.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.delegate.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            switchLaunchThemeForNormalTheme();
            super.onCreate(bundle);
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
            this.delegate = flutterActivityAndFragmentDelegate;
            flutterActivityAndFragmentDelegate.onAttach(this);
            configureWindowForTransparency();
            setContentView(createFlutterView());
            configureStatusBarForFullscreenFlutterExperience();
            getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            this.delegate.onDestroyView();
            this.delegate.onDetach();
            getApplication().unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, intent) == null) {
            super.onNewIntent(intent);
            this.delegate.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            if (!this.isCoverWithTransparentActivity) {
                this.delegate.onPause();
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPostResume();
            this.delegate.onPostResume();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048598, this, i2, strArr, iArr) == null) {
            this.delegate.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            if (this.isCoverWithTransparentActivity) {
                return;
            }
            this.delegate.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onStart();
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.delegate.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStop();
            this.delegate.onStop();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            super.onTrimMemory(i2);
            this.delegate.onTrimMemory(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.delegate.onUserLeaveHint();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, context)) == null) ? FlutterBoost.instance().engineProvider() : (FlutterEngine) invokeL.objValue;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, activity, flutterEngine)) == null) {
            if (activity != null) {
                return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
            }
            return null;
        }
        return (PlatformPlugin) invokeLL.objValue;
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Drawable splashScreenFromManifest = getSplashScreenFromManifest();
            if (splashScreenFromManifest != null) {
                return new DrawableSplashScreen(splashScreenFromManifest, ImageView.ScaleType.CENTER, 500L);
            }
            return null;
        }
        return (SplashScreen) invokeV.objValue;
    }

    public void setIsCoverWithTransparentActivity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isCoverWithTransparentActivity = z;
        }
    }

    public void setSwipeBackEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void swipeBackControl(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Double.valueOf(d2)}) == null) {
        }
    }
}
