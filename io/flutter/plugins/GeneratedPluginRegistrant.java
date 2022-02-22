package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import c.a.p.a.a;
import c.a.p.e.b;
import c.o.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
@Keep
/* loaded from: classes4.dex */
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
                flutterEngine.getPlugins().add(new c.a.p.c.a());
            } catch (Exception e4) {
                Log.e(TAG, "Error registering plugin flutter_cloud_config_gcp_plugin, com.baidu.flutter.fluttercloudconfiggcpplugin.FlutterCloudConfigGcpPlugin", e4);
            }
            try {
                flutterEngine.getPlugins().add(new c.a.p.b.a());
            } catch (Exception e5) {
                Log.e(TAG, "Error registering plugin flutter_exception_perf_plugin, com.baidu.flutter.flutter_exception_perf_plugin.FlutterExceptionPerfPlugin", e5);
            }
            try {
                flutterEngine.getPlugins().add(new c.a.p.d.a());
            } catch (Exception e6) {
                Log.e(TAG, "Error registering plugin flutter_open_page_perf, com.baidu.flutter.perf.FlutterOpenPagePerfPlugin", e6);
            }
            try {
                flutterEngine.getPlugins().add(new b());
            } catch (Exception e7) {
                Log.e(TAG, "Error registering plugin flutter_performance_report_plugin, com.baidu.flutter.report.FlutterPerformanceReportPlugin", e7);
            }
            try {
                flutterEngine.getPlugins().add(new PackageInfoPlugin());
            } catch (Exception e8) {
                Log.e(TAG, "Error registering plugin package_info, io.flutter.plugins.packageinfo.PackageInfoPlugin", e8);
            }
            try {
                flutterEngine.getPlugins().add(new PathProviderPlugin());
            } catch (Exception e9) {
                Log.e(TAG, "Error registering plugin path_provider, io.flutter.plugins.pathprovider.PathProviderPlugin", e9);
            }
            try {
                flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
            } catch (Exception e10) {
                Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e10);
            }
            try {
                flutterEngine.getPlugins().add(new c());
            } catch (Exception e11) {
                Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e11);
            }
            try {
                flutterEngine.getPlugins().add(new c.a.x0.b());
            } catch (Exception e12) {
                Log.e(TAG, "Error registering plugin ubcflutter, com.baidu.ubcflutter.UbcflutterPlugin", e12);
            }
        }
    }
}
