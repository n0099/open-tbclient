package io.flutter.plugins;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import com.baidu.e.a;
import com.baidu.network_service_plugin.b;
import com.baidu.performance_monitor.PerformanceMonitorPlugin;
import com.example.crash_report_plugin.CrashReportPlugin;
import com.example.flutter_lottie.FlutterLottiePlugin;
import com.example.global_state_sync_plugin.GlobalStateSyncPlugin;
import com.example.image_loader_plugin.ImageLoaderPlugin;
import com.example.utility_plugin.UtilityPlugin;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.oversketch.progresshud.ProgresshudPlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import top.kikt.ijkplayer.IjkplayerPlugin;
@Keep
/* loaded from: classes6.dex */
public final class GeneratedPluginRegistrant {
    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        ShimPluginRegistry shimPluginRegistry = new ShimPluginRegistry(flutterEngine);
        flutterEngine.getPlugins().add(new CrashReportPlugin());
        FlutterBoostPlugin.registerWith(shimPluginRegistry.registrarFor("com.idlefish.flutterboost.FlutterBoostPlugin"));
        IjkplayerPlugin.registerWith(shimPluginRegistry.registrarFor("top.kikt.ijkplayer.IjkplayerPlugin"));
        FlutterLottiePlugin.registerWith(shimPluginRegistry.registrarFor("com.example.flutter_lottie.FlutterLottiePlugin"));
        flutterEngine.getPlugins().add(new GlobalStateSyncPlugin());
        flutterEngine.getPlugins().add(new ImageLoaderPlugin());
        flutterEngine.getPlugins().add(new a());
        flutterEngine.getPlugins().add(new b());
        ProgresshudPlugin.registerWith(shimPluginRegistry.registrarFor("com.oversketch.progresshud.ProgresshudPlugin"));
        flutterEngine.getPlugins().add(new PathProviderPlugin());
        flutterEngine.getPlugins().add(new PerformanceMonitorPlugin());
        flutterEngine.getPlugins().add(new UtilityPlugin());
    }
}
