package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.Preconditions;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class FlutterActivityDelegate implements FlutterActivityEvents, FlutterView.Provider, PluginRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.app.android.SplashScreenUntilFirstFrame";
    public static final String TAG = "FlutterActivityDelegate";
    public static final WindowManager.LayoutParams matchParent;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity activity;
    public FlutterView flutterView;
    public View launchView;
    public final ViewFactory viewFactory;

    /* loaded from: classes10.dex */
    public interface ViewFactory {
        FlutterNativeView createFlutterNativeView();

        FlutterView createFlutterView(Context context);

        boolean retainFlutterNativeView();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2015513815, "Lio/flutter/app/FlutterActivityDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2015513815, "Lio/flutter/app/FlutterActivityDelegate;");
                return;
            }
        }
        matchParent = new WindowManager.LayoutParams(-1, -1);
    }

    public FlutterActivityDelegate(Activity activity, ViewFactory viewFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.activity = (Activity) Preconditions.checkNotNull(activity);
        this.viewFactory = (ViewFactory) Preconditions.checkNotNull(viewFactory);
    }

    private void addLaunchView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (view = this.launchView) == null) {
            return;
        }
        this.activity.addContentView(view, matchParent);
        this.flutterView.addFirstFrameListener(new FlutterView.FirstFrameListener(this) { // from class: io.flutter.app.FlutterActivityDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterActivityDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // io.flutter.view.FlutterView.FirstFrameListener
            public void onFirstFrame() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.launchView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter(this) { // from class: io.flutter.app.FlutterActivityDelegate.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                ((ViewGroup) this.this$1.this$0.launchView.getParent()).removeView(this.this$1.this$0.launchView);
                                this.this$1.this$0.launchView = null;
                            }
                        }
                    });
                    this.this$0.flutterView.removeFirstFrameListener(this);
                }
            }
        });
        this.activity.setTheme(16973833);
    }

    private View createLaunchView() {
        InterceptResult invokeV;
        Drawable launchScreenDrawableFromActivityTheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (showSplashScreenUntilFirstFrame().booleanValue() && (launchScreenDrawableFromActivityTheme = getLaunchScreenDrawableFromActivityTheme()) != null) {
                View view = new View(this.activity);
                view.setLayoutParams(matchParent);
                view.setBackground(launchScreenDrawableFromActivityTheme);
                return view;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public static String[] getArgsFromIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, intent)) == null) {
            ArrayList arrayList = new ArrayList();
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_STARTUP, false)) {
                arrayList.add(FlutterShellArgs.ARG_TRACE_STARTUP);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_START_PAUSED, false)) {
                arrayList.add(FlutterShellArgs.ARG_START_PAUSED);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
                arrayList.add(FlutterShellArgs.ARG_DISABLE_SERVICE_AUTH_CODES);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_USE_TEST_FONTS, false)) {
                arrayList.add(FlutterShellArgs.ARG_USE_TEST_FONTS);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_DART_PROFILING, false)) {
                arrayList.add(FlutterShellArgs.ARG_ENABLE_DART_PROFILING);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_SOFTWARE_RENDERING, false)) {
                arrayList.add(FlutterShellArgs.ARG_ENABLE_SOFTWARE_RENDERING);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_SKIA_DETERMINISTIC_RENDERING, false)) {
                arrayList.add(FlutterShellArgs.ARG_SKIA_DETERMINISTIC_RENDERING);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_SKIA, false)) {
                arrayList.add(FlutterShellArgs.ARG_TRACE_SKIA);
            }
            if (intent.getBooleanExtra("trace-systrace", false)) {
                arrayList.add("--trace-systrace");
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION, false)) {
                arrayList.add(FlutterShellArgs.ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_CACHE_SKSL, false)) {
                arrayList.add(FlutterShellArgs.ARG_CACHE_SKSL);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_VERBOSE_LOGGING, false)) {
                arrayList.add(FlutterShellArgs.ARG_VERBOSE_LOGGING);
            }
            int intExtra = intent.getIntExtra(FlutterShellArgs.ARG_KEY_OBSERVATORY_PORT, 0);
            if (intExtra > 0) {
                arrayList.add(FlutterShellArgs.ARG_OBSERVATORY_PORT + Integer.toString(intExtra));
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
                arrayList.add(FlutterShellArgs.ARG_DISABLE_SERVICE_AUTH_CODES);
            }
            if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENDLESS_TRACE_BUFFER, false)) {
                arrayList.add(FlutterShellArgs.ARG_ENDLESS_TRACE_BUFFER);
            }
            if (intent.hasExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS)) {
                arrayList.add("--dart-flags=" + intent.getStringExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    private Drawable getLaunchScreenDrawableFromActivityTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            TypedValue typedValue = new TypedValue();
            if (this.activity.getTheme().resolveAttribute(16842836, typedValue, true) && typedValue.resourceId != 0) {
                try {
                    return this.activity.getResources().getDrawable(typedValue.resourceId);
                } catch (Resources.NotFoundException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    private boolean isDebuggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (this.activity.getApplicationInfo().flags & 2) != 0 : invokeV.booleanValue;
    }

    private boolean loadIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, intent)) == null) {
            if ("android.intent.action.RUN".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
                String dataString = intent.getDataString();
                if (dataString == null) {
                    dataString = FlutterMain.findAppBundlePath();
                }
                if (stringExtra != null) {
                    this.flutterView.setInitialRoute(stringExtra);
                }
                runBundle(dataString);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void runBundle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || this.flutterView.getFlutterNativeView().isApplicationRunning()) {
            return;
        }
        FlutterRunArguments flutterRunArguments = new FlutterRunArguments();
        flutterRunArguments.bundlePath = str;
        flutterRunArguments.entrypoint = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        this.flutterView.runFromBundle(flutterRunArguments);
    }

    private Boolean showSplashScreenUntilFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            try {
                Bundle bundle = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 129).metaData;
                return Boolean.valueOf(bundle != null && bundle.getBoolean(SPLASH_SCREEN_META_DATA_KEY));
            } catch (PackageManager.NameNotFoundException unused) {
                return Boolean.FALSE;
            }
        }
        return (Boolean) invokeV.objValue;
    }

    @Override // io.flutter.view.FlutterView.Provider
    public FlutterView getFlutterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.flutterView : (FlutterView) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.flutterView.getPluginRegistry().hasPlugin(str) : invokeL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent)) == null) ? this.flutterView.getPluginRegistry().onActivityResult(i2, i3, intent) : invokeIIL.booleanValue;
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FlutterView flutterView = this.flutterView;
            if (flutterView != null) {
                flutterView.popRoute();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onCreate(Bundle bundle) {
        String findAppBundlePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = this.activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(1073741824);
                window.getDecorView().setSystemUiVisibility(1280);
            }
            FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), getArgsFromIntent(this.activity.getIntent()));
            FlutterView createFlutterView = this.viewFactory.createFlutterView(this.activity);
            this.flutterView = createFlutterView;
            if (createFlutterView == null) {
                FlutterView flutterView = new FlutterView(this.activity, null, this.viewFactory.createFlutterNativeView());
                this.flutterView = flutterView;
                flutterView.setLayoutParams(matchParent);
                this.activity.setContentView(this.flutterView);
                View createLaunchView = createLaunchView();
                this.launchView = createLaunchView;
                if (createLaunchView != null) {
                    addLaunchView();
                }
            }
            if (loadIntent(this.activity.getIntent()) || (findAppBundlePath = FlutterMain.findAppBundlePath()) == null) {
                return;
            }
            runBundle(findAppBundlePath);
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Application application = (Application) this.activity.getApplicationContext();
            if (application instanceof FlutterApplication) {
                FlutterApplication flutterApplication = (FlutterApplication) application;
                if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                    flutterApplication.setCurrentActivity(null);
                }
            }
            FlutterView flutterView = this.flutterView;
            if (flutterView != null) {
                if (!flutterView.getPluginRegistry().onViewDestroy(this.flutterView.getFlutterNativeView()) && !this.viewFactory.retainFlutterNativeView()) {
                    this.flutterView.destroy();
                } else {
                    this.flutterView.detach();
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.flutterView.onMemoryPressure();
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            if (isDebuggable() && loadIntent(intent)) {
                return;
            }
            this.flutterView.getPluginRegistry().onNewIntent(intent);
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Application application = (Application) this.activity.getApplicationContext();
            if (application instanceof FlutterApplication) {
                FlutterApplication flutterApplication = (FlutterApplication) application;
                if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                    flutterApplication.setCurrentActivity(null);
                }
            }
            FlutterView flutterView = this.flutterView;
            if (flutterView != null) {
                flutterView.onPause();
            }
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onPostResume() {
        FlutterView flutterView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (flutterView = this.flutterView) == null) {
            return;
        }
        flutterView.onPostResume();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, strArr, iArr)) == null) ? this.flutterView.getPluginRegistry().onRequestPermissionsResult(i2, strArr, iArr) : invokeILL.booleanValue;
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Application application = (Application) this.activity.getApplicationContext();
            if (application instanceof FlutterApplication) {
                ((FlutterApplication) application).setCurrentActivity(this.activity);
            }
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onStart() {
        FlutterView flutterView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (flutterView = this.flutterView) == null) {
            return;
        }
        flutterView.onStart();
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.flutterView.onStop();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && i2 == 10) {
            this.flutterView.onMemoryPressure();
        }
    }

    @Override // io.flutter.app.FlutterActivityEvents
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.flutterView.getPluginRegistry().onUserLeaveHint();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.flutterView.getPluginRegistry().registrarFor(str) : (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? (T) this.flutterView.getPluginRegistry().valuePublishedByPlugin(str) : (T) invokeL.objValue;
    }
}
