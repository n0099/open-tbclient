package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import c.a.o.a.a;
import c.a.o.d.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
@Keep
/* loaded from: classes3.dex */
public final class GeneratedPluginRegistrant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GeneratedPluginRegistrant";
    public transient /* synthetic */ FieldHolder $fh;

    public GeneratedPluginRegistrant() {
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

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, flutterEngine) == null) {
            try {
                flutterEngine.getPlugins().add(new a());
            } catch (Exception e2) {
                Log.e(TAG, "Error registering plugin cyberplayer, com.baidu.flutter.cyberplayer.CyberplayerPlugin", e2);
            }
            try {
                flutterEngine.getPlugins().add(new FlutterBoostPlugin());
            } catch (Exception e3) {
                Log.e(TAG, "Error registering plugin flutter_boost, com.idlefish.flutterboost.FlutterBoostPlugin", e3);
            }
            try {
                flutterEngine.getPlugins().add(new c.a.o.b.a());
            } catch (Exception e4) {
                Log.e(TAG, "Error registering plugin flutter_exception_perf_plugin, com.baidu.flutter.flutter_exception_perf_plugin.FlutterExceptionPerfPlugin", e4);
            }
            try {
                flutterEngine.getPlugins().add(new c.a.o.c.a());
            } catch (Exception e5) {
                Log.e(TAG, "Error registering plugin flutter_open_page_perf, com.baidu.flutter.perf.FlutterOpenPagePerfPlugin", e5);
            }
            try {
                flutterEngine.getPlugins().add(new b());
            } catch (Exception e6) {
                Log.e(TAG, "Error registering plugin flutter_performance_report_plugin, com.baidu.flutter.report.FlutterPerformanceReportPlugin", e6);
            }
            try {
                flutterEngine.getPlugins().add(new PathProviderPlugin());
            } catch (Exception e7) {
                Log.e(TAG, "Error registering plugin path_provider, io.flutter.plugins.pathprovider.PathProviderPlugin", e7);
            }
            try {
                flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
            } catch (Exception e8) {
                Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e8);
            }
        }
    }
}
